package com.github.odaridavid.notificationsdemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

object SimpleNotification {

    private const val CHANNEL_ID = "com.github.odaridavid.notificationsdemo.SimpleNotification"

    fun createSimpleNotification(context: Context): Notification =
        NotificationCompat.Builder(
            context,
            CHANNEL_ID
        ).apply {
            setContentTitle("Simple Notification")
            setContentText("The text to that simple notification")
            setSmallIcon(R.drawable.ic_android_black_24dp)
        }.build()

    fun createSimpleNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Simple Notification"
            val descriptionText = "Simple notification channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}
