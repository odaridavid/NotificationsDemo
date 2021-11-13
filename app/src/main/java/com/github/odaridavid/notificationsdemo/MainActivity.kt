package com.github.odaridavid.notificationsdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val NOTIFICATION_ID = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SimpleNotification.createSimpleNotificationChannel(context = this)

        findViewById<Button>(R.id.showNotificationButton).setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                notify(
                    NOTIFICATION_ID,
                    SimpleNotification.createSimpleNotification(context = this@MainActivity)
                )
            }
        }

    }
}
