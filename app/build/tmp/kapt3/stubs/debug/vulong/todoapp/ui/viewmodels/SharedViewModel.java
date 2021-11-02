package vulong.todoapp.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020TH\u0002J\b\u0010V\u001a\u00020TH\u0002J\u0006\u0010\u000f\u001a\u00020TJ\u000e\u0010=\u001a\u00020T2\u0006\u0010W\u001a\u00020\u001aJ\u000e\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020>J\u000e\u0010Z\u001a\u00020T2\u0006\u0010[\u001a\u00020\u0012J\u000e\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020\u0012J\b\u0010M\u001a\u00020TH\u0002J\b\u0010`\u001a\u00020TH\u0002J\u0006\u0010a\u001a\u00020bR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020!8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\u0019\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010)\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020(8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u00100\u001a\u00020/2\u0006\u0010\u0011\u001a\u00020/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u0019\u001a\u0004\b1\u00102\"\u0004\b3\u00104R+\u00106\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u0019\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\u001d\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0010R\u0019\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0010R+\u0010?\u001a\u00020>2\u0006\u0010\u0011\u001a\u00020>8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bD\u0010\u0019\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR+\u0010E\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bH\u0010\u0019\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R+\u0010I\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bL\u0010\u0019\u001a\u0004\bJ\u0010\u0015\"\u0004\bK\u0010\u0017R/\u0010M\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bR\u0010\u0019\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q\u00a8\u0006c"}, d2 = {"Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lvulong/todoapp/data/repositories/ToDoRepository;", "context", "Landroid/content/Context;", "(Lvulong/todoapp/data/repositories/ToDoRepository;Landroid/content/Context;)V", "_allTasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lvulong/todoapp/data/models/ToDoTask;", "_searchedTasks", "_selectedTask", "allTasks", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "<set-?>", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "description$delegate", "Landroidx/compose/runtime/MutableState;", "", "id", "getId", "()I", "setId", "(I)V", "id$delegate", "Lvulong/todoapp/util/LoadingState;", "loadDataState", "getLoadDataState", "()Lvulong/todoapp/util/LoadingState;", "setLoadDataState", "(Lvulong/todoapp/util/LoadingState;)V", "loadDataState$delegate", "Lvulong/todoapp/data/models/Priority;", "priority", "getPriority", "()Lvulong/todoapp/data/models/Priority;", "setPriority", "(Lvulong/todoapp/data/models/Priority;)V", "priority$delegate", "Lvulong/todoapp/util/SearchAppBarState;", "searchAppBarState", "getSearchAppBarState", "()Lvulong/todoapp/util/SearchAppBarState;", "setSearchAppBarState", "(Lvulong/todoapp/util/SearchAppBarState;)V", "searchAppBarState$delegate", "searchTextState", "getSearchTextState", "setSearchTextState", "searchTextState$delegate", "searchedTasks", "getSearchedTasks", "selectedTask", "getSelectedTask", "Lvulong/todoapp/util/Action;", "snackBarAction", "getSnackBarAction", "()Lvulong/todoapp/util/Action;", "setSnackBarAction", "(Lvulong/todoapp/util/Action;)V", "snackBarAction$delegate", "snackBarMessage", "getSnackBarMessage", "setSnackBarMessage", "snackBarMessage$delegate", "title", "getTitle", "setTitle", "title$delegate", "undoTask", "getUndoTask", "()Lvulong/todoapp/data/models/ToDoTask;", "setUndoTask", "(Lvulong/todoapp/data/models/ToDoTask;)V", "undoTask$delegate", "addTask", "", "deleteAllTask", "deleteTask", "taskId", "handleDatabaseActions", "action", "onDescriptionChange", "newDescription", "onTitleChange", "newTitle", "searchTasks", "searchQuery", "updateTask", "validateFields", "", "app_debug"})
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    private final vulong.todoapp.data.repositories.ToDoRepository repository = null;
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState snackBarAction$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState snackBarMessage$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState searchAppBarState$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState searchTextState$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState loadDataState$delegate = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _allTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> allTasks = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _searchedTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> searchedTasks = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<vulong.todoapp.data.models.ToDoTask> _selectedTask = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<vulong.todoapp.data.models.ToDoTask> selectedTask = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState id$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState title$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState description$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState priority$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState undoTask$delegate = null;
    
    @javax.inject.Inject()
    public SharedViewModel(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.data.repositories.ToDoRepository repository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final vulong.todoapp.util.Action getSnackBarAction() {
        return null;
    }
    
    public final void setSnackBarAction(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.util.Action p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSnackBarMessage() {
        return null;
    }
    
    public final void setSnackBarMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final vulong.todoapp.util.SearchAppBarState getSearchAppBarState() {
        return null;
    }
    
    public final void setSearchAppBarState(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.util.SearchAppBarState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchTextState() {
        return null;
    }
    
    public final void setSearchTextState(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final vulong.todoapp.util.LoadingState getLoadDataState() {
        return null;
    }
    
    public final void setLoadDataState(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.util.LoadingState p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getAllTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getSearchedTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<vulong.todoapp.data.models.ToDoTask> getSelectedTask() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final vulong.todoapp.data.models.Priority getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.data.models.Priority p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final vulong.todoapp.data.models.ToDoTask getUndoTask() {
        return null;
    }
    
    public final void setUndoTask(@org.jetbrains.annotations.Nullable()
    vulong.todoapp.data.models.ToDoTask p0) {
    }
    
    public final void handleDatabaseActions(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.util.Action action) {
    }
    
    public final void searchTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery) {
    }
    
    public final void getAllTasks() {
    }
    
    public final void getSelectedTask(int taskId) {
    }
    
    private final void addTask() {
    }
    
    private final void undoTask() {
    }
    
    private final void updateTask() {
    }
    
    private final void deleteTask() {
    }
    
    private final void deleteAllTask() {
    }
    
    public final boolean validateFields() {
        return false;
    }
    
    public final void onTitleChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newTitle) {
    }
    
    public final void onDescriptionChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newDescription) {
    }
}