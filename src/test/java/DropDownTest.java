import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownPage;

import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.quitDriver;

public class DropDownTest extends BaseTest {
    //private ChromeDriver driver;
    private DropDownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        //driver = new ChromeDriver();
        dropdownPage = new DropDownPage();
    }

    @Test
    public void dropdownSelect() {
        dropdownPage.selectOption("Option 2");
        assertEquals(dropdownPage.getSelectedOption(), "Option 2");
    }
    @Test
    public void alert() {
        dropdownPage.forceAlert();
        dropdownPage.closeAlert();

    }
}