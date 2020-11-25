package domain;

import java.util.Collections;
import java.util.Scanner;

public class SortInformation {

    public static void sortListOfTasks() {
        Collections.sort(BuildingTasksArray.getListOfTasks());
    }
}
