package domain;

import domain.GettingTaskFromUser;
import domain.Task;
import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildingTasksArray {

    private static List<Task> listOfTasks = new ArrayList<>();

    public static List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public static void startBuilding() {

        Scanner scanner = new Scanner(System.in);
        boolean buildOneMoreTask = true;

        while (buildOneMoreTask) {
            Task newTask = GettingTaskFromUser.getUserInfoOfTask();
            listOfTasks.add(newTask);

            if (newTask instanceof DailyTask) {
                System.out.print("\nХотите чтобы задача была перенесена еще и на следующий день?: \"Да/Нет\" ");
                String askForMove = scanner.nextLine();
                if (askForMove.equalsIgnoreCase("да")) {
                    try {
                        DailyTask repeatDailyTask = (DailyTask) newTask.clone();
                        repeatDailyTask.repeat();
                        listOfTasks.add(repeatDailyTask);
                    } catch (CloneNotSupportedException exc) {
                        exc.printStackTrace();
                    }
                }
            } else if (newTask instanceof YearTask) {
                System.out.print("\nХотите чтобы задача была перенесена еще и на следующий год?: \"Да/Нет\" ");
                String askForMove = scanner.nextLine();
                if (askForMove.equalsIgnoreCase("да")) {
                    try {
                        YearTask repeatYearTask = (YearTask) newTask.clone();
                        repeatYearTask.repeat();
                        listOfTasks.add(repeatYearTask);
                    } catch (CloneNotSupportedException exc) {
                        exc.printStackTrace();
                    }
                }
            }
            System.out.print("Хотите внести еще одну задачу?: \"Да/Нет\" ");
            String repeat = scanner.nextLine();
            if (repeat.equalsIgnoreCase("да")) {
                buildOneMoreTask = true;
            } else buildOneMoreTask = false;
        }
    }
}

