package com.open6.taleadventure.service

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.open6.taleadventure.R
import com.open6.taleadventure.data.local.TaleAdventureSharedPreferences
import com.open6.taleadventure.presentation.main.view.MainActivity
import com.open6.taleadventure.util.PublicString.DID_USER_CHOOSE_TO_BE_NOTIFIED
import com.open6.taleadventure.util.PublicString.NOTIFICATION_CONTENT_TEXT_KEY
import com.open6.taleadventure.util.PublicString.NOTIFICATION_CONTENT_TITLE_KEY
import com.open6.taleadventure.util.PublicString.NOTIFICATION_ID
import timber.log.Timber

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Timber.tag("FCM").d("fcm token : $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Timber.tag("FCM").d(message.notification.toString())
        Timber.tag("FCM").d(message.data.toString())
        makePushAlarm(message)
    }


    private fun makePushAlarm(message: RemoteMessage) {
        val requestCode = 0
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            requestCode,
            intent,
            PendingIntent.FLAG_IMMUTABLE,
        )

        val builder = NotificationCompat.Builder(this, packageName)
            .setSmallIcon(R.drawable.ic_push_alarm)
            .setContentTitle(message.data[NOTIFICATION_CONTENT_TITLE_KEY])
            .setColor(getColor(R.color.purple_200_aa79ed))
            .setContentText(message.data[NOTIFICATION_CONTENT_TEXT_KEY])
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val channel = NotificationChannel(
            packageName, getString(R.string.channel_name), NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = getString(R.string.channel_desc)
        }

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED && TaleAdventureSharedPreferences.getBoolean(
                DID_USER_CHOOSE_TO_BE_NOTIFIED
            )
        ) {
            notificationManager.notify(NOTIFICATION_ID, builder.build())
        }
    }
}