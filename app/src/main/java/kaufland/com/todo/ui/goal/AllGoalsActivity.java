package kaufland.com.todo.ui.goal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import kaufland.com.todo.R;

public class AllGoalsActivity extends AppCompatActivity {

    private ListView goalView;

    private Button newGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_goals);
        (goalView = findViewById(R.id.gaolView)).setOnItemClickListener((adapterView, view, i, l) -> {

        });
        (newGoal = findViewById(R.id.newGoal)).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AddGoalActivity.class)));

    }

}
