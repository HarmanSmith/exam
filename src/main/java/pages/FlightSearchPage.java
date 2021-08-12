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
    }
    //Dropdown
    @FindBy (id = "listings-sort")
    WebElement sortDropdown;
    //private By sortDropdown = new By.ById("listings-sort");

    @FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[1]")
    WebElement firstResult;
    @FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[2]")
    WebElement secondResult;
    @FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[3]")
    WebElement thirdResult;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li/div/div/div[1]/div/div/span/div/section/span[1]")
    WebElement flightPrice;

    public String getDropdownText(){
        //return driver.findElement(sortDropdown).getText();
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.sortDropdown)).getText();
    }
    public void clickDropdown(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.sortDropdown)).click();
    }
    public void clickFirstResult(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.firstResult)).click();
    }
    public void clickSecondResult(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.secondResult)).click();
    }
    public void clickThirdResult(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.thirdResult)).click();
    }
    public String getFlightPrice(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightPrice)).getText();
    }
}
