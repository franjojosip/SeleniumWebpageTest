import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPageCrumbs {
    private WebDriver driver;
    private WebDriverWait wait;
    private By linkMenClothes = By.xpath("//*[@id=\"nav\"]/ol/li[2]/a");
    private By genderRow = By.xpath("/html/body/div[6]/div[2]/div/div/div[7]/div[2]/div[1]/div/div/div/dl/dt[4]");
    private By genderType = By.xpath("//*[@id=\"narrow-by-list\"]/dd[4]/ol/li/a");
    private By firstTrainersBox = By.xpath("//*[@id=\"inner-wrap\"]/div/div/div[7]/div[2]/div[2]/div[4]/ul/li[1]/a[1]");

    //Set FindPageCrumbs driver
    public FindPageCrumbs(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    //Click on Clothes link button on webpage HomePage
    private void clickManClothesOnNavigationBar(){
        Actions action = new Actions(this.driver);
        WebElement menClothesLink = this.driver.findElement(this.linkMenClothes);
        action.moveToElement(menClothesLink).moveToElement(driver.findElement(By.xpath("//*[@id='nav']/ol/li[2]/ul/div[1]/li[6]/a"))).click().build().perform();
    }

    //Click on Gender row
    private void clickOnGender(){
        this.driver.findElement(this.genderRow).click();
    }

    //Choose gender type
    private void chooseGenderType(){
        this.driver.findElement(this.genderType).click();
    }

    //Click on first trainers
    private void chooseFirstTrainers(){
        this.driver.findElement(this.firstTrainersBox).click();
    }

    public void findPageCrumbs() {
        this.clickManClothesOnNavigationBar();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.genderRow));
        this.clickOnGender();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.genderType));
        this.chooseGenderType();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.firstTrainersBox));
        this.chooseFirstTrainers();
    }


}
