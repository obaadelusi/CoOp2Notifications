package com.oba.coop2notifications.ui.screens

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavController
import com.oba.coop2notifications.Destination
import com.oba.coop2notifications.MainActivity
import com.oba.coop2notifications.R
import com.oba.coop2notifications.ui.views.BasicActivity
import com.oba.coop2notifications.ui.views.CallStyleActivity
import com.oba.coop2notifications.ui.views.CustomActivity
import com.oba.coop2notifications.ui.views.ExpandableActivity


@Composable
fun HomeScreen(
    navController: NavController
) {

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally) {

            ElevatedButton(
                onClick = {
                          showNotification(context, "basic",
                              "Basic Notification",
                              "Basic just sent you a message!")
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(Destination.Basic.title.uppercase(), fontSize = 16.sp)
            }

            ElevatedButton(
                onClick = {
                          showNotification(context, "basic-action",
                              "Basic Notification w/ Action",
                              "This notification has an action!")
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("BASIC w/Action", fontSize = 16.sp)
            }

            ElevatedButton(
                onClick = {
                    showNotification(context, "expandable",
                        "Expandable Notification",
                        "Expandable just sent you a message!")
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
            ) {
                Text(Destination.Expandable.title.uppercase(), fontSize = 16.sp)
            }

            ElevatedButton(
                onClick = {
                    showNotification(context, "expandable-inbox",
                        "Expandable Notification",
                        "You have 5 new messages from ADEV!")
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
            ) {
                Text("EXPANDABLE w/Inbox", fontSize = 16.sp)
            }

            ElevatedButton(
                onClick = {
                    showNotification(context, "call-style",
                        "Call Style Notification",
                        "Call Style just sent you a message!")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("CALL STYLE w/Incoming", fontSize = 16.sp)
            }

            ElevatedButton(
                onClick = {
                    showNotification(context, "call-style-ongoing",
                        "Call Style Notification",
                        "Call Style just sent you a message!")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("CALL STYLE w/Ongoing", fontSize = 16.sp)
            }

//            ElevatedButton(
//                onClick = {
//                    showNotification(context, "time-sensitive",
//                        "Time Sensitive Notification",
//                        "Time Sensitive just sent you a message!")
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow,
//                                contentColor = Color.Black)
//            ) {
//            Text(Destination.TimeSensitive.title.uppercase(), fontSize = 16.sp)
//            }

            ElevatedButton(
                onClick = {
                    showNotification(context, "image",
                        "Image Notification",
                        "Tap to view your image!")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green,
                                contentColor = Color.Black)
            ) {
            Text("NOTIFICATION w/Image", fontSize = 16.sp)
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.P)
private fun showNotification(
    context: Context,
    type: String?,
    title: String?,
    message: String?
) {
    val CHANNEL_ID = "default_id"
    val CHANNEL_NAME = "Default Channel"
    val CHANNEL_DESC = "This is the channel description in BasicActivity.kt line29"

    // Set the notification content
    val notification = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_notification_coffee)
        .setColor(context.resources.getColor(R.color.teal_200))
        .setContentTitle(title)
        .setContentText(message)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notificationManager: NotificationManager =
        getSystemService(context, NotificationManager::class.java)
                as NotificationManager

    // Create a channel and set the importance
    // - Check if Android version is Oreo or higher
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH // Set the importance level
        ).apply {
            description = CHANNEL_DESC
        }

        //channel.enableLights(true) // Enable notification light
        //channel.lightColor = android.graphics.Color.RED // Set the notification light color
        //channel.enableVibration(true) // Enable vibration

        // Register the channel with the system
        notificationManager.createNotificationChannel(channel)
    }

    // Play notification sound
    //val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    //builder.setSound(defaultSoundUri)

    // Create an explicit intent for an Activity in your app.
    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    when (type) {
        "basic", "basic-action" -> {
            intent.setClass(context, BasicActivity::class.java)
        }
        "expandable", "expandable-inbox" -> {
            intent.setClass(context, ExpandableActivity::class.java)
        }
        "call-style", "call-style-ongoing" -> {
            intent.setClass(context, CallStyleActivity::class.java)
        }
//        "time-sensitive" -> {
//            intent.setClass(context, TimeSensitiveActivity::class.java)
//        }
        "image" -> {
            intent.setClass(context, CustomActivity::class.java)
        }
    }

    var pendingIntent =
        PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    notification.setContentIntent(pendingIntent)

    // Adding extra styles and features
    when (type) {
        "basic-action" -> {
            notification
                .addAction(R.drawable.ic_notification_coffee, "GO TO PAGE", pendingIntent)
        }
        "expandable" -> {
            val EXTRA_TEXT = "Try to expand this and see. Does it work? " +
                    "If it does, congratulations! If it doesn't, kindly debug. \n" +
                    "There should be a lot of text in this notification. " +
                    "You may click, or not. That's up to you. \n" +
                    "What about emojis: 😁. Do they work?"
            notification.setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(EXTRA_TEXT)
            )
        }
        "expandable-inbox" -> {
            notification
                .setLargeIcon(BitmapFactory
                    .decodeResource(Resources.getSystem(), R.drawable.ic_music_plate))
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("Mike says present!")
                        .addLine("Dani smiles?")
                        .addLine("Cong says yea yea")
                        .addLine("Zhikun drives")
                        .addLine("A message from Yi Siang")
                )
        }
        "call-style" -> {
            val incomingCaller = Person.Builder()
                .setName("Mike B.")
                .setImportant(true)
                .build()
            notification
                .setStyle(
                    NotificationCompat.CallStyle
                        .forIncomingCall(incomingCaller, pendingIntent, pendingIntent))
        }
        "call-style-ongoing" -> {
            val incomingCaller = Person.Builder()
                .setName("Dani Sanchez")
                .setImportant(true)
                .build()
            notification
                .setStyle(
                    NotificationCompat.CallStyle
                        .forOngoingCall(incomingCaller, pendingIntent))
        }
        "image" -> {
            notification
                .setLargeIcon(BitmapFactory
                    .decodeResource(context.resources, R.drawable.ic_launcher_background))
                .setStyle(NotificationCompat.BigPictureStyle()
                    .bigPicture(BitmapFactory
                        .decodeResource(context.resources, R.drawable.ic_launcher_background))
//                    .bigLargeIcon(null)
                )
        }
    }

    // Show the notification
    notificationManager.notify(0, notification.build())
}