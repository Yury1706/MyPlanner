package domain;

import java.util.Collections;

public class SortInformation {

    public static void sortListOfTasks() {
        Collections.sort(BuildingTasksArray.getListOfTasks());
    }
}
