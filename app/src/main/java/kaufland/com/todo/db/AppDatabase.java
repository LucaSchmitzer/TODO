package kaufland.com.todo.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import kaufland.com.todo.db.dao.GoalDao;
import kaufland.com.todo.db.dao.TodoDao;
import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todo.db.entity.Todo;

@Database(entities = {Todo.class, Goal.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    public abstract GoalDao goalDao();

    private static AppDatabase DB;

    public static AppDatabase getTodoDatabase(Context context) {
        if (DB == null) {
            DB =
                    Room.databaseBuilder(context, AppDatabase.class, "todo").fallbackToDestructiveMigration().allowMainThreadQueries()
                            .build();
        }
        return DB;
    }

    public static AppDatabase getGoalDatabase(Context context){
        if (DB == null){
            DB =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "goal").fallbackToDestructiveMigration().allowMainThreadQueries()
                    .build();
        }
        return DB;
    }

}
