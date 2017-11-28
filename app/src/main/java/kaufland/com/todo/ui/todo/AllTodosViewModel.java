package kaufland.com.todo.ui.todo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import kaufland.com.todo.data.TodoRepository;
import kaufland.com.todo.db.entity.Todo;
import kaufland.com.todo.ui.MainActivity;


public class AllTodosViewModel extends ViewModel{

    private MutableLiveData<List<Todo>> todoList;

    LiveData<List<Todo>> getTodoList() {
        if (todoList == null){
            todoList = new MutableLiveData<>();
            loadTodos();
        }
        return todoList;
    }

    private void loadTodos() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            List<Todo> todoArrayList = new ArrayList<>();
            todoArrayList = new TodoRepository(new MainActivity().getApplication()).getAllTodos();
            long seed = System.nanoTime();
            Collections.shuffle(todoArrayList, new Random(seed));
            todoList.setValue(todoArrayList);
        }, 5000);
    }
}
