package vulong.todoapp.navigation.destionations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import vulong.todoapp.ui.screens.splash.SplashScreen
import vulong.todoapp.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen)
    }
}