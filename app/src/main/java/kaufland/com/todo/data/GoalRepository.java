package kaufland.com.todo.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.db.entity.Goal;

public class GoalRepository extends AndroidViewModel {

    private Calendar calendar = Calendar.getInstance();

    private Goal goalObject = new Goal();

    private final AppDatabase db;

    private List<Goal> goals;

    public GoalRepository(@NonNull Application application) {
        super(application);
        db = AppDatabase.getGoalDatabase(this.getApplication().getApplicationContext());
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
