package parallelTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import models.ChangeBasket;
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

public class ChangeBasketTest extends CrossBrowser{
    private ChangeBasket changeBasketObject;
    private ExtentReports extentReports = ExtentReports.get(ChangeBasketTest.class);
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/input")
    private WebElement quantityField;

    @Test
    public void testChangeBasketQuantity() {
        this.extentReports.init("F:\\test.html", false);
        this.extentReports.startTest("Verify Change Basket");
        this.extentReports.log(LogStatus.INFO, "Elements initialized");
        PageFactory.initElements(driver, this);
        this.changeBasketObject = new ChangeBasket(driver, wait);
        this.extentReports.log(LogStatus.INFO, "Change basket class instance created");
        this.changeBasketObject.changeProductQuantity();
        this.extentReports.log(LogStatus.INFO, "Change Product quantity done");
        wait.until(ExpectedConditions.visibilityOf(this.quantityField));
        Assert.assertEquals(this.quantityField.getAttribute("value"), "3");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String destination  = "F:\\ChangeBasketTestFailScreenshot.png";
            this.extentReports.log(LogStatus.FAIL, "Test failed, screenshot below.");
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(destination));
            this.extentReports.attachScreenshot(destination);
        }
        else this.extentReports.log(LogStatus.PASS, "Test successful.");
        this.extentReports.endTest();
    }
}