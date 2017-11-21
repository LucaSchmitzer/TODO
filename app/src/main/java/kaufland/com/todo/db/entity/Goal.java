package kaufland.com.todo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"goal", "date"})
public class Goal {

    @ColumnInfo(name = "goal")
    private String goal;

    @ColumnInfo(name = "date")
    private String date;


    public Goal(@NonNull String goal, @NonNull String date) {
        this.goal = goal;
        this.date = date;
    }

    @Ignore
    public Goal() {
    }

    @NonNull
    public String getGoal() {
        return goal;
    }

    public void setGoal(@NonNull String goal) {
        this.goal = goal;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }
}
