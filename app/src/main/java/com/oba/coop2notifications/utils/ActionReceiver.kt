package com.oba.coop2notifications.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController


internal class ActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        //Toast.makeText(context,"received",Toast.LENGTH_SHORT).show();

        val action = intent.getStringExtra("action")

        if (action == "basic") {
//            performAction1()
            Log.d("onNotifClick", "You clicked on the basic notification action")
        } else if (action == "expandable") {
            Log.d("onNotifClick", "You clicked on the expandable notification")
        } else {
            Log.d("onNotifClick", "What did you click on?")
        }

        //This is used to close the notification tray
        val it = Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS")
        context.sendBroadcast(it)
    }
}