package com.example.gameapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginPage(navCont: NavController) {
    //Mutable state so the value can be changed
    val userEmail = remember { mutableStateOf("") }
    val userPass = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAABBCC))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        //Text boxes for email and pass
        TextField(
            value = userEmail.value,
            onValueChange = { userEmail.value = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = userPass.value,
            onValueChange = { userPass.value = it },
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //Goes to main screen
            navCont.navigate("welcomePage")
        }) {
            Text("Login")
        }
    }
}