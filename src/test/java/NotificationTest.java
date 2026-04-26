import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

/*кликнуть на кнопку, дождаться появления
нотификации, проверить соответствие текста ожиданиям*/

public class NotificationTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //задаем опции для нашего драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        //определяем браузер с которым хотим работать
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkNotification() {

        SoftAssert softAssert = new SoftAssert();

        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //открывает страницу по указанному url
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

        //кликнем на кнопку
        driver.findElement(By.linkText("Click here")).click();
        //получим нотификацию
        String message = driver.findElement(By.id("flash")).getText();
        //там иногда вылезает другая нотификация, поэтому вывод нужен,
        //чтоб я потом посмотрела, это тест упал законно или потому что он кривой
        System.out.println(message);
        softAssert.assertTrue(message.contains("Action successful"));

        //проверка всего
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
