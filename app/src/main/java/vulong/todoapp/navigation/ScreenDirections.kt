package vulong.todoapp.navigation

import androidx.navigation.NavHostController
import vulong.todoapp.util.Action
import vulong.todoapp.util.Constants.HOME_SCREEN
import vulong.todoapp.util.Constants.SPLASH_SCREEN

class ScreenDirections(navController: NavHostController) {

    val splashToHome: () -> Unit = {
        navController.navigate("home/${Action.NO_ACTION.name}") {
            popUpTo(SPLASH_SCREEN) {
                inclusive = true
            }
        }
    }

    val homeToTask: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

    val taskToHome: (Action) -> Unit = { action ->
        navController.navigate("home/${action.name}") {
            popUpTo(HOME_SCREEN) {
                inclusive = true
            }
        }
    }
}
