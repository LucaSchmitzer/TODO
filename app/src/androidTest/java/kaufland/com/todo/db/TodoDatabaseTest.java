package kaufland.com.todo.db;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kaufland.com.todo.db.dao.TodoDao;
import kaufland.com.todo.db.entity.Todo;

import static junit.framework.Assert.assertEquals;


public class TodoDatabaseTest {

    private AppDatabase appDatabase;
    private TodoDao todoDao;


    @Before
    public void createDB() {
        Context context = InstrumentationRegistry.getTargetContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        todoDao = appDatabase.todoDao();
    }

    @Test
    public void useAppContext() throws Exception {
        List<Todo> todoList = new ArrayList<>();
        List<Todo> todoDBList;
        for (int i = 0; i < 100; i++) {
            Todo todoObject = new Todo();
            todoObject.setTodo("Todo" + String.valueOf(i));
            todoObject.setDescription("Description" + String.valueOf(i));
            todoList.add(todoObject);
            todoDao.insertTodo(todoObject);
        }
        todoDBList = todoDao.loadAllTodos();
        for (int i = 0; i < 100; i++) {
            assertEquals(todoList.get(i).getTodo(), todoDBList.get(i).getTodo());
            assertEquals(todoList.get(i).getDescription(), todoDBList.get(i).getDescription());
        }
    }

    @After
    public void closeDB() throws IOException {
        appDatabase.close();
    }
}
