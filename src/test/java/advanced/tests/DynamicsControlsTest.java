package advanced.tests;

import advanced.pages.DynamicsControlsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicsControlsTest extends BaseTest{
    DynamicsControlsPage dynamicsControlsPage;
    @BeforeMethod
    public void setUpDriver() {
        dynamicsControlsPage = new DynamicsControlsPage(driver);
    }

    @Test
    public void checkDynamicsControls(){
        dynamicsControlsPage.open();
        dynamicsControlsPage.clickRemove();
        Assert.assertEquals(dynamicsControlsPage.waitForMessage(), "It's gone!");
        Assert.assertFalse(dynamicsControlsPage.isCheckboxPresent());

        Assert.assertFalse(dynamicsControlsPage.isInputEnabled());

        dynamicsControlsPage.clickEnable();
        Assert.assertEquals(dynamicsControlsPage.waitForMessage(), "It's enabled!");
        Assert.assertTrue(dynamicsControlsPage.isInputEnabled());

    }
}
