package org.sopt.play

import org.sopt.play.R
import androidx.compose.ui.text.font.Font
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.play.ui.theme.PlaySoptTheme

class LoginActivity : ComponentActivity() {
    private var registeredEmail=""
    private var registeredPassword=""
    private val registerLauncher=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
        if (result.resultCode==RESULT_OK) {
            registeredEmail=result.data?.getStringExtra("email")?:""
            registeredPassword=result.data?.getStringExtra("pw")?:""

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        onLoginClick={ email, password ->
                            if (email==registeredEmail && password==registeredPassword) {
                                val intent= Intent(
                                    this@LoginActivity,
                                    MainActivity::class.java
                                ).apply {
                                    flags= Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                }
                                startActivity(intent)
                            }

                        },
                        onRegisterClick={
                            registerLauncher.launch(
                                Intent(this@LoginActivity, RegisterActivity::class.java)
                            )
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier= Modifier,
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit
) {
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    val emailError=!email.contains("@") || !email.contains(".com")
    val passwordError=password.length<6

    val context = LocalContext.current


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "이메일로 로그인하기",
            fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text("이메일주소")

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("abc@email.com", color= Color(0xFFD1D5D6)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =
                    if (email.isNotEmpty() && emailError) Color.Red
                    else Color(0xFF505559),
                unfocusedBorderColor = Color(0xFFD1D5D6)
            ),

        )

        if (email.isNotEmpty() && emailError) {
            Text(text = "올바른 이메일을 입력해주세요.",
                color = Color.Red)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("비밀번호")
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("6자 이상의 비밀번호", color= Color(0xFFD1D5D6)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =
                    if (password.isNotEmpty() && passwordError) Color.Red
                    else Color(0xFF505559),
                unfocusedBorderColor = Color(0xFFD1D5D6),
            ),
            visualTransformation = PasswordVisualTransformation()

        )
        Spacer(modifier = Modifier.height(6.dp))

        if (password.isNotEmpty() && passwordError) {
            Text(text = "비밀번호는 6자 이상 입력해주세요.",
                color= Color.Red)
        }

        Spacer(modifier = Modifier.height(40.dp))

        //로그인버튼
        Button(
            onClick = {
                onLoginClick(email,password)
            },
            enabled = !emailError && !passwordError,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color(0xFFF7F7F7),

                disabledContainerColor = Color(0xFFF7F7F7),
                disabledContentColor = Color(0xFFB2BABD)
            ),
            modifier= Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("로그인")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .requiredHeightIn()
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("아직 계정이 없으신가요?", color = Color(0xFFB2BABD))

            TextButton(
                onClick = onRegisterClick
            ) {
                Text("회원가입하기", color= Color.Black,
                    )
            }
        }
    }


}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PlaySoptTheme() {
        LoginScreen(
            onLoginClick = {email, password ->},
            onRegisterClick = {}
        )
    }
}

