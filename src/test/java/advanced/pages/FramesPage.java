package advanced.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    private final By IFRAME_LINK = By.linkText("iFrame");
    private final By IFRAME = By.id("mce_0_ifr");
    private final By TEXT = By.tagName("p");

    public void open() {
        driver.get(BASE_URL + "frames");
    }

    public void openIframe() {
        driver.findElement(IFRAME_LINK).click();
    }

    public String getTextFromIframe() {
        driver.switchTo().frame(driver.findElement(IFRAME));
        String text = driver.findElement(TEXT).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}