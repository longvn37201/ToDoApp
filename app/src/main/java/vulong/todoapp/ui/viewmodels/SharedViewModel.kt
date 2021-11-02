package vulong.todoapp.ui.viewmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import vulong.todoapp.R
import vulong.todoapp.data.models.Priority
import vulong.todoapp.data.models.ToDoTask
import vulong.todoapp.data.repositories.ToDoRepository
import vulong.todoapp.util.Action
import vulong.todoapp.util.Constants.MAX_DESCRIPTION_LENGTH
import vulong.todoapp.util.Constants.MAX_TITLE_LENGTH
import vulong.todoapp.util.LoadingState
import vulong.todoapp.util.SearchAppBarState
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var snackBarAction by mutableStateOf(Action.NO_ACTION)
    var snackBarMessage by mutableStateOf("")

    var searchAppBarState by mutableStateOf(SearchAppBarState.CLOSED)
    var searchTextState by mutableStateOf("")

    var loadDataState by mutableStateOf(LoadingState.LOADING)
    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    private val _searchedTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val searchedTasks: StateFlow<List<ToDoTask>> = _searchedTasks

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTask: StateFlow<ToDoTask?> = _selectedTask
    var id by mutableStateOf(0)
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var priority by mutableStateOf(Priority.LOW)

    var undoTask: ToDoTask? by mutableStateOf(null)

    fun handleDatabaseActions(action: Action) {
        when (action) {
            Action.ADD -> {
                addTask()
            }
            Action.UPDATE -> {
                updateTask()
            }
            Action.DELETE -> {
                deleteTask()
            }
            Action.DELETE_ALL -> {
                deleteAllTask()
            }
            Action.UNDO -> {
                undoTask()
            }
            else -> {
            }
        }
    }

    fun searchTasks(searchQuery: String) {
        loadDataState = LoadingState.LOADING
        try {
            viewModelScope.launch {
                repository.searchTasks(searchQuery = "%$searchQuery%").collect {
                    _searchedTasks.value = it
                    loadDataState = LoadingState.SUCCESS
                }
            }
        } catch (e: Exception) {
            loadDataState = LoadingState.ERROR
        }
        searchAppBarState = SearchAppBarState.TRIGGERED
    }

    fun getAllTasks() {
        try {
            viewModelScope.launch {
                repository.getAllTask().collect {
                    _allTasks.value = it
                    loadDataState = LoadingState.SUCCESS
                }
            }
        } catch (e: Exception) {
            loadDataState = LoadingState.ERROR
        }
    }

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            repository.getTask(taskId = taskId).collect {
                _selectedTask.value = it
                id = if (it != null) it.id else -1
                title = if (it != null) it.title else ""
                description = if (it != null) it.description else ""
                priority = if (it != null) it.priority else Priority.LOW
            }
        }
    }

    private fun addTask() {
        viewModelScope.launch(IO) {
            val todoTask = ToDoTask(
                title = title,
                description = description,
                priority = priority
            )
            repository.addTask(
                toDoTask = todoTask
            )
            snackBarAction = Action.ADD
            snackBarMessage = todoTask.title
        }
        searchAppBarState = SearchAppBarState.CLOSED
    }

    private fun undoTask() {
        viewModelScope.launch(IO) {
            repository.addTask(
                toDoTask = undoTask!!
            )
        }
    }

    private fun updateTask() {
        viewModelScope.launch(IO) {
            val todoTask = ToDoTask(
                id = id,
                title = title,
                description = description,
                priority = priority
            )
            repository.updateTask(
                toDoTask = todoTask
            )
            snackBarAction = Action.UPDATE
            snackBarMessage = todoTask.title
        }
    }

    private fun deleteTask() {
        viewModelScope.launch(IO) {
            val todoTask = ToDoTask(
                id = id,
                title = title,
                description = description,
                priority = priority
            )
            repository.deleteTask(
                toDoTask = todoTask
            )
            snackBarAction = Action.DELETE
            snackBarMessage = todoTask.title
            undoTask = todoTask
        }
    }

    private fun deleteAllTask() {
        viewModelScope.launch(IO) {
            repository.deleteAllTask()
            snackBarAction = Action.DELETE_ALL
            snackBarMessage = context.getString(R.string.all_tasks)
        }
    }

    fun validateFields(): Boolean {
        return title.isNotEmpty() && description.isNotEmpty()
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
}