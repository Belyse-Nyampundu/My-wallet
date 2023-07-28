package com.nbelyse.bill.repository

import com.nbelyse.bill.api.ApiClient
import com.nbelyse.bill.api.ApiInterface
import com.nbelyse.bill.model.LoginRequest
import com.nbelyse.bill.model.LoginResponse
import com.nbelyse.bill.model.RegisterRequest
import com.nbelyse.bill.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

 suspend fun register(registerRequest: RegisterRequest):
         Response<RegisterResponse>{
     return withContext(Dispatchers.IO){
         apiClient.registerUser(registerRequest)
     }

 }
    suspend fun login(loginRequest: LoginRequest):
            Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiClient.registerUserLogin(loginRequest)
        }
    }
}
