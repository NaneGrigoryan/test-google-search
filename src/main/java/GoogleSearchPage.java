import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends pageobjects.BasePage {
    private By searchInput = By.cssSelector("input#lst-ib");
    private By searchButton = By.cssSelector("input[name=btnK']");

    public GoogleSearchPage (WebDriver webdriver){
        super(webdriver);
        visit("https://www.google.com/");
    }

    public void clickSearchButton(){
        click(searchButton);
    }
    public void typeSearchText(String text){
        type(searchInput, text);
    }
    public void search(String text){
        typeSearchText(text);
        clickSearchButton();
    }

}
