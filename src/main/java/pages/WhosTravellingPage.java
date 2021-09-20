package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WhosTravellingPage extends BasePage{
    public WhosTravellingPage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//img[@alt='www.travelocity.com']")
    WebElement websiteLogo;
    @FindBy (xpath = "//h2[@class='faceoff-module-title']")
    WebElement whosTravellingHeader;
    @FindBy (id = "complete-booking")
    WebElement completeBooking;
    @FindBy (xpath = "//h3[@class='your-price-summary']")
    WebElement yourPriceSummary;
    @FindBy (id ="yes_insurance")
    WebElement insuranceCheckbox;
    public boolean checkLogo(){
    return this.getWait().until(ExpectedConditions.visibilityOf(websiteLogo)).isDisplayed();
    }
    public boolean checkCompleteBooking() {return this.getWait().until(ExpectedConditions.visibilityOf(completeBooking)).isDisplayed();}
    public boolean checkWhosTravellingHeader(){return this.getWait().until(ExpectedConditions.visibilityOf(whosTravellingHeader)).isDisplayed();}
    public boolean checkYourPriceSummary(){return this.getWait().until(ExpectedConditions.visibilityOf(yourPriceSummary)).isDisplayed();}
    public boolean checkInsuranceCheckbox(){return this.getWait().until(ExpectedConditions.visibilityOf(insuranceCheckbox)).isDisplayed();}

}
