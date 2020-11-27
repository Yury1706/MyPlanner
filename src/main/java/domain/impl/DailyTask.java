package domain.impl;

import domain.Category;
import domain.Repeated;
import domain.Priority;
import domain.Task;

public class DailyTask extends Task implements Repeated {

    private String[] dayOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
    private int numberOfDay;
    private String time;
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {


        private DailyTask newTask;
        public Builder() {
            newTask = new DailyTask();
        }

        public Builder withEvent(String event) {
            newTask.setEvent(event);
            return this;
        }

        public Builder withMessage(String message) {
            newTask.setMessage(message);
            return this;
        }

        public Builder withPriority(Priority priority) {
            newTask.setPriority(priority);
            return this;
        }

        public Builder withCategory(Category category) {
            newTask.setCategory(category);
            return this;
        }

        public Builder withId(T id) {
            newTask.setId(id.toString());
            return this;
        }

        public Builder withNumberOfDay (int numberOfDay) {
            newTask.numberOfDay = numberOfDay - 1;
            return this;
        }

        public Builder withTime(String time) {
            newTask.time = time;
            return this;
        }

        public DailyTask build() {
            return newTask;
        }

    }
    public DailyTask() {
        setType("Каждодневная");
    }

    public DailyTask(String event, String message, int numberOfDay, String time) {
        super(event, message);
        setType("Каждодневная");
        this.numberOfDay = numberOfDay - 1;
        this.time = time;
    }

    public DailyTask(String event, String message, Category category,
                     Priority priority, int numberOfDay, String time) {
        super(event, message, category, priority);
        setType("Каждодневная");
        this.numberOfDay = numberOfDay - 1; // т.к. в массиве индекс на 1 меньше
        this.time = time;
    }

    public String getDayOfWeek() {
        return dayOfWeek[numberOfDay];
    }

    public String getTime() {
        return time;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay - 1;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int compareTo(DailyTask obj) {
        return getEvent().compareTo(obj.getEvent());
    }

    @Override
    public void showInfo() {
        System.out.println(dayOfWeek[numberOfDay] + ", " + time + " - у вас " + getEvent());
    }

    @Override
    public void showMessage() {
        System.out.println("Не забудьте: " + getMessage());
    }

    // переводит задачу на следующий день
    @Override
    public void repeat() {
        System.out.println("Теперь задача перенесена еще и на следующий день.");
        numberOfDay++;
        if (numberOfDay == dayOfWeek.length) {
            numberOfDay = 0;
        }
    }

    @Override
    public String toString() {

        return "\nПолное описание задачи:" +
                "\nТип задачи - " + getType() +
                "\nСобытие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДень - " + getDayOfWeek() +
                "\nВремя - " + time +
                "\nНе забудьте: " + getMessage();
    }
}
