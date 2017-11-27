package kaufland.com.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class AllTodos extends AppCompatActivity {

    private ListView todoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todos);
        todoView = findViewById(R.id.todoView);
    }

}
