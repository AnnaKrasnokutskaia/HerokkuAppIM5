package advanced.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage{

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    private final By FILE_INPUT = By.id("file-upload");
    private final By UPLOAD_BUTTON = By.id("file-submit");
    private final By UPLOADED_FILE = By.id("uploaded-files");

    public void open() {
        driver.get(BASE_URL + "upload");
    }

    public void uploadFile(String filePath) {
        driver.findElement(FILE_INPUT).sendKeys(filePath);
        driver.findElement(UPLOAD_BUTTON).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(UPLOADED_FILE).getText();
    }
}
