package kaufland.com.todo.object.goal.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import kaufland.com.todo.MainActivity;
import kaufland.com.todo.R;

public class AddDateForGoalActivity extends AppCompatActivity {

    private Button save;
    private DatePicker datePicker;
    private static Context context;


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
                String date = new AddGoalActivity().getGoalRepository().getDateFromDatePicker(datePicker);
              //  new GoalRepository().saveGoal(new GoalRepository().createGoal(new AddGoalActivity().getG().getGoal(), date));
            }
        });
    }

    public static Context getContext() {
        return context;
    }
}
