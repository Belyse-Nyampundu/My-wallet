package com.nbelyse.bill.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbelyse.bill.model.LoginRequest
import com.nbelyse.bill.model.LoginResponse
import com.nbelyse.bill.model.RegisterRequest
import com.nbelyse.bill.model.RegisterResponse
import com.nbelyse.bill.repository.LoginRepository
import com.nbelyse.bill.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {

    val loginRepo = LoginRepository()
    val loginLiveData = MutableLiveData<LoginResponse>()
    val errLiveData = MutableLiveData<String>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = loginRepo.loginUser(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())

            }else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
