package com.example.lecture24_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.lecture24_1.api.ApiClient
import com.example.lecture24_1.api.myviewmodel.LoginViewModel
import com.example.lecture24_1.api.request.LoginRequest
import com.example.lecture24_1.api.response.LoginResponse
import com.example.lecture24_1.databinding.ActivityMainBinding
import io.reactivex.Observable

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: LoginViewModel

    lateinit var loginResponse: LoginResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        setupObservers()
    }



    private fun setupObservers() {
        viewModel.success.observe(this){
                Toast.makeText(baseContext, it, Toast.LENGTH_LONG).show()
            }


        viewModel.error.observe(this){
            Toast.makeText(baseContext, it, Toast.LENGTH_LONG).show()
        }
    }
}