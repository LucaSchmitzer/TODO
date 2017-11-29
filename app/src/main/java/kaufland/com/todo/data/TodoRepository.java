package kaufland.com.todo.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Todo;

public class TodoRepository extends AndroidViewModel {

    private final AppDatabase db;

    private volatile List<Todo> todoList = new ArrayList<>();

    private List<String> strings = new ArrayList<>();

    public TodoRepository(@NonNull Application application) {
        super(application);
        db = AppDatabase.getTodoDatabase(this.getApplication().getApplicationContext());
    }

    public List<String> todosFromDb() {
          todoList = getAllTodos();
        for (int i = 0; i < todoList.size(); i++) {
            strings.add(todoList.get(i).getTodo());
        }
        return strings;
    }

    public void saveTodo(Todo todoParam) {
        db.todoDao().insertTodo(todoParam);
    }

    public List<Todo> getAllTodos() {
        todoList = db.todoDao().loadAllTodos();
        return todoList;

    }

    public List<Todo> getTodoList() {
        return todoList;
    }
}
