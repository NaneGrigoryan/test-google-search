package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;
import java.util.logging.Logger;

import static setup.DriverSetup.getDriver;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    Logger log = Logger.getLogger(Log.class.getName());
    /*private WebDriver driver;*/
    protected WebDriver driver;

    public static final String BASE_URL = System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage(WebDriver driver){
       this.driver = getDriver();
       PageFactory.initElements(this.driver, this);
    }
    public void visit(String url){
        log.info("Visiting " + url);
        driver.get(url);
        this.get();
    }


    public WebElement find(By locator){
        log.info("Finding element By locator " + locator.toString());
        return driver.findElement(locator);
        //return find(By.cssSelector(cssSelector));
    }

    public List<WebElement> findElements(By locator){
        log.info("Finding element by locator " + locator.toString());
        return driver.findElements(locator);
    }

    public WebElement find(String cssSelector){
        log.info("Finding element by cssSelector " + cssSelector);
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator){
        log.info("finding element by locator " + locator.toString());
        click(find(locator));
        //find (locator).click();
    }

    public void click(WebElement element){
        log.info("Clicking on element " + element.toString());
        element.click();
    }

    public void click(String cssSelector) {
        log.info("clicking on element " + cssSelector);
        click(find(cssSelector));
    }

    public void type(By locator, String text){
        log.info("Typing " + text + " into element " + locator.toString());
        type(find(locator), text); // aveli lav tarberak qan nerqevin@
        //find(locator).sendKeys(text);
    }

    public void type(WebElement element, String text){
        log.info("Typing " + text + " into element " + element.toString());
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text){
        log.info("Typing " + text + " into element " + cssSelector);
        type(find(cssSelector), text);
    }

    public boolean isDisplayed(WebElement element, int i){
        log.info("Checking element visibility " + element.toString());
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
    // WaitHelper-neric heto sa kareli a jnjel
   /* public boolean isDisplayed(WebElement element, Integer timeout){
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
    public  WebElement waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }
*/

    public boolean isDisplayed(By locator){
        return isDisplayed(find(locator), 10);
    }

    public boolean isDisplayed(String cssSelector){
        return isDisplayed(find(cssSelector), 10);
    }

    public void clickSearchButton(By locator){
        click(locator);
    }

    public abstract String getUrl();
    @Override
    protected void load(){

    }

    @Override
    protected void isLoaded() throws Error{
        driver.getCurrentUrl().contains(getUrl());
    }

}