import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "scrollingClasses")
    private WebElement btnHomePageLogin;
    @FindBy(id = "mini-login")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"mini-password\"]")
    private WebElement passwordMark ;
    @FindBy(id = "send2")
    private WebElement btnLogin;

    //Set Login
    public Login(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on Login button on HomePage
    private void clickHomePageLogin(){
        this.btnHomePageLogin.click();
    }

    //Insert email in email field
    private void insertLoginEmail(String email){
        this.email.sendKeys(email);
    }

    //Insert password in password field
    private void insertLoginPassword(String password){
        this.passwordMark.sendKeys(password);
    }

    //Click on login button
    private void clickLogin(){
        this.btnLogin.click();
    }

    public void loginRoutine(String email, String password) {
        this.wait.until(ExpectedConditions.visibilityOf(this.btnHomePageLogin));
        this.clickHomePageLogin();
        this.wait.until(ExpectedConditions.visibilityOf(this.btnHomePageLogin));
        this.insertLoginEmail(email);
        this.insertLoginPassword(password);
        this.clickLogin();
    }


}
