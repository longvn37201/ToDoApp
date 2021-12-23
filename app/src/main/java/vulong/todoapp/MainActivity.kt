package vulong.todoapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import vulong.todoapp.navigation.Navigation
import vulong.todoapp.ui.theme.ToDoAppTheme
import vulong.todoapp.util.Constants.NOTIFICATION_CHANNEL_DISPLAY_NAME
import vulong.todoapp.util.Constants.NOTIFICATION_CHANNEL_ID

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val id = intent.getIntExtra("id", -1)
        createNotificationChanel()
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                Navigation(id)
            }
        }
    }

    private fun createNotificationChanel() {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_DISPLAY_NAME,
            NotificationManager.IMPORTANCE_HIGH,
        )
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}
