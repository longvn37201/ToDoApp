package vulong.todoapp.ui.screens.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0007\u001aA\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0007\u001a3\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"DisplayTasks", "", "toDoTasks", "", "Lvulong/todoapp/data/models/ToDoTask;", "navigateToTaskScreen", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "taskId", "EmptyContent", "ListScreenContent", "sharedViewModel", "Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "LoadingContent", "TaskItem", "toDoTask", "app_debug"})
public final class ListScreenContentKt {
    
    @androidx.compose.runtime.Composable()
    public static final void ListScreenContent(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.ui.viewmodels.SharedViewModel sharedViewModel, @org.jetbrains.annotations.NotNull()
    java.util.List<vulong.todoapp.data.models.ToDoTask> toDoTasks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> navigateToTaskScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DisplayTasks(@org.jetbrains.annotations.NotNull()
    java.util.List<vulong.todoapp.data.models.ToDoTask> toDoTasks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> navigateToTaskScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TaskItem(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.data.models.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> navigateToTaskScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LoadingContent() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyContent() {
    }
}