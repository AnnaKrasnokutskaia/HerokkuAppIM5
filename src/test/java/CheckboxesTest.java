import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

/*проверить, что первый чекбокс unchecked, отметить
первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
checked, сделать uncheck, проверить, что он unchecked */

public class CheckboxesTest {

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
    public void checkCheckboxes() {

        SoftAssert softAssert = new SoftAssert();

        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //открывает страницу по указанному url
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //получили два чекбокса
        List<WebElement> elements = driver.findElements(By.cssSelector("[type=checkbox]"));

        //проверили первый
        boolean isChecked1 = elements.get(0).isSelected();
        softAssert.assertFalse(isChecked1);

        //отметили и проверили
        elements.get(0).click();
        isChecked1 = elements.get(0).isSelected();
        softAssert.assertTrue(isChecked1);

        //проверили второй
        boolean isChecked2 = elements.get(1).isSelected();
        softAssert.assertTrue(isChecked2);

        //сняли отметку и проверили
        elements.get(1).click();
        isChecked2 = elements.get(1).isSelected();
        softAssert.assertFalse(isChecked2);

        //проверка всего
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
