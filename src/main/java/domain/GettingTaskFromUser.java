package domain;

import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.Scanner;

public class GettingTaskFromUser {

    private static int numberOfTask;


    public static Task getUserInfoOfTask() throws MyOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        boolean hasNoMistake = true;

        while (hasNoMistake) {
            System.out.print("Введите номер задачи: " +
                    "(1) - \"Каждодневная\" , (2) - \"Одноразовая\" : ");
            numberOfTask = scanner.nextInt();
            scanner.nextLine();
            try {
                ExceptionMethods.checkUserValue(numberOfTask);
                hasNoMistake = false;
            } catch (UserIsWrongException exception) {
                System.out.println(exception.getMessage());
                hasNoMistake = true;
            }
        }

        if (numberOfTask == 1) {
            DailyTask.Builder buildTask = DailyTask.builder();
            System.out.print("Укажите событие: ");
            buildTask.withEvent(scanner.nextLine());
            System.out.print("Укажите порядковый номер дня события от 1 до 7: ");
            int numberOfDay = scanner.nextInt();
            scanner.nextLine();
            if (numberOfDay < 1 || numberOfDay > 7) {
                throw new MyOutOfBoundsException("Дня с таким номер не существует");
            }
            buildTask.withNumberOfDay(numberOfDay);
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
            System.out.print("Укажите год: ");
            buildTask.withYear(scanner.nextInt());
            System.out.print("Укажите месяц цифрой: ");
            int month = scanner.nextInt();
            if (month < 1 || month > 12) {
                throw new MyOutOfBoundsException("Месяца с таким значением нет.");
            }
            buildTask.withNumberOfMonth(month);
            int date;
            while (true) {
                System.out.print("Укажите дату(день на календаре): ");
                date = scanner.nextInt();
                scanner.nextLine();
                try {
                    ExceptionMethods.checkDate(month, date);
                    buildTask.withDate(date);
                    break;
                } catch (DateException exc) {
                    System.out.println(exc.getMessage());
                }
            }
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
