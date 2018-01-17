import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JSAlertsPage;

public class JSAlertsTest {
    private ChromeDriver driver;
    private JSAlertsPage jsalertsPage;

    @BeforeMethod
    public void setUp() {
        /*System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();*/
        jsalertsPage = new JSAlertsPage();
    }

    /*@AfterMethod
    public void tearDown() {
        driver.close();
    }*/

    @Test
    public void clickAlert() {
        jsalertsPage.clickLink();
        jsalertsPage.closeAlert();
    }
    @Test
    public void okConfirmation() {
        jsalertsPage.clickLink1();
        jsalertsPage.okConfirmation();
    }
    @Test
    public void closeConfirmation() {
        jsalertsPage.clickLink1();
        jsalertsPage.closeConfirmation();
    }
    @Test
    public void okPrompt() {
        jsalertsPage.clickLink2();
        jsalertsPage.textPrompt();
        jsalertsPage.okPrompt();
    }
    @Test
    public void cancelPrompt() {
        jsalertsPage.clickLink2();
        jsalertsPage.cancelPrompt();
    }
}