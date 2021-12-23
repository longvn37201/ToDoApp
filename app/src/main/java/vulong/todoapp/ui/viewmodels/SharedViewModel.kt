package vulong.todoapp.ui.viewmodels

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import vulong.todoapp.R
import vulong.todoapp.data.models.Priority
import vulong.todoapp.data.models.ToDoTask
import vulong.todoapp.data.repositories.ToDoRepository
import vulong.todoapp.util.Constants.MAX_DESCRIPTION_LENGTH
import vulong.todoapp.util.Constants.MAX_SEARCH_LENGTH
import vulong.todoapp.util.Constants.MAX_TITLE_LENGTH
import vulong.todoapp.util.LoadingState
import vulong.todoapp.util.ReminderBroadcast
import vulong.todoapp.util.SnackBarDetail
import java.util.*
import java.util.Calendar.*
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    init {
        getAllTasksByRecent()
        getAllTasksByPriority()
    }

    var isSortByPriority by mutableStateOf(false)

    var searchText by mutableStateOf("")
    var firstTimeLoadDataState by mutableStateOf(LoadingState.LOADING)

    var snackBarDetail: SnackBarDetail? by mutableStateOf(null)

    private val _allTasksByRecent = MutableStateFlow<MutableList<ToDoTask>>(arrayListOf())
    val allTasksByRecent = _allTasksByRecent.asStateFlow()

    private val _allTasksByPriority = MutableStateFlow<MutableList<ToDoTask>>(arrayListOf())
    val allTasksByPriority = _allTasksByPriority.asStateFlow()

    val searchedTasks = MutableStateFlow<MutableList<ToDoTask>>(arrayListOf())

    var selectedTask: ToDoTask? by mutableStateOf(null)
    var id by mutableStateOf(-1)
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var priority by mutableStateOf(Priority.LOW)
    var isSetReminder: Boolean by mutableStateOf(false)
    var year: Int? by mutableStateOf(null)
    var month: Int? by mutableStateOf(null)
    var day: Int? by mutableStateOf(null)
    var hour: Int? by mutableStateOf(null)
    var minute: Int? by mutableStateOf(null)

    private var tempDeleteAllTasks: MutableList<ToDoTask> by mutableStateOf(arrayListOf())

    var isLaunchFromNotification: Boolean by mutableStateOf(false)
    var idFromNotification: Int by mutableStateOf(-1)


    private fun getAllTasksByRecent() {
        try {
            viewModelScope.launch {
                repository.getAllTask().collect {
                    _allTasksByRecent.value = it as MutableList<ToDoTask>
                    firstTimeLoadDataState = LoadingState.SUCCESS
                    searchTasks()
                }
            }
        } catch (e: Exception) {
            firstTimeLoadDataState = LoadingState.ERROR
        }
    }


    private fun getAllTasksByPriority() {
        viewModelScope.launch {
            repository.getByHighPriority().collect {
                _allTasksByPriority.value = it as MutableList<ToDoTask>
            }
        }
    }

    fun searchTasks() {
        val temp = mutableListOf<ToDoTask>()
        _allTasksByRecent.value.forEach {
            if (
                searchText.trim().isNotEmpty()
                && (it.title.contains(searchText) || it.description.contains(searchText))
            ) {
                temp.add(it)
            }
        }
        searchedTasks.value = temp
    }

    fun addTask(isUndoDeleteTask: Boolean = false) {
        viewModelScope.launch(IO) {
            if (!isUndoDeleteTask) {
                id = if (_allTasksByRecent.value.size != 0) {
                    _allTasksByRecent.value[0].id + 1
                } else {
                    1
                }
                val newTask =
                    ToDoTask(
                        title = title,
                        description = description,
                        priority = priority,
                        isSetReminder = isSetReminder,
                        year = year,
                        month = month,
                        day = day,
                        hour = hour,
                        minute = minute
                    )
                //datetime valid is checked
                if (isSetReminder) {
                    setReminder()
                }
                repository.addTask(newTask)
            } else {
                repository.addTask(selectedTask!!)
                if (selectedTask!!.isSetReminder) {
                    setReminder()
                }
            }
            //sau khi add, collect trong allAllTasks auto duoc goi lai
        }
    }


    fun updateTask() {
        viewModelScope.launch(IO) {
            val newTask = ToDoTask(
                selectedTask!!.id,
                title,
                description,
                priority,
                isSetReminder,
                year,
                month,
                day,
                hour,
                minute
            )
            repository.updateTask(newTask)
            if (isSetReminder && checkDateTimeValid()) {
                setReminder()
            }

            //delete reminder when updated
            if (selectedTask!!.isSetReminder && !isSetReminder) {
                removeReminder()
            }
            //sau khi update, collect trong allAllTasks auto duoc goi lai
        }
    }

    fun tempDeleteAllTasks() {
        tempDeleteAllTasks.addAll(_allTasksByRecent.value)
        if (isSortByPriority) {
            _allTasksByPriority.value = arrayListOf()
        } else {
            _allTasksByRecent.value = arrayListOf()
        }
        snackBarDetail = SnackBarDetail(
            context.getString(R.string.delete_all_task),
            "",
            context.getString(R.string.undo),
        )
    }

    fun deleteAllTasks() {
        //delete all reminder
        tempDeleteAllTasks.forEach {
            if (it.isSetReminder) {
                id = it.id
                removeReminder()
            }
        }

        viewModelScope.launch(IO) {
            repository.deleteAllTask()
            tempDeleteAllTasks = arrayListOf()
        }
    }

    fun undoDeleteAllTasks() {
        snackBarDetail = null
        if (isSortByPriority) {
            _allTasksByPriority.value.addAll(tempDeleteAllTasks)
        } else {
            _allTasksByRecent.value.addAll(tempDeleteAllTasks)
        }
        tempDeleteAllTasks.clear()
        searchTasks()
    }


    fun deleteSelectedTask() {
        if (selectedTask!!.isSetReminder) {
            removeReminder()
        }
        viewModelScope.launch(IO) {
            repository.deleteTask(selectedTask!!)
            snackBarDetail = SnackBarDetail(
                context.getString(R.string.delete),
                selectedTask?.title,
                context.getString(R.string.undo),
            )
            //sau khi delete, collect trong allAllTasks auto duoc goi lai
        }
    }


    fun getTask(taskIndex: Int?) {
        if (taskIndex == null || taskIndex == -1) {
            selectedTask = null
            title = ""
            description = ""
            priority = Priority.LOW
            isSetReminder = false
            year = null
            month = null
            day = null
            hour = null
            minute = null
        } else {
            if (isLaunchFromNotification) {
                allTasksByRecent.value.forEach {
                    if (it.id == idFromNotification) {
                        selectedTask = it
                    }
                }
                isLaunchFromNotification = false
            } else {
                if (isSortByPriority) selectedTask = allTasksByPriority.value[taskIndex]
                if (!isSortByPriority) selectedTask = allTasksByRecent.value[taskIndex]

                selectedTask =
                    if (searchedTasks.value.isNotEmpty()) {
                        searchedTasks.value[taskIndex]
                    } else {
                        if (isSortByPriority) allTasksByPriority.value[taskIndex]
                        else allTasksByRecent.value[taskIndex]
                    }
            }


            id = selectedTask!!.id
            title = selectedTask!!.title
            description = selectedTask!!.description
            priority = selectedTask!!.priority
            isSetReminder = selectedTask!!.isSetReminder
            year = selectedTask!!.year
            month = selectedTask!!.month
            day = selectedTask!!.day
            hour = selectedTask!!.hour
            minute = selectedTask!!.minute
        }
    }

    fun dismissSnackBar() {
        if (snackBarDetail?.title == context.getString(R.string.delete_all_task)) {
            deleteAllTasks()
        }
        snackBarDetail = null
    }

    fun validateFields(): Boolean {
        return title.trim().isNotEmpty() && description.trim().isNotEmpty()
    }

    fun onTitleChange(newTitle: String) {
        if (newTitle.length <= MAX_TITLE_LENGTH) {
            title = newTitle
        }
    }

    fun onDescriptionChange(newDescription: String) {
        if (newDescription.length <= MAX_DESCRIPTION_LENGTH) {
            description = newDescription
        }
    }

    fun onSearchChange(newSearch: String) {
        if (newSearch.length <= MAX_SEARCH_LENGTH) {
            searchText = newSearch
            searchTasks()
        }
    }

    private fun setReminder() {
        val intent = Intent(context, ReminderBroadcast::class.java)
        intent.putExtra("id", id)
        intent.putExtra("title", title)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            id,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_CANCEL_CURRENT //fix crash android 12
        )

        val calendar = getInstance()
        calendar[YEAR] = year!!
        calendar[MONTH] = month!!
        calendar[DAY_OF_MONTH] = day!!
        calendar[HOUR_OF_DAY] = hour!!
        calendar[MINUTE] = minute!!

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
        alarmManager?.set(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )


    }

    private fun removeReminder() {
        val intent = Intent(context, ReminderBroadcast::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            id,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_CANCEL_CURRENT
        )
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
        alarmManager?.cancel(pendingIntent)

    }

    fun checkDateTimeValid(justCheckNotUpdateIsSetReminder: Boolean = false): Boolean {
        val timeSet = getInstance()
        if (
            year != null &&
            month != null &&
            day != null &&
            hour != null &&
            minute != null
        ) {
            timeSet[YEAR] = year!!
            timeSet[MONTH] = month!!
            timeSet[DAY_OF_MONTH] = day!!
            timeSet[HOUR_OF_DAY] = hour!!
            timeSet[MINUTE] = minute!!

            val currentTime = getInstance()
            currentTime.time = Date()

            if (timeSet.timeInMillis < currentTime.timeInMillis) {
                if (!justCheckNotUpdateIsSetReminder) {
                    isSetReminder = false
                }
                return false
            } else {
                if (!justCheckNotUpdateIsSetReminder) {
                    isSetReminder = true
                }
                return true
            }
        } else {
            if (!justCheckNotUpdateIsSetReminder) {
                isSetReminder = false
            }
            return false
        }
    }

}