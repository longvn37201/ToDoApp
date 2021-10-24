package vulong.todoapp.navigation.destionations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import vulong.todoapp.ui.screens.list.ListScreen
import vulong.todoapp.util.Constants.LIST_ARGUMENT_KEY
import vulong.todoapp.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) { type = NavType.StringType })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}