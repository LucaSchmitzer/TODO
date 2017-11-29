package kaufland.com.todo.ui.goal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.DatePicker;

import kaufland.com.todo.R;
import kaufland.com.todo.data.GoalRepository;
import kaufland.com.todo.db.entity.Goal;

public class AddDateForGoalActivity extends AppCompatActivity {

    private Button save;
    private DatePicker datePicker;
    private static AddDateForGoalActivity instance;
    private Goal goalObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_add_date_for_goal);
        datePicker = findViewById(R.id.dateGoal);
        (save = findViewById(R.id.save)).setOnClickListener(v -> {
            goalObject = new Goal();
            startActivity(new Intent(getApplicationContext(), AllGoalsActivity.class));
            goalObject.setDate(new GoalRepository(instance.getApplication()).getDateFromDatePicker(datePicker));
            goalObject.setGoal(new AddGoalActivity().getGoal().getGoal());
            saveToDB();
        });
    }

    private void saveToDB() {
        new Thread() {
            public void run() {
                new GoalRepository(instance.getApplication()).saveGoal(goalObject);
            }
        }.start();
    }
}
