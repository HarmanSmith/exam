package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    @FindBy(xpath="//button[@data-stid='date-picker-paging'][1]")
    WebElement flightsCalendarPreviousMonth;
    @FindBy(css = "[data-day='1']")
    WebElement flightsCalendarDayStart;
    @FindBy(css = "[data-day='7']")
    WebElement flightsCalendarDayEnd;
    @FindBy(css = "[data-day='13']")
    WebElement flightsCalendarDayEnd_Exercise2;

    @FindBy(xpath = "(//div//button[contains(@data-stid,'apply-date-picker')])")
    WebElement flightsCalendarApply;

    //Cruises
    @FindBy(id ="cruise-destination")
    WebElement cruiseDestination;
    @FindBy(id ="d1-btn")
    WebElement cruiseDepartureButton;
    @FindBy(xpath="//button[@class='uitk-button uitk-button-medium uitk-button-only-icon uitk-flex-item uitk-button-paging'][1]")
    WebElement cruisePreviousMonth;
    @FindBy(xpath="//button[@class='uitk-button uitk-button-medium uitk-button-only-icon uitk-flex-item uitk-button-paging'][2]")
    WebElement cruiseNextMonth;
    @FindBy(xpath="//button[@class='uitk-date-picker-day uitk-new-date-picker-day'][1]")
    WebElement cruiseSelectDay;
    @FindBy(xpath="//button[@data-stid='apply-date-picker']")
    WebElement cruiseConfirmDate;
    @FindBy(xpath="//button[@data-testid='submit-button']")
    WebElement cruiseSearch;


    //Other
    @FindBy(xpath = "//a[@href='#id-roundtrip-error']")
    WebElement dateErrorLink;
    @FindBy(id = "d2-error")
    WebElement dateReturningErrorText;
    @FindBy(id ="d1-error")
    WebElement dateHotelErrorText;


    //error messages
    public boolean getDateError(){
        return this.getWait().until(ExpectedConditions.visibilityOf(this.dateErrorLink)).isDisplayed();
    }
    public boolean getReturnDateErrorText(){
        return this.getWait().until(ExpectedConditions.visibilityOf(this.dateReturningErrorText)).isDisplayed();
    }
    public boolean getHotelErrorText(){
        return this.getWait().until(ExpectedConditions.visibilityOf(this.dateHotelErrorText)).isDisplayed();
    }
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
        //this.scrollDown(2);
        //this.scrollUp(2);
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsAddHotel)).click();
        this.flightsAddHotel.click();
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
    public void clickFlightsCalendarPreviousMonth(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightsCalendarPreviousMonth)).click();
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
    public void clickFlightSearch_Exercise4(){
        this.flightsSearch.click();
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
    public void cruiseSelectDropdown(String option){
        System.out.println("Option: " + option);
        Select dropdownElement = new Select(this.cruiseDestination);
        dropdownElement.selectByVisibleText(option);
    }
    public void clickCruiseDeparture(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruiseDepartureButton)).click();
    }
    public void clickCruiseNextMonth(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruiseNextMonth)).click();
    }
    public void clickCruiseDay(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruiseSelectDay)).click();
    }
    public void clickCruiseConfirmDate(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruiseConfirmDate)).click();
    }
    public CruiseSearchPage clickCruiseSearch(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.cruiseSearch)).click();
        return new CruiseSearchPage(this.driver);
    }

}
