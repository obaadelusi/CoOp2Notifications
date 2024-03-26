package com.oba.coop2notifications.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.oba.coop2notifications.Destination
import com.oba.coop2notifications.ui.components.PageScaffold

@Composable
fun TimeSensitiveScreen(
    navController: NavHostController
) {
    Column {
        Text(text = "Time Sensitive Screen")
    }
}