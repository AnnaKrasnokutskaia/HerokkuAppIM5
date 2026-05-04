package advanced.tests;

import advanced.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest{
    FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUpDriver() {
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test
    public void checkFileUpload() {
        File file = new File("src/test/java/advanced/files/example.txt");
        fileUploadPage.open();
        fileUploadPage.uploadFile(file.getAbsolutePath());
        Assert.assertEquals(fileUploadPage.getUploadedFileName(), file.getName());
    }
}
