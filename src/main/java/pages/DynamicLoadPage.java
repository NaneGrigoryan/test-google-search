package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

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
        visit(getUrl());
        //PageFactory.initElements(driver, this);//DynamicLoadPage.class petq a ashxati this-i nman,
        // tanenq basepage, vorpeszi amen angam chgrenq bolor pagerum
        // dynamicLoadPage classic verevum find arac elementner@ init a anum
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/dynamic_loading/1";
    }

    public void clickStart(){
        click(startButton);
    }

    public boolean isFinishDisplayed(){
       try{
           WaitHelper.getWait().waitForElementToBeVisible(finishText);
           return true;
       } catch (Error e){
           return false;
       }
    }

    public boolean isLoadingDisplayed() {
        try {
            WaitHelper.getWait().waitForElementToBeVisible(loadingText);
            return true;
        } catch (Error e){
            return false;

        }
    }

    public boolean isLoadingNotDisplayed() {
        try {
            WaitHelper.getWait().waitForElementNotVisible(loadingText);
            return true;
        } catch (Error e){
            return false;

        }
    }

    public WebElement getFinish(){
        return finishText;
    }

}