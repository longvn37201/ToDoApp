package vulong.todoapp.util

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import vulong.todoapp.MainActivity
import vulong.todoapp.R
import vulong.todoapp.util.Constants.NOTIFICATION_CHANNEL_ID

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        //id title from Broadcast
        val id = intent?.getIntExtra("id", -1)
        val title = intent?.getStringExtra("title")

        //open task(id) in main
        val goToMain = Intent(context, MainActivity::class.java)
        goToMain.putExtra("id", id)
        val pendingIntent = PendingIntent.getActivity(
            context!!,
            id!!,
            goToMain,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_CANCEL_CURRENT
        )

        val builder = NotificationCompat
            .Builder(context, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_alarm)
            .setContentTitle("Note: $title")
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(id, builder.build())

    }

}