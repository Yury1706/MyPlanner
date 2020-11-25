package demo;

import domain.BuildingTasksArray;
import domain.ShowingTasks;
import domain.SortInformation;

import java.util.Scanner;

public class StartTheGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BuildingTasksArray.startBuilding();
        System.out.println("Хотите просмотреть список задач или отсортировать список задач по событиям и показать?" +
                "\n1. Показать список задач." +
                "\n2. Отсортировать задачи и показать." +
                "\nУкажите номер.");
        switch (scanner.nextInt()) {
            case 1:
                ShowingTasks.showInfoOfTasks();
                break;
            case 2:
                SortInformation.sortListOfTasks();
                ShowingTasks.showInfoOfTasks();
        }
    }
}
