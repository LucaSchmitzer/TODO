package kaufland.com.todo.db;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import kaufland.com.todo.db.dao.GoalDao;
import kaufland.com.todo.db.entity.Goal;

import static junit.framework.Assert.assertEquals;

public class GaolDatabaseTest {

    private AppDatabase db;
    private GoalDao goalDao;

    @Before
    public void createDB() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        goalDao = db.goalDao();
    }


    @Test
    public void testGoalDB() {
        List<Goal> goalList = new ArrayList<>();
        List<Goal> goalDBList;
        for (int i = 0; i < 100; i++) {
            Goal goalObject = new Goal();
            goalObject.setGoal("Goal" + String.valueOf(i));
            goalObject.setDate("Date" + String.valueOf(i));
            goalList.add(goalObject);
            goalDao.insertGoal(goalObject);
        }
        goalDBList = goalDao.loadAllGoals();
        for (int i = 0; i < 100; i++) {
            assertEquals(goalList.get(i).getGoal(), goalDBList.get(i).getGoal());
            assertEquals(goalList.get(i).getDate(), goalDBList.get(i).getDate());
        }
    }

    @After
    public void closeDB() {
        db.close();
    }
}
