package com.example.androidengineercodingchallengewizamunthali


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidengineercodingchallengewizamunthali.data.models.FarmerSurvey
import com.example.androidengineercodingchallengewizamunthali.screens.SurveyActivity
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private var sharedPreferences: SharedPreferences? = null
    private val url = "https://run.mocky.io/v3/d628facc-ec18-431d-a8fc-9c096e00709a"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("com.example.androidengineercodingchallengewizamunthali",
            MODE_PRIVATE)

        //Get JSON and Parse it into Classes
        firstRun()

        //Button to start the survey
        val startBtn: Button = findViewById(R.id.startButton)
        startBtn.setOnClickListener{
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }

    }

    //checks if its the apps first run
    private fun firstRun(){
        if(sharedPreferences?.getBoolean("firstRun", true) == true){
            //get api info and store in db
            url.getSurveyJson()
            sharedPreferences?.edit()?.putBoolean("firstRun", false)?.apply()
        }else{
            println("this is not the first run")
        }
    }

    //Get json string and create DB
    private fun String.getSurveyJson() {
        val request = Request.Builder().url(this).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
               val result: ResponseBody? = response.body()
                try{
                    val gson = Gson()
                    val survey: FarmerSurvey = gson.fromJson("${result?.string()}", FarmerSurvey::class.java)
                    println(survey.questions + survey.start_question_id)

                }catch (error: Error){
                    println(error)
                }
            }
            })
        }

}