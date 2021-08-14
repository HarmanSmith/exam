package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchPage extends BasePage{
    public FlightSearchPage(WebDriver driver){
        super(driver);
    }
    //Dropdown
    //@FindBy (id = "listings-sort")
    //WebElement sortDropdown;
    private By sortDropdown = new By.ById("listings-sort");

    //@FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[1]")
    //WebElement firstResult;
    private By firstResult = By.xpath("(//div//div//div//button[contains(@class,'uitk-card-link')])[1]");


    //@FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[2]")
    //WebElement secondResult;
    private By secondResult = By.xpath("(//div//div//div//button[contains(@class,'uitk-card-link')])[2]");

    //@FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[3]")
    //WebElement thirdResult;
    private By thirdResult = By.xpath("(//div//div//div//button[contains(@class,'uitk-card-link')])[3]");
    //@FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li/div/div/div[1]/div/div/span/div/section/span[1]")
    //WebElement flightPrice;
    private By flightPrice = By.xpath("//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li/div/div/div[1]/div/div/span/div/section/span[1]");

    public String getDropdownText(){
        //return driver.findElement(sortDropdown).getText();
        return this.driver.findElement(sortDropdown).getText();
    }
    public void clickDropdown(){
        driver.findElement(sortDropdown).click();
    }
    public void clickFirstResult(){
        driver.findElement(this.firstResult).click();
    }
    public void clickSecondResult(){
        driver.findElement(secondResult).click();
    }
    public void clickThirdResult(){
        driver.findElement(this.thirdResult).click();
    }
    public String getFlightPrice(){
        return driver.findElement(this.flightPrice).getAttribute("innerHTML");
    }
}
