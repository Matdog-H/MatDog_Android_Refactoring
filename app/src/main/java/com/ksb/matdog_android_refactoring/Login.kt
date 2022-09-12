package com.ksb.matdog_android_refactoring

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Login() {
    var text by remember { mutableStateOf(TextFieldValue(""))}
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("\uD83D\uDC36MatDog\uD83D\uDC36")
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text(text = "아이디") }
        )
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text(text = "비밀번호") }
        )
        Button(
            onClick = { print("로그인 버튼 클릭")},
            contentPadding = PaddingValues(12.dp)){
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    Login()
}

