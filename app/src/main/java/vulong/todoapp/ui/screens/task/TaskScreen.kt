package vulong.todoapp.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import vulong.todoapp.R
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.Action

@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TaskScreenAppBar(
                title = if (sharedViewModel.selectedTask.value == null) null else stringResource(R.string.edit),
                navigateToListScreen = {
                    if (sharedViewModel.validateFields() || it == Action.NO_ACTION) {
                        sharedViewModel.snackBarAction = Action.NO_ACTION
                        navigateToListScreen(it)
                    } else {
                        displayToast(context = context)
                    }
                },
            )
        },
        content = {
            TaskScreenContent(
                title = sharedViewModel.title,
                onTitleChange = { sharedViewModel.onTitleChange(it) },
                description = sharedViewModel.description,
                onDescriptionChange = { sharedViewModel.onDescriptionChange(it) },
                priority = sharedViewModel.priority,
                onPrioritySelected = { sharedViewModel.priority = it }
            )
        },
    )
}

private fun displayToast(context: Context) {
    Toast.makeText(context, "Fields empty", Toast.LENGTH_SHORT).show()
}
