package kaufland.com.todo.ui.goal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import kaufland.com.todo.R;
import kaufland.com.todo.db.entity.Goal;

public class AddGoalActivity extends AppCompatActivity {

    private Button nextStep;

    private TextView goalInput;

    private Goal goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        goalInput = findViewById(R.id.goalInput);
        (nextStep = findViewById(R.id.nextStep)).setOnClickListener(v -> {
            (goal = new Goal()).setGoal(goalInput.toString());
            startActivity(new Intent(getApplicationContext(), AddDateForGoalActivity.class));
        });
    }

    public Goal getGoal() {
        return goal;
    }
}
