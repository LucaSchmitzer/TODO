package kaufland.com.todo.object.todo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.object.todo.activity.AddTodoActivity;

@Entity(primaryKeys = {"todo", "description"}, tableName = "todo")
public class Todo {

    @ColumnInfo(name = "todo")
    @NonNull
    private String todo;

    @ColumnInfo(name = "description")
    @NonNull
    private String description;

    @Ignore
    private Todo todoObject;

    @Ignore
    private AppDatabase db = Room.databaseBuilder(AddTodoActivity.getContext(), AppDatabase.class, "todo").build();

    @Ignore
    private List<Todo> todos = new ArrayList<>();

    public Todo createTodo(String todo, String description) {
        return todoObject = new Todo(todo, description);
    }

    public void saveTodo(final Todo todoParam) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.todoDao().insertTodo(todoParam);
                getAllTodos();
            }
        });
    }

    private List<Todo> getAllTodos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                todos = db.todoDao().loadAllTodos();
            }
        });
        return todos;
    }


    public Todo(@NonNull String todo, @NonNull String description) {
        this.todo = todo;
        this.description = description;
    }

    public Todo() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo getTodoObject() {
        return todoObject;
    }

    public void setTodoObject(Todo todoObject) {
        this.todoObject = todoObject;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }


}
