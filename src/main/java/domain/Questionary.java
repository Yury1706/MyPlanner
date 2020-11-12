package domain;

import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.Scanner;

public class Questionary {

    Scanner scanner = new Scanner(System.in);

    private String event;
    private String message;
    private static int numberOfTask;
    private int numberOfDay;
    private String priority;
    private String category;

    public void getUserInfoOfTask() {

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
                task.setObj(new DailyTask());
                System.out.print("Укажите событие: ");
                task.getObj().setEvent(scanner.nextLine());
//                System.out.print("Укажите порядковый номер дня события от 1 до 7: ");
//                task.getObj().setNumberOfDay((scanner.nextInt()) - 1);
//                scanner.nextLine();
//                System.out.print("Укажите время события: ");
//                task.getObj().setTime(scanner.nextLine());
//                System.out.print("Укажите приоритет события(В верхнем регистре) -" +
//                        " \"HIGH\", \"MIDDLE\" или \"LOW\": ");
//                task.getObj().setPriority(Priority.valueOf(scanner.nextLine()));
//                System.out.print("Укажите себе задачу на это событие: ");
//                task.getObj().setMessage(scanner.nextLine());
//                System.out.println("Укажите категорию из списка:\"SPORT\", \"AUTO\", \"WORK\", " +
//                        "\"HOLIDAY\", \"HEALTH\", \"HOME\", \"FINANCE\", \"SHOPPING\"");
//                task.getObj().setCategory(Category.valueOf(scanner.nextLine()));
//                System.out.println(task.getObj().toString());
//                System.out.print("\nХотите чтобы задача была перенесена еще и на следующий день?: \"Да/Нет\" ");
//                String askForMove = scanner.nextLine();
//                if (askForMove.equalsIgnoreCase("да")) {
//                    task.getObj().repeat();
//                }
                System.out.print("Хотите внести еще одну задачу?: \"Да/Нет\" ");
                String repeat = scanner.nextLine();
                if (repeat.equalsIgnoreCase("да")) {
                    buildNewTask = true;
                } else buildNewTask = false;
            } else {
                Tasks<YearTask> task = new Tasks<>();
                task.setObj(new YearTask());
                System.out.print("Укажите событие: ");
                task.getObj().setEvent(scanner.nextLine());
//                System.out.print("Укажите дату(день на календаре): ");
//                task.getObj().setDate(scanner.nextInt());
//                System.out.print("Укажите месяц цифрой: ");
//                task.getObj().setNumberOfMonth((scanner.nextInt() - 1));
//                System.out.print("Укажите год: ");
//                task.getObj().setYear(scanner.nextInt());
//                scanner.nextLine();
//                System.out.print("Укажите deadline: ");
//                task.getObj().setDeadline(scanner.nextLine());
//                System.out.print("Укажите приоритет события - \"HIGH\", \"MIDDLE\" или \"LOW\": ");
//                task.getObj().setPriority(Priority.valueOf(scanner.nextLine()));
//                System.out.println("Укажите категорию из списка:\"SPORT\", \"AUTO\", \"WORK\", " +
//                        "\"HOLIDAY\", \"HEALTH\", \"HOME\", \"FINANCE\", \"SHOPPING\"");
//                task.getObj().setCategory(Category.valueOf(scanner.nextLine()));
//                System.out.print("Укажите себе задачу на это событие: ");
//                task.getObj().setMessage(scanner.nextLine());
//                System.out.println(task.getObj().toString());
//                System.out.print("Хотите чтобы задача была перенесена еще и на следующий год?: \"Да/Нет\" ");
//                String askForMove = scanner.nextLine();
//                if (askForMove.equalsIgnoreCase("да")) {
//                    task.getObj().repeat();
//                }
                System.out.print("Хотите внести еще одну задачу?: \"Да/Нет\" ");
                String repeat = scanner.nextLine();
                if (repeat.equalsIgnoreCase("да")) {
                    buildNewTask = true;
                } else buildNewTask = false;
            }
        }
    }

    public void showInfoOfTasks() {
        System.out.println("\nПоказать список задач?" +
                "\n0. Нет не надо." +
                "\n1. Все задачи." +
                "\n2. Каждодневные задачи." +
                "\n3. Одноразовые задачи." +
                "\nУкажите номер.");
        int value = scanner.nextInt();
        scanner.nextLine();
        switch (value) {
            case 0:
                break;
            case 1:
                Tasks.printList();
                break;
            case 2:
                DailyTask.printList();
                break;
            case 3:
                YearTask.printList();
                break;
        }
    }

    public void sortTask() {
        System.out.println("\nХотите отсортировать список?" +
                "\n0. Нет не надо." +
                "\n1. По событию.");
        int value = scanner.nextInt();
        SortInformation.sortListOfTasks(value);
    }
}
