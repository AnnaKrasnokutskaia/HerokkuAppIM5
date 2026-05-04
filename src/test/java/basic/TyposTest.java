package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

/*Проверить соответствие параграфа орфографии (на уроке сказали повторить 10 раз)*/

public class TyposTest {

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
    public void checkTypos(){

        SoftAssert softAssert = new SoftAssert();

        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //открывает страницу по указанному url
        driver.get("https://the-internet.herokuapp.com/typos");

        for (int i = 0; i < 10; i++){
            //refresh page
            driver.navigate().refresh();
            //получить текст
            String text = driver.findElement(By.xpath("(//p)[2]")).getText();
            //проверка одной штуки
            softAssert.assertEquals(text,"Sometimes you'll see a typo, other times you won't.");
        }

        //проверка всего
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
