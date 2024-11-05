package com.example.gameapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun GameCenter(navCont: NavHostController) {
    // Track selected answers for each question
    var answer1 by remember { mutableStateOf<Int?>(null) }
    var answer2 by remember { mutableStateOf<Int?>(null) }
    var answer3 by remember { mutableStateOf<Int?>(null) }
    var answer4 by remember { mutableStateOf(setOf<Int>()) }
    var answer5 by remember { mutableStateOf(setOf<Int>()) }

    // Define correct answers for each questions
    val correctAnswers = listOf(
        0,
        3,
        2,
        setOf(0, 1, 3),
        setOf(0, 1, 2, 3)
    )

    // Track the score and whether answers have been submitted
    var score by remember { mutableStateOf<Int?>(null) }

    // Display all questions in a  LazyColumn so its scrollable
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFAABBCC))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Question 1
        item {
            Text("1. What state is Long Island a part of?", fontSize = 18.sp)
            listOf("NY", "WI", "TX", "AL").forEachIndexed { index, option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = answer1 == index,
                        onClick = { answer1 = index }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        // MCQ Questions
        item {
            Text("2. How many states are in the US?", fontSize = 18.sp)
            listOf("0", "12", "55", "50").forEachIndexed { index, option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = answer2 == index,
                        onClick = { answer2 = index }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        // MCQ questions
        item {
            Text("3. Where is Farmingdale State College Located?", fontSize = 18.sp)
            listOf("Commack", "Bronx", "Farmingdale", "Mastic").forEachIndexed { index, option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = answer3 == index,
                        onClick = { answer3 = index }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        // Question with multiple answers
        item {
            Text("4. Which are Apple products?", fontSize = 18.sp)
            listOf("iPhone", "Mac", "iPod", "AirPods").forEachIndexed { index, option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = answer4.contains(index),
                        onCheckedChange = {
                            answer4 = if (answer4.contains(index)) answer4 - index else answer4 + index
                        }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        // Question with multiple answers
        item {
            Text("5. Which are names of states?", fontSize = 18.sp)
            listOf("NY", "TX", "AL", "NV").forEachIndexed { index, option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = answer5.contains(index),
                        onCheckedChange = {
                            answer5 = if (answer5.contains(index)) answer5 - index else answer5 + index
                        }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        // Submit Button
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    // Calculate score
                    score = listOf(
                        answer1 == correctAnswers[0],
                        answer2 == correctAnswers[1],
                        answer3 == correctAnswers[2],
                        answer4 == correctAnswers[3],
                        answer5 == correctAnswers[4]
                    ).count { it }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Answers (Scroll down for score after click)")
            }

            // Display the score
            if (score != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Your Score: $score/${correctAnswers.size}",
                    fontSize = 20.sp,
                )
            }
        }
    }
}
