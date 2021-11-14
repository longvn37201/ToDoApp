package vulong.todoapp.ui.screens.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.delay
import vulong.todoapp.R
import vulong.todoapp.ui.theme.LOGO_SIZE
import vulong.todoapp.ui.theme.SplashScreenBackground
import vulong.todoapp.util.Constants.SPLASH_SCREEN_DURATION

@Composable
fun SplashScreen(
    navigateToHomeScreen: () -> Unit,
) {

    LaunchedEffect(key1 = true, block = {
        delay(SPLASH_SCREEN_DURATION)
        navigateToHomeScreen()
    })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.SplashScreenBackground),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.size(LOGO_SIZE),
            painter = painterResource(id = R.drawable.ic_splash_screen),
            contentDescription = stringResource(
                R.string.logo_icon
            ),
        )
    }

}

