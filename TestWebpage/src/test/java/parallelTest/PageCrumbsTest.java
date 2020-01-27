package parallelTest;

import org.testng.Assert;
import models.FindPageCrumbs;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageCrumbsTest extends CrossBrowser{
    private FindPageCrumbs findPageCrumbsObj;
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div/div[1]/div/div[1]/ul/li[4]/a")
    public WebElement rukometPageCrumb;

    @Test
    public void testFeriviHandballProductPageCrumbs() {
        PageFactory.initElements(driver, this);
        this.findPageCrumbsObj = new FindPageCrumbs(driver, wait);
        this.findPageCrumbsObj.findPageCrumbs();
        wait.until(ExpectedConditions.visibilityOf(this.rukometPageCrumb));
        Assert.assertEquals(this.rukometPageCrumb.getText(), "RUKOMET");
    }
}