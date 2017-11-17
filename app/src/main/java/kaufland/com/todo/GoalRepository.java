package kaufland.com.todo;

import android.arch.persistence.room.Room;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todo.ui.goal.AddDateForGoalActivity;

/**
 * Created by lsch0909 on 16.11.17.
 */

public class GoalRepository {

    private Calendar calendar;

    private Goal goalObject;

    private AppDatabase db = Room.databaseBuilder(AddDateForGoalActivity.getContext(), AppDatabase.class, "goal").build();


    private List<Goal> goalList = new ArrayList<>();

    public String getDateFromDatePicker(DatePicker datePicker) {
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        goalObject.setDate(calendar.getTime().toString());
        return goalObject.getDate();
    }

    public Goal createGoal(String goal, String date) {
        return goalObject = new Goal(goal, date);
    }

    public void saveGoal(Goal goalParameter) {
        db.goalDao().insertGoal(goalParameter);
    }

    private List<Goal> getAllGoals() {
        new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                goalList = db.goalDao().loadAllGoals();
            }
        };
        return goalList;
    }
}
