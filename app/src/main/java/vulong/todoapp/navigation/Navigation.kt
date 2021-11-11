package vulong.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import vulong.todoapp.ui.screens.home_screen.HomeScreen
import vulong.todoapp.ui.screens.search_screen.SearchScreen
import vulong.todoapp.ui.screens.splash_screen.SplashScreen
import vulong.todoapp.ui.screens.task_screen.TaskScreen
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.Constants
import vulong.todoapp.util.Constants.HOME_SCREEN
import vulong.todoapp.util.Constants.SEARCH_SCREEN
import vulong.todoapp.util.Constants.SPLASH_SCREEN
import vulong.todoapp.util.Constants.TASK_SCREEN

@Composable
fun Navigation(
    sharedViewModel: SharedViewModel = hiltViewModel()
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SPLASH_SCREEN) {

        composable(
            route = SPLASH_SCREEN,
        ) {
            SplashScreen(
                navigateToHomeScreen = {
                    navController.navigate(HOME_SCREEN) {
                        popUpTo(SPLASH_SCREEN) {
                            inclusive = true
                        }
                    }
                },
            )
        }

        composable(
            route = SEARCH_SCREEN,
        ) {
            SearchScreen(
                sharedViewModel = sharedViewModel,
                navigateToHomeScreen = {
                    navController.popBackStack()
                },
                navigateToTaskScreen = { taskId ->
                    navController.navigate("task/$taskId")
                }
            )
        }

        composable(
            route = HOME_SCREEN,
        ) {
            HomeScreen(
                sharedViewModel = sharedViewModel,
                navigateToSearchScreen = {
                    navController.navigate(SEARCH_SCREEN)
                },
                navigateToTaskScreen = { taskId ->
                    navController.navigate("task/$taskId")
                },
            )
        }

        composable(
            route = TASK_SCREEN,
            arguments = listOf(
                navArgument(Constants.TASK_ARGUMENT_KEY) { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val taskId = navBackStackEntry.arguments?.getInt(Constants.TASK_ARGUMENT_KEY)

            //fix crash khi xoa index cuoi, se goi getTask 3 lan neu k co launch effect
            LaunchedEffect(key1 = true, block = {
                sharedViewModel.getTask(taskId = taskId)
            })
            TaskScreen(
                sharedViewModel,
                backToHomeScreen = {
                    navController.popBackStack()
                },
            )
        }

    }

}
