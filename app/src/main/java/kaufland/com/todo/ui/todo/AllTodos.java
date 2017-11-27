package kaufland.com.todo.ui.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import kaufland.com.todo.R;

public class AllTodos extends AppCompatActivity {

    private ListView todoView;

    private Button newTodo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todos);
        todoView = findViewById(R.id.todoView);
        newTodo = findViewById(R.id.newTodo);
    }

}
