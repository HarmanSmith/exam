package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends BasePage{
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
    @FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[4]")
    WebElement fourthResult;
    @FindBy (xpath = "(//div//div//div//button[contains(@class,'uitk-card-link')])[5]")
    WebElement fifthResult;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li/div/div/div[1]/div/div/span/div/section/span[1]")
    WebElement flightPrice;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li[1]/div/button")
    WebElement flightPriceAlt;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[1]/button")
    WebElement closeFlightPanel;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[2]/div[1]/h3")
    WebElement flightDuration;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[2]/div[1]/h3")
    WebElement flightDurationAlternative;
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/footer/div/button[1]")
    WebElement flightSelectButton;

    public String getDropdownText(){
        //return driver.findElement(sortDropdown).getText();
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.sortDropdown)).getText();
    }
    public void selectDropdown(String option){
        System.out.println("Checking first 5 elements: " + option);
        Select dropdownelement = new Select(this.sortDropdown);
        dropdownelement.selectByVisibleText(option);
        //return new FlightSearchPage(this.driver);
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
    public void clickFourthResult(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.fourthResult)).click();
    }
    public void clickFifthResult(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.fifthResult)).click();
    }

    public void clickCloseFlightPanel(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.closeFlightPanel)).click();
    }

    public String getFlightPrice(int setting){
        switch(setting){
            case 1:
                //System.out.println("Entered Case 1");
                return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightPrice)).getText();
            case 2:
                //System.out.println("Entered Case 2");
                String panelText = this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightPriceAlt)).getText();
                clickCloseFlightPanel();
                //System.out.println(panelText);
                return panelText;
            default:
                System.out.println("Missing getFlightPrice setting number");
                return "Error";
        }

    }
    public WebElement getFlightDuration(){
        return this.flightDuration;
    }
    public WebElement getFlightSelectButton(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightSelectButton));
    }
    public WebElement getFlightDurationAlternative(){
        return this.flightDurationAlternative;
    }

}
