package kaufland.com.todo.ui.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import kaufland.com.todo.R;
import kaufland.com.todo.data.TodoRepository;
import kaufland.com.todo.db.entity.Todo;

public class AddTodoActivity extends AppCompatActivity {

    private Button addTodo;

    private TextView todoDescription;

    private TextView todoTitle;

    private Todo todo;

    private AddTodoActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        instance = this;
        todoTitle = findViewById(R.id.todoTitle);
        todoDescription = findViewById(R.id.description);
        addTodo = findViewById(R.id.BaddTodo);
        addTodo.setOnClickListener(view -> {
            todo = new Todo();
            todo.setTodo(todoTitle.toString());
            todo.setDescription(todoDescription.toString());
            startActivity(new Intent(getApplicationContext(), AllTodosActivity.class));
            saveToDB();
        });
    }

    private void saveToDB() {
        new Thread() {
            public void run() {
                new TodoRepository(instance.getApplication()).saveTodo(todo);
            }
        }.start();
    }
}
