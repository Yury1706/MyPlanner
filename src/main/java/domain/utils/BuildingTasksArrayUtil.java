package domain.utils;

import domain.GettingTaskFromUser;
import domain.numsAndExceptions.MyOutOfBoundsException;
import domain.Task;
import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildingTasksArrayUtil {

    private static List<Task> listOfTasks = new ArrayList<>();

    public static List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public static void startBuilding() {

        Scanner scanner = new Scanner(System.in);
        boolean buildOneMoreTask = true;

        while (buildOneMoreTask) {
            try {
                Task newTask = GettingTaskFromUser.getUserInfoOfTask();
                listOfTasks.add(newTask);

                if (newTask instanceof DailyTask) {
                    System.out.print("Хотите чтобы задача была перенесена еще и на следующий день?: \"Да/Нет\" ");
                    String askForMove = scanner.nextLine();
                    if (askForMove.equalsIgnoreCase("да")) {
                        try {
                            DailyTask repeatableDailyTask = (DailyTask) newTask.clone();
                            repeatableDailyTask.repeat();
                            listOfTasks.add(repeatableDailyTask);
                        } catch (CloneNotSupportedException exc) {
                            System.out.println("Что-то пошло не так... " +
                                    "Мы почему-то не можем склонировать задачу на следующий день. " +
                                    "Создайте заново эту задачу на следующий день.");
                        }
                    }
                } else if (newTask instanceof YearTask) {
                    System.out.print("Хотите чтобы задача была перенесена еще и на следующий год?: \"Да/Нет\" ");
                    String askForMove = scanner.nextLine();
                    if (askForMove.equalsIgnoreCase("да")) {
                        try {
                            YearTask repeatableYearTask = (YearTask) newTask.clone();
                            repeatableYearTask.repeat();
                            listOfTasks.add(repeatableYearTask);
                        } catch (CloneNotSupportedException exc) {
                            System.out.println("Что-то пошло не так... " +
                                    "Мы почему-то не можем склонировать задачу на следующий день. " +
                                    "Создайте заново эту задачу на следующий день.");
                        }
                    }
                }
            } catch (MyOutOfBoundsException exc) {
                System.out.println(exc.getMessage());
            } finally {
                System.out.print("Хотите внести еще одну задачу?: \"Да/Нет\" ");
                String repeat = scanner.nextLine();
                if (repeat.equalsIgnoreCase("да")) {
                    buildOneMoreTask = true;
                } else {
                    buildOneMoreTask = false;
                }
                System.out.println();
            }
        }
    }
}

