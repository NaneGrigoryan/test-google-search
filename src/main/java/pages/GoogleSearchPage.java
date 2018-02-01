package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static setup.DriverSetup.getDriver;


public class GoogleSearchPage extends BasePage {
    private By searchInput = By.cssSelector("input#lst-ib");
    private By searchButton = By.cssSelector("input[name='btnK']");
    private By result = By.cssSelector("div#resultStats");

    public GoogleSearchPage (){
        super(getDriver());
        visit(getUrl());
    }

    public void typeSearchText(By locator, String text){
        type(searchInput, text);
    }

    public void search(String text){
        WebElement webElement = find(searchInput);
        webElement.clear();
        type(searchInput, text );
        clickSearchButton(searchButton);
    }
    public boolean isResultDisplayed(){
        return isDisplayed(find(result), 10);
    }
    public WebElement getResult(){
        return find(result);
    }


    public WebElement getFirstResult(){
        List<WebElement> elements = findElements(By.cssSelector(".rc .r"));
        return elements.get(0);
    }

    @Override
    public String getUrl() {
        return "https://www.google.am/?gws_rd=cr&dcr=0&ei=SuxtWsn0N8aesgHO4Z_IAw";
    }
}
