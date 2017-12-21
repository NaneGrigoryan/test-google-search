import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends pageobjects.BasePage {
    private By searchInput = By.cssSelector("input#lst-ib");
    private By searchButton = By.cssSelector("input[name='btnK']");

    public GoogleSearchPage (WebDriver webdriver){
        super(webdriver);
        visit("https://www.google.com/");
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

    public WebElement getFirstResult(){
        List<WebElement> elements = findElements(By.cssSelector(".rc .r"));
        return elements.get(0);
    }

}
