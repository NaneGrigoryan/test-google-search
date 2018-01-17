import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WindowsPage;

public class MultiWindowsTest {
    private ChromeDriver driver;
    private WindowsPage windowsPage;

    @BeforeMethod
    public void setUp() {
        /*System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();*/
        windowsPage = new WindowsPage();
    }
    /*@AfterMethod
    public void tearDown() {
        driver.close();
    }*/
    @Test
    public void windowChange() {
        windowsPage.clickLink();
        windowsPage.switchToWindow(0);
    }

}