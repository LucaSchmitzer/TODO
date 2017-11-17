package kaufland.com.todo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "todo")
public class Todo {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "todo")
    @NonNull
    private String todo;

    @ColumnInfo(name = "description")
    @NonNull
    private String description;


    public Todo(@NonNull int id, @NonNull String todo, @NonNull String description) {
        this.todo = todo;
        this.description = description;
    }
    @Ignore
    public Todo(@NonNull String todo, @NonNull String description) {
        this.todo = todo;
        this.description = description;
    }

    @Ignore
    public Todo() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public int getId() {
        return id;
    }
}
