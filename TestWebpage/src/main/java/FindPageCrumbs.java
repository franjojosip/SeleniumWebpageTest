import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindPageCrumbs {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (xpath = "//*[@id=\"nav\"]/ol/li[2]/a")
    private WebElement linkMenClothes;
    @FindBy (xpath = "/html/body/div[6]/div[2]/div/div/div[7]/div[2]/div[1]/div/div/div/dl/dt[4]")
    private WebElement genderRow;
    @FindBy (xpath = "//*[@id=\"narrow-by-list\"]/dd[4]/ol/li/a")
    private WebElement genderType;
    @FindBy (xpath = "//*[@id=\"inner-wrap\"]/div/div/div[7]/div[2]/div[2]/div[4]/ul/li[1]/a[1]")
    private WebElement firstTrainersBox;
    @FindBy (xpath = "//*[@id='nav']/ol/li[2]/ul/div[1]/li[6]/a")
    private WebElement shoesBox;

    //Set FindPageCrumbs driver
    public FindPageCrumbs(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on Clothes link button on webpage HomePage
    private void clickManClothesOnNavigationBar(){
        Actions action = new Actions(this.driver);
        WebElement menClothesLink = this.linkMenClothes;
        action.moveToElement(menClothesLink).moveToElement(this.shoesBox).click().build().perform();
    }

    //Click on Gender row
    private void clickOnGender(){
        this.genderRow.click();
    }

    //Choose gender type
    private void chooseGenderType(){
        this.genderType.click();
    }

    //Click on first trainers
    private void chooseFirstTrainers(){
        this.firstTrainersBox.click();
    }

    public void findPageCrumbs() {
        this.clickManClothesOnNavigationBar();
        this.wait.until(ExpectedConditions.visibilityOf(this.genderRow));
        this.clickOnGender();
        this.wait.until(ExpectedConditions.visibilityOf(this.genderType));
        this.chooseGenderType();
        this.wait.until(ExpectedConditions.visibilityOf(this.firstTrainersBox));
        this.chooseFirstTrainers();
    }
}
