package vulong.todoapp.util

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

object Constants {
    const val DATABASE_TABLE = "todo_table"
    const val DATABASE_NAME = "todo_database"

    const val SPLASH_SCREEN = "splash"
    const val LIST_SCREEN = "list/{action}"
    const val TASK_SCREEN = "task/{taskId}"

    const val LIST_ARGUMENT_KEY = "action"
    const val TASK_ARGUMENT_KEY = "taskId"

    const val TAG = "longvn"
    val LOREM_IPSUM = LoremIpsum(500).values.joinToString()

    const val MAX_TITLE_LENGTH = 25
    const val MAX_DESCRIPTION_LENGTH = 1000

    const val SPLASH_SCREEN_DURATION = 3000L


}