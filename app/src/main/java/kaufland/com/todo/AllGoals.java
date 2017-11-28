package kaufland.com.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import kaufland.com.todo.ui.goal.AddGoalActivity;

public class AllGoals extends AppCompatActivity {

    private ListView goalView;

    private Button newGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_goals);
        goalView = findViewById(R.id.gaolView);
        (newGoal = findViewById(R.id.newGoal)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddGoalActivity.class));
            }
        });

    }

}