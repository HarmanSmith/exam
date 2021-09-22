package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CruiseCabinPage extends BasePage {
    public CruiseCabinPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//span[@class='ship-name']")
    WebElement shipName;
    @FindBy(xpath="//span[@class='sailing-departing-on']")
    WebElement shipDeparting;
    @FindBy(xpath="//span[@class='sailing-returning-on']")
    WebElement shipReturning;

    public boolean checkShipNameIsPresent(){
        return getWait().until(ExpectedConditions.visibilityOf(shipName)).isDisplayed();
    }
    public boolean checkShipDepartureIsPresent(){
        return getWait().until(ExpectedConditions.visibilityOf(shipDeparting)).isDisplayed();
    }
    public boolean checkShipReturnIsPresent(){
        return getWait().until(ExpectedConditions.visibilityOf(shipReturning)).isDisplayed();
    }
}
