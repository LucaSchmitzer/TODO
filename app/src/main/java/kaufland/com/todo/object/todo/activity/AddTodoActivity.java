package kaufland.com.todo.object.todo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kaufland.com.todo.MainActivity;
import kaufland.com.todo.R;
import kaufland.com.todo.object.todo.Todo;

public class AddTodoActivity extends AppCompatActivity {

    private Button addTodo;

    private TextView todoDescription;

    private TextView todoTitle;

    private static Context context;

    private String todo;

    private String description;

    private AddTodoActivity myActivity = AddTodoActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_add_todo);
        todoDescription = findViewById(R.id.description);
        todoTitle = findViewById(R.id.todoTitle);
        addTodo = findViewById(R.id.BaddTodo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                addTodo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        todo = todoTitle.getText().toString();
                        description = todoDescription.getText().toString();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        new Todo().saveTodo(new Todo().createTodo(todo, description));
                    }
                });
            }
        }).start();
    }

    public static Context getContext() {
        return context;
    }
}
