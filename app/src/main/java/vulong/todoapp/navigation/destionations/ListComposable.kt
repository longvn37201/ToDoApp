package vulong.todoapp.navigation.destionations

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import vulong.todoapp.ui.screens.list.ListScreen
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.Constants.LIST_ARGUMENT_KEY
import vulong.todoapp.util.Constants.LIST_SCREEN
import vulong.todoapp.util.toAction

fun NavGraphBuilder.listComposable(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) { type = NavType.StringType })
    ) {
        val action = it.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        LaunchedEffect(key1 = action) {
            sharedViewModel.handleDatabaseActions(action = action)
        }

        ListScreen(
            sharedViewModel = sharedViewModel,
            navigateToTaskScreen = navigateToTaskScreen,
        )
    }
}