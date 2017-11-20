package kaufland.com.todo.ui.goal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kaufland.com.todo.data.GoalRepository;
import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todoValue.R;

public class AddGoalActivity extends AppCompatActivity {

    private Button nextStep;

    private TextView goalInput;

    private Goal goal;

    private GoalRepository goalRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        goalInput = findViewById(R.id.goalInput);
        (nextStep = findViewById(R.id.nextStep)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (goal = new Goal()).setGoal(goalInput.toString());
                startActivity(new Intent(getApplicationContext(), AddDateForGoalActivity.class));
            }
        });
    }

    public GoalRepository getGoalRepository() {
        return goalRepository;
    }

    public Goal getGoal() {
        return goal;
    }
}
