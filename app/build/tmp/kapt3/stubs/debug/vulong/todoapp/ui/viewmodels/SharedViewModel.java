package vulong.todoapp.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010t\u001a\u00020u2\b\b\u0002\u0010v\u001a\u000207J\u0010\u0010w\u001a\u0002072\b\b\u0002\u0010x\u001a\u000207J\u0006\u0010y\u001a\u00020uJ\u0006\u0010z\u001a\u00020uJ\u0006\u0010{\u001a\u00020uJ\b\u0010\u000e\u001a\u00020uH\u0002J\b\u0010\u0011\u001a\u00020uH\u0002J\u0015\u0010|\u001a\u00020u2\b\u0010}\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010~\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\u001bJ\u0010\u0010\u0080\u0001\u001a\u00020u2\u0007\u0010\u0081\u0001\u001a\u00020\u001bJ\u0010\u0010\u0082\u0001\u001a\u00020u2\u0007\u0010\u0083\u0001\u001a\u00020\u001bJ\t\u0010\u0084\u0001\u001a\u00020uH\u0002J\u0007\u0010\u0085\u0001\u001a\u00020uJ\t\u0010\u0086\u0001\u001a\u00020uH\u0002J\u0006\u0010f\u001a\u00020uJ\u0007\u0010\u0087\u0001\u001a\u00020uJ\u0007\u0010\u0088\u0001\u001a\u00020uJ\u0007\u0010\u0089\u0001\u001a\u000207R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010#\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R/\u0010)\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R+\u0010-\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00103\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u0010\u001a\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R+\u00108\u001a\u0002072\u0006\u0010\u0012\u001a\u0002078F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b<\u0010\u001a\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R+\u0010=\u001a\u0002072\u0006\u0010\u0012\u001a\u0002078F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b?\u0010\u001a\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R+\u0010@\u001a\u0002072\u0006\u0010\u0012\u001a\u0002078F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bB\u0010\u001a\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R/\u0010C\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bF\u0010\u001a\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R/\u0010G\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bJ\u0010\u001a\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R+\u0010L\u001a\u00020K2\u0006\u0010\u0012\u001a\u00020K8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bQ\u0010\u001a\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010R\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bU\u0010\u001a\u001a\u0004\bS\u0010\u001e\"\u0004\bT\u0010 R\u001d\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010XR/\u0010Y\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b^\u0010\u001a\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R/\u0010`\u001a\u0004\u0018\u00010_2\b\u0010\u0012\u001a\u0004\u0018\u00010_8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\be\u0010\u001a\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR7\u0010f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\bk\u0010\u001a\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR+\u0010l\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bo\u0010\u001a\u001a\u0004\bm\u0010\u001e\"\u0004\bn\u0010 R/\u0010p\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bs\u0010\u001a\u001a\u0004\bq\u0010\u0016\"\u0004\br\u0010\u0018\u00a8\u0006\u008a\u0001"}, d2 = {"Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lvulong/todoapp/data/repositories/ToDoRepository;", "context", "Landroid/content/Context;", "(Lvulong/todoapp/data/repositories/ToDoRepository;Landroid/content/Context;)V", "_allTasksByPriority", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lvulong/todoapp/data/models/ToDoTask;", "_allTasksByRecent", "allTasksByPriority", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTasksByPriority", "()Lkotlinx/coroutines/flow/StateFlow;", "allTasksByRecent", "getAllTasksByRecent", "<set-?>", "", "day", "getDay", "()Ljava/lang/Integer;", "setDay", "(Ljava/lang/Integer;)V", "day$delegate", "Landroidx/compose/runtime/MutableState;", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "description$delegate", "Lvulong/todoapp/util/LoadingState;", "firstTimeLoadDataState", "getFirstTimeLoadDataState", "()Lvulong/todoapp/util/LoadingState;", "setFirstTimeLoadDataState", "(Lvulong/todoapp/util/LoadingState;)V", "firstTimeLoadDataState$delegate", "hour", "getHour", "setHour", "hour$delegate", "id", "getId", "()I", "setId", "(I)V", "id$delegate", "idFromNotification", "getIdFromNotification", "setIdFromNotification", "idFromNotification$delegate", "", "isLaunchFromNotification", "()Z", "setLaunchFromNotification", "(Z)V", "isLaunchFromNotification$delegate", "isSetReminder", "setSetReminder", "isSetReminder$delegate", "isSortByPriority", "setSortByPriority", "isSortByPriority$delegate", "minute", "getMinute", "setMinute", "minute$delegate", "month", "getMonth", "setMonth", "month$delegate", "Lvulong/todoapp/data/models/Priority;", "priority", "getPriority", "()Lvulong/todoapp/data/models/Priority;", "setPriority", "(Lvulong/todoapp/data/models/Priority;)V", "priority$delegate", "searchText", "getSearchText", "setSearchText", "searchText$delegate", "searchedTasks", "getSearchedTasks", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedTask", "getSelectedTask", "()Lvulong/todoapp/data/models/ToDoTask;", "setSelectedTask", "(Lvulong/todoapp/data/models/ToDoTask;)V", "selectedTask$delegate", "Lvulong/todoapp/util/SnackBarDetail;", "snackBarDetail", "getSnackBarDetail", "()Lvulong/todoapp/util/SnackBarDetail;", "setSnackBarDetail", "(Lvulong/todoapp/util/SnackBarDetail;)V", "snackBarDetail$delegate", "tempDeleteAllTasks", "getTempDeleteAllTasks", "()Ljava/util/List;", "setTempDeleteAllTasks", "(Ljava/util/List;)V", "tempDeleteAllTasks$delegate", "title", "getTitle", "setTitle", "title$delegate", "year", "getYear", "setYear", "year$delegate", "addTask", "", "isUndoDeleteTask", "checkDateTimeValid", "justCheckNotUpdateIsSetReminder", "deleteAllTasks", "deleteSelectedTask", "dismissSnackBar", "getTask", "taskIndex", "onDescriptionChange", "newDescription", "onSearchChange", "newSearch", "onTitleChange", "newTitle", "removeReminder", "searchTasks", "setReminder", "undoDeleteAllTasks", "updateTask", "validateFields", "app_debug"})
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
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isSetReminder$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState year$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState month$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState day$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState hour$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.runtime.MutableState minute$delegate = null;
    private final androidx.compose.runtime.MutableState tempDeleteAllTasks$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLaunchFromNotification$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState idFromNotification$delegate = null;
    
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
    
    public final boolean isSetReminder() {
        return false;
    }
    
    public final void setSetReminder(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getYear() {
        return null;
    }
    
    public final void setYear(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMonth() {
        return null;
    }
    
    public final void setMonth(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDay() {
        return null;
    }
    
    public final void setDay(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getHour() {
        return null;
    }
    
    public final void setHour(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMinute() {
        return null;
    }
    
    public final void setMinute(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    private final java.util.List<vulong.todoapp.data.models.ToDoTask> getTempDeleteAllTasks() {
        return null;
    }
    
    private final void setTempDeleteAllTasks(java.util.List<vulong.todoapp.data.models.ToDoTask> p0) {
    }
    
    public final boolean isLaunchFromNotification() {
        return false;
    }
    
    public final void setLaunchFromNotification(boolean p0) {
    }
    
    public final int getIdFromNotification() {
        return 0;
    }
    
    public final void setIdFromNotification(int p0) {
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
    
    private final void setReminder() {
    }
    
    private final void removeReminder() {
    }
    
    public final boolean checkDateTimeValid(boolean justCheckNotUpdateIsSetReminder) {
        return false;
    }
}