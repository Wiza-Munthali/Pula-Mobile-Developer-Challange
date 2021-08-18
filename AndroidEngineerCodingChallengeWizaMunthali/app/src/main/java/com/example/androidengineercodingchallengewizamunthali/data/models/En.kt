package com.example.androidengineercodingchallengewizamunthali.data.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "En")
data class En(

    var en_id: Int,
    var opt_female: String?,
    var opt_male: String?,
    var opt_other: String?,
    var q_farmer_gender: String?,
    var q_farmer_name: String?,
    var q_size_of_farm: String?
){
    constructor():this(0,"", "", "","", "","")
}