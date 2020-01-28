package parallelTest;

import org.testng.Assert;
import org.testng.ITestResult;
import models.WomenShoesFilter;
import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;

public class WomenShoesFilterTest extends CrossBrowser{
    private WomenShoesFilter womenShoesFilterObject;
    private ExtentReports extentReports = ExtentReports.get(WomenShoesFilterTest.class);
    @FindBy (xpath = "/html/body/div[6]/div[2]/div/div/div[7]/div[2]/div[1]/div/div/div/div/ol/li")
    private WebElement womenGenderFilter;

    @Test
    public void testWomenShoesFilter() {
        this.extentReports.init("F:\\test.html", false);
        this.extentReports.startTest("Verify Women Shoes Filter");
        this.extentReports.log(LogStatus.INFO, "Elements initialized");
        PageFactory.initElements(driver, this);
        this.womenShoesFilterObject = new WomenShoesFilter(driver, wait);
        this.extentReports.log(LogStatus.INFO, "Women shoes filter class instance created");
        this.womenShoesFilterObject.filterWomenShoesRoutine();
        this.extentReports.log(LogStatus.INFO, "File Women shoes routine done");
        wait.until(ExpectedConditions.visibilityOf(this.womenGenderFilter));
        Assert.assertEquals(this.womenGenderFilter.getText(), "Uklonite ovaj filter\n" + "SPOL:\n" + "Ženski");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String destination  = "F:\\WomenShoesFilterTestFailScreenshot.png";
            this.extentReports.log(LogStatus.FAIL, "Test failed, screenshot below.");
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(destination));
            this.extentReports.attachScreenshot(destination);
        }
        else this.extentReports.log(LogStatus.PASS, "Test successful.");
        this.extentReports.endTest();
    }



}