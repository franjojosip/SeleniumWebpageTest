package parallelTest;

import models.CleanBasket;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CleanBasketTest extends CrossBrowser{
    private CleanBasket cleanBasketObject;
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div/div[2]/div[2]/h1")
    public WebElement emptyBasketTitle;

    @Test
    public void testCleanBasket() {
        PageFactory.initElements(driver, this);
        this.cleanBasketObject = new CleanBasket(driver, wait);
        this.cleanBasketObject.cleanBasketRoutine();
        wait.until(ExpectedConditions.visibilityOf(this.emptyBasketTitle));
        Assert.assertEquals(this.emptyBasketTitle.getText(), "KOŠARICA JE PRAZNA");
    }

}