package com.oba.coop2notifications.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oba.coop2notifications.Destination
import com.oba.coop2notifications.ui.screens.AboutScreen
import com.oba.coop2notifications.ui.screens.BasicScreen
import com.oba.coop2notifications.ui.screens.CallStyleScreen
import com.oba.coop2notifications.ui.screens.CustomScreen
import com.oba.coop2notifications.ui.screens.ExpandableScreen
import com.oba.coop2notifications.ui.screens.HomeScreen
import com.oba.coop2notifications.ui.screens.TimeSensitiveScreen

@Composable
fun PageScaffold(
    navController: NavHostController,
    page: Destination
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { paddingValues ->
        NavHost(navController = navController,
            startDestination = page.route,
            modifier = Modifier.padding(paddingValues))
        {
            composable(Destination.Home.route){
                HomeScreen(navController)
            }

            composable(Destination.About.route){
                AboutScreen()
            }

            composable(Destination.Basic.route){
                BasicScreen(navController)
            }

            composable(Destination.Expandable.route){
                ExpandableScreen(navController)
            }

            composable(Destination.CallStyle.route){
                CallStyleScreen(navController)
            }

            composable(Destination.TimeSensitive.route){
                TimeSensitiveScreen(navController)
            }

            composable(Destination.Custom.route){
                CustomScreen(navController)
            }
        }
    }

}