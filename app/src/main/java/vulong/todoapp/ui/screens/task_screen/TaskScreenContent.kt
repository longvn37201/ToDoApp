package vulong.todoapp.ui.screens.task_screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vulong.todoapp.R
import vulong.todoapp.ui.components.PriorityDropDown
import vulong.todoapp.ui.components.ReminderTimeStamp
import vulong.todoapp.ui.theme.LARGE_PADDING
import vulong.todoapp.ui.theme.MEDIUM_PADDING
import vulong.todoapp.ui.theme.ReminderTimeStampBackground
import vulong.todoapp.ui.viewmodels.SharedViewModel
import java.util.*
import java.util.Calendar.*

@Composable
fun TaskScreenContent(
    sharedViewModel: SharedViewModel = viewModel()
) {
    val context = LocalContext.current
    val currentTime = getInstance()
    currentTime.time = Date()

    val timePickerDialog = TimePickerDialog(
        context,
        { _, hourOfDay, minute ->
            sharedViewModel.hour = hourOfDay
            sharedViewModel.minute = minute
            if (!sharedViewModel.checkDateTimeValid()) {
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.date_has_passed),
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
        if (sharedViewModel.hour != null) {
            sharedViewModel.hour!!
        } else currentTime[HOUR_OF_DAY],
        if (sharedViewModel.minute != null) {
            sharedViewModel.minute!!
        } else currentTime[MINUTE],
        true
    )

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            sharedViewModel.year = year
            sharedViewModel.month = month
            sharedViewModel.day = day
            timePickerDialog.show()
        },
        if (sharedViewModel.year != null) {
            sharedViewModel.year!!
        } else currentTime[YEAR],
        if (sharedViewModel.month != null) {
            sharedViewModel.month!!
        } else currentTime[MONTH],
        if (sharedViewModel.day != null) {
            sharedViewModel.day!!
        } else currentTime[DAY_OF_MONTH],
    )


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
            value = sharedViewModel.title,
            onValueChange = { sharedViewModel.onTitleChange(it) },
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
                PriorityDropDown(
                    priority = sharedViewModel.priority,
                    onPrioritySelected = { sharedViewModel.priority = it })
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ReminderTimeStamp(
                        text = if (sharedViewModel.isSetReminder)
                            "${sharedViewModel.day}/${sharedViewModel.month}, ${sharedViewModel.hour}:${sharedViewModel.minute}"
                        else stringResource(R.string.add_reminder),
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .clickable(enabled = !sharedViewModel.isSetReminder, onClick = {
                                datePickerDialog.show()
                            })
                            .background(ReminderTimeStampBackground)
                            .padding(MEDIUM_PADDING),
                        isStrikethrough = if(sharedViewModel.isSetReminder) !sharedViewModel.checkDateTimeValid(true) else false
                    )
                    Spacer(Modifier.width(2.dp))
                    if (sharedViewModel.isSetReminder) {
                        IconButton(
                            onClick = {
                                sharedViewModel.isSetReminder = false
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = stringResource(R.string.delete_icon),
                            )
                        }
                    }
                }
            }
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = sharedViewModel.description,
            onValueChange = { sharedViewModel.onDescriptionChange(it) },
            label = { Text(text = stringResource(R.string.description)) },
            textStyle = MaterialTheme.typography.body1,
        )
    }
}


@Preview
@Composable
fun PreviewTaskContent() {
    TaskScreenContent(
    )
}