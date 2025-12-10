package com.example.ai37a.model

data class UserModel(
    val userId:String = "",
    val firstName:String = "",
    val lastName:String = "",
    val email:String = "",
    val dob:String = "",
    val gender:String = "",
){

    fun toMap() : Map<String,Any?>{
        return mapOf(
            "userId" to userId,
            "firstName" to firstName,
            "lastName" to lastName,
            "email" to email,
            "dob" to dob,
            "gender" to gender,
        )
    }
}
