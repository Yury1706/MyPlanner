package demo;

import domain.Questionary;

public class BuildingTask {

    public void startBuilding() {
        Questionary questionary = new Questionary();
        questionary.getUserInfoOfTask();
        questionary.sortTask();
        questionary.showInfoOfTasks();
    }
}
