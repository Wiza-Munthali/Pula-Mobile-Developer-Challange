package com.example.androidengineercodingchallengewizamunthali.screens

import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.androidengineercodingchallengewizamunthali.R
import com.example.androidengineercodingchallengewizamunthali.data.models.Answers
import org.jetbrains.anko.toast
import java.lang.Exception

class SurveyActivity : AppCompatActivity() {
    private var answers: Answers = Answers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        val nameTextField: EditText = findViewById(R.id.nameTextField)
        val gender: RadioGroup = findViewById(R.id.genderOptions)
        val sizeOfFarm: EditText = findViewById(R.id.sizeTextField)


        //Button to start the survey
        val startBtn: Button = findViewById(R.id.finishButton)
        startBtn.setOnClickListener{


           if(isEmpty(sizeOfFarm.text) || isEmpty(nameTextField.text)){
               toast("Please enter the required fields")
           }else{
               val chosenGender: Int = gender.checkedRadioButtonId
               println("her eit is $chosenGender")
               val rdButton: RadioButton = findViewById(chosenGender)
               submit(nameTextField.text.toString(), rdButton.text.toString(), sizeOfFarm.text.toString())
           }
        }
    }

    private fun submit(name:String, gender: String, size: String){
        try {
            answers.farmerName = name
            answers.farmerGender = gender
            answers.farmSize = size.toDouble()
            toast("here is the name of the farmer ${answers.farmerName}")
        }catch (e: Exception){

        }
    }


}