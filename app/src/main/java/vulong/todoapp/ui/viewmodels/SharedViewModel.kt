package vulong.todoapp.ui.viewmodels

import android.content.Context
import android.util.Log
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
import vulong.todoapp.util.Constants.TAG
import vulong.todoapp.util.LoadingState
import vulong.todoapp.util.SnackBarDetail
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    init {
        getAllTasks()
    }

    var searchText by mutableStateOf("")
    var firstTimeLoadDataState by mutableStateOf(LoadingState.LOADING)

    var snackBarDetail: SnackBarDetail? by mutableStateOf(null)

    private val _allTasks = MutableStateFlow<MutableList<ToDoTask>>(arrayListOf())
    val allTasks get() = _allTasks.asStateFlow()

    private val _searchedTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val searchedTasks = _searchedTasks.asStateFlow()

    var selectedTask: ToDoTask? by mutableStateOf(null)
    var id by mutableStateOf(-1)
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var priority by mutableStateOf(Priority.LOW)

    val tempDeleteTasks: MutableList<ToDoTask> by mutableStateOf(arrayListOf())

    private fun getAllTasks() {
        try {
            viewModelScope.launch {
                repository.getAllTask().collect {
                    _allTasks.value = it as MutableList<ToDoTask>
                    firstTimeLoadDataState = LoadingState.SUCCESS
                    Log.d(TAG, "getAllTasks:${_allTasks.value.size} ${allTasks.value.size} ${_allTasks.value}")
                }
            }
        } catch (e: Exception) {
            firstTimeLoadDataState = LoadingState.ERROR
        }
    }

    fun addTask(isUndoDeleteTask: Boolean = false) {
        Log.d(TAG, "addTask: undo")
        viewModelScope.launch(IO) {
            if (!isUndoDeleteTask) {
                val newTask =
                    ToDoTask(title = title, description = description, priority = priority)
                repository.addTask(newTask)
                snackBarDetail = SnackBarDetail(
                    context.getString(R.string.added),
                    newTask.title,
                    context.getString(R.string.ok),
                )
            } else {
                Log.d(TAG, "addTask: undo")
                repository.addTask(selectedTask!!)
            }
            //sau khi add, collect trong allAllTasks auto duoc goi lai
        }
    }

    fun updateTask() {
        viewModelScope.launch(IO) {
            val newTask = ToDoTask(selectedTask!!.id, title, description, priority)
            repository.updateTask(newTask)
            snackBarDetail = SnackBarDetail(
                context.getString(R.string.update),
                newTask.title,
                context.getString(R.string.ok),
            )
            //sau khi update, collect trong allAllTasks auto duoc goi lai
        }
    }

    fun deleteSelectedTask() {
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

    fun getTask(taskId: Int?) {
        if (taskId == null || taskId == -1) {
            selectedTask = null
            title = ""
            description = ""
            priority = Priority.LOW
        } else {
            selectedTask = allTasks.value[taskId]
            title = selectedTask!!.title
            description = selectedTask!!.description
            priority = selectedTask!!.priority
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

    fun onSearchChange(newSearch: String) {
        if (newSearch.length <= MAX_SEARCH_LENGTH) {
            searchText = newSearch
        }
    }

}