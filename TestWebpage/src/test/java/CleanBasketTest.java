import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CleanBasketTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private CleanBasket cleanBasketObject;
    private String URL = "http://www.ferivisport.hr/";
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div/div[2]/div[2]/h1")
    private WebElement emptyBasketTitle;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        this.cleanBasketObject = new CleanBasket(this.driver);
        this.wait = new WebDriverWait(this.driver, 5);
        this.driver.navigate().to(this.URL);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testCleanBasket() {
        this.cleanBasketObject.cleanBasketRoutine();
        this.wait.until(ExpectedConditions.visibilityOf(this.emptyBasketTitle));
        Assert.assertEquals(this.emptyBasketTitle.getText(), "KOŠARICA JE PRAZNA");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        this.driver.quit();
    }

}