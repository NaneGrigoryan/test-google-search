package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static setup.DriverSetup.getDriver;

public class HoverPage extends BasePage {
    public HoverPage( ) {
        super(getDriver());
        //visit("http://the-internet.herokuapp.com/hovers");
        visit(getUrl());
    }
    public String getUrl() {
        return BASE_URL + "/hovers";
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
    public WebElement getHeader() {
        hoverAvatar();
        return find(By.className("figcaption"));
        }
}