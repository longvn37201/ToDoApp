package vulong.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import vulong.todoapp.navigation.destionations.listComposable
import vulong.todoapp.navigation.destionations.taskComposable
import vulong.todoapp.util.Constants.LIST_SCREEN

@Composable
fun Navigation(
    navController: NavHostController,
) {

    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }

}
