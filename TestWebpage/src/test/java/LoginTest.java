import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private Login loginObj;
    private String URL = "http://www.ferivisport.hr/";
    @FindBy (xpath = "//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p")
    private WebElement loginTitle;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        this.loginObj = new Login(driver);
        this.wait = new WebDriverWait(this.driver, 5);
        this.driver.navigate().to(this.URL);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testLogin() throws InterruptedException {
        this.loginObj.loginRoutine("pace.cosimo@uola.org", "test123");
        this.wait.until(ExpectedConditions.visibilityOf(this.loginTitle));
        Assert.assertEquals(this.loginTitle.getText(), "DOBRODOŠLI, PERO PERIC!");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        this.driver.quit();
    }

}