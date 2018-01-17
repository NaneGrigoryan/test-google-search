package pages;

import org.openqa.selenium.WebDriver;

import static setup.DriverSetup.getDriver;

public class JSAlertsPage extends BasePage {
    public JSAlertsPage() {
        super(getDriver());
       // visit("http://the-internet.herokuapp.com/javascript_alerts");
        visit(getUrl());
    }
    public String getUrl() {
        return BASE_URL + "/javascript_alerts";
    }

    public void clickLink() {
        find(".example li:nth-child(1) button ").click();
    }
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    public void clickLink1() {
        find(".example li:nth-child(2) button ").click();
    }
    public void okConfirmation() {
        driver.switchTo().alert().accept();
    }
    public void closeConfirmation() {
        driver.switchTo().alert().dismiss();
    }

    public void clickLink2() {
        find(".example li:nth-child(3) button ").click();
    }
    public void okPrompt() {
        driver.switchTo().alert().accept();
    }
    public void textPrompt() {
        driver.switchTo().alert().sendKeys("11111");
    }
    public void cancelPrompt() {
        driver.switchTo().alert().dismiss();
    }
}
