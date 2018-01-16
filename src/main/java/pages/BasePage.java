package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class BasePage {
    Logger log = Logger.getLogger(Log.class.getName());
    /*private WebDriver driver;*/
    protected WebDriver driver;

    public static final String BASE_URL = System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage(WebDriver webdriver){
        this.driver = webdriver;
    }
    public void visit(String url){
        log.info("Visiting " + url);
        driver.get(url);
        PageFactory.initElements(driver, this);
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
    public boolean isDisplayed(WebElement element, Integer timeout){
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }
    public boolean isNotDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
            } catch (TimeoutException e) {
                return false; }
          return true;
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