package com.nbelyse.bill.api

import com.nbelyse.bill.model.LoginRequest
import com.nbelyse.bill.model.LoginResponse
import com.nbelyse.bill.model.RegisterRequest
import com.nbelyse.bill.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
//    because of corotorin use response retrofit
    suspend fun registerUser(@Body registerRequest: RegisterRequest)
    :Response<RegisterResponse>

    @POST("/users/login")
    suspend fun registerUserLogin(@Body loginRequest: LoginRequest)
    :Response<LoginResponse>
}