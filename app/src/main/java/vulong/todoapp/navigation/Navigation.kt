package vulong.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import vulong.todoapp.navigation.destionations.listComposable
import vulong.todoapp.navigation.destionations.splashComposable
import vulong.todoapp.navigation.destionations.taskComposable
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.Constants.SPLASH_SCREEN

@Composable
fun Navigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
) {

    val direction = remember(navController) {
        ScreenDirections(navController = navController)
    }

    NavHost(navController = navController, startDestination = SPLASH_SCREEN) {
        splashComposable(
            navigateToListScreen = direction.splashToList
        )
        listComposable(
            sharedViewModel = sharedViewModel,
            navigateToTaskScreen = direction.listToTask,
        )
        taskComposable(
            sharedViewModel = sharedViewModel,
            navigateToListScreen = direction.taskToList,
        )
    }

}
