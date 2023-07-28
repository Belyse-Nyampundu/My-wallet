package com.nbelyse.bill.repository

import com.nbelyse.bill.api.ApiClient
import com.nbelyse.bill.api.ApiInterface
import com.nbelyse.bill.model.LoginRequest
import com.nbelyse.bill.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response

class LoginRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
     return withContext(Dispatchers.IO){
         apiClient.registerUserLogin(loginRequest)
     }
    }
}