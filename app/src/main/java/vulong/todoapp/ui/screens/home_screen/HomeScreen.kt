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

    LaunchedEffect(key1 = true, block = {
        if (sharedViewModel.isLaunchFromNotification) {
            navigateToTaskScreen(sharedViewModel.idFromNotification)
        }
    })

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
                    sharedViewModel.dismissSnackBar()
                    navigateToSearchScreen()
                },
                onSortByRecentClicked = {
                    sharedViewModel.dismissSnackBar()
                    sharedViewModel.isSortByPriority = false
                },
                onSortByPriorityClicked = {
                    sharedViewModel.dismissSnackBar()
                    sharedViewModel.isSortByPriority = true
                },
                onConfirmDeleteAll = {
                    sharedViewModel.dismissSnackBar()
                    sharedViewModel.tempDeleteAllTasks()
                },
                sharedViewModel = sharedViewModel
            )
        },
        scaffoldState = scaffoldState,
        content = {
            HomeScreenContent(
                sharedViewModel = sharedViewModel,
                navigateToTaskScreen = {
                    sharedViewModel.dismissSnackBar()
                    navigateToTaskScreen(it)
                }
            )
        },
        floatingActionButton = {
            ListFAB(navigateToTaskScreen = {
                sharedViewModel.dismissSnackBar()
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
            message = if (sharedViewModel.snackBarDetail?.title == "Deleted")
                "Deleted a task!"
            else "Deleted all task",
            actionLabel = sharedViewModel.snackBarDetail?.action,
        )
        when (snackBarResult) {
            SnackbarResult.Dismissed -> {
                if (sharedViewModel.snackBarDetail?.title == "Deleted all tasks") {
                    sharedViewModel.deleteAllTasks()
                }
                sharedViewModel.snackBarDetail = null
            }
            SnackbarResult.ActionPerformed -> {
                if (sharedViewModel.snackBarDetail?.title == "Deleted") {
                    sharedViewModel.addTask(isUndoDeleteTask = true)
                }
                if (sharedViewModel.snackBarDetail?.title == "Deleted all tasks") {
                    sharedViewModel.undoDeleteAllTasks()
                }
                sharedViewModel.snackBarDetail = null
            }
        }
    }
}