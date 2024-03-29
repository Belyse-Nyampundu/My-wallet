package com.nbelyse.bill.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone_number")   var phoneNumber: String,
    @SerializedName("first_name")  var firstName: String,
    @SerializedName("last_name")   var lastName: String,
    @SerializedName("user_id")   var userId: String,
    @SerializedName("email")  var email: String

//    naming this stuff it depends on the response you have in your link
)
