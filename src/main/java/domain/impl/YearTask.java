package domain.impl;

import domain.Category;
import domain.Repeated;
import domain.Priority;
import domain.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class YearTask extends Tasks implements Repeated {

    private String type = "Одноразовая";
    private int date;
    private String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private int numberOfMonth;
    private int year;
    private String deadline;
    private static List<YearTask> arrayOfYearTasks = new ArrayList<>();

    public YearTask() {
        arrayOfYearTasks.add(this);
    }

    public YearTask(String event, String message, int date, int numberOfMonth, int year, String deadline) {
        super(event, message);
        this.date = date;
        this.numberOfMonth = numberOfMonth - 1;
        this.year = year;
        this.deadline = deadline;
        arrayOfYearTasks.add(this);
    }

    public YearTask(String event, String message, Category category,
                    Priority priority, int date, int numberOfMonth, int year, String deadline) {
        super(event, message, category, priority);
        this.date = date;
        this.numberOfMonth = numberOfMonth - 1;
        this.year = year;
        this.deadline = deadline;
        arrayOfYearTasks.add(this);
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

    public static void printList() {
        arrayOfYearTasks.forEach(yearTask -> System.out.println(yearTask));
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
