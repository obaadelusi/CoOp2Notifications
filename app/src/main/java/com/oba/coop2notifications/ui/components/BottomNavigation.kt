package com.oba.coop2notifications.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oba.coop2notifications.Destination


@Composable
fun BottomNavigation(navController: NavController){
    BottomAppBar(tonalElevation = 7.dp) {
        val navBackStackEntry = navController.currentBackStackEntry
        val currentDestination = navBackStackEntry?.destination //maybe comeback?

        NavigationBarItem(
            icon = {
                Icon(Icons.Default.Home, contentDescription = "Home")
            },
            label = { Text(text = Destination.Home.title) },
            selected = currentDestination?.route == Destination.Home.route,
            onClick = {
                navController.navigate(Destination.Home.route){
                    popUpTo(Destination.Home.route) {inclusive= true}
                    launchSingleTop = true
                }
            }

        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Default.Info, contentDescription = "Project information")
            },
            label = { Text(text = Destination.About.title) },
            selected = currentDestination?.route == Destination.About.route,
            onClick = {
                navController.navigate(Destination.About.route){
                    popUpTo(Destination.About.route)
                    launchSingleTop = true
                }
            },

        )
    }

}
