package org.sopt.play

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.sopt.play.ui.theme.SoptColor
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.ui.theme.PlaySoptTheme
import org.sopt.play.ui.theme.SoptTypography

class RegisterActivity : ComponentActivity() {
    private val registerViewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterScreen(
                        name = registerViewModel.name,
                        email = registerViewModel.email,
                        password = registerViewModel.password,
                        confirmPassword = registerViewModel.confirmPassword,
                        emailError = registerViewModel.emailError,
                        passwordError = registerViewModel.passwordError,
                        confirmPasswordError = registerViewModel.confirmPasswordError,
                        canRegister = registerViewModel.canRegister,
                        onNameChange = registerViewModel::onNameChange,
                        onEmailChange = registerViewModel::onEmailChange,
                        onPasswordChange = registerViewModel::onPasswordChange,
                        onConfirmPwChange = registerViewModel::onConfirmPwChange,
                        modifier = Modifier.padding(innerPadding),
                        onRegisterClick={ email, pw ->
                            intent.putExtra("email", email)
                            intent.putExtra("pw",pw)
                            setResult(RESULT_OK, intent)
                            finish()
                        })
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    emailError: Boolean,
    passwordError: Boolean,
    confirmPasswordError: Boolean,
    canRegister: Boolean,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPwChange: (String) -> Unit,
    modifier: Modifier= Modifier,
    onRegisterClick: (String, String) -> Unit
        )
{

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "이메일로 회원가입",
            color = SoptColor.Black,
            style = SoptTypography.b28
        )

        Spacer(modifier = Modifier.height(40.dp))


        // 이름 입력

        Text("이름",
            color = SoptColor.Gray6,
            style = SoptTypography.sb16)

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = onNameChange,
            textStyle = SoptTypography.m18,
            placeholder = { Text("홍길동",
                style = SoptTypography.m18,
                color= SoptColor.Gray2) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =SoptColor.Gray5,
                unfocusedBorderColor = SoptColor.Gray2

            )
        )
        Spacer(modifier = Modifier.height(32.dp))


        // 이메일 입력
        Text("이메일주소",
            color = SoptColor.Gray6,
            style = SoptTypography.sb16)

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = onEmailChange,
            textStyle = SoptTypography.m18,
            placeholder = { Text(text = "abc@email.com",
                style = SoptTypography.m18,
                color= SoptColor.Gray2) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =
                    if (email.isNotEmpty() && emailError) SoptColor.Red
                    else SoptColor.Gray5,
                unfocusedBorderColor = SoptColor.Gray2
            )
        )
        if (email.isNotEmpty() && emailError) {
            Text(text = "올바른 이메일을 입력해주세요.",
                style = SoptTypography.m18,
                color = SoptColor.Red)
        }


        Spacer(modifier = Modifier.height(32.dp))


        //비밀번호 입력
        Text("비밀번호",
            color = SoptColor.Gray6,
            style = SoptTypography.sb16)
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = onPasswordChange,
            textStyle = SoptTypography.m18,
            placeholder = { Text(text = "6자 이상의 비밀번호",
                style = SoptTypography.m18,
                color= SoptColor.Gray2) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =
                    if (password.isNotEmpty() && passwordError) SoptColor.Red
                    else SoptColor.Gray5,
                unfocusedBorderColor = SoptColor.Gray2
            ),
            visualTransformation = PasswordVisualTransformation(),
        )
        if (password.isNotEmpty() && passwordError) {
            Text(text = "비밀번호는 6자 이상 입력해주세요.",
                style = SoptTypography.m18,
                color= SoptColor.Red)
        }

        Spacer(modifier = Modifier.height(32.dp))


        // 비밀번호 확인
        Text("비밀번호 확인",
            color = SoptColor.Gray6,
            style = SoptTypography.sb16)
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = confirmPassword,
            onValueChange = onConfirmPwChange,
            textStyle = SoptTypography.m18,
            placeholder = { Text("6자 이상의 비밀번호",
                style = SoptTypography.m18,
                color= SoptColor.Gray2) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =
                    if (confirmPassword.isNotEmpty() && confirmPasswordError) SoptColor.Red
                    else SoptColor.Gray5,
                unfocusedBorderColor = SoptColor.Gray2,
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        if (password.isNotEmpty() && confirmPasswordError) {
            Text(text = "비밀번호와 동일하게 입력해주세요.",
                style = SoptTypography.m18,
                color= SoptColor.Red)
        }

        Spacer(modifier = Modifier.height(32.dp))


        // 회원가입 버튼
        Button(
            onClick = {
                onRegisterClick(email, password)
            },
            enabled = canRegister,
            colors = ButtonDefaults.buttonColors(
                containerColor = SoptColor.Black,
                contentColor = SoptColor.Gray1,

                disabledContainerColor = SoptColor.Gray1,
                disabledContentColor = SoptColor.Gray3
            ),
            modifier= Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text("회원가입",
                style = SoptTypography.sb14)
        }


        }
    }




@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    PlaySoptTheme() {
        RegisterScreen(
            name = "홍길동",
            email = "abc@email.com",
            password = "123456",
            confirmPassword = "123456",
            emailError = false,
            passwordError = false,
            confirmPasswordError = false,
            canRegister = true,
            onNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPwChange = {},
            onRegisterClick = {email, password ->}
        )
    }
}
