package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsCheckoutPage extends BasePage{

    public HotelsCheckoutPage(WebDriver driver){super(driver);}
    @FindBy(xpath="//span[@class='amount-value']")
    WebElement hotelPrice;
    @FindBy(xpath="//span[@class='rating-out-of-five']")
    WebElement hotelRating;
    @FindBy(xpath="//span[@class='check-in']")
    WebElement checkInTitle;
    @FindBy(xpath="//span[@class='room-count']")
    WebElement roomCount;
    @FindBy(id="complete-booking")
    WebElement completeBookingButton;
    public boolean checkHotelPrice(){
        return this.getWait().until(ExpectedConditions.visibilityOf(hotelPrice)).isDisplayed();
    }
    public boolean checkHotelRating(){
        return this.getWait().until(ExpectedConditions.visibilityOf(hotelRating)).isDisplayed();
    }
    public boolean checkCheckInTitle(){
        return this.getWait().until(ExpectedConditions.visibilityOf(checkInTitle)).isDisplayed();
    }
    public boolean checkRoomCount(){
        return this.getWait().until(ExpectedConditions.visibilityOf(roomCount)).isDisplayed();
    }
    public boolean checkCompleteBookingButton(){
        scrollDown(20);
        return this.getWait().until(ExpectedConditions.visibilityOf(completeBookingButton)).isDisplayed();
    }


}
