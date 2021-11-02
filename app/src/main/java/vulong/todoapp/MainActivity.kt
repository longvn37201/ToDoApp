package vulong.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vulong.todoapp.navigation.Navigation
import vulong.todoapp.ui.theme.ToDoAppTheme
import vulong.todoapp.ui.viewmodels.SharedViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                navController = rememberNavController()
                Navigation(
                        navController = navController,
                        sharedViewModel = sharedViewModel
                )
            }
        }
    }
}
