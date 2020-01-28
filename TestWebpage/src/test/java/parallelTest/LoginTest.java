package parallelTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import models.Login;
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

import java.io.File;
import java.io.IOException;

public class LoginTest extends CrossBrowser{
    private Login loginObj;
    private ExtentReports extentReports = ExtentReports.get(LoginTest.class);
    @FindBy (xpath = "//*[@id='inner-wrap']/div/div/div[2]/div[1]/div[3]/p")
    private WebElement loginTitle;

    @Test
    public void testLogin() {
        this.extentReports.init("F:\\test.html", false);
        this.extentReports.startTest("Verify Login");
        PageFactory.initElements(driver, this);
        this.extentReports.log(LogStatus.INFO, "Elements initialized");
        this.loginObj = new Login(driver,wait);
        this.extentReports.log(LogStatus.INFO, "Login class instance created");
        this.loginObj.loginRoutine("pace.cosimo@uola.org", "test123");
        this.extentReports.log(LogStatus.INFO, "Login Routine done");
        wait.until(ExpectedConditions.visibilityOf(this.loginTitle));
        Assert.assertEquals(this.loginTitle.getText(), "DOBRODOŠLI, PERO PERIC!");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String destination  = "F:\\Projektici\\LoginTestFailScreenshot.png";
            this.extentReports.log(LogStatus.FAIL, "Test failed, screenshot below.");
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(destination));
            this.extentReports.attachScreenshot(destination);
        }
        else this.extentReports.log(LogStatus.PASS, "Test successful.");
        this.extentReports.endTest();
    }

}