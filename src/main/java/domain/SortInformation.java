package domain;

import java.util.Collections;
import java.util.Comparator;

public class SortInformation {

    public static void sortListOfTasks(int criterion) {

        switch (criterion) {
            case 0:
                break;
            case 1:
                    Collections.sort(Tasks.getTasksArrayList());
                break;
        }
    }
}
