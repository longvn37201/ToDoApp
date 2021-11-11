package vulong.todoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import vulong.todoapp.data.models.ToDoTask
import vulong.todoapp.util.Constants.DATABASE_TABLE

@Dao
interface ToDoDao {

    @Query("SELECT * FROM $DATABASE_TABLE WHERE id=:taskId ")
    fun getTask(taskId: Int): Flow<ToDoTask>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY id DESC")
    fun getAllTask(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun getByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun getByHighPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $DATABASE_TABLE WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTasks(searchQuery: String): Flow<List<ToDoTask>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM $DATABASE_TABLE")
    suspend fun deleteAllTask()

}