package com.example.lecture24_1.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lecture24_1.model.remote.request.LoginRequest
import com.example.lecture24_1.model.remote.response.LoginResponse
import com.example.lecture24_1.model.repository.LoginRepository
import com.example.lecture24_1.model.repository.NetworkData
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(): ViewModel() {

    val emailId = ObservableField<String>("")
    val password = ObservableField<String>("")

    val loginResponse = MutableLiveData<LoginResponse>()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<String>()

    fun login(){
        val loginRequest = LoginRequest(emailId.get()?:"NA", password.get()?:"NA")

        val observeLogin = LoginRepository(NetworkData()).fetchDataFromNetwork(loginRequest)

        observeLogin.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())
    }

    private fun getObserver(): Observer<LoginResponse> {
        return object:Observer<LoginResponse>{
            override fun onSubscribe(d: Disposable) {
                Log.d("LOGIN", "onSubscribe")
            }

            override fun onNext(t: LoginResponse) {
                t.token.let{
                    success.postValue("Login Successful")
                    Log.d("LOGIN", "SUCCESS")
                }
            }

            override fun onError(e: Throwable) {
                error.postValue(e.message)
                Log.d("LOGIN", "FAIL: ${e.message}")
            }

            override fun onComplete() {
                Log.d("LOGIN", "OnComplete")
            }

        }
    }
}