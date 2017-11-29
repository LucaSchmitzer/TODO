package kaufland.com.todo.ui.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kaufland.com.todo.R;
import kaufland.com.todo.data.TodoRepository;
import kaufland.com.todo.db.entity.Todo;


public class AllTodosActivity extends AppCompatActivity {

    private ListView todoView;

    private Button newTodo;

    private List<String> todoStringList = new ArrayList<>();

    private static AllTodosActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todos);
        todoView = findViewById(R.id.todoView);
        instance = this;
        final List<Todo> todoList = new TodoRepository(getApplication()).getAllTodos();
        String[] listItems = new String[todoList.size()];
        for (int i = 0; i < todoList.size();) {
            Todo todo = todoList.get(i);
            listItems[i] = todo.getTodo();
            i++;
        }
        List<String> stringList = new ArrayList<String>(Arrays.asList(listItems));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, stringList);
        todoView.setAdapter(adapter);
        //AllTodosViewModel model = ViewModelProviders.of(this).get(AllTodosViewModel.class);
        /*model.getTodoList().observe(this, todos -> {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, todos);
            todoView.setAdapter(arrayAdapter);
            //progressBar.setVisibility(View.GONE);
        });*/
        todoView.setOnItemClickListener((adapterView, view, i, l) -> {

        });
        (newTodo = findViewById(R.id.newTodo)).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AddTodoActivity.class)));
    }

    public List<String> getDbTodos() {
        new Thread() {
            public void run() {
                todoStringList = new TodoRepository(instance.getApplication()).todosFromDb();
            }
        }.start();
        return getTodoStringList();
    }

    public List<String> getTodoStringList() {
        return todoStringList;
    }
}
