package parallelTest;
import models.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends CrossBrowser{
    private Login loginObj;
    @FindBy (xpath = "//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p")
    public WebElement loginTitle;

    @Test
    public void testLogin() {
        PageFactory.initElements(driver, this);
        this.loginObj = new Login(driver,wait);
        this.loginObj.loginRoutine("pace.cosimo@uola.org", "test123");
        wait.until(ExpectedConditions.visibilityOf(this.loginTitle));
        Assert.assertEquals(this.loginTitle.getText(), "DOBRODOŠLI, PERO PERIC!");
    }

}