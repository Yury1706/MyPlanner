package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Tasks<T> implements Comparable<T>{

    private String event;
    private String message;
    private Priority priority;
    private Category category;
    private T obj;
    private static List<Tasks> tasksArrayList = new ArrayList<>();

    public static class Builder {

        private String event;
        private String message;
        private Priority priority;
        private Category category;
        public Builder(String event, String message, Priority priority, Category category) {
            this.event = event;
            this.message = message;
            this.priority = priority;
            this.category = category;
        }

        public Tasks build() {
            Tasks task = new Tasks();
            task.event = this.event;
            task.message = this.message;
            task.priority = this.priority;
            task.category = this.category;
            return task;
        }
    }

    public Tasks() {
        tasksArrayList.add(this);
    }

    public Tasks(String event, String message) {
        this.event = event;
        this.message = message;
        tasksArrayList.add(this);
    }

    public Tasks(String event, String message, Category category, Priority priority) {
        this(event, message);
        this.category = category;
        this.priority = priority;
        tasksArrayList.add(this);
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public static List<Tasks> getTasksArrayList() {
        return tasksArrayList;
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

    static void printList() {
        tasksArrayList.forEach(tasks -> System.out.println(tasks));
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
        Tasks<?> tasks = (Tasks<?>) o;
        return event.equals(tasks.event) &&
                message.equals(tasks.message) &&
                priority == tasks.priority &&
                category == tasks.category &&
                obj.equals(tasks.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, message, priority, category, obj);
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }

    @Override
    public String toString() {
        return "\n";
    }
}
