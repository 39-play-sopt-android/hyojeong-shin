package org.sopt.play

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var name by mutableStateOf(value = "")
        private set

    var email by mutableStateOf(value = "")
        private set

    var password by mutableStateOf(value = "")
        private set

    var confirmPassword by mutableStateOf(value = "")
        private set

    val emailError: Boolean
        get() = !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    val passwordError: Boolean
        get() = password.length < 6

    val confirmPasswordError: Boolean
        get() = confirmPassword != password

    val canRegister: Boolean
        get() = !emailError && !passwordError && !confirmPasswordError

    fun onNameChange(value: String) {
        name = value
    }

    fun onEmailChange(value: String) {
        email=value
    }

    fun onPasswordChange(value: String) {
        password=value
    }

    fun onConfirmPwChange(value: String) {
        confirmPassword=value
    }

}
