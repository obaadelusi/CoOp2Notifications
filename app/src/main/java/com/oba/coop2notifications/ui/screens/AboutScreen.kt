package com.oba.coop2notifications.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
    ) {
        Column {
            Text(
                "Co-Op Learning Demo 2",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 12.dp))

            Text("Title: Notifications",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp))
            
            Text("This is one in three co-op learning demo: an ongoing assignment designed to help students participate in shared learning. " +
                    "",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 12.dp))

            Text(
                "Here are some tasks to do: ",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 2.dp))

            Text(
                "- Find a feature you want to add to your final project\n" +
                        "- Research the feature.\n" +
                        "- Implement the feature\n" +
                        "- Report your findings to the class. \n",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}