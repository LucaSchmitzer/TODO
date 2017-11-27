package kaufland.com.todo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kaufland.com.todo.R;
import kaufland.com.todo.db.entity.Todo;
import kaufland.com.todo.ui.goal.AddGoalActivity;
import kaufland.com.todo.ui.todo.AddTodoActivity;

public class MainActivity extends AppCompatActivity {

    private Button addTodo;

    private Button addGoals;

    private final MainActivity myActivity = MainActivity.this;

    private ListView listView;

    private List<Todo> todoList = new ArrayList<>();

    private String[] listItems;

    //TODO ADD TODOD und ADD GOAL IN GOAL UND TODO transformieren und dafür bei den neuen layouts ein plus oder
    // TODO so für hinzufügen machen und dort nach einem click auf das alte Layout verweisen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (addTodo = findViewById(R.id.BaddTodo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddTodoActivity.class));
            }
        });
        (addGoals = findViewById(R.id.bAddGoals)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddGoalActivity.class));
            }
        });
        /*(listView = findViewById(R.id.todoListView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO Create a ListView for Main Activity or create a new Activity for the Listview
            }
        });*/
    }
}
