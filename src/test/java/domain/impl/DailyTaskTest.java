package domain.impl;

import org.testng.Assert;
import org.testng.annotations.*;

public class DailyTaskTest {

    @BeforeClass
    public void beforeClass() {
        DailyTask.Builder builder = DailyTask.builder();
        System.out.println("@BeforeClass run...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass run");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod - setUp");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Method is OK");
    }

    @Test
    public void testGetterSetter() {
        DailyTask ds = new DailyTask("Event", "Don't forget", "11:00");
        ds.setTime("10:00");
        Assert.assertEquals("10:00", ds.getTime());
    }

    @Test(dataProvider = "testBuildTasksByBuilder")
    public void testBuildingTask(String event, String message, String time, int day, String dayOfWeek) {
        DailyTask.Builder builder = DailyTask.builder();
        DailyTask dailyTask = builder.withEvent(event).withMessage(message).withTime(time).withNumberOfDay(day).build();
        System.out.println(dailyTask);
        Assert.assertEquals(dailyTask.getEvent(), event);
        Assert.assertEquals(dailyTask.getMessage(), message);
        Assert.assertEquals(dailyTask.getTime(), time);
        Assert.assertEquals(dailyTask.getDayOfWeek(), dayOfWeek);
    }

    @DataProvider(name = "testBuildTasksByBuilder")
    public Object[][] listOfValues() {
        return new Object[][]{
                {"Homework", "Send my homework to teacher", "10:00", 5, "FRIDAY"},
                {"Football", "Score a goal", "20:00", 7, "SUNDAY"},
                {"My birthday", "Send a invitations for my guests", "15:00", 2, "TUESDAY"}
        };
    }
}