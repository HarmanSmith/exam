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
    private By flightsButton = By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']");
    private By hotelButton = By.xpath("//a[@href='?pwaLob=wizard-hotel-pwa-v2']");
    private By cruisesButton = By.xpath("//a[@href='?pwaLob=wizard-cruise-pwa']");

    //Flights tab buttons
    private By flightsRoundtripButton = By.xpath("//a[@href='?flightType=roundtrip']");
    private By flightsDepartureBox = By.xpath("//button[@aria-label='Leaving from']");
    private By flightsDestinationBox = By.xpath("//button[@aria-label='Going to']");
    private By flightsDepartureInput = By.xpath("//input[@placeholder='Where are you leaving from?']");
    private By flightsDestinationInput = By.xpath("//button[@aria-label='Going to']");
    private By flightsAddHotel = By.id("add-hotel-checkbox");
    private By flightsSearch = By.cssSelector("[data-testid='submit-button']");

    //Flights Calendar buttons
    private By flightsCalendarFrom = By.id("d1-btn");
    private By flightsCalendarTo = By.id("d2-btn");
    private By flightsCalendarNextMonth = By.xpath("(//div//button[contains(@data-stid,'date-picker-paging')])[2]");
    private By flightsCalendarDayStart = By.cssSelector("[data-day='1']");
    private By flightsCalendarDayEnd = By.cssSelector("[data-day='7']");
    private By flightsCalendarApply = By.xpath("(//div//button[contains(@data-stid,'apply-date-picker')])");

    //flight+hotel page missing?



    //clicks
    public void clickFlights(){
        driver.findElement(flightsButton).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsButton)).click();
    }
    public void clickHotels(){
        driver.findElement(hotelButton).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.hotelButton)).click();
    }
    public void clickCruises(){
        driver.findElement(cruisesButton).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruisesButton)).click();
    }
    public void clickRoundtripButton(){
        driver.findElement(flightsRoundtripButton).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsRoundtripButton)).click();
    }
    public void clickDepartureButton(){
        driver.findElement(flightsDepartureBox).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDepartureBox)).click();
    }
    public void clickDestinationButton(){
        driver.findElement(flightsDestinationBox).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDestinationBox)).click();
    }
    public void clickAddHotel(){
        driver.findElement(flightsAddHotel).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsAddHotel)).click();
    }
    public void clickFlightsCalendarFrom(){
        driver.findElement(flightsCalendarFrom).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarFrom)).click();
    }
    public void clickFlightsCalendarTo(){
        driver.findElement(flightsCalendarTo).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarTo)).click();
    }
    public void clickFlightsCalendarNextMonth(){
        driver.findElement(flightsCalendarNextMonth).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarNextMonth)).click();
    }
    public void clickFlightsCalendarDayStart() {
        driver.findElement(flightsCalendarDayStart).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarDayStart)).click();
    }
    public void clickFlightsCalendarDayEnd() {
        driver.findElement(flightsCalendarDayEnd).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarDayEnd)).click();
    }
    public void clickFlightsCalendarApply(){
        driver.findElement(flightsCalendarApply).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarApply)).click();
    }
    public FlightSearchPage clickFlightSearch(){
        driver.findElement(flightsSearch).click();
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsSearch)).click();
        return new FlightSearchPage(this.driver);
    }
    //typing
    public void typeDeparture(String departure){
        driver.findElement(flightsDepartureInput).sendKeys( departure + Keys.ENTER);
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDepartureInput)).sendKeys(departure + Keys.ENTER);
    }
    public void typeDestination(String destination){
        driver.findElement(flightsDestinationInput).sendKeys( destination + Keys.ENTER);
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsDestinationInput)).sendKeys(destination + Keys.ENTER);

    }

}
