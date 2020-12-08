package domain.utils;

import domain.Task;
import domain.impl.DailyTask;
import domain.impl.YearTask;
import domain.numsAndExceptions.*;
import domain.utils.ValidationUtils;

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
                ValidationUtils.checkUserValue(numberOfTask);
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
            System.out.print("Укажите время события в формате \"чч:мм\" : ");
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
            System.out.print("Укажите дату в формате \"дд/мм/гг\" : ");
            buildTask.withDate(scanner.nextLine());
            System.out.print("Укажите deadline в формате \"дд/мм/гг\" : ");
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
