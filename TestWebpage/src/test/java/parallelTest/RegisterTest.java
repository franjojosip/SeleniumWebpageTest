package parallelTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import models.Register;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

public class RegisterTest extends CrossBrowser{
    private Register registerObject;
    private ExtentReports extentReports = ExtentReports.get(RegisterTest.class);
    @FindBy (xpath = "//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p")
    private WebElement registerTitle;

    @Test
    public void testFeriviRegister() throws IOException, UnsupportedFlavorException {
        this.extentReports.init("F:\\test.html", false);
        this.extentReports.startTest("Verify Register");
        this.extentReports.log(LogStatus.INFO, "Elements initialized");
        PageFactory.initElements(driver, this);
        this.registerObject = new Register(driver, wait);
        this.extentReports.log(LogStatus.INFO, "Register class instance created");
        this.registerObject.registerRoutine("Pero","Peric","12","1","1994", "test123");
        this.extentReports.log(LogStatus.INFO, "Register routine done");
        wait.until(ExpectedConditions.visibilityOf(this.registerTitle));
        Assert.assertEquals(this.registerTitle.getText(), "DOBRODOŠLI, PERO PERIC!");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String destination  = "F:\\RegisterTestFailScreenshot.png";
            this.extentReports.log(LogStatus.FAIL, "Test failed, screenshot below.");
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(destination));
            this.extentReports.attachScreenshot(destination);
        }
        else this.extentReports.log(LogStatus.PASS, "Test successful.");
        this.extentReports.endTest();
    }
}