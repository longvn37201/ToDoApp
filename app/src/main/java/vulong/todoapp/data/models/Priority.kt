package vulong.todoapp.data.models

import androidx.compose.ui.graphics.Color
import vulong.todoapp.ui.theme.HighPriorityColor
import vulong.todoapp.ui.theme.LowPriorityColor
import vulong.todoapp.ui.theme.MediumPriorityColor
import vulong.todoapp.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}
