package parallelTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import models.CleanBasket;
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

public class CleanBasketTest extends CrossBrowser{
    private CleanBasket cleanBasketObject;
    private ExtentReports extentReports = ExtentReports.get(CleanBasketTest.class);
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div/div[2]/div[2]/h1")
    private WebElement emptyBasketTitle;

    @Test
    public void testCleanBasket() {
        this.extentReports.init("F:\\test.html", false);
        this.extentReports.startTest("Verify Clean Basket");
        this.extentReports.log(LogStatus.INFO, "Elements initialized");
        PageFactory.initElements(driver, this);
        this.cleanBasketObject = new CleanBasket(driver, wait);
        this.extentReports.log(LogStatus.INFO, "Clean basket class instance created");
        this.cleanBasketObject.cleanBasketRoutine();
        this.extentReports.log(LogStatus.INFO, "Clean Basket routine done");
        wait.until(ExpectedConditions.visibilityOf(this.emptyBasketTitle));
        Assert.assertEquals(this.emptyBasketTitle.getText(), "KOŠARICA JE PRAZNA");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String destination  = "F:\\CleanBasketTestFailScreenshot.png";
            this.extentReports.log(LogStatus.FAIL, "Test failed, screenshot below.");
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(destination));
            this.extentReports.attachScreenshot(destination);
        }
        else this.extentReports.log(LogStatus.PASS, "Test successful.");
        this.extentReports.endTest();
    }

}