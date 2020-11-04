package domain.impl;

import domain.Category;
import domain.Moved;
import domain.Priority;
import domain.Tasks;

public class YearTask extends Tasks implements Moved {

    private int date;
    private String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private int numberOfMonth;
    private int year;
    private String deadline;

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
    public void move() {
        System.out.println("Метод \"move()\" был вызван. Теперь задача перенесена на следующий год.");
        year++;
    }

    @Override
    public String toString() {
        if (getPriority() == null || getCategory() == null) {
            return "Полное описание события:\n" +
                    "Событие - " + getEvent() +
                    "\nДата - " + date +
                    "\nМесяц - " + months[numberOfMonth] +
                    "\nГод - " + year +
                    "\nНе забудьте: " + getMessage() +
                    "\nКрайний срок исполнения - " + deadline;
        }
        return "Полное описание события:\n" +
                "Событие - " + getEvent() +
                "\nКатегория - " + getCategory() +
                "\nПриоритет - " + getPriority() +
                "\nДата - " + date +
                "\nМесяц - " + months[numberOfMonth] +
                "\nГод - " + year +
                "\nНе забудьте: " + getMessage() +
                "\nКрайний срок исполнения - " + deadline;
    }
}
