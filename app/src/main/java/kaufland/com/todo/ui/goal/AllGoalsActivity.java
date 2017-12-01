package kaufland.com.todo.ui.goal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kaufland.com.todo.R;
import kaufland.com.todo.data.GoalRepository;
import kaufland.com.todo.db.entity.Goal;

public class AllGoalsActivity extends AppCompatActivity {

    private ListView goalView;

    private Button newGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_goals);
        goalView = findViewById(R.id.gaolView);
        final List<Goal> goalList = new GoalRepository(getApplication()).getAllGoals();
        String[] listItems = new String[goalList.size()];
        if (goalList != null){
            for (int i = 0; i < goalList.size(); i++) {
                listItems[i] = goalList.get(i).getGoal();
            }
        }
        List<String> stringList = new ArrayList<>(Arrays.asList(listItems));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, stringList);
        goalView.setAdapter(adapter);
        goalView.setOnItemClickListener((adapterView, view, i, l) -> {

        });
        (newGoal = findViewById(R.id.newGoal)).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), AddGoalActivity.class)));

    }

}
