package org.sopt.play

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.sopt.play.ui.theme.SoptColor
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.ui.theme.PlaySoptTheme
import org.sopt.play.ui.theme.SoptTypography

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterScreen(modifier = Modifier.padding(innerPadding),
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
        modifier: Modifier= Modifier,
        onRegisterClick: (String, String) -> Unit
        )
{
    var name by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var confirmPw by remember { mutableStateOf(value = "") }
    val emailError=!Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val passwordError=password.length<6
    val confirmPasswordError = confirmPw!=password

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
            onValueChange = { name = it },
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
            onValueChange = { email = it },
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
            onValueChange = { password = it },
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
            value = confirmPw,
            onValueChange = { confirmPw = it },
            placeholder = { Text("6자 이상의 비밀번호",
                style = SoptTypography.m18,
                color= SoptColor.Gray2) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =
                    if (confirmPw.isNotEmpty() && confirmPasswordError) SoptColor.Red
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
            enabled = !emailError && !passwordError && !confirmPasswordError,
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
            onRegisterClick = {email, password ->}
        )
    }
}
