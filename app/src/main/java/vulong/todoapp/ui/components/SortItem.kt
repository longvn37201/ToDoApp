package vulong.todoapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import vulong.todoapp.ui.theme.LARGE_PADDING
import vulong.todoapp.ui.theme.Typography

@Composable
fun SortItem(
    title: String,
    isSelected: Boolean,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(MaterialTheme.colors.primary)
        )
        Spacer(modifier = Modifier.width(LARGE_PADDING))
        Text(
            text = title,
            style = Typography.subtitle2,
            color = MaterialTheme.colors.onSurface,
        )
    }
}

@Preview
@Composable
fun SortItemPre() {
    SortItem(title = "Sort by recent", isSelected = true)
}