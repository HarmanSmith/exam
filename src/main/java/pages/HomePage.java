package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
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

    //Hotel elements
    @FindBy (xpath="//button[@data-testid='travelers-field-trigger']")
    WebElement travelersButton;

    //Flights tab buttons
    @FindBy(xpath = "//a[@href='?flightType=roundtrip']")
    WebElement flightsRoundtripButton;
    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    WebElement flightsDepartureBox;
    @FindBy(xpath = "//button[@aria-label='Going to']")
    WebElement flightsDestinationBox;
    @FindBy(xpath="//button[@data-stid='location-field-destination-menu-trigger'] ")
    WebElement hotelsDestinationBox;
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
    @FindBy(css = "[data-day='13']")
    WebElement flightsCalendarDayEnd_Exercise2;

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
    public void clickFlightsCalendarDayEnd_Exercise2() {
        //driver.findElement(flightsCalendarDayEnd).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarDayEnd_Exercise2)).click();
    }

    public void clickFlightsCalendarApply(){
        //driver.findElement(flightsCalendarApply).click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarApply)).click();
    }
    public FlightSearchPage clickFlightSearch(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsSearch)).click();
        return new FlightSearchPage(this.driver);
    }
    public HotelsSearchPage clickHotelsSearch(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsSearch)).click();
        return new HotelsSearchPage(this.driver);
    }
    //checks
    public boolean travelersCheck(){
        this.getWait().until(ExpectedConditions.visibilityOf(travelersButton));
        return this.travelersButton.isDisplayed();
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
    public void clickHotelsDestinationButton(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.hotelsDestinationBox)).click();
    }
    public void typeHotelsDestination(String destination){
        //driver.findElement(flightsDestinationInput).sendKeys( destination + Keys.ENTER);

        this.getWait().until(ExpectedConditions.elementToBeClickable(this.hotelsDestinationBox)).sendKeys(destination + Keys.ENTER);

    }
}
