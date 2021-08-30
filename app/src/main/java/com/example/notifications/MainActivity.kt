package com.example.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val NOTIFICATION_CHANNEL_ID = "My channel"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        choosechannel()
        notif.setOnClickListener {
            allow()
        }
    }
    fun choosechannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel=NotificationChannel(NOTIFICATION_CHANNEL_ID,"My Title",NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE)as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    var count=0
     fun allow() {
        val builder = NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID)
        builder.setContentTitle("My Title")
        builder.setContentText("This is my notification ${count++}")
         builder.setSmallIcon(R.mipmap.ic_launcher)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE)as NotificationManager
        notificationManager.notify(NOTIFICATION_CHANNEL_ID,count,builder.build())
    }
}