package domain;

import java.util.Scanner;

public class ShowingTasks {

    public static void showInfoOfTasks() {
        BuildingTasksArray.getListOfTasks().forEach(task -> System.out.println(task));
    }
}

