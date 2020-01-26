import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageCrumbsTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private FindPageCrumbs findPageCrumbsObj;
    private String URL = "http://www.ferivisport.hr/";
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div/div[1]/div/div[1]/ul/li[4]/a")
    private WebElement rukometPageCrumb;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 5);
        this.findPageCrumbsObj = new FindPageCrumbs(this.driver);
        this.driver.navigate().to(this.URL);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testFeriviHandballProductPageCrumbs() {
        this.findPageCrumbsObj.findPageCrumbs();
        this.wait.until(ExpectedConditions.visibilityOf(this.rukometPageCrumb));
        Assert.assertEquals(this.rukometPageCrumb.getText(), "RUKOMET");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}