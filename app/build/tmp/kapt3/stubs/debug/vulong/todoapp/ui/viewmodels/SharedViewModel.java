package vulong.todoapp.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020KJ\b\u0010\u000f\u001a\u00020KH\u0002J\u0015\u0010O\u001a\u00020K2\b\u0010P\u001a\u0004\u0018\u00010!\u00a2\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020\u0012J\u000e\u0010T\u001a\u00020K2\u0006\u0010U\u001a\u00020\u0012J\u000e\u0010V\u001a\u00020K2\u0006\u0010W\u001a\u00020\u0012J\u0006\u0010X\u001a\u00020KJ\u0006\u0010Y\u001a\u00020MR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u001a8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020!8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\u0019\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010)\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020(8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010/\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0010R/\u00105\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b:\u0010\u0019\u001a\u0004\b6\u00107\"\u0004\b8\u00109R/\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\u0011\u001a\u0004\u0018\u00010;8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bA\u0010\u0019\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R!\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010\u0019\u001a\u0004\bC\u0010DR+\u0010F\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bI\u0010\u0019\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010\u0017\u00a8\u0006Z"}, d2 = {"Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lvulong/todoapp/data/repositories/ToDoRepository;", "context", "Landroid/content/Context;", "(Lvulong/todoapp/data/repositories/ToDoRepository;Landroid/content/Context;)V", "_allTasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lvulong/todoapp/data/models/ToDoTask;", "_searchedTasks", "", "allTasks", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "<set-?>", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "description$delegate", "Landroidx/compose/runtime/MutableState;", "Lvulong/todoapp/util/LoadingState;", "firstTimeLoadDataState", "getFirstTimeLoadDataState", "()Lvulong/todoapp/util/LoadingState;", "setFirstTimeLoadDataState", "(Lvulong/todoapp/util/LoadingState;)V", "firstTimeLoadDataState$delegate", "", "id", "getId", "()I", "setId", "(I)V", "id$delegate", "Lvulong/todoapp/data/models/Priority;", "priority", "getPriority", "()Lvulong/todoapp/data/models/Priority;", "setPriority", "(Lvulong/todoapp/data/models/Priority;)V", "priority$delegate", "searchText", "getSearchText", "setSearchText", "searchText$delegate", "searchedTasks", "getSearchedTasks", "selectedTask", "getSelectedTask", "()Lvulong/todoapp/data/models/ToDoTask;", "setSelectedTask", "(Lvulong/todoapp/data/models/ToDoTask;)V", "selectedTask$delegate", "Lvulong/todoapp/util/SnackBarDetail;", "snackBarDetail", "getSnackBarDetail", "()Lvulong/todoapp/util/SnackBarDetail;", "setSnackBarDetail", "(Lvulong/todoapp/util/SnackBarDetail;)V", "snackBarDetail$delegate", "tempDeleteTasks", "getTempDeleteTasks", "()Ljava/util/List;", "tempDeleteTasks$delegate", "title", "getTitle", "setTitle", "title$delegate", "addTask", "", "isUndoDeleteTask", "", "deleteSelectedTask", "getTask", "taskId", "(Ljava/lang/Integer;)V", "onDescriptionChange", "newDescription", "onSearchChange", "newSearch", "onTitleChange", "newTitle", "updateTask", "validateFields", "app_debug"})
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    private final vulong.todoapp.data.repositories.ToDoRepository repository = null;
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState searchText$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState firstTimeLoadDataState$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState snackBarDetail$delegate = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _allTasks = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _searchedTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> searchedTasks = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState selectedTask$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState id$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState title$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState description$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState priority$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState tempDeleteTasks$delegate = null;
    
    @javax.inject.Inject()
    public SharedViewModel(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.data.repositories.ToDoRepository repository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchText() {
        return null;
    }
    
    public final void setSearchText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final vulong.todoapp.util.LoadingState getFirstTimeLoadDataState() {
        return null;
    }
    
    public final void setFirstTimeLoadDataState(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.util.LoadingState p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final vulong.todoapp.util.SnackBarDetail getSnackBarDetail() {
        return null;
    }
    
    public final void setSnackBarDetail(@org.jetbrains.annotations.Nullable()
    vulong.todoapp.util.SnackBarDetail p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getAllTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getSearchedTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final vulong.todoapp.data.models.ToDoTask getSelectedTask() {
        return null;
    }
    
    public final void setSelectedTask(@org.jetbrains.annotations.Nullable()
    vulong.todoapp.data.models.ToDoTask p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<vulong.todoapp.data.models.ToDoTask> getTempDeleteTasks() {
        return null;
    }
    
    private final void getAllTasks() {
    }
    
    public final void addTask(boolean isUndoDeleteTask) {
    }
    
    public final void updateTask() {
    }
    
    public final void deleteSelectedTask() {
    }
    
    public final void getTask(@org.jetbrains.annotations.Nullable()
    java.lang.Integer taskId) {
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
    
    public final void onSearchChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newSearch) {
    }
}