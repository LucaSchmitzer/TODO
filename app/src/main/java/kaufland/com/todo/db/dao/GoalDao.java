package kaufland.com.todo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import kaufland.com.todo.db.entity.Goal;

@Dao
public interface GoalDao {

    @Query("SELECT * FROM goal")
    LiveData<Goal> loadAllGoals();

    @Insert
    void insertGoal(Goal goal);

    @Update
    void updateGoal(Goal goal);

    @Delete
    void deleteGoal(Goal goal);

}
