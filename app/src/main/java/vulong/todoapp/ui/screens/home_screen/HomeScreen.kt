package vulong.todoapp.ui.screens.home_screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import vulong.todoapp.R
import vulong.todoapp.ui.theme.fabBackgroundColor
import vulong.todoapp.ui.viewmodels.SharedViewModel

@Composable
fun HomeScreen(
    navigateToSearchScreen: () -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {

    val scaffoldState = rememberScaffoldState()
    if (sharedViewModel.snackBarDetail != null) {
        CustomSnackBar(
            scaffoldState = scaffoldState,
            sharedViewModel = sharedViewModel,
        )
    }

    Scaffold(
        topBar = {
            HomeScreenAppBar(
                navigateToSearchScreen = {
                    sharedViewModel.snackBarDetail = null
                    navigateToSearchScreen()
                },
                sharedViewModel = sharedViewModel
            )
        },
        scaffoldState = scaffoldState,
        content = {
            HomeScreenContent(
                sharedViewModel = sharedViewModel,
                navigateToTaskScreen = {
                    sharedViewModel.snackBarDetail = null
                    navigateToTaskScreen(it)
                }
            )
        },
        floatingActionButton = {
            ListFAB(navigateToTaskScreen = {
                sharedViewModel.snackBarDetail = null
                navigateToTaskScreen(it)
            })
        }
    )
}

@Composable
fun ListFAB(
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    FloatingActionButton(
        onClick = {
            navigateToTaskScreen(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )

    }
}

@Composable
fun CustomSnackBar(
    scaffoldState: ScaffoldState,
    sharedViewModel: SharedViewModel,
) {
    LaunchedEffect(key1 = true) {
        val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
            message = "${sharedViewModel.snackBarDetail?.title}: ${sharedViewModel.snackBarDetail?.message}",
            actionLabel = sharedViewModel.snackBarDetail?.action,
        )
        when (snackBarResult) {
            SnackbarResult.Dismissed -> {
                sharedViewModel.snackBarDetail = null
            }
            SnackbarResult.ActionPerformed -> {
                if (sharedViewModel.snackBarDetail?.title == "Deleted"){
                    sharedViewModel.addTask(isUndoDeleteTask = true)
                }
                //todo delete_all
                sharedViewModel.snackBarDetail = null
            }
        }
    }
}