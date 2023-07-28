package com.nbelyse.bill.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbelyse.bill.model.LoginRequest
import com.nbelyse.bill.model.LoginResponse
import com.nbelyse.bill.model.RegisterRequest
import com.nbelyse.bill.model.RegisterResponse
import com.nbelyse.bill.repository.UserRepository

import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {

    val userRepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterResponse>()
    val loginLiveData = MutableLiveData<LoginResponse>()
    val errLiveDta = MutableLiveData<String>()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userRepo.register(registerRequest)
            if(response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveDta.postValue(response.errorBody()?.string())
            }
        }
    }

}