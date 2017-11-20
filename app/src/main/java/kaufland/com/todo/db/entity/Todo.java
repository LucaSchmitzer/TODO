package kaufland.com.todo.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"todoValue", "description"})
public class Todo {

    @ColumnInfo(name = "todoValue")
    @NonNull
    private String todoValue;

    @ColumnInfo(name = "description")
    @NonNull
    private String description;


    public Todo(@NonNull String todoValue, @NonNull String description) {
        this.todoValue = todoValue;
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

    public String getTodoValue() {
        return todoValue;
    }

    public void setTodoValue(String todoValue) {
        this.todoValue = todoValue;
    }

}
