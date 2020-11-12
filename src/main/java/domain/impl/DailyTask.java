package domain.impl;

import domain.Category;
import domain.Repeated;
import domain.Priority;
import domain.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DailyTask extends Tasks implements Repeated {

    private String type = "Каждодневная";
    private String[] dayOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
    private int numberOfDay;
    private String time;
    private static List<DailyTask> arrayOfDailyTasks = new ArrayList<>();

    public DailyTask() {
        arrayOfDailyTasks.add(this);
    }

    public DailyTask(String event, String message, int numberOfDay, String time) {
        super(event, message);
        this.numberOfDay = numberOfDay - 1;
        this.time = time;
        arrayOfDailyTasks.add(this);
    }

    public DailyTask(String event, String message, Category category, Priority priority, int numberOfDay, String time) {
        super(event, message, category, priority);
        this.numberOfDay = numberOfDay - 1; // т.к. в массиве индекс на 1 меньше
        this.time = time;
        arrayOfDailyTasks.add(this);
    }

    public String getDayOfWeek() {
        return dayOfWeek[numberOfDay];
    }

    public String getTime() {
        return time;
    }

    public void setDayOfWeek(String[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static List<DailyTask> getArrayOfDailyTasks() {
        return arrayOfDailyTasks;
    }

    public static void printList() {
        arrayOfDailyTasks.forEach(dailyTask -> System.out.println(dailyTask));
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
                "\nТип задачи - " + type +
                "\nСобытие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДень - " + getDayOfWeek() +
                "\nВремя - " + time +
                "\nНе забудьте: " + getMessage();
    }
}
