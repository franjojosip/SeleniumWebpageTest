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

public class WomenShoesFilterTest{
    private WebDriver driver;
    private WebDriverWait wait;
    private WomenShoesFilter womenShoesFilterObject;
    private String URL = "http://www.ferivisport.hr/";
    @FindBy (xpath = "/html/body/div[6]/div[2]/div/div/div[7]/div[2]/div[1]/div/div/div/div/ol/li")
    private WebElement womenGenderFilter;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Franjo Josip/IdeaProjects/ChromeDriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        this.womenShoesFilterObject = new WomenShoesFilter(this.driver);
        this.wait = new WebDriverWait(this.driver, 5);
        this.driver.navigate().to(this.URL);
        this.driver.manage().window().fullscreen();
    }

    @Test
    public void testWomenShoesFilter() {
        this.womenShoesFilterObject.filterWomenShoesRoutine();
        this.wait.until(ExpectedConditions.visibilityOf(this.womenGenderFilter));
        Assert.assertEquals(this.womenGenderFilter.getText(), "Uklonite ovaj filter\n" + "SPOL:\n" + "Ženski");
    }

    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        this.driver.quit();
    }

}