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
fun RegisterPage(navCont: NavController) {
    //Initalize varibles to store input
    val fName = remember { mutableStateOf("") }
    val fLname = remember { mutableStateOf("") }
    val dBirth = remember { mutableStateOf("") }
    val userEmail = remember { mutableStateOf("") }
    val userPass = remember { mutableStateOf("") }
    val errorMsg = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .background(Color(0xFFAABBCC))
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        //Text boxes for user input
        TextField(
            value = fName.value,
            onValueChange = { fName.value = it },
            label = { Text("First Name") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = fLname.value,
            onValueChange = { fLname.value = it },
            label = { Text("Family Name") }
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = dBirth.value,
            onValueChange = { dBirth.value = it },
            label = { Text("Date of Birth") }
        )
        Spacer(modifier = Modifier.height(20.dp))

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

        //Register button and also check for data validation
        Button(onClick = {
            if (fName.value.isEmpty() || fLname.value.isEmpty() ||
                dBirth.value.isEmpty() || userEmail.value.isEmpty() || userPass.value.isEmpty()) {
                errorMsg.value = "Every box needs to be filled"
            } else if (fName.value.length !in 3..30) {
                errorMsg.value = "First name must be at least 3 charactters and max 30"
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail.value).matches()) {
                errorMsg.value = "Enter a valid email"
            } else {
                errorMsg.value = null
                navCont.navigate("loginRegister")
            }
        }) {
            Text("Register")
        }

        errorMsg.value?.let {
            Text(text = it, color = Color.Blue, modifier = Modifier.padding(top = 20.dp))
        }
    }
}
