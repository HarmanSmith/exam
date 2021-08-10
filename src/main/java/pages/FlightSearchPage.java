package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchPage {
    private WebDriver driver;//extends BasePage?

    //constructor with inheritancy?
    public FlightSearchPage(WebDriver driver){
        this.driver = driver;
    }
    private By sortDropdown = new By.ById("listings-sort");

    public String getDropdownText(){
        return driver.findElement(sortDropdown).getText();
    }
}
