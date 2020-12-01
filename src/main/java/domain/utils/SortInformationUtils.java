package domain.utils;

import domain.Task;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortInformationUtils {

    public static List<Task> sortAllTasksByEventAndPrint() {

        Comparator<Task> taskComparator = (o1, o2) -> o1.getEvent().compareTo(o2.getEvent());

        List<Task> sortedTaskList = BuildingTasksArrayUtil.getListOfTasks().stream()
                .sorted(taskComparator)
                .collect(Collectors.toList());

        sortedTaskList.forEach(System.out::println);
        return sortedTaskList;
    }

    public static List<Task> filterListByTypeAndPrint(String type) {

        Comparator<Task> taskComparator = (o1, o2) -> o1.getEvent().compareTo(o2.getEvent());

        List<Task> filteredAndSortedTasksByType = BuildingTasksArrayUtil.getListOfTasks().stream()
                .filter(task -> task.getType().equalsIgnoreCase(type))
                .sorted(taskComparator)
                .collect(Collectors.toList());

        filteredAndSortedTasksByType.forEach(System.out::println);
        return filteredAndSortedTasksByType;
    }
}
