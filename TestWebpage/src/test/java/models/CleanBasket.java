package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CleanBasket {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (xpath = "//*[@id=\"nav\"]/ol/li[2]/a")
    private WebElement linkMenClothes;
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[7]/div[2]/div[2]/div[4]/ul/li[1]/a[1]")
    private WebElement firstTrainersBox;
    @FindBy (id = "swatch263")
    private WebElement sizeBox;
    @FindBy (xpath = "//*[@id=\"product_addtocart_form\"]/div[4]/div[5]/div[2]/div[2]/button")
    private WebElement btnAddProduct;
    @FindBy (id = "empty_cart_button")
    private WebElement btnCleanBasket;
    @FindBy (xpath = "//*[@id=\"nav\"]/ol/li[2]/ul/div[1]/li[6]")
    private WebElement shoesBox;

    //Set CleanBasket drivers
    public CleanBasket(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    //Click on Clothes link button on webpage HomePage
    private void clickManClothesOnNavigationBar(){
        Actions action = new Actions(this.driver);
        action.moveToElement(this.linkMenClothes).moveToElement(this.shoesBox).click().build().perform();
    }

    //Click on first trainers
    private void chooseFirstTrainers(){
        this.firstTrainersBox.click();
    }

    //Choose size
    private void chooseTrainersSize(){
        this.sizeBox.click();
    }

    //Add product to basket
    private void clickOnAddToBasketBtn(){
        this.btnAddProduct.click();
    }

    //Clean basket
    private void clickCleanBasket(){
        this.btnCleanBasket.click();
    }


    public void cleanBasketRoutine() {
        this.clickManClothesOnNavigationBar();
        this.wait.until(ExpectedConditions.visibilityOf(this.firstTrainersBox));
        this.chooseFirstTrainers();
        this.wait.until(ExpectedConditions.visibilityOf(this.sizeBox));
        this.chooseTrainersSize();
        this.wait.until(ExpectedConditions.visibilityOf(this.btnAddProduct));
        this.clickOnAddToBasketBtn();
        this.wait.until(ExpectedConditions.visibilityOf(this.btnCleanBasket));
        this.clickCleanBasket();
    }


}
