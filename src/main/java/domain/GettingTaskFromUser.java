package domain;

import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.Scanner;

public class GettingTaskFromUser {

    private static int numberOfTask;

    public static Task getUserInfoOfTask() {
        Scanner scanner = new Scanner(System.in);
        boolean hasNoMistake = true;

        while (hasNoMistake) {
            System.out.print("Введите номер задачи: (1) - \"Каждодневная\" , (2) - \"Одноразовая\" : ");
            numberOfTask = scanner.nextInt();
            scanner.nextLine();
            if (numberOfTask == 0 || numberOfTask > 2) {
                System.out.println("Вы ввели не верное число.");
                hasNoMistake = true;
            } else {
                hasNoMistake = false;
            }
        }

        if (numberOfTask == 1) {
            DailyTask.Builder buildTask = DailyTask.builder();
            System.out.print("Укажите событие: ");
            buildTask.withEvent(scanner.nextLine());
            System.out.print("Укажите порядковый номер дня события от 1 до 7: ");
            buildTask.withNumberOfDay(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Укажите время события: ");
            buildTask.withTime(scanner.nextLine());
            System.out.print("Укажите приоритет события(В верхнем регистре) -" +
                    " \"HIGH\", \"MIDDLE\" или \"LOW\": ");
            buildTask.withPriority(Priority.valueOf(scanner.nextLine()));
            System.out.print("Укажите себе задачу на это событие: ");
            buildTask.withMessage(scanner.nextLine());
            System.out.println("Укажите категорию из списка:\"SPORT\", \"AUTO\", \"WORK\", " +
                    "\"HOLIDAY\", \"HEALTH\", \"HOME\", \"FINANCE\", \"SHOPPING\"");
            buildTask.withCategory(Category.valueOf(scanner.nextLine()));
            DailyTask dailyTask = buildTask.build();
            return dailyTask;
        } else {
            YearTask.Builder buildTask = YearTask.builder();
            System.out.print("Укажите событие: ");
            buildTask.withEvent(scanner.nextLine());
            System.out.print("Укажите дату(день на календаре): ");
            buildTask.withDate(scanner.nextInt());
            System.out.print("Укажите месяц цифрой: ");
            buildTask.withNumberOfMonth(scanner.nextInt());
            System.out.print("Укажите год: ");
            buildTask.withYear(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Укажите deadline: ");
            buildTask.withDeadLine(scanner.nextLine());
            System.out.print("Укажите приоритет события - \"HIGH\", \"MIDDLE\" или \"LOW\": ");
            buildTask.withPriority(Priority.valueOf(scanner.nextLine()));
            System.out.println("Укажите категорию из списка:\"SPORT\", \"AUTO\", \"WORK\", " +
                    "\"HOLIDAY\", \"HEALTH\", \"HOME\", \"FINANCE\", \"SHOPPING\"");
            buildTask.withCategory(Category.valueOf(scanner.nextLine()));
            System.out.print("Укажите себе задачу на это событие: ");
            buildTask.withMessage(scanner.nextLine());
            YearTask yearTask = buildTask.build();
            return yearTask;
        }
    }
}
