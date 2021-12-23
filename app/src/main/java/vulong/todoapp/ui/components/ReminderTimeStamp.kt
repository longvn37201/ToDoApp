package vulong.todoapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vulong.todoapp.R

@Composable
fun ReminderTimeStamp(
    modifier: Modifier = Modifier,
    text: String = "Add reminder",
    isStrikethrough: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_alarm),
            contentDescription = "Alarm icon"
        )
        Spacer(Modifier.width(2.dp))
        Text(
            text = text,
            style = if (isStrikethrough)
                TextStyle(textDecoration = TextDecoration.LineThrough)
            else LocalTextStyle.current
        )
    }

}

@Preview
@Composable
fun ReminderTimeStampPrev() {
    ReminderTimeStamp()
}