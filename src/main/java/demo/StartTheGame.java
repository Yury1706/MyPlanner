package demo;

import domain.*;

import java.util.Scanner;

public class StartTheGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean hasNoMistake = true;

        BuildingTasksArray.startBuilding();

        while (hasNoMistake) {
            System.out.println("Хотите просмотреть список задач" +
                    " или отсортировать список задач по событиям и показать?" +
                    "\n1. Показать список задач." +
                    "\n2. Отсортировать задачи и показать." +
                    "\nУкажите номер.");
            int userValue = scanner.nextInt();
            try {
                ExceptionMethods.checkUserValue(userValue);
                hasNoMistake = false;
            } catch (UserIsWrongException exc) {
                System.out.println(exc.getMessage());
                hasNoMistake = true;
            }
            switch (userValue) {
                case 1:
                    ShowingTasks.showInfoOfTasks();
                    break;
                case 2:
                    SortInformation.sortListOfTasksByEvent();
                    ShowingTasks.showInfoOfTasks();
            }
        }
    }
}
