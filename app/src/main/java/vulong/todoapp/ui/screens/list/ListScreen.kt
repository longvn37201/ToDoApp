package vulong.todoapp.ui.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import vulong.todoapp.R

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
) {
    Scaffold(
        content = {

        },
        floatingActionButton = {
            ListFAB(navigateToTaskScreen = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFAB(
    navigateToTaskScreen: (Int) -> Unit,
) {
    FloatingActionButton(
        onClick = {
            navigateToTaskScreen(-1)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )

    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}