package com.example.Assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.Assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier= Modifier) {
    var email by remember { mutableStateOf(value = "") }
    var pw by remember { mutableStateOf(value = "") }

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Text(
            text = "이메일로 로그인하기",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text("이메일주소")

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("abc@email.com") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("비밀번호")

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = pw,
            onValueChange = { pw = it },
            placeholder = { Text("6자 이상의 비밀번호") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val intent = Intent(context, NextActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or
                            Intent.FLAG_ACTIVITY_NEW_TASK
                }

                context.startActivity(intent)
            }
        ) {
            Text("로그인")
        }

        Row(
            modifier = Modifier.requiredHeightIn()
        ) {
            Text("아직 계정이 없으신가요?")

            Button(
                onClick = {
                    val intent = Intent(context, RegisterActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                Intent.FLAG_ACTIVITY_NEW_TASK
                    }

                    context.startActivity(intent)
                }
            ) {
                Text("회원가입하기")
            }
        }
    }


}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AssignmentTheme {
        LoginScreen()
    }
}

