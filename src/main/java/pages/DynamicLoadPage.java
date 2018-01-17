package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;


public class DynamicLoadPage extends BasePage {
    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(id = "#finish")
    private WebElement finishText;

    @FindBy(css = "loading")
    private WebElement loadingText;

//
   /* private By startButton = By.cssSelector("#start button");
    private By finishText = By.id("finish");
    private By loadingText = By.id("loading");*/

    public DynamicLoadPage( ) {
        super(getDriver());
        visit("http://the-internet.herokuapp.com/dynamic_loading/1");
        //PageFactory.initElements(driver, this);//DynamicLoadPage.class petq a ashxati this-i nman,
        // tanenq basepage, vorpeszi amen angam chgrenq bolor pagerum
        // dynamicLoadPage classic verevum find arac elementner@ init a anum
    }

    public void clickStart(){

        click(startButton);
    }
    public boolean isFinishDisplayed(){ return isDisplayed(finishText, 10); }
    public boolean isLoadingDisplayed() { return isDisplayed (loadingText, 10); }
    public boolean isLoadingNotDisplayed() { return isNotDisplayed(loadingText, 10);
        }
    public WebElement getFinish(){
        return finishText;
    }


}