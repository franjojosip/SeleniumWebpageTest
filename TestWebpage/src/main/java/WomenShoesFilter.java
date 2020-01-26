import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenShoesFilter {
    private WebDriver driver;
    private WebDriverWait wait;
    private By shoeslink = By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");
    private By fashionShoeslink = By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/div[1]/li[1]");
    private By genderRow = By.xpath("//*[@id=\"narrow-by-list\"]/dt[3]");
    private By genderType = By.xpath("//*[@id=\"narrow-by-list\"]/dd[3]/ol/li[2]/a");

    //Set WomenShoesFilter driver
    public WomenShoesFilter(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on Clothes link button on webpage HomePage
    private void clickFashionShoesOnNavigationBar(){
        Actions action = new Actions(this.driver);
        WebElement shoesLink = this.driver.findElement(this.shoeslink);
        action.moveToElement(shoesLink).moveToElement(driver.findElement(this.fashionShoeslink)).click().build().perform();
    }

    //Click on gender row
    private void clickOnGender(){
        this.driver.findElement(this.genderRow).click();
    }

    //Choose gender type
    private void chooseGenderType(){
        this.driver.findElement(this.genderType).click();
    }

    public void filterWomenShoesRoutine() {
        this.clickFashionShoesOnNavigationBar();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.genderRow));
        this.clickOnGender();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.genderType));
        this.chooseGenderType();

    }


}
