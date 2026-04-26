package advanced.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    private final By box = By.id("hot-spot");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightClick() {
        actions.contextClick(driver.findElement(box)).perform();
    }

    public String alertText(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
