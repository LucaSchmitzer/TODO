package kaufland.com.todo.ui.todo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import kaufland.com.todo.R;
import kaufland.com.todo.data.TodoRepository;
import kaufland.com.todo.db.entity.Todo;

public class AllTodosActivity extends AppCompatActivity {

    private ListView todoView;

    private Button newTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todos);
        AllTodosViewModel model = ViewModelProviders.of(this).get(AllTodosViewModel.class);
        model.getTodoList().observe(this, todos -> {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, todos);
            todoView.setAdapter(arrayAdapter);
            //progressBar.setVisibility(View.GONE);
        });
        (todoView = findViewById(R.id.todoView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        (newTodo = findViewById(R.id.newTodo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddTodoActivity.class));
            }
        });
    }

    public List<String> getDbTodos() {
        List<String> todoStringList = new ArrayList<>();
        for (int i = 0; i < new TodoRepository(this.getApplication()).getAllTodos().size(); i++) {
            todoStringList.add(new TodoRepository(getApplication()).getAllTodos().get(i).getTodo());
        }
        return todoStringList;
    }

}
