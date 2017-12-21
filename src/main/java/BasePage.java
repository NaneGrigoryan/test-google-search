package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver webdriver){
        this.driver = webdriver;
    }
    public void visit(String url){
        driver.get(url);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
        //return find(By.cssSelector(cssSelector));
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public WebElement find(String cssSelector){
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator){
        click(find(locator));
        //find (locator).click();
    }
    public void click(WebElement element){
        element.click();
    }
    public void click(String cssSelector) {
        click(driver.findElement(By.cssSelector(cssSelector)));
        //click(find(cssSelector));
    }
    public void type(By locator, String text){
        type(find(locator), text); // aveli lav tarberak qan nerqevin@
        //find(locator).sendKeys(text);
    }
    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public boolean isDisplayed(By locator){
        return isDisplayed(find(locator));
    }
    public boolean isDisplayed(String cssSelector){
        return isDisplayed(find(cssSelector));
    }
    public void clickSearchButton(By locator){
        click(locator);
    }

}