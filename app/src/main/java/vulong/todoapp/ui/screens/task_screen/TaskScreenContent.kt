package vulong.todoapp.ui.screens.task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vulong.todoapp.R
import vulong.todoapp.data.models.Priority
import vulong.todoapp.ui.components.PriorityDropDown
import vulong.todoapp.ui.components.ReminderTimeStamp
import vulong.todoapp.ui.theme.LARGE_PADDING
import vulong.todoapp.ui.theme.MEDIUM_PADDING
import vulong.todoapp.ui.theme.ReminderTimeStampBackground

@Composable
fun TaskScreenContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(
                all = LARGE_PADDING
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = {
                Text(text = stringResource(id = R.string.title))
            },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(modifier = Modifier.weight(1f)) {
                PriorityDropDown(priority = priority, onPrioritySelected = onPrioritySelected)
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ReminderTimeStamp(
                        text = "28/12, 15:30",
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .clickable {
                                //todo change reminder time
                            }
                            .background(ReminderTimeStampBackground)
                            .padding(MEDIUM_PADDING)
                    )
                    Spacer(Modifier.width(2.dp))
                    IconButton(
                        onClick = {
                                  //todo delete reminder
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(R.string.delete_icon),
//                           tint = MaterialTheme.colors.topAppBarContentColor,
                        )
                    }
                }
            }
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(R.string.description)) },
            textStyle = MaterialTheme.typography.body1,
        )
    }
}


@Preview
@Composable
fun PreviewTaskContent() {
    TaskScreenContent(
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}