package com.example.androidengineercodingchallengewizamunthali.data.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Option")
data class Option(

    var display_text: String?,
    var value: String?
){
    constructor():this("","")

    override fun toString(): String{
        return "$display_text, $value"
    }

}