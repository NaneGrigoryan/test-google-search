import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage extends pageobjects.BasePage {
    public HoverPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/hovers");
    }

    public void hoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverAvatar() {
        hoverElement(find(By.className("figure")));

    }

    public boolean isHeaderDisplayed() {
        return isDisplayed(By.className("figcaption"));
    }

    public boolean isHeaderNotDisplayed() {
        return isNotDisplayed(find(By.className("figcaption")), 5);
    }
}