package vulong.todoapp.ui.screens.search_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import vulong.todoapp.R
import vulong.todoapp.ui.components.DisplayTasks
import vulong.todoapp.ui.screens.home_screen.CustomSnackBar
import vulong.todoapp.ui.theme.TOP_APP_BAR_HEIGHT
import vulong.todoapp.ui.theme.topAppBarBackgroundColor
import vulong.todoapp.ui.theme.topAppBarContentColor
import vulong.todoapp.ui.viewmodels.SharedViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    sharedViewModel: SharedViewModel,
    navigateToHomeScreen: () -> Unit,
    navigateToTaskScreen: (taskIt: Int) -> Unit,
) {

    LaunchedEffect(key1 = true, block = {
        sharedViewModel.searchTasks()
    })


    val scaffoldState = rememberScaffoldState()
    if (sharedViewModel.snackBarDetail != null) {
        CustomSnackBar(
            scaffoldState = scaffoldState,
            sharedViewModel = sharedViewModel,
        )
    }

    BackHandler(true) {
        sharedViewModel.searchText = ""
        sharedViewModel.dismissSnackBar()
        navigateToHomeScreen()
    }

    Scaffold(
        topBar = {
            SearchAppBar(
                text = sharedViewModel.searchText,
                onTextChange = {
                    sharedViewModel.onSearchChange(it)

                },
                onBackClicked = {
                    sharedViewModel.searchText = ""
                    sharedViewModel.dismissSnackBar()
                    navigateToHomeScreen()
                },
                onSearchClicked = {
                },
            )
        },
        scaffoldState = scaffoldState,
        content = {
            val searchedTasks by sharedViewModel.searchedTasks.collectAsState()
            DisplayTasks(
                toDoTasks = searchedTasks,
                navigate = navigateToTaskScreen
            )
        },
    )

}

@ExperimentalComposeUiApi
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onBackClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
) {

    var isInitSearchScreen by rememberSaveable {
        mutableStateOf(true)
    }
    val focusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(true) {
        if (isInitSearchScreen) {
            focusRequester.requestFocus()
            isInitSearchScreen = false
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (it.isFocused) {
                        keyboardController?.show()
                    } else {
                        keyboardController?.hide()
                    }
                },
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    text = stringResource(R.string.search_placeholder),
                    color = Color.White,
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = {
                        onBackClicked()
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_icon),
                        tint = MaterialTheme.colors.topAppBarContentColor,
                    )
                }
            },
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            onTextChange("")
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(R.string.delete_icon),
                            tint = MaterialTheme.colors.topAppBarContentColor,
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                    keyboardController?.hide()
                    focusManager.clearFocus()
                },
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
            ),
        )
    }
}

