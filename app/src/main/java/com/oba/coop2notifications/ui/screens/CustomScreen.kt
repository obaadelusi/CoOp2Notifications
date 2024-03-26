package com.oba.coop2notifications.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.oba.coop2notifications.Destination
import com.oba.coop2notifications.ui.components.PageScaffold

@Composable
fun CustomScreen(
    navController: NavHostController
) {
    Column {
        Text(text = "Custom Screen")
    }
}