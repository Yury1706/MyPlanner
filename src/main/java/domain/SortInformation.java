package domain;

import java.util.Collections;
import java.util.Comparator;

public class SortInformation {

    public static void sortListOfTasks(int criterion) {

        switch (criterion) {
            case 0:
                break;
            case 1:
                Comparator<Tasks> comparator = new Comparator<Tasks>() {

                    @Override
                    public int compare(Tasks o1, Tasks o2) {
                        return o1.getEvent().compareTo(o2.getEvent());
                    }
                };
                Collections.sort(Tasks.getTasksArrayList(),comparator);
                break;
            case 2:
                Comparator<Tasks> comparator1 = new Comparator<Tasks>() {
                    @Override
                    public int compare(Tasks o1, Tasks o2) {
                        return o1.getCategory().compareTo(o2.getCategory());
                    }
                };
                Collections.sort(Tasks.getTasksArrayList(),comparator1);
                break;
            case 3:
                Comparator<Tasks> comparator2 = new Comparator<Tasks>() {
                    @Override
                    public int compare(Tasks o1, Tasks o2) {
                        return o1.getPriority().compareTo(o2.getPriority());
                    }
                };
                Collections.sort(Tasks.getTasksArrayList(),comparator2);
        }
    }
}
