import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {
    private GoogleSearchPage googleSearchPage;
    private ChromeDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void searchTest(){
        googleSearchPage.search("Armenia");
        assertTrue(googleSearchPage.getFirstResult().getText().contains("Wikipedia"));

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
