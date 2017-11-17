package kaufland.com.todo.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import kaufland.com.todo.db.entity.Goal;
import kaufland.com.todo.db.entity.Todo;
import kaufland.com.todo.db.dao.GoalDao;
import kaufland.com.todo.db.dao.TodoDao;

@Database(entities = {Todo.class, Goal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    public abstract GoalDao goalDao();

    private static AppDatabase DB;

    public static AppDatabase getDatabase(Context context) {
        if (DB == null) {
            DB =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "todo")
                            .build();
        }
        return DB;
    }


}
