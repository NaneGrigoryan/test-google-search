import org.testng.annotations.AfterMethod;

import static setup.DriverSetup.quitDriver;

public class BaseTest {
    @AfterMethod
    public void tearDownBase() {
        quitDriver();
    }
}
