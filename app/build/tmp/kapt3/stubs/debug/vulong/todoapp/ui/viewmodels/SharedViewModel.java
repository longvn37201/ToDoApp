package vulong.todoapp.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020)J\u0006\u0010W\u001a\u00020UJ\u0006\u0010X\u001a\u00020UJ\u0006\u0010Y\u001a\u00020UJ\b\u0010\u000e\u001a\u00020UH\u0002J\b\u0010\u0011\u001a\u00020UH\u0002J\u0015\u0010Z\u001a\u00020U2\b\u0010[\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0002\u0010\\J\u000e\u0010]\u001a\u00020U2\u0006\u0010^\u001a\u00020\u0013J\u000e\u0010_\u001a\u00020U2\u0006\u0010`\u001a\u00020\u0013J\u000e\u0010a\u001a\u00020U2\u0006\u0010b\u001a\u00020\u0013J\u0006\u0010c\u001a\u00020UJ\u0006\u0010J\u001a\u00020UJ\u0006\u0010d\u001a\u00020UJ\u0006\u0010e\u001a\u00020UJ\u0006\u0010f\u001a\u00020)R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010#\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R+\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020)8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u00100\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u00106\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u001a\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\u001d\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R/\u0010=\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bB\u0010\u001a\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR/\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u0012\u001a\u0004\u0018\u00010C8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bI\u0010\u001a\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR7\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\bO\u0010\u001a\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR+\u0010P\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bS\u0010\u001a\u001a\u0004\bQ\u0010\u0016\"\u0004\bR\u0010\u0018\u00a8\u0006g"}, d2 = {"Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lvulong/todoapp/data/repositories/ToDoRepository;", "context", "Landroid/content/Context;", "(Lvulong/todoapp/data/repositories/ToDoRepository;Landroid/content/Context;)V", "_allTasksByPriority", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lvulong/todoapp/data/models/ToDoTask;", "_allTasksByRecent", "allTasksByPriority", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTasksByPriority", "()Lkotlinx/coroutines/flow/StateFlow;", "allTasksByRecent", "getAllTasksByRecent", "<set-?>", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "description$delegate", "Landroidx/compose/runtime/MutableState;", "Lvulong/todoapp/util/LoadingState;", "firstTimeLoadDataState", "getFirstTimeLoadDataState", "()Lvulong/todoapp/util/LoadingState;", "setFirstTimeLoadDataState", "(Lvulong/todoapp/util/LoadingState;)V", "firstTimeLoadDataState$delegate", "", "id", "getId", "()I", "setId", "(I)V", "id$delegate", "", "isSortByPriority", "()Z", "setSortByPriority", "(Z)V", "isSortByPriority$delegate", "Lvulong/todoapp/data/models/Priority;", "priority", "getPriority", "()Lvulong/todoapp/data/models/Priority;", "setPriority", "(Lvulong/todoapp/data/models/Priority;)V", "priority$delegate", "searchText", "getSearchText", "setSearchText", "searchText$delegate", "searchedTasks", "getSearchedTasks", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedTask", "getSelectedTask", "()Lvulong/todoapp/data/models/ToDoTask;", "setSelectedTask", "(Lvulong/todoapp/data/models/ToDoTask;)V", "selectedTask$delegate", "Lvulong/todoapp/util/SnackBarDetail;", "snackBarDetail", "getSnackBarDetail", "()Lvulong/todoapp/util/SnackBarDetail;", "setSnackBarDetail", "(Lvulong/todoapp/util/SnackBarDetail;)V", "snackBarDetail$delegate", "tempDeleteAllTasks", "getTempDeleteAllTasks", "()Ljava/util/List;", "setTempDeleteAllTasks", "(Ljava/util/List;)V", "tempDeleteAllTasks$delegate", "title", "getTitle", "setTitle", "title$delegate", "addTask", "", "isUndoDeleteTask", "deleteAllTasks", "deleteSelectedTask", "dismissSnackBar", "getTask", "taskIndex", "(Ljava/lang/Integer;)V", "onDescriptionChange", "newDescription", "onSearchChange", "newSearch", "onTitleChange", "newTitle", "searchTasks", "undoDeleteAllTasks", "updateTask", "validateFields", "app_debug"})
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    private final vulong.todoapp.data.repositories.ToDoRepository repository = null;
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isSortByPriority$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState searchText$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState firstTimeLoadDataState$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState snackBarDetail$delegate = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _allTasksByRecent = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> allTasksByRecent = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _allTasksByPriority = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> allTasksByPriority = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> searchedTasks = null;
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
    private final androidx.compose.runtime.MutableState tempDeleteAllTasks$delegate = null;
    
    @javax.inject.Inject()
    public SharedViewModel(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.data.repositories.ToDoRepository repository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    public final boolean isSortByPriority() {
        return false;
    }
    
    public final void setSortByPriority(boolean p0) {
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
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getAllTasksByRecent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getAllTasksByPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getSearchedTasks() {
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
    
    private final java.util.List<vulong.todoapp.data.models.ToDoTask> getTempDeleteAllTasks() {
        return null;
    }
    
    private final void setTempDeleteAllTasks(java.util.List<vulong.todoapp.data.models.ToDoTask> p0) {
    }
    
    private final void getAllTasksByRecent() {
    }
    
    private final void getAllTasksByPriority() {
    }
    
    public final void searchTasks() {
    }
    
    public final void addTask(boolean isUndoDeleteTask) {
    }
    
    public final void updateTask() {
    }
    
    public final void tempDeleteAllTasks() {
    }
    
    public final void deleteAllTasks() {
    }
    
    public final void undoDeleteAllTasks() {
    }
    
    public final void deleteSelectedTask() {
    }
    
    public final void getTask(@org.jetbrains.annotations.Nullable()
    java.lang.Integer taskIndex) {
    }
    
    public final void dismissSnackBar() {
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