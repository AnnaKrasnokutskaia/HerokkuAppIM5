import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

/*добавить 2 элемента, удалить элемент,
проверить количество элементов DELETE*/

public class AddRemoveElementTest {

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
    public void checkAddRemoveElement(){

        SoftAssert softAssert = new SoftAssert();

        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //открывает страницу по указанному url
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        int size = driver.findElements(By.xpath("//button[text()='Delete']")).size();

        softAssert.assertEquals(size,2);

        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        int size1 = driver.findElements(By.xpath("//button[text()='Delete']")).size();

        softAssert.assertEquals(size1,1);

        //проверка
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
