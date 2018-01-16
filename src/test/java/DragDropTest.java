import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.getDriver;


public class DragDropTest extends BaseTest{
    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp() {
        dragAndDropPage = new DragAndDropPage();

    }

    @Test
    public void dragAndDropTest() {
        assertEquals(dragAndDropPage.getDropText(), "Drop here");
        dragAndDropPage.dragAndDrop();
        assertEquals(dragAndDropPage.getDropText(), "Dropped!");
    }
}