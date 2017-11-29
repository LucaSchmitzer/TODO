package kaufland.com.todo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "todo")
    @NonNull
    private String todo;

    @ColumnInfo(name = "description")
    @NonNull
    private String description;

    public Todo(@NonNull String todo, @NonNull String description, int id) {
        this.todo = todo;
        this.description = description;
        this.id = id;
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
