package vulong.todoapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import vulong.todoapp.data.models.Priority
import vulong.todoapp.ui.theme.LARGE_PADDING
import vulong.todoapp.ui.theme.PRIORITY_INDICATOR_SIZE
import vulong.todoapp.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier.size(PRIORITY_INDICATOR_SIZE),
            onDraw = {
                drawCircle(color = priority.color)
            },
        )
        Spacer(modifier = Modifier.width(LARGE_PADDING))
        Text(
            text = priority.name,
            style = Typography.subtitle2,
            color = MaterialTheme.colors.onSurface,
        )
    }
}

@Preview
@Composable
fun Preview() {
    PriorityItem(priority = Priority.MEDIUM)
}