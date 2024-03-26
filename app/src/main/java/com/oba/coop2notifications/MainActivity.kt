package com.oba.coop2notifications

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.oba.coop2notifications.ui.components.PageScaffold
import com.oba.coop2notifications.ui.theme.Coop2NotificationsTheme

sealed class Destination(val route: String, val title: String) {
    data object Home: Destination("home", "Home")
    data object About: Destination("about", "About")
    data object Basic: Destination("basic", "Basic")
    data object Expandable: Destination("expandable", "expandable")
    data object CallStyle: Destination("call-style", "Call Style")
    data object TimeSensitive: Destination("time-sensitive", "Time Sensitive")
    data object Custom: Destination("custom", "Custom")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Coop2NotificationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    HomeScaffold(navController)
                }
            }
        }
    }
}


@Composable
fun HomeScaffold(
    navController: NavHostController
) {
    PageScaffold(navController = navController, page = Destination.Home)
}