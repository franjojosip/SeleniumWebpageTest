package models;

import java.awt.Toolkit;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.datatransfer.UnsupportedFlavorException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Register {
    public WebDriver driver;
    public WebDriverWait wait;
    private String email;
    private String emailUrl = "http://www.minuteinbox.com/";
    private String feriviUrl = "http://www.ferivisport.hr/";

    @FindBy (xpath = "/html/body/div/div[3]/div[2]/div[1]/a")
    private WebElement copyEmail;
    @FindBy (xpath = "/html/body/div[5]/div[2]/div/div/div[5]/div[1]/div[3]/div[2]/ul/li[2]/a")
    private WebElement btnHomePageRegister;
    @FindBy (name = "firstname")
    private WebElement firstNameTextBox;
    @FindBy (name = "lastname")
    private WebElement lastNameTextBox;
    @FindBy (id = "email_address")
    private WebElement emailTextBox;
    @FindBy (id = "day")
    private WebElement dayTextBox;
    @FindBy (id = "month")
    private WebElement monthTextBox;
    @FindBy (id = "year")
    private WebElement yearTextBox;
    @FindBy (id = "password")
    private WebElement passwordTextBox;
    @FindBy (id = "confirmation")
    private WebElement repeatPasswordTextBox;
    @FindBy (xpath = "//*[@id=\"form-validate\"]/div[3]/div[2]/button")
    private WebElement btnCreateAccount;

    //Set driver
    public Register(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    //Navigate to page with 10min emails
    private void navigateToEmailPage() {
        this.driver.navigate().to(this.emailUrl);
    }

    //Click on models.Login button on HomePage
    private void copyEmail() throws IOException, UnsupportedFlavorException {
        this.copyEmail.click();
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
        this.btnHomePageRegister.click();
    }

    //Insert user information in register fields
    private void insertRegisterData(String firstName, String lastName, String day, String month, String year, String password) {
        this.firstNameTextBox.sendKeys(firstName);
        this.lastNameTextBox.sendKeys(lastName);
        this.emailTextBox.sendKeys(this.email);
        this.dayTextBox.sendKeys(day);
        this.monthTextBox.sendKeys(month);
        this.yearTextBox.sendKeys(year);
        this.passwordTextBox.sendKeys(password);
        this.repeatPasswordTextBox.sendKeys(password);
        this.btnCreateAccount.click();
    }

    //method for executing register sequence on Ferivi page
    public void registerRoutine(String firstName, String lastName, String day, String month, String year, String password) throws IOException, UnsupportedFlavorException {
        this.navigateToEmailPage();
        this.wait.until(ExpectedConditions.visibilityOf(this.copyEmail));
        this.copyEmail();
        this.navigateToFeriviPage();
        this.wait.until(ExpectedConditions.visibilityOf(this.btnHomePageRegister));
        this.clickRegister();
        this.insertRegisterData(firstName, lastName, day, month, year, password);
    }
}
