package demo;

import domain.*;

public class StartTheGame {

    public static void main(String[] args) {

        BuildingTasksArray.startBuilding();
        try {
            Need.askDeleteTheSameTasks(Need.askWhatTasksNeeded());
        } catch (NullPointerException exc) {
            System.out.println();
        }
        Need.showAllNamesOfEvents();
        Need.checkTheLength();
    }
}

