import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HoverTest {
    private ChromeDriver driver;
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();
        hoverPage = new HoverPage(driver);

    }
/*
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
*/
    @Test
    public void dropdownSelect() {
        assertTrue(hoverPage.isHeaderNotDisplayed(), "Header was visible!");
        hoverPage.hoverAvatar();
        assertTrue(hoverPage.isHeaderDisplayed(), "Header was not visible!");

        assertTrue(hoverPage.getHeader().getText().contains("name: user1"), "Header text was not correct!");
}

}