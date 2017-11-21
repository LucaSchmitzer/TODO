package kaufland.com.todo.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Todo;

public class TodoRepository extends AndroidViewModel {

    private Todo todoObject;

    private final AppDatabase db;

    private List<Todo> todoList;

    public TodoRepository(@NonNull Application application) {
        super(application);
        db = AppDatabase.getGoalDatabase(this.getApplication());
        todoList = db.todoDao().loadAllTodos();
    }

    public void saveTodo(Todo todoParam) {
        db.todoDao().insertTodo(todoParam);
    }

    public List<Todo> getAllTodos() {
        return db.todoDao().loadAllTodos();
    }

    public void closeDB(){
        db.close();
    }

}
