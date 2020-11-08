package domain;

import domain.impl.DailyTask;
import domain.impl.YearTask;

public class FactoryOfTask {

    public Tasks obj;

    public FactoryOfTask(int number) {
        if (number == 1) {
            obj = new Tasks<DailyTask>();
        }
        if (number == 2) {
            obj = new Tasks<YearTask>();
        }
    }

    public void madeTask(int numberOfTask) {
        if (numberOfTask == 1) {
            obj = new Tasks<DailyTask>();
        }
        if (numberOfTask == 2) {
            obj = new Tasks<YearTask>();
        }
    }

    @Override
    public String toString() {
        return "FactoryOfTask{" +
                "obj=" + obj +
                '}' + "Priority= " + obj.getPriority();
    }
}
