package kaufland.com.todo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kaufland.com.todo.ui.goal.AllGoals;
import kaufland.com.todo.R;
import kaufland.com.todo.ui.todo.AllTodosActivity;

public class MainActivity extends AppCompatActivity {

    private Button addTodo;

    private Button addGoals;

    //TODO ADD TODOD und ADD GOAL IN GOAL UND TODO transformieren und dafür bei den neuen layouts ein plus oder
    // TODO so für hinzufügen machen und dort nach einem click auf das alte Layout verweisen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (addTodo = findViewById(R.id.BaddTodo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AllTodosActivity.class));
            }
        });
        (addGoals = findViewById(R.id.bAddGoals)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AllGoals.class));
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
