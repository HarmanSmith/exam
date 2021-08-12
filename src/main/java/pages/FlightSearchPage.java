package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightSearchPage extends BasePage{
    private WebDriver driver;//extends BasePage?

    public FlightSearchPage(WebDriver driver){
        super(driver);
        System.out.println("1");
    }
    //Dropdown
    @FindBy (id = "listings-sort")
    WebElement sortDropdown;
    //private By sortDropdown = new By.ById("listings-sort");

    public String getDropdownText(){
        //return driver.findElement(sortDropdown).getText();
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.sortDropdown)).getText();
    }
}
