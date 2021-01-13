package domain.utils;

import static org.testng.Assert.*;

import domain.numsAndExceptions.UserIsWrongException;
import org.testng.annotations.*;

public class ValidationUtilsTest {

    @BeforeClass
    public void beforeClass() {
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
        System.out.println("@AfterMethod - tearDown");
    }

    @Test(expectedExceptions = UserIsWrongException.class)
    public void testCheckUserValue() throws UserIsWrongException {
        System.out.println("@Test - testCheckUserValue with exception");
        ValidationUtils.checkUserValue(1);
    }

}