package vulong.todoapp.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import vulong.todoapp.R
import vulong.todoapp.data.models.ToDoTask
import vulong.todoapp.ui.theme.*
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.LoadingState
import vulong.todoapp.util.SearchAppBarState

@Composable
fun ListScreenContent(
    sharedViewModel: SharedViewModel,
    toDoTasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    val searchTask by sharedViewModel.searchedTasks.collectAsState()

    when (sharedViewModel.loadDataState) {
        LoadingState.LOADING -> {
            LoadingContent()
        }
        LoadingState.SUCCESS -> {
            if (sharedViewModel.searchAppBarState == SearchAppBarState.CLOSED) {
                if (toDoTasks.isEmpty()) {
                    EmptyContent()
                } else {
                    DisplayTasks(toDoTasks = toDoTasks, navigateToTaskScreen = navigateToTaskScreen)
                }
            } else {
                if (searchTask.isEmpty()) {
                    EmptyContent()
                } else {
                    DisplayTasks(toDoTasks = searchTask, navigateToTaskScreen = navigateToTaskScreen)
                }
            }
        }
        LoadingState.ERROR -> {
            //Todo for err
        }

    }
}

@Composable
fun DisplayTasks(
    toDoTasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    LazyColumn() {
        items(
            items = toDoTasks,
            key = { task ->
                task.id
            },
            itemContent = { task ->
                TaskItem(
                    toDoTask = task,
                    navigateToTaskScreen = navigateToTaskScreen
                )
            },
        )
    }
}

@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    navigateToTaskScreen(toDoTask.id)
                }
            ),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
    ) {
        Column(
            modifier = Modifier
                .padding(LARGE_PADDING)
                .fillMaxWidth(),
        ) {
            Row() {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                Box(
                    modifier = Modifier.weight(1f),
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE)
                            .align(Alignment.TopEnd),
                        onDraw = {
                            drawCircle(color = toDoTask.priority.color)
                        },
                    )
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun LoadingContent() {
    Box(Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad),
            contentDescription = stringResource(
                R.string.sad_icon
            ),
            tint = MediumGray,
        )
        Text(
            stringResource(R.string.empty_content),
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize,
        )
    }
}