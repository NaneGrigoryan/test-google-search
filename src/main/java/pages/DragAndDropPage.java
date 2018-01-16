package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static setup.DriverSetup.getDriver;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }

    public void dragAndDrop(WebElement draggable, WebElement target) {
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(draggable, target).build().perform();
    }

    public void dragAndDrop() {
        WebElement draggable = find(By.cssSelector(".ui-draggable"));
        WebElement target = find(By.cssSelector(".ui-droppable"));
        dragAndDrop(draggable, target);
    }

    public String getDropText() {
        return find(By.cssSelector(".ui-droppable")).getText();
    }


}