package vulong.todoapp.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lvulong/todoapp/util/Constants;", "", "()V", "DATABASE_NAME", "", "DATABASE_TABLE", "HOME_SCREEN", "LOREM_IPSUM", "getLOREM_IPSUM", "()Ljava/lang/String;", "MAX_DESCRIPTION_LENGTH", "", "MAX_SEARCH_LENGTH", "MAX_TITLE_LENGTH", "NOTIFICATION_CHANNEL_DISPLAY_NAME", "NOTIFICATION_CHANNEL_ID", "SEARCH_SCREEN", "SPLASH_SCREEN", "SPLASH_SCREEN_DURATION", "", "TAG", "TASK_ARGUMENT_KEY", "TASK_SCREEN", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final vulong.todoapp.util.Constants INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_TABLE = "todo_table";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "todo_database";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SPLASH_SCREEN = "splash";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH_SCREEN = "search";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_SCREEN = "home";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TASK_SCREEN = "task/{taskId}";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TASK_ARGUMENT_KEY = "taskId";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "longvn";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOREM_IPSUM = null;
    public static final int MAX_TITLE_LENGTH = 25;
    public static final int MAX_SEARCH_LENGTH = 100;
    public static final int MAX_DESCRIPTION_LENGTH = 1000;
    public static final long SPLASH_SCREEN_DURATION = 1700L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_ID = "notifyToDo";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_DISPLAY_NAME = "To do app channel";
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLOREM_IPSUM() {
        return null;
    }
}