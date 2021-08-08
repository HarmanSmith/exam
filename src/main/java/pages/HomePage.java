package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    //Tabs
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

    //Flights Calendar buttons
    private By flightsCalendarFrom = By.id("d1-btn");
    private By flightsCalendarTo = By.id("d2-btn");
    private By flightsCalendarNextMonth = By.xpath("//button[@data-stid='date-picker-paging']"); //not working

    //flight+hotel page missing?

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    //clicks
    public void clickFlights(){
        driver.findElement(flightsButton).click();
    }
    public void clickHotels(){
        driver.findElement(hotelButton).click();
    }
    public void clickCruises(){
        driver.findElement(cruisesButton).click();
    }
    public void clickRoundtripButton(){
        driver.findElement(flightsRoundtripButton).click();
    }
    public void clickDepartureButton(){
        driver.findElement(flightsDepartureBox).click();
    }
    public void clickDestinationButton(){
        driver.findElement(flightsDestinationBox).click();
    }
    public void clickAddHotel(){
        driver.findElement(flightsAddHotel).click();
    }
    public void clickFlightsCalendarFrom(){
        driver.findElement(flightsCalendarFrom).click();
    }
    public void clickFlightsCalendarTo(){
        driver.findElement(flightsCalendarTo).click();
    }
    public void clickFlightsCalendarNextMonth(){
        driver.findElement(flightsCalendarNextMonth).click();
    }
    //typing
    public void typeDeparture(String departure){
        driver.findElement(flightsDepartureInput).sendKeys( departure + Keys.ENTER);
    }
    public void typeDestination(String destination){
        driver.findElement(flightsDestinationInput).sendKeys( destination + Keys.ENTER);
    }

}
