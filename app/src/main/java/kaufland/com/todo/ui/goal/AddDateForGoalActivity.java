package kaufland.com.todo.ui.goal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import kaufland.com.todo.R;
import kaufland.com.todo.data.GoalRepository;
import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todo.ui.MainActivity;

public class AddDateForGoalActivity extends AppCompatActivity {

    private Button save;
    private DatePicker datePicker;
    private static Context context;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_add_date_for_goal);
        datePicker = findViewById(R.id.dateGoal);
        (save = findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                date = new GoalRepository(getApplication()).getDateFromDatePicker(datePicker);
                saveToDB();
            }
        });
    }

    private void saveToDB() {
        new Thread() {
            public void run() {
                //TODO exception handling
                new GoalRepository(getApplication()).saveGoal(new Goal(new AddGoalActivity().getGoal().getGoal(), date));
            }
        }.start();
    }

    public static Context getContext() {
        return context;
    }
}
