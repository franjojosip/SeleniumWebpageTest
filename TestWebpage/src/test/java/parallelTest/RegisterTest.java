package parallelTest;

import models.Register;
import org.testng.Assert;
import java.io.IOException;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.datatransfer.UnsupportedFlavorException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterTest extends CrossBrowser{
    private Register registerObject;
    @FindBy (xpath = "//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p")
    public WebElement registerTitle;

    @Test
    public void testFeriviRegister() throws IOException, UnsupportedFlavorException {
        PageFactory.initElements(driver, this);
        this.registerObject = new Register(driver, wait);
        this.registerObject.registerRoutine("Pero","Peric","12","1","1994", "test123");
        wait.until(ExpectedConditions.visibilityOf(this.registerTitle));
        Assert.assertEquals(this.registerTitle.getText(), "DOBRODOŠLI, PERO PERIC!");
    }
}