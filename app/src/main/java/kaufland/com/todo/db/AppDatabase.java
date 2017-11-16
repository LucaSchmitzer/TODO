package kaufland.com.todo.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import kaufland.com.todo.object.goal.Goal;
import kaufland.com.todo.object.todo.Todo;

@Database(entities = {Todo.class, Goal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    public abstract GoalDao goalDao();



}
