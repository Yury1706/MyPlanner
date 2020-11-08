package domain;

import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.Scanner;

public class BuildingTask {

    Scanner scanner = new Scanner(System.in);

    private String event;
    private String message;
    private static int numberOfTask;
    private int numberOfDay;
    private String priority;
    private String category;

    public void buildTask() {

        boolean buildNewTask = true;

        while (buildNewTask) {

            boolean isCorrect = true;

            while (isCorrect) {
                System.out.print("Введите номер задачи: (1) - \"Каждодневная\" , (2) - \"Одноразовая\" : ");
                numberOfTask = scanner.nextInt();
                scanner.nextLine();
                if (numberOfTask == 0 || numberOfTask > 2) {
                    System.out.println("Вы ввели не верное число.");
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }
            }

            if (numberOfTask == 1) {
                Tasks<DailyTask> task = new Tasks<DailyTask>();
                task.obj = new DailyTask();
                System.out.print("Укажите событие: ");
                task.obj.setEvent(scanner.nextLine());
                System.out.print("Укажите порядковый номер дня события от 1 до 7: ");
                task.obj.setNumberOfDay((scanner.nextInt()) - 1);
                scanner.nextLine();
                System.out.print("Укажите время события: ");
                task.obj.setTime(scanner.nextLine());
                System.out.print("Укажите приоритет события(В верхнем регистре) -" +
                        " \"HIGH\", \"MIDDLE\" или \"LOW\": ");
                task.obj.setPriority(Priority.valueOf(scanner.nextLine()));
                System.out.print("Укажите себе задачу на это событие: ");
                task.obj.setMessage(scanner.nextLine());
                System.out.println("Укажите категорию из списка:\"SPORT\", \"AUTO\", \"WORK\", " +
                        "\"HOLIDAY\", \"HEALTH\", \"HOME\", \"FINANCE\", \"SHOPPING\"");
                task.obj.setCategory(Category.valueOf(scanner.nextLine()));
                System.out.println(task.obj.toString());
                System.out.print("Хотите чтобы задача была перенесена еще и на следующий день?: \"Да/Нет\" ");
                String askForMove = scanner.nextLine();
                if (askForMove.equalsIgnoreCase("да")) {
                    task.obj.move();
                }
                System.out.print("Хотите внести еще одну задачу?: \"Да/Нет\" ");
                String repeat = scanner.nextLine();
                if (repeat.equalsIgnoreCase("да")) {
                    buildNewTask = true;
                } else buildNewTask = false;
            } else {
                Tasks<YearTask> task = new Tasks<>();
                task.obj = new YearTask();
                System.out.print("Укажите событие: ");
                task.obj.setEvent(scanner.nextLine());
                System.out.print("Укажите дату: ");
                task.obj.setDate(scanner.nextInt());
                System.out.print("Укажите месяц цифрой: ");
                task.obj.setNumberOfMonth((scanner.nextInt() - 1));
                System.out.print("Укажите год: ");
                task.obj.setYear(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Укажите deadline: ");
                task.obj.setDeadline(scanner.nextLine());
                System.out.print("Укажите приоритет события - \"HIGH\", \"MIDDLE\" или \"LOW\": ");
                task.obj.setPriority(Priority.valueOf(scanner.nextLine()));
                System.out.println("Укажите категорию из списка:\"SPORT\", \"AUTO\", \"WORK\", " +
                        "\"HOLIDAY\", \"HEALTH\", \"HOME\", \"FINANCE\", \"SHOPPING\"");
                task.obj.setCategory(Category.valueOf(scanner.nextLine()));
                System.out.print("Укажите себе задачу на это событие: ");
                task.obj.setMessage(scanner.nextLine());
                System.out.println(task.obj.toString());
                System.out.print("Хотите чтобы задача была перенесена еще и на следующий год?: \"Да/Нет\" ");
                String askForMove = scanner.nextLine();
                if (askForMove.equalsIgnoreCase("да")) {
                    task.obj.move();
                }
                System.out.print("Хотите внести еще одну задачу?: \"Да/Нет\" ");
                String repeat = scanner.nextLine();
                if (repeat.equalsIgnoreCase("да")) {
                    buildNewTask = true;
                } else buildNewTask = false;
            }
        }
    }
}
