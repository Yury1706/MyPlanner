package domain;

public abstract class Tasks {

    private String event;
    private String message;
    private int priority;
    private String category;

    public Tasks(String event, String message) {
        this.event = event;
        this.message = message;
    }

    public Tasks(String event, String message, String category, int priority) {
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    protected abstract void showInfo();

    protected abstract void showMessage();

    @Override
    public String toString() {
        return "Напоминание: \nСобытие - " + event + ".\nЧто необходимо сделать: " + message + ".";
    }
}
