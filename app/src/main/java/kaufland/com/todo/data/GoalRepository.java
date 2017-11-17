package kaufland.com.todo.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.widget.DatePicker;

import java.util.Calendar;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todo.ui.goal.AddDateForGoalActivity;

/**
 * Created by lsch0909 on 16.11.17.
 */

public class GoalRepository extends AndroidViewModel{

    private Calendar calendar;

    private Goal goalObject;

    private AppDatabase db;

    private LiveData<Goal> goals;

    public GoalRepository(@NonNull Application application){
        super(application);
        db = Room.databaseBuilder(AddDateForGoalActivity.getContext(), AppDatabase.class, "goal").build();
        goals = db.goalDao().loadAllGoals();
    }

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

    public LiveData<Goal> getAllGoals() {
        return goals = db.goalDao().loadAllGoals();
    }
}
