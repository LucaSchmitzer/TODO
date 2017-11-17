package kaufland.com.todo.object.todo.activity;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kaufland.com.todo.MainActivity;
import kaufland.com.todo.R;
import kaufland.com.todo.object.todo.Todo;
import kaufland.com.todo.object.todo.TodoRepository;

public class AddTodoActivity extends AppCompatActivity {

    private Button addTodo;

    private TextView todoDescription;

    private TextView todoTitle;

    private Todo todo;

    private AddTodoActivity myActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        todoTitle = findViewById(R.id.todoTitle);
        todoDescription = findViewById(R.id.description);
        addTodo = findViewById(R.id.BaddTodo);
        myActivity = AddTodoActivity.this;
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


    private void saveToDB() {
        new AsyncTask(){
            LiveData<Todo> todos;
            @Override
            protected LiveData<Todo> doInBackground(Object... objects) {
                myActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new TodoRepository(getApplication()).saveTodo(todo);
                        todos = new TodoRepository(getApplication()).getAllTodos();
                    }
                });
                return todos;
            }
        }.execute();
    }
}
