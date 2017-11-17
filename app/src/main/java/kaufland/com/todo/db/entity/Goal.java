package kaufland.com.todo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "goal")
public class Goal {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "goal")
    @NonNull
    private String goal;

    @ColumnInfo(name = "date")
    @NonNull
    private String date;


    public Goal(int id, String goal, String date) {
        this.id = id;
        this.goal = goal;
        this.date = date;
    }
    @Ignore
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

    public int getId() {
        return id;
    }
}
