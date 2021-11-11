package vulong.todoapp.ui.screens.task_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.Action

@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    backToHomeScreen: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TaskScreenAppBar(
                isNewTask = sharedViewModel.selectedTask == null,
                navigate = {
                    when (it.name) {
                        Action.ADD.name -> {
                            if (sharedViewModel.validateFields()) {
                                sharedViewModel.addTask()
                                backToHomeScreen()
                            } else {
                                displayToast(context = context)
                            }
                        }
                        Action.UPDATE.name -> {
                            if (sharedViewModel.validateFields()) {
                                sharedViewModel.updateTask()
                                backToHomeScreen()
                            } else {
                                displayToast(context = context)
                            }
                        }
                        Action.DELETE.name -> {
                            sharedViewModel.deleteSelectedTask()
                            backToHomeScreen()
                        }
                        else -> {
                            backToHomeScreen()
                        }
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
