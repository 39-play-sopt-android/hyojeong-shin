package org.sopt.play

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    private var registeredEmail = ""
    private var registeredPassword = ""

    fun onEmailChange(value: String) {
        email=value
    }

    fun onPasswordChange(value: String) {
        password=value
    }

    fun onRegisterSuccess(email: String, password: String) {
        registeredEmail=email
        registeredPassword=password
        this.email=email
        this.password=password
    }

    fun canLogin(): Boolean {
        return email== registeredEmail&&
                password==registeredPassword
    }
}