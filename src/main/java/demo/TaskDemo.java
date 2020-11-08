package demo;


import domain.Category;
import domain.GenTasks;
import domain.Priority;
import domain.Tasks;
import domain.impl.DailyTask;
import domain.impl.YearTask;

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
                Category.SPORT, Priority.HIGH, 6, "18:00");
        System.out.println(dailyTask2);
        System.out.println();

        YearTask yearTask1 = new YearTask("День рождения", "поздравить друга Сашу",
                16, 2, 2021, "16 февраля 2021");
        System.out.println(yearTask1);
        System.out.println();

        YearTask yearTask2 = new YearTask("Прохождение ТО на авто", "подготовить авто к указанной дате",
                Category.AUTO, Priority.valueOf("MIDDLE"), 20, 12, 2020, "19 декабря 2020");
        yearTask2.showInfo();
        yearTask2.showMessage();
        System.out.println();
        yearTask2.move();
        yearTask2.showInfo();
        System.out.println();

        Tasks.Builder builder = new Tasks.Builder("ДР", "поздравить", Priority.LOW, Category.HOLIDAY);
        Tasks task = builder.build();
        System.out.println(task);
        System.out.println();
//
//        Tasks<String> genTask2 = new Tasks<>("50");
//        System.out.println(genTask2.getIntId());

        GenTasks<YearTask> genTasks1 = new GenTasks<>(yearTask1);
        YearTask yearTask3 = genTasks1.getObj();
        System.out.println(yearTask3);

//        Tasks genTask1 = new Tasks(20);
//        int x = genTask1.getIntId();
//        System.out.println(x);
//        System.out.println();
    }
}
