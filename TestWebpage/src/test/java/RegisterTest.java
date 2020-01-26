import org.testng.Assert;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.datatransfer.UnsupportedFlavorException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private Register registerObject;
    private By registerTitle = By.xpath("//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p");

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, 5);
        this.registerObject = new Register(this.driver);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testFeriviRegister() throws IOException, UnsupportedFlavorException {
        this.registerObject.registerRoutine("Pero","Peric","12","1","1994", "test123");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.registerTitle));
        WebElement title = this.driver.findElement(this.registerTitle);
        Assert.assertEquals(title.getText(), "DOBRODOŠLI, PERO PERIC!");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        this.driver.quit();
    }
}