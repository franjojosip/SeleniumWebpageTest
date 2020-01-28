package parallelTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import models.FindPageCrumbs;
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

public class PageCrumbsTest extends CrossBrowser{
    private FindPageCrumbs findPageCrumbsObj;
    private ExtentReports extentReports = ExtentReports.get(PageCrumbsTest.class);
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div/div[1]/div/div[1]/ul/li[4]/a")
    private WebElement rukometPageCrumb;

    @Test
    public void testFeriviHandballProductPageCrumbs() {
        this.extentReports.init("F:\\test.html", false);
        this.extentReports.startTest("Verify Find Page Crumbs");
        this.extentReports.log(LogStatus.INFO, "Elements initialized");
        PageFactory.initElements(driver, this);
        this.findPageCrumbsObj = new FindPageCrumbs(driver, wait);
        this.extentReports.log(LogStatus.INFO, "Find page crumbs class instance created");
        this.findPageCrumbsObj.findPageCrumbs();
        this.extentReports.log(LogStatus.INFO, "Find page crumbs done");
        wait.until(ExpectedConditions.visibilityOf(this.rukometPageCrumb));
        Assert.assertEquals(this.rukometPageCrumb.getText(), "RUKOMET");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String destination  = "F:\\PageCrumbsTestFailScreenshot.png";
            this.extentReports.log(LogStatus.FAIL, "Test failed, screenshot below.");
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(destination));
            this.extentReports.attachScreenshot(destination);
        }
        else this.extentReports.log(LogStatus.PASS, "Test successful.");
        this.extentReports.endTest();
    }
}