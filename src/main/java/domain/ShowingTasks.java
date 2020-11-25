package domain;

public class ShowingTasks {

    public static void showInfoOfTasks() {
        BuildingTasksArray.getListOfTasks().forEach(task -> System.out.println(task));
    }
}

