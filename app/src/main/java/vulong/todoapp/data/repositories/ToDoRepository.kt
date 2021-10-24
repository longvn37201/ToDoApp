package vulong.todoapp.data.repositories

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import vulong.todoapp.data.ToDoDao
import vulong.todoapp.data.models.ToDoTask
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    fun getTask(taskId: Int): Flow<ToDoTask> = toDoDao.getTask(taskId = taskId)

    fun getAllTask(): Flow<List<ToDoTask>> = toDoDao.getAllTask()

    fun getByLowPriority(): Flow<List<ToDoTask>> = toDoDao.getByLowPriority()

    fun getByHighPriority(): Flow<List<ToDoTask>> = toDoDao.getByHighPriority()

    fun searchTasks(searchQuery: String): Flow<List<ToDoTask>> =
        toDoDao.searchTasks(searchQuery = searchQuery)

    suspend fun addTask(toDoTask: ToDoTask) = toDoDao.addTask(toDoTask = toDoTask)

    suspend fun updateTask(toDoTask: ToDoTask) = toDoDao.updateTask(toDoTask = toDoTask)

    suspend fun deleteTask(toDoTask: ToDoTask) = toDoDao.deleteTask(toDoTask = toDoTask)

    suspend fun deleteAllTask() = toDoDao.deleteAllTask()

}