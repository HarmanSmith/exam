package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    private By flightsButton = By.xpath("//a[@href='?pwaLob=wizard-flight-pwa']");
    private By departureBox = By.xpath("//button[@aria-label='Leaving from']");
    private By destinationBox = By.xpath("//button[@aria-label='Going to']");
    private By departureInput = By.xpath("//input[@data-stid='location-field-leg1-origin-dialog-input']");
    private By destinationInput = By.xpath("//button[@aria-label='Going to']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //waiting
    public void wait1Second(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    //clicks
    public void clickFlights(){
        driver.findElement(flightsButton).click();
    }
    public void clickDepartureButton(){
        driver.findElement(departureBox).click();
    }
    public void clickDestinationButton(){
        driver.findElement(destinationBox).click();
    }

    //typing
    public void typeDeparture(String departure){
        driver.findElement(departureInput).sendKeys( departure + Keys.ENTER);
    }
    public void typeDestination(String destination){
        driver.findElement(destinationInput).sendKeys( destination + Keys.ENTER);
    }

}
