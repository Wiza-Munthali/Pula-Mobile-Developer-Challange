package com.example.androidengineercodingchallengewizamunthali.data.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Strings(


    var strings_id: Int = 0,

    var en: En = En()
){

    constructor():this(0, En())
    override fun toString(): String {
        return "$en"
    }
}