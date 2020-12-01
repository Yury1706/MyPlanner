package demo;

import domain.utils.AdditionalInfoUtils;
import domain.utils.BuildingTasksArrayUtil;

public class StartTheGame {

    public static void main(String[] args) {

        BuildingTasksArrayUtil.startBuilding();
        try {
            AdditionalInfoUtils.askDeleteTheSameTasks(AdditionalInfoUtils.askWhatTasksNeeded());
        } catch (NullPointerException exc) {
            System.out.println();
        }
        AdditionalInfoUtils.showAllNamesOfEvents();
        AdditionalInfoUtils.checkTheLength();
    }
}

