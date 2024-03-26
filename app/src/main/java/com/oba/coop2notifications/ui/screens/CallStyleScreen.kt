package com.oba.coop2notifications.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CallStyleScreen(
    navController: NavHostController
) {
    Column(
        Modifier.padding(8.dp)
    ) {
        Text(
            "Call Style Notification",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp))

        Text("Congratulations! You just Accepted/Declined a call.\n" +
                "Or worse, you hung up. Why?",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 12.dp))

        Text("Anyways, go check out other notification styles.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 12.dp))
    }
}