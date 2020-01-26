import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeBasket {
    private WebDriver driver;
    private WebDriverWait wait;
    private By btnSearch = By.xpath("//*[@id=\"search_mini_form\"]/div/div[2]");
    private By btnSubmit = By.xpath("//*[@id=\"search_mini_form\"]/div/div[1]/div/button");
    private By searchField = By.id("search");
    private By productField = By.xpath("//*[@id=\"inner-wrap\"]/div/div/div[6]/div[2]/div[2]/div[4]/ul/li/a[1]");
    private By productSize = By.xpath("//*[@id=\"swatch25\"]/span[1]");
    private By btnAddProduct = By.xpath("//*[@id=\"product_addtocart_form\"]/div[4]/div[5]/div[2]/div[2]/button");
    private By quantityField = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/input");

    //Set ChangeBasket driver
    public ChangeBasket(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on search button on webpage HomePage
    private void clickSearchBtn(){ this.driver.findElement(this.btnSearch).click(); }

    //Click on submit search button on webpage HomePage
    private void clickSubmitBtn(){ this.driver.findElement(this.btnSubmit).click(); }

    //Input search string
    private void inputValueInSearchField() {
        this.driver.findElement(this.searchField).sendKeys("TENISICA RS-X? PUZZLE");
    }

    //Choose product
    private void chooseProduct() {
        this.driver.findElement(this.productField).click();
    }

    //Choose product
    private void chooseProductSize() {
        this.driver.findElement(this.productSize).click();
    }

    //Add products
    private void addProductsToBasket() {
        this.driver.findElement(this.btnAddProduct).click();
    }

    //Add products
    private void changeQuantity() {
        this.driver.findElement(this.quantityField).clear();
        this.driver.findElement(this.quantityField).sendKeys("3");
        WebElement textbox = driver.findElement(this.quantityField);
        textbox.sendKeys(Keys.ENTER);
    }

    public void changeProductQuantity() {
        this.clickSearchBtn();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.searchField));
        this.inputValueInSearchField();
        this.clickSubmitBtn();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.productField));
        this.chooseProduct();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.productSize));
        this.chooseProductSize();
        this.addProductsToBasket();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.quantityField));
        this.changeQuantity();
    }


}
