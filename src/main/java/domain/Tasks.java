package domain;

public class Tasks<T> {

    private String event;
    private String message;
    private Priority priority;
    private Category category;
    public T obj;

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
    }

    public Tasks(String event, String message) {
        this.event = event;
        this.message = message;
    }

    public Tasks(String event, String message, Category category, Priority priority) {
        this(event, message);
        this.category = category;
        this.priority = priority;
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
    public String toString() {
        return "Напоминание: \nСобытие - " + event +
                ".\nЧто необходимо сделать: " + message + "." +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority();
    }
}
