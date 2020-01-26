import java.awt.Toolkit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.datatransfer.UnsupportedFlavorException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Register {
    private WebDriver driver;
    private WebDriverWait wait;
    private String email;
    private String emailUrl = "https://www.minuteinbox.com/";
    private String feriviUrl = "http://www.ferivisport.hr/";
    private By copyEmail = By.xpath("/html/body/div/div[3]/div[2]/div[1]/a");;
    private By btnHomePageRegister = By.xpath("/html/body/div[5]/div[2]/div/div/div[5]/div[1]/div[3]/div[2]/ul/li[2]/a");
    private By firstNameTextBox = By.name("firstname");
    private By lastNameTextBox = By.name("lastname");
    private By emailTextBox = By.id("email_address");
    private By dayTextBox = By.id("day");
    private By monthTextBox = By.id("month");
    private By yearTextBox = By.id("year");
    private By passwordTextBox = By.id("password");
    private By repeatPasswordTextBox = By.id("confirmation");
    private By btnCreateAccount = By.xpath("//*[@id=\"form-validate\"]/div[3]/div[2]/button");

    //Set driver
    public Register(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Navigate to page with 10min emails
    private void navigateToEmailPage() {
        driver.navigate().to(emailUrl);
    }

    //Click on Login button on HomePage
    private void copyEmail() throws IOException, UnsupportedFlavorException {
        driver.findElement(this.copyEmail).click();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        email = (String) contents.getTransferData(DataFlavor.stringFlavor);
    }

    //Navigate to Ferivi page
    private void navigateToFeriviPage() {
        driver.navigate().to(this.feriviUrl);
    }

    //Click on register button
    private void clickRegister() {
        driver.findElement(this.btnHomePageRegister).click();
    }

    //Insert user information in register fields
    private void insertRegisterData(String firstName, String lastName, String day, String month, String year, String password) {
        driver.findElement(this.firstNameTextBox).sendKeys(firstName);
        driver.findElement(this.lastNameTextBox).sendKeys(lastName);
        driver.findElement(this.emailTextBox).sendKeys(this.email);
        driver.findElement(this.dayTextBox).sendKeys(day);
        driver.findElement(this.monthTextBox).sendKeys(month);
        driver.findElement(this.yearTextBox).sendKeys(year);
        driver.findElement(this.passwordTextBox).sendKeys(password);
        driver.findElement(this.repeatPasswordTextBox).sendKeys(password);
        driver.findElement(this.btnCreateAccount).click();
    }

    //method for executing register sequence on Ferivi page
    public void registerRoutine(String firstName, String lastName, String day, String month, String year, String password) throws IOException, UnsupportedFlavorException {
        this.navigateToEmailPage();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.copyEmail));
        this.copyEmail();
        this.navigateToFeriviPage();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnHomePageRegister));
        this.clickRegister();
        this.insertRegisterData(firstName, lastName, day, month, year, password);
    }
}
