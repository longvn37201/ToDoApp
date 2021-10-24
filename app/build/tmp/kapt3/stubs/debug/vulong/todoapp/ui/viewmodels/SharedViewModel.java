package vulong.todoapp.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lvulong/todoapp/data/repositories/ToDoRepository;", "(Lvulong/todoapp/data/repositories/ToDoRepository;)V", "_allTasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lvulong/todoapp/data/models/ToDoTask;", "allTasks", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "getAllTask", "", "app_debug"})
public final class SharedViewModel extends androidx.lifecycle.ViewModel {
    private final vulong.todoapp.data.repositories.ToDoRepository repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> _allTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> allTasks = null;
    
    @javax.inject.Inject()
    public SharedViewModel(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.data.repositories.ToDoRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<vulong.todoapp.data.models.ToDoTask>> getAllTasks() {
        return null;
    }
    
    public final void getAllTask() {
    }
}