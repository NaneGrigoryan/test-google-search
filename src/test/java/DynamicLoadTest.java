import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DynamicLoadTest extends BaseTest{
   // private ChromeDriver driver;
    private DynamicLoadPage dynamicLoadPage;

    @BeforeMethod
    public void setUp() {
        /*System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();*/
        dynamicLoadPage = new DynamicLoadPage();
    }
    @Test
    public void dynamicLoad() {
        dynamicLoadPage.clickStart();
        assertTrue(dynamicLoadPage.isLoadingDisplayed());
        assertTrue(dynamicLoadPage.isLoadingNotDisplayed());
        assertTrue(dynamicLoadPage.isFinishDisplayed());
        assertEquals(dynamicLoadPage.getFinish().getText(),"Hello World!");

    }

}
