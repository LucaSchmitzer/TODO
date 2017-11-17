package kaufland.com.todo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kaufland.com.todo.R;
import kaufland.com.todo.ui.goal.AddGoalActivity;
import kaufland.com.todo.ui.todo.AddTodoActivity;

public class MainActivity extends AppCompatActivity {

    private Button addTodo;

    private Button addGoals;

    private MainActivity myActivity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
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
            }
        });

    }
}
