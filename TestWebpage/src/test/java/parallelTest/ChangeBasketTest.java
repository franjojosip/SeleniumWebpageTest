package parallelTest;
import org.testng.Assert;
import models.ChangeBasket;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeBasketTest extends CrossBrowser{
    private ChangeBasket changeBasketObject;
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/input")
    public WebElement quantityField;

    @Test
    public void testChangeBasketQuantity() {
        PageFactory.initElements(driver, this);
        this.changeBasketObject = new ChangeBasket(driver, wait);
        this.changeBasketObject.changeProductQuantity();
        wait.until(ExpectedConditions.visibilityOf(this.quantityField));
        Assert.assertEquals(this.quantityField.getAttribute("value"), "3");
    }
}