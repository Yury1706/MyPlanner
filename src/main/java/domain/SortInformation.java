package domain;

import java.util.Collections;

public class SortInformation {

    public static void sortListOfTasksByEvent() {
        Collections.sort(BuildingTasksArray.getListOfTasks());
    }
}
