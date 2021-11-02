package vulong.todoapp.navigation

import androidx.navigation.NavHostController
import vulong.todoapp.util.Action
import vulong.todoapp.util.Constants.LIST_SCREEN
import vulong.todoapp.util.Constants.SPLASH_SCREEN

class ScreenDirections(navController: NavHostController) {

    val splashToList: () -> Unit = {
        navController.navigate("list/${Action.NO_ACTION.name}") {
            popUpTo(SPLASH_SCREEN) {
                inclusive = true
            }
        }
    }

    val listToTask: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

    val taskToList: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }
}
