import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDownPage extends pageobjects.BasePage {
    public DropDownPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/dropdown");
    }

    public WebElement getDropDown() {
        return find(By.id("dropdown"));
    }

    public List<WebElement> getDropDownOptions() {
        return getDropDown().findElements(By.tagName("option"));
    }

    public void selectOption(String optionName) {
        List<WebElement> options = getDropDownOptions();
        for (WebElement option:options) {
            if (option.getText().equals(optionName)) {
                option.click();
            }
        }
    }

    public String getSelectedOption() {
        List<WebElement> options = getDropDownOptions();
        for (WebElement option:options) {
            if (option.isSelected()) {
                return option.getText();
            }
        }
        return null;
    }
}