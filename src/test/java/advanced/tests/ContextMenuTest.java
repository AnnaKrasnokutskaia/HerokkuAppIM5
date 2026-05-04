package advanced.tests;

import advanced.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{
    ContextMenuPage contextMenuPage;
    @BeforeMethod
    public void setUpDriver() {
        contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void checkContextMenu(){
        contextMenuPage.open();
        contextMenuPage.rightClick();
        Assert.assertEquals(contextMenuPage.alertText(), "You selected a context menu");
    }
}
