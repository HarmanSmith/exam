package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CruiseSearchPage extends BasePage {
    public CruiseSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@class='filter-by-header']")
    WebElement filterByHeader;
    /*@FindBy (xpath = "//fieldset[@class='desktop-filter-container']")
    List<WebElement> filterFramesList;*/
    @FindBy (id= "main-results")
    WebElement resultFrame;
    //@FindBy(id = "length-15-ember874-label")
    @FindBy (xpath = "/html/body/div[2]/div[2]/div/div[3]/div[5]/aside/div/div/fieldset[2]/div/div/div/form/div/div[4]/div/label/input")
    WebElement filter10to14nights;
    //private By filter10to14nights = By.id("length-15-ember874-label");
    @FindBy(xpath = "//div[@class='flex-card']")
    List<WebElement> cruiseCards;
    @FindBy(xpath = "//a[@class='btn btn-secondary btn-action select-sailing-button']")
    List<WebElement> cruiseCardsButton;
    @FindBy(xpath = "//div[@class='promotion-tag-icon']")
    List<WebElement> discountIcon;
    @FindBy(xpath="//button[@data-opt-group='Departure Date']")
    WebElement sortByDatesButton;

    public void clickFilterTenTo14Nights() {
        //driver.switchTo().frame(resultFrame);
        getWait().until(ExpectedConditions.elementToBeClickable(this.filter10to14nights)).click();
        //this.filter10to14nights.click();
        //clickElement(filter10to14nights);
    }

    public void clickSortDates(){
        getWait().until(ExpectedConditions.elementToBeClickable(sortByDatesButton)).click();
        /*try{
            getWait().until(ExpectedConditions.visibilityOfAllElements(cruiseCards)).wait();
        }catch(Exception e){
            System.out.println("Algo ocurrió intentando esperar");
        }*/
    }
    public CruiseCabinPage clickCruiseCard(int index){
        getWait().until(ExpectedConditions.elementToBeClickable(cruiseCardsButton.get(index))).click();
        return new CruiseCabinPage(this.driver);
    }
    public boolean checkFilterByHeader() {
        return getWait().until(ExpectedConditions.visibilityOf(filterByHeader)).isDisplayed();
    }

    public boolean checkTenToFourteenNights() {
        //driver.switchTo().frame(resultFrame);
        return getWait().until(ExpectedConditions.visibilityOf(this.filter10to14nights)).isDisplayed();
        //return filter10to14nights.isDisplayed();
    }
    public boolean checkCruiseDiscounts() {
        if (getWait().until(ExpectedConditions.visibilityOf(discountIcon.get(0))).isDisplayed()) {
            System.out.println("Discount results found");
            return true;
        } else if (getWait().until(ExpectedConditions.visibilityOf(cruiseCards.get(0))).isDisplayed()) {
            System.out.println("Discount not found but regular cruises found");
            return true;
        } else {
            System.out.println("Something went wrong");
            return false;
        }
    }

    public void returnToMainFrame(){
        driver.switchTo().parentFrame();
    }

}

