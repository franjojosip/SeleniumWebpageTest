import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;
    private By btnHomePageLogin = By.id("scrollingClasses");
    private By email = By.id("mini-login");
    private By passwordMark = By.xpath("//*[@id=\"mini-password\"]");
    private By btnLogin = By.id("send2");

    //Set Login
    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on Login button on HomePage
    private void clickHomePageLogin(){
        this.driver.findElement(this.btnHomePageLogin).click();
    }

    //Insert email in email field
    private void insertLoginEmail(String email){
        this.driver.findElement(this.email).sendKeys(email);
    }

    //Insert password in password field
    private void insertLoginPassword(String password){
        this.driver.findElement(this.passwordMark).sendKeys(password);
    }

    //Click on login button
    private void clickLogin(){
        this.driver.findElement(this.btnLogin).click();
    }

    public void loginRoutine(String email, String password) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnHomePageLogin));
        this.clickHomePageLogin();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnHomePageLogin));
        this.insertLoginEmail(email);
        this.insertLoginPassword(password);
        this.clickLogin();
    }


}
