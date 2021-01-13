package domain.impl;

import domain.numsAndExceptions.Category;
import domain.Repeatable;
import domain.numsAndExceptions.Priority;
import domain.Task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DailyTask extends Task implements Repeatable {

    private static LocalDate today = LocalDate.now();
    private LocalTime time;
    private LocalDate date;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

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

        public Builder withNumberOfDay(int numberOfDay) {
            switch (numberOfDay) {
                case 1:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
                    return this;
                case 2:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
                    return this;
                case 3:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
                    return this;
                case 4:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
                    return this;
                case 5:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
                    return this;
                case 6:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
                    return this;
                default:
                    newTask.date = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
                    return this;
            }
        }

        public Builder withTime(String time) {
            newTask.time = LocalTime.parse(time, formatter);
            return this;
        }

        public DailyTask build() {
            return newTask;
        }
    }

    public DailyTask() {
        setType("Каждодневная");
    }

    public DailyTask(String event, String message, String time) {
        super(event, message);
        setType("Каждодневная");
        this.time = LocalTime.parse(time);
    }

    public DailyTask(String event, String message, Category category,
                     Priority priority, String time) {
        super(event, message, category, priority);
        setType("Каждодневная");
        this.time = LocalTime.parse(time);
    }

    public String getDayOfWeek() {
        return String.valueOf(date.getDayOfWeek());
    }

    public String getTime() {
        return time.format(formatter);
    }

    public void setTime(String time) {
        this.time = LocalTime.parse(time);
    }


    public int compareTo(DailyTask obj) {
        return getEvent().compareTo(obj.getEvent());
    }

    public String showTimeFromNowUntilEvent() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, LocalDateTime.of(date, time));
        long period = duration.toHours();
        return String.valueOf(period);
    }

    @Override
    public void showInfo() {
        System.out.println(date.getDayOfWeek() + ", " + time.format(formatter) + " - у вас " + getEvent());
    }

    @Override
    public void showMessage() {
        System.out.println("Не забудьте: " + getMessage());
    }

    // переводит задачу на следующий день
    @Override
    public void repeat() {
        System.out.println("Теперь задача перенесена еще и на следующий день.");
        date = date.plusDays(1);
    }

    @Override
    public String toString() {

        return "\nПолное описание задачи:" +
                "\nТип задачи - " + getType() +
                "\nСобытие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДень - " + date.getDayOfWeek() +
                "\nВремя - " + time.format(formatter) +
                "\nНе забудьте: " + getMessage() +
                "\nОсталось часов: " + showTimeFromNowUntilEvent();
    }
}
