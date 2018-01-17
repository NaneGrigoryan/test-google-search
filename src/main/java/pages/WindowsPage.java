package pages;

import org.openqa.selenium.WebDriver;

import static setup.DriverSetup.getDriver;

public class WindowsPage extends BasePage {
    public WindowsPage() {
        super(getDriver());
        //visit("http://the-internet.herokuapp.com/windows");
        visit(getUrl());
    }
    public String getUrl() {
        return BASE_URL + "/window";
    }

    public void clickLink() {
        find(".example a").click();
    }

    public Object[] getAllWindows() {
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index) {
        driver.switchTo().window(getAllWindows()[index].toString());
    }

    /*public void hoverElement(WebElement element){
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
    }*/
}