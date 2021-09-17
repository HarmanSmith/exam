package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightSummaryPage extends BasePage{
    public FlightSummaryPage(WebDriver driver){
        super(driver);
    }


    @FindBy (xpath = "//span[@class='uitk-text uitk-type-500 uitk-type-bold uitk-text-emphasis-theme']")
    WebElement totalPrice;

    @FindBy (xpath = "//div[@class='uitk-card-content-section uitk-card-content-section-border-block-end uitk-card-content-section-padded uitk-spacing uitk-spacing-padding-blockend-three uitk-spacing-padding-inline-three'")
    WebElement departureInformation;
    @FindBy (xpath = "//div[@class='uitk-card-content-section uitk-card-content-section-border-block-end uitk-card-content-section-padded uitk-spacing uitk-spacing-padding-blockend-three uitk-spacing-padding-inline-three']")
    WebElement returnInformation;

    @FindBy (xpath = "//button[@data-test-id='goto-checkout-button'")
    WebElement checkoutButton;

    public WhosTravellingPage clickCheckout(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new WhosTravellingPage(this.driver);
    }
    public boolean priceExists(){
        return this.getWait().until(ExpectedConditions.visibilityOf(totalPrice)).isDisplayed();
    }
    public void switchTabs(){
        ArrayList<String> newTb = new ArrayList<String>(this.driver.getWindowHandles());
        //switch to new tab
        this.driver.switchTo().window(newTb.get(1));
    }
    public boolean checkDepartureInformation(){
        return this.getWait().until(ExpectedConditions.visibilityOf(departureInformation)).isDisplayed();
    }
    public boolean checkReturnInformation(){
        return this.getWait().until(ExpectedConditions.visibilityOf(returnInformation)).isDisplayed();
    }
}
/* Old code
*
*
    public void printSomethingDebug(){
        System.out.println(this.getWait().until(ExpectedConditions.visibilityOf(totalPrice)).getText());
    }
*
*
*
* */