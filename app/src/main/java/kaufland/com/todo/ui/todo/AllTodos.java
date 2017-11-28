package kaufland.com.todo.ui.todo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import kaufland.com.todo.R;
import kaufland.com.todo.data.TodoRepository;
import kaufland.com.todo.db.entity.Todo;

public class AllTodos extends AppCompatActivity {

    private ListView todoView;

    private Button newTodo;

    private MutableLiveData<List<Todo>> todoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todos);
        todoView = findViewById(R.id.todoView);
        (newTodo = findViewById(R.id.newTodo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddTodoActivity.class));
            }
        });
    }

    LiveData<List<Todo>> getTodos() {
            if (todoList == null){
                todoList = new MutableLiveData<>();
                loadTodos();
            }
            return todoList;
    }

    private void loadTodos() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            List<Todo> todoArrayList = new ArrayList<>();
            todoArrayList = new TodoRepository(getApplication()).getAllTodos();
            long seed = System.nanoTime();
            Collections.shuffle(todoArrayList, new Random(seed));

            todoList.setValue(todoArrayList);
        }, 5000);
    }

}
