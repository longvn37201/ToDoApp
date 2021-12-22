package vulong.todoapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
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


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    sharedViewModel: SharedViewModel = hiltViewModel()
) {

    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = if (android.os.Build.VERSION.SDK_INT < 31) SPLASH_SCREEN else HOME_SCREEN
    ) {
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
            SEARCH_SCREEN,
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
            HOME_SCREEN,
        ) {
            LaunchedEffect(key1 = true, block = {
                sharedViewModel.searchedTasks.value = arrayListOf()
            })
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
            ),
            enterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { it })
            },
            exitTransition = {
                slideOutHorizontally(animationSpec = tween(300), targetOffsetX = { it })
            }
        ) { navBackStackEntry ->
            val taskIndex = navBackStackEntry.arguments?.getInt(Constants.TASK_ARGUMENT_KEY)

            //fix crash khi xoa index cuoi, se goi getTask 3 lan neu k co launch effect
            LaunchedEffect(key1 = true, block = {
                sharedViewModel.getTask(taskIndex = taskIndex)
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
