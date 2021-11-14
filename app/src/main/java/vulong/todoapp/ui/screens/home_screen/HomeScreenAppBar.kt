package vulong.todoapp.ui.screens.home_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import vulong.todoapp.R
import vulong.todoapp.ui.components.ConfirmDialog
import vulong.todoapp.ui.components.SortItem
import vulong.todoapp.ui.theme.*
import vulong.todoapp.ui.viewmodels.SharedViewModel

@Composable
fun HomeScreenAppBar(
    navigateToSearchScreen: () -> Unit,
    onSortByRecentClicked: () -> Unit,
    onSortByPriorityClicked: () -> Unit,
    onConfirmDeleteAll: () -> Unit,
    sharedViewModel: SharedViewModel,
) {
    var openDialog by remember {
        mutableStateOf(false)
    }
    if (openDialog) {
        ConfirmDialog(
            title = "Delete all",
            message = "Are you sure?",
            openDialog = openDialog,
            closeDialog = { openDialog = false },
            onConfirmClicked = {
                onConfirmDeleteAll()
            }
        )
    }
    DefaultListAppBar(
        onSearchClicked = {
            navigateToSearchScreen()
        },
        onSortByPriorityClicked = onSortByPriorityClicked,
        onSortByRecentClicked = onSortByRecentClicked,
        isSortByPriority = sharedViewModel.isSortByPriority,
        onDeleteAllClicked = {
            openDialog = true
        },
    )

}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortByRecentClicked: () -> Unit,
    onSortByPriorityClicked: () -> Unit,
    isSortByPriority: Boolean,
    onDeleteAllClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor,
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortByRecentClicked = onSortByRecentClicked,
                onSortByPriorityClicked = onSortByPriorityClicked,
                isSortByPriority = isSortByPriority,
                onDeleteAllClicked = onDeleteAllClicked
            )
        }
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortByRecentClicked: () -> Unit,
    onSortByPriorityClicked: () -> Unit,
    onDeleteAllClicked: () -> Unit,
    isSortByPriority: Boolean
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(
        onSortByPriorityClicked = onSortByPriorityClicked,
        onSortByRecentClicked = onSortByRecentClicked,
        isSortByPriority =isSortByPriority
    )
    DeleteAllAction(onDeleteAllClicked = onDeleteAllClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit,
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(
    onSortByRecentClicked: () -> Unit,
    onSortByPriorityClicked: () -> Unit,
    isSortByPriority: Boolean,
) {
    var isExpanded by remember { mutableStateOf(false) }

    IconButton(onClick = { isExpanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.sort_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            DropdownMenuItem(
                onClick = {
                    isExpanded = false
                    onSortByRecentClicked()
                }
            ) {
                SortItem(
                    title = stringResource(R.string.sort_by_most_recent),
                    isSelected = !isSortByPriority,
                )
            }
            DropdownMenuItem(
                onClick = {
                    isExpanded = false
                    onSortByPriorityClicked()
                }
            ) {
                SortItem(
                    title = stringResource(R.string.sort_by_priority),
                    isSelected = isSortByPriority,
                )
            }
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteAllClicked: () -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    IconButton(onClick = { isExpanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(R.string.delete_all_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            DropdownMenuItem(
                onClick = {
                    isExpanded = false
                    onDeleteAllClicked()
                }
            ) {
                Text(
                    modifier = Modifier.padding(LARGE_PADDING),
                    text = stringResource(R.string.delete_all_action),
                    style = Typography.subtitle2
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onBackClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
) {
    val focusRequester = FocusRequester()
    val keyboardController = LocalSoftwareKeyboardController.current

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
        DisposableEffect(Unit) {
            focusRequester.requestFocus()
            onDispose { }
        }
    }
}

