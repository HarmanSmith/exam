package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightSummaryPage extends BasePage{
    public FlightSummaryPage(WebDriver driver){
        super(driver);
    }


    @FindBy (xpath = "//span[@class='uitk-text uitk-type-500 uitk-type-bold uitk-text-emphasis-theme']")
    WebElement totalPrice;

    @FindBy (xpath = "//h2[@class='uitk-heading-4']")
    List<WebElement> flightHeaders;

    @FindBy (xpath = "//div [@class='uitk-card-content-section uitk-card-content-section-border-block-end uitk-card-content-section-padded uitk-spacing uitk-spacing-padding-blockend-three uitk-spacing-padding-inline-three']")
    List<WebElement> flightInformation;
    /*@FindBy (xpath = "//div[@class='uitk-card-content-section uitk-card-content-section-border-block-end uitk-card-content-section-padded uitk-spacing uitk-spacing-padding-blockend-three uitk-spacing-padding-inline-three']")
    WebElement returnInformation;*/

    @FindBy (xpath = "//button[@data-test-id='goto-checkout-button']")
    WebElement checkoutButton;
    @FindBy (xpath ="//h2 [@class = 'uitk-messaging-card-section-header' and contains(text(),'fees')]")
    WebElement priceGuarantee;

    public WhosTravellingPage clickCheckout(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new WhosTravellingPage(this.driver);
    }
    public boolean priceExists(){
        return this.getWait().until(ExpectedConditions.visibilityOf(totalPrice)).isDisplayed();
    }

    public int getFlightInfoSize(){
        return flightInformation.size();
    }

    public boolean checkFlightInformation(int index){
        //scrollDown(10);
        //scrollUp(12);
        this.getWait().until(ExpectedConditions.visibilityOfAllElements(flightInformation));
        return flightInformation.get(index).isDisplayed();

    }
    public boolean checkPriceGuarantee(){
        return this.getWait().until(ExpectedConditions.visibilityOf(priceGuarantee)).isDisplayed();
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