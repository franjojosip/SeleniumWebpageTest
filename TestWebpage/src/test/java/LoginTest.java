import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private Login loginObj;
    private String URL = "http://www.ferivisport.hr/";
    private By loginTitle = By.xpath("//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p");

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.loginObj = new Login(driver);
        this.wait = new WebDriverWait(this.driver, 5);
        this.driver.navigate().to(this.URL);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testLogin() throws InterruptedException {
        this.loginObj.loginRoutine("pace.cosimo@uola.org", "test123");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.loginTitle));
        WebElement testLink = this.driver.findElement(this.loginTitle);
        Assert.assertEquals(testLink.getText(), "DOBRODOŠLI, PERO PERIC!");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        this.driver.quit();
    }

}