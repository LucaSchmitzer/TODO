package kaufland.com.todo.ui.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import kaufland.com.todo.data.TodoRepository;
import kaufland.com.todo.db.entity.Todo;
import kaufland.com.todo.ui.MainActivity;
import kaufland.com.todo.R;

public class AddTodoActivity extends AppCompatActivity {

    private Button addTodo;

    private TextView todoDescription;

    private TextView todoTitle;

    private Todo todo;

    private List<Todo> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        todoTitle = findViewById(R.id.todoTitle);
        todoDescription = findViewById(R.id.description);
        addTodo = findViewById(R.id.BaddTodo);
        addTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo = new Todo();
                todo.setTodo(todoTitle.toString());
                todo.setDescription(todoDescription.toString());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                saveToDB();
            }
        });
    }

    private List<Todo> saveToDB() {
        new Thread() {
            public void run() {
                new TodoRepository(getApplication()).saveTodo(todo);
                todos = new TodoRepository(getApplication()).getAllTodos();
            }
        }.start();
        return todos;
    }
}
