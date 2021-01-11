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
}