package com.example.gameapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GameRules(navCont: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAABBCC))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Game Rules",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(text = " 5 questions in total", fontSize = 16.sp)
        Text(text = " Questions 1-3: multiple choice (one correct answer)", fontSize = 16.sp)
        Text(text = " Questions 4-5: multiple answers (select all that apply)", fontSize = 16.sp)
        Text(text = " Score will be shown at the end", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navCont.navigate("gameCenter") }) {
            Text(text = "Start Quiz")
        }
    }
}
