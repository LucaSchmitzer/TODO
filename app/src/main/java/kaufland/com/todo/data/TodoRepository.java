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

    private List<String> strings;

    public TodoRepository(@NonNull Application application) {
        super(application);
        db = AppDatabase.getTodoDatabase(this.getApplication().getApplicationContext());
        todoList = db.todoDao().loadAllTodos();
        strings = db.todoDao().todosFromDB();
    }

    public List<String> todosFromDb(){
        return strings;
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
