package domain.impl;

import domain.numsAndExceptions.Category;
import domain.Repeatable;
import domain.numsAndExceptions.Priority;
import domain.Task;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearTask extends Task implements Repeatable {

    private LocalDate fullDate;
    private LocalDate deadline;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {

        private YearTask newYearTask;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

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

        public Builder withDate(String date) {
            newYearTask.fullDate = LocalDate.parse(date, formatter);
            return this;
        }

        public Builder withDeadLine(String deadLine) {
            newYearTask.deadline = LocalDate.parse(deadLine, formatter);
            return this;
        }

        public YearTask build() {
            return newYearTask;
        }
    }

    public YearTask() {
        setType("Одноразовая");
    }

    public YearTask(String event, String message, String date, String deadline) {
        super(event, message);
        setType("Одноразовая");
        this.fullDate = LocalDate.parse(date, formatter);
        this.deadline = LocalDate.parse(deadline, formatter);
    }

    public YearTask(String event, String message, Category category,
                    Priority priority, String date, String deadline) {
        super(event, message, category, priority);
        setType("Одноразовая");
        this.fullDate = LocalDate.parse(date, formatter);
        this.deadline = LocalDate.parse(deadline, formatter);
    }

    public void setDeadline(String deadline) {
        this.deadline = LocalDate.parse(deadline, formatter);
    }

    public String getDeadline() {
        return deadline.format(formatter);
    }

    public int compareTo(YearTask obj) {
        return getEvent().compareTo(obj.getEvent());
    }

    public long showDaysFromTodayUntilDeadline() {
        LocalDate today = LocalDate.now();
        Duration duration = Duration.between(today.atStartOfDay(), deadline.atStartOfDay());
        return duration.toDays();
    }

    @Override
    public void showInfo() {
        System.out.println(fullDate.format(formatter) + " - наступает следующее событие: " + getEvent());
    }

    @Override
    public void showMessage() {
        System.out.println("Не забудьте: " + getMessage() + ".\nКрайний срок исполнения - " + deadline.format(formatter));
    }

    @Override
    public void repeat() {
        System.out.println("Теперь задача перенесена еще и на следующий год.");
        fullDate = fullDate.plusYears(1);
        deadline = deadline.plusYears(1);
    }

    @Override
    public String toString() {

        return "\nПолное описание задачи:" +
                "\nТип задачи - " + getType() +
                "\nСобытие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДата - " + fullDate.format(formatter) +
                "\nНе забудьте: " + getMessage() +
                "\nКрайний срок исполнения - " + deadline.format(formatter) +
                "\nКоличество дней до DeadLine - " + showDaysFromTodayUntilDeadline();
    }
}
