package com.example.androidengineercodingchallengewizamunthali.data.models

data class Answers(
    var farmerName: String,
    var farmerGender: String,
    var farmSize: Double,
){
    constructor(): this("","",0.00)
}