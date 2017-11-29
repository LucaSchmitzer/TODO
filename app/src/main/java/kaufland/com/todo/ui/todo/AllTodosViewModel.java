package kaufland.com.todo.ui.todo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AllTodosViewModel extends ViewModel {

    private MutableLiveData<List<String>> todoList;

    LiveData<List<String>> getTodoList() {
        if (todoList == null) {
            todoList = new MutableLiveData<>();
            loadTodos();
        }
        return todoList;
    }

    private void loadTodos() {
        new Handler().postDelayed(() -> {
            List<String> todoArrayList = new ArrayList<>();
            todoArrayList= new AllTodosActivity().getDbTodos();
            long seed = System.nanoTime();
            if (todoArrayList != null) {
                Collections.shuffle(todoArrayList, new Random(seed));
                todoList.setValue(todoArrayList);
            }
        }, 5000);

    }
}
