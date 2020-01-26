import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeBasketTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private ChangeBasket changeBasketObject;
    private String URL = "http://www.ferivisport.hr/";
    private By quantityField = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/input");

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.changeBasketObject = new ChangeBasket(this.driver);
        this.wait = new WebDriverWait(this.driver, 5);
        this.driver.navigate().to(this.URL);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testChangeBasketQuantity() {
        this.changeBasketObject.changeProductQuantity();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.quantityField));
        WebElement testLink = this.driver.findElement(this.quantityField);
        Assert.assertEquals(testLink.getAttribute("value"), "3");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        this.driver.quit();
    }

}