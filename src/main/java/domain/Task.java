package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task implements Comparable<Task>, Cloneable {

    private String event;
    private String message;
    private Priority priority;
    private Category category;
    private String id;

    public static class Builder<T> {

        private Task newTask;

        public Builder() {
            newTask = new Task();
        }

        public Builder withEvent(String event) {
            newTask.event = event;
            return this;
        }

        public Builder withMessage(String message) {
            newTask.message = message;
            return this;
        }

        public Builder withPriority(Priority priority) {
            newTask.priority = priority;
            return this;
        }

        public Builder withCategory(Category category) {
            newTask.category = category;
            return this;
        }

        public Builder withId(T id) {
            newTask.id = id.toString();
            return this;
        }

        public Task build() {
            return newTask;
        }
    }

    public Task() {

    }

    public Task(String event, String message) {
        this.event = event;
        this.message = message;
    }

    public Task(String event, String message, Category category, Priority priority) {
        this(event, message);
        this.category = category;
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getMessage() {
        return message;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    protected void showInfo() {
        System.out.println(event);
    }

    protected void showMessage() {
        System.out.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return event.equals(task.event) &&
                message.equals(task.message) &&
                priority == task.priority &&
                category == task.category &&
                id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, message, priority, category, id);
    }

    @Override
    public int compareTo(Task o) {
        return event.compareTo(o.event);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return event;
    }
}
