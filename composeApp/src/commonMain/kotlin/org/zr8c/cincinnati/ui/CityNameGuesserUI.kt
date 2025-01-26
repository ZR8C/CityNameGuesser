package org.zr8c.cincinnati.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.zr8c.cincinnati.data.levenshteinDistance
import org.zr8c.cincinnati.data.wrongWaysToSpellCincinnati

@Composable
fun CityNameGuesserUI() {
    var cityName by remember { mutableStateOf("") }
    var guess: String? by remember { mutableStateOf(null)}

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("City Name Quiz")
                }
            },
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val textFieldModifier = Modifier.fillMaxWidth(0.5f)

                TextField(
                    value = cityName,
                    onValueChange = { cityName = it },
                    label = { Text("Enter guess") },
                    modifier = textFieldModifier,
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    enabled = guess == null
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        guess = cityName
                    },
                    modifier = textFieldModifier,
                    enabled = guess == null
                ) {
                    val text = if (guess == null) "Submit" else "WRONG!"
                    Text(text)
                }
                Spacer(modifier = Modifier.height(16.dp))
                AnimatedVisibility(visible = guess != null) {
                    Column {
                        Row {
                            Text("The answer was: Cincinnati")
                        }
                        Row {
                            Text("Your guess was: ${if (levenshteinDistance("Cincinnati", cityName) <= 1) wrongWaysToSpellCincinnati.random() else guess}")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}