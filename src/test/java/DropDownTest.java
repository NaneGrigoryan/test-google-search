import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTest {
    private ChromeDriver driver;
    private DropDownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();
        dropdownPage = new DropDownPage(driver);

    }

   /* @AfterMethod
    public void tearDown() {
        driver.close();
    }*/

    @Test
    public void dropdownSelect() {
        dropdownPage.selectOption("Option 2");
        assertEquals(dropdownPage.getSelectedOption(), "Option 2");
    }

}