package models;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeBasket {
    public WebDriver driver;
    public WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div/div[2]")
    private WebElement btnSearch;
    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div/div[1]/div/button")
    private WebElement btnSubmit;
    @FindBy(id = "search")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"inner-wrap\"]/div/div/div[6]/div[2]/div[2]/div[4]/ul/li/a[1]")
    private WebElement productField;
    @FindBy(xpath = "//*[@id=\"swatch25\"]/span[1]")
    private WebElement productSize;
    @FindBy(xpath = "//*[@id=\"product_addtocart_form\"]/div[4]/div[5]/div[2]/div[2]/button")
    private WebElement btnAddProduct;
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/input")
    private WebElement quantityField;

    //Set models.ChangeBasket driver
    public ChangeBasket(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    //Click on search button on webpage HomePage
    private void clickSearchBtn(){ this.btnSearch.click(); }

    //Click on submit search button on webpage HomePage
    private void clickSubmitBtn(){ this.btnSubmit.click(); }

    //Input search string
    private void inputValueInSearchField() {
        this.searchField.sendKeys("TENISICA RS-X? PUZZLE");
    }

    //Choose product
    private void chooseProduct() {
        this.productField.click();
    }

    //Choose product
    private void chooseProductSize() {
        this.productSize.click();
    }

    //Add products
    private void addProductsToBasket() {
        this.btnAddProduct.click();
    }

    //Add products
    private void changeQuantity() {
        this.quantityField.clear();
        this.quantityField.sendKeys("3");
        this.quantityField.sendKeys(Keys.ENTER);
    }

    public void changeProductQuantity() {
        this.clickSearchBtn();
        this.wait.until(ExpectedConditions.visibilityOf(this.searchField));
        this.inputValueInSearchField();
        this.clickSubmitBtn();
        this.wait.until(ExpectedConditions.visibilityOf(this.productField));
        this.chooseProduct();
        this.wait.until(ExpectedConditions.visibilityOf(this.productSize));
        this.chooseProductSize();
        this.addProductsToBasket();
        this.wait.until(ExpectedConditions.visibilityOf(this.quantityField));
        this.changeQuantity();
    }


}
