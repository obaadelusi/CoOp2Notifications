package com.oba.coop2notifications.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.oba.coop2notifications.Destination
import com.oba.coop2notifications.ui.components.PageScaffold
import com.oba.coop2notifications.ui.theme.Coop2NotificationsTheme

class BasicActivity: ComponentActivity() {
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

                    //BasicScreen(navController)
                    PageScaffold(navController = navController, page = Destination.Basic)
                }
            }
        }
    }
}