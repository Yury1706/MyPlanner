package domain.impl;

import domain.Moved;
import domain.Tasks;

public class DailyTask extends Tasks implements Moved {

    private String[] dayOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
    int numberOfDay;
    private String time;

    public DailyTask(String event, String message, int numberOfDay, String time) {
        super(event, message);
        this.numberOfDay = numberOfDay - 1;
        this.time = time;
    }

    public DailyTask(String event, String message, String category, int priority, int numberOfDay, String time) {
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
        System.out.println("Метод \"move()\" был вызван. Теперь задача перенесена на следующий день.");
        numberOfDay++;
        if (numberOfDay == dayOfWeek.length) {
            numberOfDay = 0;
        }
    }

    @Override
    public String toString() {
        if (getPriority() == 0 || getCategory() == null) {
            return "Полное описание события:\n" +
                    "Событие - " + getEvent() +
                    "\nДень - " + dayOfWeek[numberOfDay] +
                    "\nВремя - " + time +
                    "\nНе забудьте: " + getMessage();
        }
        return "Полное описание события:\n" +
                "Событие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДень - " + dayOfWeek[numberOfDay] +
                "\nВремя - " + time +
                "\nНе забудьте: " + getMessage();
    }
}
