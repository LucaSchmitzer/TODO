package kaufland.com.todo.object.goal;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Room;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kaufland.com.todo.db.AppDatabase;
import kaufland.com.todo.object.goal.activity.AddDateForGoalActivity;

@Entity(primaryKeys = {"goal", "date"}, tableName = "goal")
public class Goal {

    @ColumnInfo(name = "goal")
    @NonNull
    private String goal;

    @ColumnInfo(name = "date")
    @NonNull
    private String date;

    @Ignore
    private Calendar calendar;

    @Ignore
    private Goal goalObject;

    @Ignore
    private AppDatabase db = Room.databaseBuilder(AddDateForGoalActivity.getContext(), AppDatabase.class, "goal").build();

    @Ignore
    private List<Goal> goalList = new ArrayList<>();

    public Goal(String goal, String date) {
        this.goal = goal;
        this.date = date;
    }

    public Goal() {
    }

    public String getDateFromDatePicker(DatePicker datePicker) {
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        date = calendar.getTime().toString();
        return date;
    }

    public Goal createGoal(String goal, String date) {
        return goalObject = new Goal(goal, date);
    }

    public void saveGoal(final Goal goalParameter) {
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


    @NonNull
    public String getGoal() {
        return goal;
    }

    public void setGoal(@NonNull String goal) {
        this.goal = goal;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }
}
