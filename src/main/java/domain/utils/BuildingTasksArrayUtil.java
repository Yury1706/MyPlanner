package domain.utils;

import domain.numsAndExceptions.MyOutOfBoundsException;
import domain.Task;
import domain.impl.DailyTask;
import domain.impl.YearTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildingTasksArrayUtil {

    private static final String FILENAME = "src/main/resources/SavingTasks/TasksInfo.txt";
    private static List<Task> listOfTasks = new ArrayList<>();

    public static List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public static void startBuilding() {

        Scanner scanner = new Scanner(System.in);
        boolean buildOneMoreTask = true;

            System.out.println("Идет проверка на наличие уже существующих задач...");
            Object loadedObject = SerializationUtils.loadInfo(FILENAME);
            if (loadedObject instanceof ArrayList) {
                listOfTasks = (ArrayList<Task>) loadedObject;
                System.out.println("Информация загружена.");
            }

        while (buildOneMoreTask) {
            try {
                Task newTask = GettingTaskFromUser.getUserInfoOfTask();
                listOfTasks.add(newTask);

                if (newTask instanceof DailyTask) {
                    System.out.print("Хотите чтобы задача была перенесена еще и на следующий день?: \"YES/NO\" ");
                    String askForMove = scanner.nextLine();
                    if (askForMove.equalsIgnoreCase("YES")) {
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
                    System.out.print("Хотите чтобы задача была перенесена еще и на следующий год?: \"YES/NO\" ");
                    String askForMove = scanner.nextLine();
                    if (askForMove.equalsIgnoreCase("YES")) {
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
                System.out.print("Хотите внести еще одну задачу?: \"YES/NO\" ");
                String repeat = scanner.nextLine();
                System.out.println();
                if (repeat.equalsIgnoreCase("YES")) {
                    buildOneMoreTask = true;
                } else if (repeat.equalsIgnoreCase("NO")) {
                    buildOneMoreTask = false;
                    SerializationUtils.saveInfo(listOfTasks, FILENAME);
                }
                System.out.println();
            }
        }
    }
}

