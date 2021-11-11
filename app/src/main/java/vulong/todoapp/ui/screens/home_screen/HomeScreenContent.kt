package vulong.todoapp.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import vulong.todoapp.R
import vulong.todoapp.ui.components.DisplayTasks
import vulong.todoapp.ui.theme.MediumGray
import vulong.todoapp.ui.viewmodels.SharedViewModel
import vulong.todoapp.util.LoadingState

@Composable
fun HomeScreenContent(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {

    when (sharedViewModel.firstTimeLoadDataState) {
        LoadingState.LOADING -> {
            LoadingContent()
        }
        LoadingState.SUCCESS -> {
            if (sharedViewModel.allTasks.value.isEmpty()) {
                EmptyContent()
            } else {
                DisplayTasks(
                    toDoTasks = sharedViewModel.allTasks.value,
                    navigate = navigateToTaskScreen
                )
            }
        }
        LoadingState.ERROR -> {
            //Todo first loading err
        }
    }

}


@Composable
fun LoadingContent() {
    Box(Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad),
            contentDescription = stringResource(
                R.string.sad_icon
            ),
            tint = MediumGray,
        )
        Text(
            stringResource(R.string.empty_content),
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize,
        )
    }
}