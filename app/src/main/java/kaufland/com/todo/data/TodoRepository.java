package kaufland.com.todo.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Todo;

public class TodoRepository extends AndroidViewModel {

    private Todo todoObject;

    private AppDatabase db;

    private LiveData<Todo> todoList;

    public TodoRepository(@NonNull Application application) {
        super(application);
        db = AppDatabase.getDatabase(this.getApplication());
        todoList = db.todoDao().loadAllTodos();
    }

    public void saveTodo(Todo todoParam) {
        db.todoDao().insertTodo(todoParam);
    }

    public LiveData<Todo> getAllTodos() {
        return db.todoDao().loadAllTodos();
    }

    public void closeDB(){
        db.close();
    }

}
