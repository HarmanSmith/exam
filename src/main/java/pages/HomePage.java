package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
    }

    //Tabs clicks
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-flight-pwa']")
    WebElement flightsButton;
    @FindBy(xpath = "//a[@href='?pwaLob=wizard-hotel-pwa-v2']")
    WebElement hotelButton;
    @FindBy(xpath ="//a[@href='?pwaLob=wizard-cruise-pwa']" )
    WebElement cruisesButton;

    //Flights tab buttons
    @FindBy(xpath = "//a[@href='?flightType=roundtrip']")
    WebElement flightsRoundtripButton;
    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    WebElement flightsDepartureBox;
    @FindBy(xpath = "//button[@aria-label='Going to']")
    WebElement flightsDestinationBox;
    @FindBy(xpath = "//input[@placeholder='Where are you leaving from?']")
    WebElement flightsDepartureInput;
    @FindBy(xpath = "//button[@aria-label='Going to']")
    WebElement flightsDestinationInput;
    @FindBy(id = "add-hotel-checkbox")
    WebElement flightsAddHotel;
    @FindBy(css = "[data-testid='submit-button']")
    WebElement flightsSearch;

    //Flights Calendar buttons
    @FindBy (id = "d1-btn")
    WebElement flightsCalendarFrom;
    @FindBy (id = "d2-btn")
    WebElement flightsCalendarTo;
    @FindBy(xpath="(//div//button[contains(@data-stid,'date-picker-paging')])[2]")
    WebElement flightsCalendarNextMonth;
    @FindBy(css = "[data-day='1']")
    WebElement flightsCalendarDayStart;
    @FindBy(css = "[data-day='7']")
    WebElement flightsCalendarDayEnd;
    @FindBy(xpath = "(//div//button[contains(@data-stid,'apply-date-picker')])")
    WebElement flightsCalendarApply;

    //flight+hotel page missing?



    //clicks
    public void clickFlights(){
        //driver.findElement(flightsButton).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsButton)).click();
    }
    public void clickHotels(){
        //driver.findElement(hotelButton).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.hotelButton)).click();
    }
    public void clickCruises(){
        //driver.findElement(cruisesButton).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruisesButton)).click();
    }
    public void clickRoundtripButton(){
        //driver.findElement(flightsRoundtripButton).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsRoundtripButton)).click();
    }
    public void clickDepartureButton(){
        //driver.findElement(flightsDepartureBox).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDepartureBox)).click();
    }
    public void clickDestinationButton(){
        //driver.findElement(flightsDestinationBox).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDestinationBox)).click();
    }
    public void clickAddHotel(){
        //driver.findElement(flightsAddHotel).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsAddHotel)).click();
    }
    public void clickFlightsCalendarFrom(){
        //driver.findElement(flightsCalendarFrom).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarFrom)).click();
    }
    public void clickFlightsCalendarTo(){
        //driver.findElement(flightsCalendarTo).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarTo)).click();
    }
    public void clickFlightsCalendarNextMonth(){
        //driver.findElement(flightsCalendarNextMonth).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarNextMonth)).click();
    }
    public void clickFlightsCalendarDayStart() {
        //driver.findElement(flightsCalendarDayStart).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarDayStart)).click();
    }
    public void clickFlightsCalendarDayEnd() {
        //driver.findElement(flightsCalendarDayEnd).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarDayEnd)).click();
    }
    public void clickFlightsCalendarApply(){
        //driver.findElement(flightsCalendarApply).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarApply)).click();
    }
    public FlightSearchPage clickFlightSearch(){
        //driver.findElement(flightsSearch).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsSearch)).click();
        return new FlightSearchPage(driver);
    }
    //typing
    public void typeDeparture(String departure){
        //driver.findElement(flightsDepartureInput).sendKeys( departure + Keys.ENTER);
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDepartureInput)).sendKeys(departure + Keys.ENTER);
    }
    public void typeDestination(String destination){
        //driver.findElement(flightsDestinationInput).sendKeys( destination + Keys.ENTER);
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDestinationInput)).sendKeys(destination + Keys.ENTER);
    }

}
