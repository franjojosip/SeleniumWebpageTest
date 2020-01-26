import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CleanBasket {
    private WebDriver driver;
    private WebDriverWait wait;
    private By linkMenClothes = By.xpath("//*[@id=\"nav\"]/ol/li[2]/a");
    private By firstTrainersBox = By.xpath("//*[@id=\"inner-wrap\"]/div/div/div[7]/div[2]/div[2]/div[4]/ul/li[1]/a[1]");
    private By sizeBox = By.id("swatch273");
    private By btnAddProduct = By.xpath("//*[@id=\"product_addtocart_form\"]/div[4]/div[5]/div[2]/div[2]/button");
    private By btnCleanBasket = By.id("empty_cart_button");

    //Set CleanBasket driver
    public CleanBasket(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on Clothes link button on webpage HomePage
    private void clickManClothesOnNavigationBar(){
        Actions action = new Actions(this.driver);
        WebElement menClothesLink = this.driver.findElement(this.linkMenClothes);
        action.moveToElement(menClothesLink).moveToElement(driver.findElement(By.xpath("//*[@id='nav']/ol/li[2]/ul/div[1]/li[6]/a"))).click().build().perform();
    }

    //Click on first trainers
    private void chooseFirstTrainers(){
        this.driver.findElement(this.firstTrainersBox).click();
    }

    //Choose size
    private void chooseTrainersSize(){
        this.driver.findElement(this.sizeBox).click();
    }

    //Add product to basket
    private void clickOnAddToBasketBtn(){
        this.driver.findElement(this.btnAddProduct).click();
    }

    //Clean basket
    private void clickCleanBasket(){
        this.driver.findElement(this.btnCleanBasket).click();
    }


    public void cleanBasketRoutine() {
        this.clickManClothesOnNavigationBar();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.firstTrainersBox));
        this.chooseFirstTrainers();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.sizeBox));
        this.chooseTrainersSize();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnAddProduct));
        this.clickOnAddToBasketBtn();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnCleanBasket));
        this.clickCleanBasket();
    }


}
