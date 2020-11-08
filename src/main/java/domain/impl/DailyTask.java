package domain.impl;

import domain.Category;
import domain.Moved;
import domain.Priority;
import domain.Tasks;

public class DailyTask extends Tasks implements Moved {

    private String[] dayOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
    private int numberOfDay;
    private String time;

    public DailyTask() {
    }

    public DailyTask(String event, String message, int numberOfDay, String time) {
        super(event, message);
        this.numberOfDay = numberOfDay - 1;
        this.time = time;
    }

    public DailyTask(String event, String message, Category category, Priority priority, int numberOfDay, String time) {
        super(event, message, category, priority);
        this.numberOfDay = numberOfDay - 1; // т.к. в массиве индекс на 1 меньше
        this.time = time;
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
    public void move() {
        System.out.println("Теперь задача перенесена еще и на следующий день.");
        numberOfDay++;
        if (numberOfDay == dayOfWeek.length) {
            numberOfDay = 0;
        }
    }

    @Override
    public String toString() {

        return "Полное описание события:\n" +
                "Событие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДень - " + getDayOfWeek() +
                "\nВремя - " + time +
                "\nНе забудьте: " + getMessage();
    }
}
