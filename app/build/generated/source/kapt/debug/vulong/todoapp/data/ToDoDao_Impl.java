package vulong.todoapp.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import vulong.todoapp.data.models.Priority;
import vulong.todoapp.data.models.ToDoTask;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ToDoDao_Impl implements ToDoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ToDoTask> __insertionAdapterOfToDoTask;

  private final EntityDeletionOrUpdateAdapter<ToDoTask> __deletionAdapterOfToDoTask;

  private final EntityDeletionOrUpdateAdapter<ToDoTask> __updateAdapterOfToDoTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTask;

  public ToDoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfToDoTask = new EntityInsertionAdapter<ToDoTask>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `todo_table` (`id`,`title`,`description`,`priority`,`isSetReminder`,`year`,`month`,`day`,`hour`,`minute`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ToDoTask value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getPriority() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, __Priority_enumToString(value.getPriority()));
        }
        final int _tmp;
        _tmp = value.isSetReminder() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getYear() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getYear());
        }
        if (value.getMonth() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getMonth());
        }
        if (value.getDay() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDay());
        }
        if (value.getHour() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getHour());
        }
        if (value.getMinute() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getMinute());
        }
      }
    };
    this.__deletionAdapterOfToDoTask = new EntityDeletionOrUpdateAdapter<ToDoTask>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `todo_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ToDoTask value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfToDoTask = new EntityDeletionOrUpdateAdapter<ToDoTask>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `todo_table` SET `id` = ?,`title` = ?,`description` = ?,`priority` = ?,`isSetReminder` = ?,`year` = ?,`month` = ?,`day` = ?,`hour` = ?,`minute` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ToDoTask value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getPriority() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, __Priority_enumToString(value.getPriority()));
        }
        final int _tmp;
        _tmp = value.isSetReminder() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getYear() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getYear());
        }
        if (value.getMonth() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getMonth());
        }
        if (value.getDay() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDay());
        }
        if (value.getHour() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getHour());
        }
        if (value.getMinute() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getMinute());
        }
        stmt.bindLong(11, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllTask = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM todo_table";
        return _query;
      }
    };
  }

  @Override
  public Object addTask(final ToDoTask toDoTask, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfToDoTask.insert(toDoTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteTask(final ToDoTask toDoTask, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfToDoTask.handle(toDoTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateTask(final ToDoTask toDoTask, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfToDoTask.handle(toDoTask);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllTask(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTask.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllTask.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<ToDoTask> getTask(final int taskId) {
    final String _sql = "SELECT * FROM todo_table WHERE id=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, taskId);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<ToDoTask>() {
      @Override
      public ToDoTask call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsSetReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "isSetReminder");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final ToDoTask _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            _tmpPriority = __Priority_stringToEnum(_cursor.getString(_cursorIndexOfPriority));
            final boolean _tmpIsSetReminder;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSetReminder);
            _tmpIsSetReminder = _tmp != 0;
            final Integer _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            }
            final Integer _tmpMonth;
            if (_cursor.isNull(_cursorIndexOfMonth)) {
              _tmpMonth = null;
            } else {
              _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            }
            final Integer _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            }
            final Integer _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            }
            final Integer _tmpMinute;
            if (_cursor.isNull(_cursorIndexOfMinute)) {
              _tmpMinute = null;
            } else {
              _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            }
            _result = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpPriority,_tmpIsSetReminder,_tmpYear,_tmpMonth,_tmpDay,_tmpHour,_tmpMinute);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> getAllTask() {
    final String _sql = "SELECT * FROM todo_table ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsSetReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "isSetReminder");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            _tmpPriority = __Priority_stringToEnum(_cursor.getString(_cursorIndexOfPriority));
            final boolean _tmpIsSetReminder;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSetReminder);
            _tmpIsSetReminder = _tmp != 0;
            final Integer _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            }
            final Integer _tmpMonth;
            if (_cursor.isNull(_cursorIndexOfMonth)) {
              _tmpMonth = null;
            } else {
              _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            }
            final Integer _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            }
            final Integer _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            }
            final Integer _tmpMinute;
            if (_cursor.isNull(_cursorIndexOfMinute)) {
              _tmpMinute = null;
            } else {
              _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            }
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpPriority,_tmpIsSetReminder,_tmpYear,_tmpMonth,_tmpDay,_tmpHour,_tmpMinute);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> getByLowPriority() {
    final String _sql = "SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsSetReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "isSetReminder");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            _tmpPriority = __Priority_stringToEnum(_cursor.getString(_cursorIndexOfPriority));
            final boolean _tmpIsSetReminder;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSetReminder);
            _tmpIsSetReminder = _tmp != 0;
            final Integer _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            }
            final Integer _tmpMonth;
            if (_cursor.isNull(_cursorIndexOfMonth)) {
              _tmpMonth = null;
            } else {
              _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            }
            final Integer _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            }
            final Integer _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            }
            final Integer _tmpMinute;
            if (_cursor.isNull(_cursorIndexOfMinute)) {
              _tmpMinute = null;
            } else {
              _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            }
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpPriority,_tmpIsSetReminder,_tmpYear,_tmpMonth,_tmpDay,_tmpHour,_tmpMinute);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> getByHighPriority() {
    final String _sql = "SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsSetReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "isSetReminder");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            _tmpPriority = __Priority_stringToEnum(_cursor.getString(_cursorIndexOfPriority));
            final boolean _tmpIsSetReminder;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSetReminder);
            _tmpIsSetReminder = _tmp != 0;
            final Integer _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            }
            final Integer _tmpMonth;
            if (_cursor.isNull(_cursorIndexOfMonth)) {
              _tmpMonth = null;
            } else {
              _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            }
            final Integer _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            }
            final Integer _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            }
            final Integer _tmpMinute;
            if (_cursor.isNull(_cursorIndexOfMinute)) {
              _tmpMinute = null;
            } else {
              _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            }
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpPriority,_tmpIsSetReminder,_tmpYear,_tmpMonth,_tmpDay,_tmpHour,_tmpMinute);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ToDoTask>> searchTasks(final String searchQuery) {
    final String _sql = "SELECT * FROM todo_table WHERE title LIKE ? OR description LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"todo_table"}, new Callable<List<ToDoTask>>() {
      @Override
      public List<ToDoTask> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsSetReminder = CursorUtil.getColumnIndexOrThrow(_cursor, "isSetReminder");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final List<ToDoTask> _result = new ArrayList<ToDoTask>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ToDoTask _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            _tmpPriority = __Priority_stringToEnum(_cursor.getString(_cursorIndexOfPriority));
            final boolean _tmpIsSetReminder;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSetReminder);
            _tmpIsSetReminder = _tmp != 0;
            final Integer _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            }
            final Integer _tmpMonth;
            if (_cursor.isNull(_cursorIndexOfMonth)) {
              _tmpMonth = null;
            } else {
              _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            }
            final Integer _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            }
            final Integer _tmpHour;
            if (_cursor.isNull(_cursorIndexOfHour)) {
              _tmpHour = null;
            } else {
              _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            }
            final Integer _tmpMinute;
            if (_cursor.isNull(_cursorIndexOfMinute)) {
              _tmpMinute = null;
            } else {
              _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            }
            _item = new ToDoTask(_tmpId,_tmpTitle,_tmpDescription,_tmpPriority,_tmpIsSetReminder,_tmpYear,_tmpMonth,_tmpDay,_tmpHour,_tmpMinute);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __Priority_enumToString(final Priority _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case HIGH: return "HIGH";
      case MEDIUM: return "MEDIUM";
      case LOW: return "LOW";
      case NONE: return "NONE";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private Priority __Priority_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "HIGH": return Priority.HIGH;
      case "MEDIUM": return Priority.MEDIUM;
      case "LOW": return Priority.LOW;
      case "NONE": return Priority.NONE;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
