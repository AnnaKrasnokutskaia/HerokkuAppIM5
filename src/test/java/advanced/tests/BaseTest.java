package advanced.tests;

import advanced.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    WebDriver driver;

    // папка, куда Chrome будет скачивать файлы
    protected final Path DOWNLOAD_DIR = Path.of("downloads").toAbsolutePath();

    @BeforeMethod
    public void setUp() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        // настройки Chrome для скачивания без всплывающего окна "куда сохранить?"
        //честно украдено, извините
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOAD_DIR.toString());
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        //определяем браузер с которым хотим работать
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
