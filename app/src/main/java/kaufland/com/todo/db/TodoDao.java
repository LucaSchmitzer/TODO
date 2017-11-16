package kaufland.com.todo.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import kaufland.com.todo.object.todo.Todo;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    List<Todo> loadAllTodos();

    @Insert
    void insertTodo(Todo todo);

    @Update
    void updateTodo(Todo todo);

    @Delete
    void deleteTodo(Todo todo);
}
