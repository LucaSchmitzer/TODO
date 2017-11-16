package kaufland.com.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kaufland.com.todo.object.goal.activity.AddGoalActivity;
import kaufland.com.todo.object.todo.activity.AddTodoActivity;

public class MainActivity extends AppCompatActivity {

    private Button addTodo;
    private Button addGoals;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
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
        }).start();

    }

    public static Context getContext() {
        return context;
    }
}
