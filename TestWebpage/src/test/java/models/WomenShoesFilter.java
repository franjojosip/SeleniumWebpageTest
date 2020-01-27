package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenShoesFilter {
    public WebDriver driver;
    public WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[4]/a")
    private WebElement shoeslink;
    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[4]/ul/div[1]/li[1]")
    private WebElement fashionShoeslink;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/dt[3]")
    private WebElement genderRow;
    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/dd[3]/ol/li[2]/a")
    private WebElement genderType;

    //Set models.WomenShoesFilter driver
    public WomenShoesFilter(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    //Click on Clothes link button on webpage HomePage
    private void clickFashionShoesOnNavigationBar(){
        Actions action = new Actions(this.driver);
        action.moveToElement(this.shoeslink).moveToElement(this.fashionShoeslink).click().build().perform();
    }

    //Click on gender row
    private void clickOnGender(){
        this.genderRow.click();
    }

    //Choose gender type
    private void chooseGenderType(){
        this.genderType.click();
    }

    public void filterWomenShoesRoutine() {
        this.clickFashionShoesOnNavigationBar();
        this.wait.until(ExpectedConditions.visibilityOf(this.genderRow));
        this.clickOnGender();
        this.wait.until(ExpectedConditions.visibilityOf(this.genderType));
        this.chooseGenderType();

    }


}
