package kaufland.com.todo.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todo.ui.goal.AddDateForGoalActivity;

public class GoalRepository extends AndroidViewModel{

    private Calendar calendar;

    private Goal goalObject;

    private final AppDatabase db;

    private List<Goal> goals;

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

    public void saveGoal(Goal goalParameter) {
        db.goalDao().insertGoal(goalParameter);
    }

    public List<Goal> getAllGoals() {
        return goals = db.goalDao().loadAllGoals();
    }
}
