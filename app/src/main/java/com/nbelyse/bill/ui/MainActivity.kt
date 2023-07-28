package com.nbelyse.bill.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.nbelyse.bill.databinding.ActivityMainBinding
import com.nbelyse.bill.model.RegisterRequest
import com.nbelyse.bill.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onResume()
    }

    override fun onResume() {
        super.onResume()
        clearErrorOnType()

        binding.btnSignUp.setOnClickListener {
                validateRegisters()
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginPage::class.java)
            startActivity(intent)

        }

        userViewModel.regLiveData.observe(this){ regResponse ->
            Toast.makeText(this,regResponse.message,Toast.LENGTH_LONG).show()

        }
        userViewModel.errLiveDta.observe(this){err->
            Toast.makeText(this,err,Toast.LENGTH_LONG).show()
        }



        }
        fun clearErrorOnType() {

            binding.etFirstName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.tilFirstName.error = null

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.tilFirstName.error = null
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })
            binding.etLastName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.tilLastName.error = null

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.tilLastName.error = null
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })

            binding.etPhoneNumber.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.tilPhoneNumber.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.tilPhoneNumber.error = null
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })
            binding.etEmail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.tilEmail.error = null

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.tilEmail.error = null
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })
            binding.etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.tilPassword.error = null

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.tilPassword.error = null
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })


            binding.etConfirmPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    binding.tilconfirmPassword.error = null

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    binding.tilconfirmPassword.error = null
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })



        }

        fun validateRegisters() {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val phoneNumber = binding.etPhoneNumber.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val passwordConfirm = binding.etConfirmPassword.text.toString()


            var error = false

            if (firstName.isBlank()) {
                binding.tilFirstName.error = "First name is required"
                error = true
            }
            if (lastName.isBlank()) {
                binding.tilLastName.error = "Last name is required"
                error = true
            }

            if (phoneNumber.isBlank()) {
                binding.tilPhoneNumber.error = "contacts is required"
                error = true
            }

            if (email.isBlank()) {
                binding.tilEmail.error = "Email is required"
                error = true
            }

            if (password.isBlank()) {
                binding.tilPassword.error = "Email is required"
                error = true
            }

            if (password!=passwordConfirm){
                binding.tilconfirmPassword.error = "password don`t match password comfirmation is required"
                error = true
            }


//            not a must to follow order
            if (!error){
                val registerRequest= RegisterRequest(
                    firstName = firstName,
                    lastName = lastName,
                    phoneNumber= phoneNumber,
                    email = email,
                    password = password,

                )
             userViewModel.registerUser(registerRequest)
            }
//
//        if (!error) {
//            Toast.makeText(this, "$firstName,$phoneNumber, $email", Toast.LENGTH_LONG).show()
//        }




        }}

