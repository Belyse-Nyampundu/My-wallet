package com.nbelyse.bill.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.nbelyse.bill.databinding.ActivityLoginPageBinding
import com.nbelyse.bill.model.LoginRequest
import com.nbelyse.bill.viewmodel.UserViewModel
import androidx.lifecycle.ViewModel
import com.nbelyse.bill.model.LoginResponse
import com.nbelyse.bill.viewmodel.LoginViewModel

class LoginPage : AppCompatActivity() {
    lateinit var binding: ActivityLoginPageBinding
    val userViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onResume()
    }

    override fun onResume() {
        super.onResume()
        clearErrorOnType()

//        binding.btnLogin2.setOnClickListener {
//            validateLogins()
//        }
        binding.btnLogin2.setOnClickListener {
            val intent = Intent(this@LoginPage,HomePage::class.java)
            startActivity(intent)
            validateLogins()
        }
        userViewModel.errLiveData.observe(this, Observer {
            err->Toast.makeText(this,err,Toast.LENGTH_LONG).show()
//            binding.progressBar
        })
        userViewModel.loginLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(this,loginResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,HomePage::class.java))
        })



//
//            userViewModel.regLiveData.observe(this){ regResponse ->
//                Toast.makeText(this,regResponse.message, Toast.LENGTH_LONG).show()
//
//            }
//            userViewModel.errLiveDta.observe(this){err->
//                Toast.makeText(this,err, Toast.LENGTH_LONG).show()
//            }
//
//
//
//        }
    }
    fun clearErrorOnType() {

        binding.etEmailLogin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.etEmailLogin.error = null

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmailLogin.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.etPasswordLogin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.tilPasswordLogin.error = null

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPasswordLogin.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        }
 fun validateLogins(){
     var email = binding.etEmailLogin.text.toString()
     var password = binding.etPasswordLogin.text.toString()

     var error = false


     if(email.isBlank()){
         binding.tilEmailLogin.error = "Email is required"
         error = true
     }
     if(password.isBlank()){
         binding.tilPasswordLogin.error = "Password is needed"
         error = true
     }


     if (!error){
         val loginRequest= LoginRequest(
             email = email,
             password = password

         )
         userViewModel.loginUser(loginRequest)

//       userViewModel.loginUser(loginRequest)
//         UserViewModel.loginUser(loginRequest)
//         UserViewModel.





     }
 }

}