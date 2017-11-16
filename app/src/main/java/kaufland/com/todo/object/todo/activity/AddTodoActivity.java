package kaufland.com.todo.object.todo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import kaufland.com.todo.MainActivity;
import kaufland.com.todo.R;
import kaufland.com.todo.object.todo.Todo;

public class AddTodoActivity extends AppCompatActivity {

    private Button addTodo;

    private TextView todoDescription;

    private TextView todoTitle;

    private Context context;

    private String todo;

    private String description;

    private AddTodoActivity myActivity = AddTodoActivity.this;

    private boolean bool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();


        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                addTodo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        todo = todoTitle.getText().toString();
                        description = todoDescription.getText().toString();
                        bool = true;
                    }
                });
            }
        });

        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (bool) {
                    new Todo().saveTodo(new Todo().createTodo(todo, description));
                    List<Todo>todoList = new Todo().getAllTodos();
                    bool = false;
                }
            }
        });
    }

    private void init() {
        context = getApplicationContext();
        setContentView(R.layout.activity_add_todo);
        todoTitle = findViewById(R.id.todoTitle);
        todoDescription = findViewById(R.id.description);
        addTodo = findViewById(R.id.BaddTodo);
    }

    public Context getContext() {
        return context;
    }
}
