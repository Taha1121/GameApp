package com.example.gameapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.navigation.NavController

@Composable
fun SplashScreen(navCont: NavController) {
    // Slow the splash Screen so its visable
    LaunchedEffect(Unit) {
        delay(1000)
        navCont.navigate("loginRegister") {
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(140.dp)
            )
            Text(text = "Game App", fontSize = 40.sp)
        }
    }
}
