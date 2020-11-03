package demo;


import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.time.YearMonth;

public class TaskDemo {

    public static void main(String[] args) {

        DailyTask dailyTask1 = new DailyTask("Совещание", "подготовить доклад",
                7, "16:00");
        System.out.println(dailyTask1);
        dailyTask1.move();
        System.out.println();
        System.out.println(dailyTask1);
        System.out.println();

        DailyTask dailyTask2 = new DailyTask("Футбольный матч", "собрать форму",
                "Спорт", 9, 6, "18:00");
        System.out.println(dailyTask2);
        System.out.println();

        YearTask yearTask1 = new YearTask("День рождения", "поздравить друга Сашу",
                16, 2, 2021, "16 февраля 2021");
        System.out.println(yearTask1);
        System.out.println();

        YearTask yearTask2 = new YearTask("Прохождение ТО на авто", "подготовить авто к указанной дате", "Автомобиль",
                7, 20, 12, 2020, "19 декабря 2020");
        yearTask2.showInfo();
        yearTask2.showMessage();
        System.out.println();
        yearTask2.move();
        yearTask2.showInfo();

    }

}
