package vulong.todoapp.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import vulong.todoapp.R
import vulong.todoapp.ui.theme.fabBackgroundColor
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.Action

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTasks()
    }

    val allTasks by sharedViewModel.allTasks.collectAsState()

    val scaffoldState = rememberScaffoldState()
    if (sharedViewModel.snackBarAction != Action.NO_ACTION) {
        DisplaySnackBar(
            scaffoldState = scaffoldState,
            sharedViewModel = sharedViewModel,
        )
    }

    Scaffold(
        topBar = {
            ListScreenAppBar(
                sharedViewModel = sharedViewModel
            )
        },
        scaffoldState = scaffoldState,
        content = {
            ListScreenContent(
                sharedViewModel,
                allTasks,
                navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFAB(navigateToTaskScreen = navigateToTaskScreen)
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
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    sharedViewModel: SharedViewModel,
) {

    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true, block = {
        if (sharedViewModel.snackBarAction != Action.NO_ACTION) {
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "${sharedViewModel.snackBarAction.name}: ${sharedViewModel.snackBarMessage}",
                    actionLabel = if (sharedViewModel.snackBarAction == Action.DELETE) "UNDO" else "OK",
                )
                when (snackBarResult) {
                    SnackbarResult.Dismissed -> {
                        sharedViewModel.snackBarAction = Action.NO_ACTION
                    }
                    SnackbarResult.ActionPerformed -> {
                        if(sharedViewModel.snackBarAction==Action.DELETE)
                           sharedViewModel.handleDatabaseActions(Action.UNDO)
                        sharedViewModel.snackBarAction = Action.NO_ACTION
                    }
                }
            }
        }
    })
}