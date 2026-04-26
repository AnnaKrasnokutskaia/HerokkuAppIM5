package advanced.tests;

import advanced.pages.FramesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    FramesPage framesPage;

    @BeforeMethod
    public void setUpDriver() {
        framesPage = new FramesPage(driver);
    }

    @Test
    public void checkIframeText() {
        framesPage.open();
        framesPage.openIframe();
        Assert.assertEquals(framesPage.getTextFromIframe(), "Your content goes here.");
    }
}