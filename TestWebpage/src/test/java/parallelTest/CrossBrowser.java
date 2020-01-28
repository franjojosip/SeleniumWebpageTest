package parallelTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CrossBrowser {

    protected WebDriver driver = null;
    protected WebDriverWait wait;
    private String URL = "http://www.ferivisport.hr/";

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            if(this.driver == null){
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
            }
        }
        //Check if parameter passed from TestNG is 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            if(this.driver == null){
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
            }
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("edge")) {
            if(this.driver == null) {
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver();
            }
        }
        //Check if parameter passed as 'ie' (Internet Explorer)
        else if (browser.equalsIgnoreCase("ie")) {
            if(this.driver == null) {
                WebDriverManager.iedriver().setup();
                this.driver = new InternetExplorerDriver();
            }
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        this.driver.manage().window().fullscreen();
        //WebDriverWait with 10 seconds wait for Web element to show
        this.wait = new WebDriverWait(this.driver, 10);
        this.driver.navigate().to(this.URL);
    }

    @AfterTest
    public void teardownTest() {
        //Close browser and end the session
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}