package domain.impl;

import domain.Category;
import domain.Repeated;
import domain.Priority;
import domain.Task;

public class YearTask extends Task implements Repeated {

    private String type = "Одноразовая";
    private int date;
    private String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private int numberOfMonth;
    private int year;
    private String deadline;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {

        private YearTask newYearTask;

        public Builder() {
            newYearTask = new YearTask();
        }

        public Builder withEvent(String event) {
            newYearTask.setEvent(event);
            return this;
        }

        public Builder withMessage(String message) {
            newYearTask.setMessage(message);
            return this;
        }

        public Builder withPriority(Priority priority) {
            newYearTask.setPriority(priority);
            return this;
        }

        public Builder withCategory(Category category) {
            newYearTask.setCategory(category);
            return this;
        }

        public Builder withId(T id) {
            newYearTask.setId(id.toString());
            return this;
        }

        public Builder withNumberOfMonth(int numberOfMonth) {
            newYearTask.numberOfMonth = numberOfMonth - 1;
            return this;
        }

        public Builder withDate(int date) {
            newYearTask.date = date;
            return this;
        }

        public Builder withYear(int year) {
            newYearTask.year = year;
            return this;
        }

        public Builder withDeadLine(String deadLine) {
            newYearTask.deadline = deadLine;
            return this;
        }

        public YearTask build() {
            return newYearTask;
        }
    }

    public YearTask() {

    }

    public YearTask(String event, String message, int date, int numberOfMonth, int year, String deadline) {
        super(event, message);
        this.date = date;
        this.numberOfMonth = numberOfMonth - 1;
        this.year = year;
        this.deadline = deadline;
    }

    public YearTask(String event, String message, Category category,
                    Priority priority, int date, int numberOfMonth, int year, String deadline) {
        super(event, message, category, priority);
        this.date = date;
        this.numberOfMonth = numberOfMonth - 1;
        this.year = year;
        this.deadline = deadline;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public void setNumberOfMonth(int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getDate() {
        return date;
    }

    public String getNumberOfMonth() {
        return months[numberOfMonth];
    }

    public int getYear() {
        return year;
    }

    public String getDeadline() {
        return deadline;
    }

    public int compareTo(YearTask obj) {
        return getEvent().compareTo(obj.getEvent());
    }

    @Override
    public void showInfo() {
        System.out.println(date + "/" + months[numberOfMonth] + "/" + year + " - наступает следующее событие: " + getEvent());
    }

    @Override
    public void showMessage() {
        System.out.println("Не забудьте: " + getMessage() + ".\nКрайний срок исполнения - " + deadline);
        System.out.println("Если хотите оставить напоминание на следующий год, вызовите метод \"move()\".");
    }

    @Override
    public void repeat() {
        System.out.println("Теперь задача перенесена еще и на следующий год.");
        year++;
    }

    @Override
    public String toString() {

        return "\nПолное описание задачи:" +
                "\nТип задачи - " + type +
                "\nСобытие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДата - " + date +
                "\nМесяц - " + months[numberOfMonth] +
                "\nГод - " + year +
                "\nНе забудьте: " + getMessage() +
                "\nКрайний срок исполнения - " + deadline;
    }
}
