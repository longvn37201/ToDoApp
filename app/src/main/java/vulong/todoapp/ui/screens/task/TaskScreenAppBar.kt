package vulong.todoapp.ui.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import vulong.todoapp.R
import vulong.todoapp.ui.components.Dialog
import vulong.todoapp.ui.theme.topAppBarBackgroundColor
import vulong.todoapp.ui.theme.topAppBarContentColor
import vulong.todoapp.util.Action

@Composable
fun TaskScreenAppBar(
    title: String?,
    navigateToListScreen: (Action) -> Unit
) {
    if (title.isNullOrEmpty()) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            title = title,
            navigateToListScreen = navigateToListScreen
        )
    }
}

@Composable
fun ExistingTaskAppBar(
    title: String,
    navigateToListScreen: (Action) -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        },
        title = {
            Text(
                title,
                color = MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit,
) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.close_action),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }
    if (openDialog) {
        Dialog(
            title = "Delete task",
            message = "Are you sure?",
            openDialog = openDialog,
            closeDialog = { openDialog = false },
            onConfirmClicked = {
                onDeleteClicked(Action.DELETE)
            }
        )
    }
    IconButton(onClick = { openDialog = true }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_action),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit,
) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update_action),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        },
        title = {
            Text(
                stringResource(R.string.new_task),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
    )
}


@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_icon),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task_action),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Preview
@Composable
fun Pre() {
    NewTaskAppBar(navigateToListScreen = {})
}

@Preview
@Composable
fun Pre2() {
    ExistingTaskAppBar(
        navigateToListScreen = {},
        title = "test"
    )
}