package kaufland.com.todo.object.goal;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"goal", "date"}, tableName = "goal")
public class Goal {

    @ColumnInfo(name = "goal")
    @NonNull
    private String goal;

    @ColumnInfo(name = "date")
    @NonNull
    private String date;


    public Goal(String goal, String date) {
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
