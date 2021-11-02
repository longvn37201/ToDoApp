package vulong.todoapp.ui.screens.list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a8\u0010\t\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0016\u0010\r\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001aF\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001c\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u0014"}, d2 = {"DefaultListAppBar", "", "onSearchClicked", "Lkotlin/Function0;", "onSortClicked", "Lkotlin/Function1;", "Lvulong/todoapp/data/models/Priority;", "onDeleteAllClicked", "DeleteAllAction", "ListAppBarActions", "ListScreenAppBar", "sharedViewModel", "Lvulong/todoapp/ui/viewmodels/SharedViewModel;", "SearchAction", "SearchAppBar", "text", "", "onTextChange", "onBackClicked", "SortAction", "app_debug"})
public final class ListScreenAppBarKt {
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.ui.ExperimentalComposeUiApi()
    public static final void ListScreenAppBar(@org.jetbrains.annotations.NotNull()
    vulong.todoapp.ui.viewmodels.SharedViewModel sharedViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DefaultListAppBar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super vulong.todoapp.data.models.Priority, kotlin.Unit> onSortClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ListAppBarActions(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super vulong.todoapp.data.models.Priority, kotlin.Unit> onSortClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SearchAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SortAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super vulong.todoapp.data.models.Priority, kotlin.Unit> onSortClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DeleteAllAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.ui.ExperimentalComposeUiApi()
    public static final void SearchAppBar(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearchClicked) {
    }
}