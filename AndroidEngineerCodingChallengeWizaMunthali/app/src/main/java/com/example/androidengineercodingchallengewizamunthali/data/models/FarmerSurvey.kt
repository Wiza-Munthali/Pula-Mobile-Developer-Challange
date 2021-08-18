package com.example.androidengineercodingchallengewizamunthali.data.models

data class FarmerSurvey(
    var id: String?,
    var questions: List<Question>,
    var start_question_id: String?,
    var strings: Strings
){
constructor(): this("", listOf(Question()), "", Strings())
}
