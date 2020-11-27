package domain;

import java.util.List;
import java.util.Scanner;

public class Need {

    public static List<Task> askWhatTasksNeeded() throws NullPointerException {

        Scanner scanner = new Scanner(System.in);
        boolean hasNoMistake = true;
        int userValue = 0;

        while (hasNoMistake) {
            System.out.print("\nХотите просмотреть список задач" +
                    " или отсортировать список задач по событию и показать?" +
                    "\n0. Нет, не хочу." +
                    "\n1. Показать список задач." +
                    "\n2. Отсортировать все задачи по событию и показать." +
                    "\n3. Отсортировать каждодневные задачи по событию и показать." +
                    "\n4. Отсортировать одноразовые задачи по событию и показать." +
                    "\nУкажите номер: ");
            userValue = scanner.nextInt();
            scanner.nextLine();

            if (userValue < 0 || userValue > 4) {
                System.out.println("Неверное значение!");
                System.out.println();
                hasNoMistake = true;
            } else hasNoMistake = false;
        }
        switch (userValue) {
            case 1:
                BuildingTasksArray.getListOfTasks().forEach(System.out::println);
                return BuildingTasksArray.getListOfTasks();
            case 2:
                return SortInformation.sortAllTasksByEventAndPrint();
            case 3:
                return SortInformation.filterListByTypeAndPrint("Каждодневная");
            case 4:
                return SortInformation.filterListByTypeAndPrint("Одноразовая");
            case 0:
            default:
                throw new NullPointerException();
        }
    }

    public static void askDeleteTheSameTasks(List<Task> upgradingTaskList) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nХотите упорядочить список задач(убрать задачи с одинаковыми событиями)?" +
                "\n1. Нет, не хочу." +
                "\n2. Да, убрать повторяющиеся задачи.");
        int userValue = scanner.nextInt();

        if (userValue < 1 || userValue > 2) {
            System.out.println("Неверное значение! " +
                    "Наверное вы не хотели убирать задачи с одинаковыми событиями.");
            System.out.println();
            userValue = 1;
        }
        if (userValue == 2) {
            upgradingTaskList.stream().distinct().forEach(System.out::println);
        }
    }

    public static void showAllNamesOfEvents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nХотите просмотреть список всех событий задач?" +
                "\n1. Да." +
                "\n2. Нет");
        int userAnswer = scanner.nextInt();

        if (userAnswer == (1)) {
            BuildingTasksArray.getListOfTasks().stream().map(task -> task.getEvent()).forEach(s -> System.out.print(s + " "));
        }
    }

    public static void checkTheLength(){
        boolean eventsValueAreMoreThanOneChar = BuildingTasksArray.getListOfTasks().stream()
                .allMatch(task -> task.getEvent()
                        .length() > 1);
        System.out.println("\nВсе названия событий в списке задач больше 1: " + eventsValueAreMoreThanOneChar);
    }
}

