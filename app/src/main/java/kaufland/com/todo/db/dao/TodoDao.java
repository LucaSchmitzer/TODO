package kaufland.com.todo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import kaufland.com.todo.db.entity.Todo;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    List<Todo> loadAllTodos();

    @Query("SELECT * FROM todo")
    LiveData<Todo> liveTodos();

    @Query("SELECT todo FROM todo")
    List<String> todosFromDB();

    @Insert
    void insertTodo(Todo todo);

    @Update
    void updateTodo(Todo todo);

    @Delete
    void deleteTodo(Todo todo);
}
