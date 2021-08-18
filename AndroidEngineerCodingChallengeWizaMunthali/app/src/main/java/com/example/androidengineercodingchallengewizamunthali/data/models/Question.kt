package com.example.androidengineercodingchallengewizamunthali.data.models


data class Question(

    var answer_type: String,
    var question_id: String,
    var next: String?,
    var options: List<Option>,
    var question_text: String?,
    var question_type: String?
){
    constructor():this("", "","", listOf(Option()),"","")

    override fun toString(): String{
        return "$answer_type, $question_id, $next, $options, $question_text, $question_type"
    }
}