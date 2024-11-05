package com.example.gameapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginRegisterScreen(navCont: NavController) {
    Column(
        //Set alignment plus add background color
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAABBCC))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(140.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Welcome to my Quiz Game")
        Spacer(modifier = Modifier.height(30.dp))

        // Go to register Screen
        Button(onClick = { navCont.navigate("registerPage") }) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Go to login Screen
        Button(onClick = { navCont.navigate("loginPage") }) {
            Text(text = "Login")
        }
    }
}