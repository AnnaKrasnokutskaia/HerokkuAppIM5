import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

/*Проверить на возможность ввести различные цифровые и
нецифровые значения, используя Keys.ARROW_UP И
Keys.ARROW_DOWN */

public class InputsTest {

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
    public void checkInputs() {

        SoftAssert softAssert = new SoftAssert();

        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //открывает страницу по указанному url
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement input = driver.findElement(By.tagName("input"));

        input.click();

        //ввести буквы
        String letters = "abcd";
        input.sendKeys(letters);
        softAssert.assertEquals(input.getAttribute("value"),"");
        input.clear();

        //ввести спецсимволы
        String specialCharacters = "&?!!!?///";
        input.sendKeys(specialCharacters);
        softAssert.assertEquals(input.getAttribute("value"),"");
        input.clear();

        //ввести цифры
        String numbers = "10";
        input.sendKeys(numbers);
        softAssert.assertEquals(input.getAttribute("value"), numbers);

        //пощёлкать вверх
        int num = Integer.parseInt(numbers);
        input.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(input.getAttribute("value"),String.valueOf(num+1));

        //пощёлкать вниз
        input.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(input.getAttribute("value"),numbers);

        //проверка всего
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
