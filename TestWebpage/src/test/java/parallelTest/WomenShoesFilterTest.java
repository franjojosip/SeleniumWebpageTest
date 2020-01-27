package parallelTest;

import org.testng.Assert;
import models.WomenShoesFilter;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenShoesFilterTest extends CrossBrowser{
    private WomenShoesFilter womenShoesFilterObject;
    @FindBy (xpath = "/html/body/div[6]/div[2]/div/div/div[7]/div[2]/div[1]/div/div/div/div/ol/li")
    public WebElement womenGenderFilter;

    @Test
    public void testWomenShoesFilter() {
        PageFactory.initElements(driver, this);
        this.womenShoesFilterObject = new WomenShoesFilter(driver, wait);
        this.womenShoesFilterObject.filterWomenShoesRoutine();
        wait.until(ExpectedConditions.visibilityOf(this.womenGenderFilter));
        Assert.assertEquals(this.womenGenderFilter.getText(), "Uklonite ovaj filter\n" + "SPOL:\n" + "Ženski");
    }



}