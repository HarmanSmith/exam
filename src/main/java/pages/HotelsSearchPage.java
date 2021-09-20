package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelsSearchPage extends BasePage{
    public HotelsSearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//img[@alt='travelocity logo']")
    WebElement travelocityLogo;
    @FindBy(id = "sort")
    WebElement sortDropdown;
    @FindBy (id="undefined__btn")
    WebElement travelersButton;
    @FindBy(xpath = "//button[@aria-label='Search by property name']")
    WebElement propertyNameSearchBox;
    @FindBy(xpath = "//h3[@class='uitk-heading-5']")
    WebElement filterArea;
    @FindBy(xpath="//a[@data-stid='open-hotel-information'] ")
    List<WebElement> resultCards;

    public boolean checkLogo(){
        return this.getWait().until(ExpectedConditions.visibilityOf(travelocityLogo)).isDisplayed();
    }
    public boolean checkSortDropdown(){
        return this.getWait().until(ExpectedConditions.visibilityOf(sortDropdown)).isDisplayed();
    }
    public boolean checkTravelersButton(){
        return this.getWait().until(ExpectedConditions.visibilityOf(travelersButton)).isDisplayed();
    }
    public boolean checkPropertyNameSearchBox(){
        return this.getWait().until(ExpectedConditions.visibilityOf(propertyNameSearchBox)).isDisplayed();
    }
    public boolean checkFilterArea(){
        return this.getWait().until(ExpectedConditions.visibilityOf(filterArea)).isDisplayed();
    }
    public String getDropdownText(){
        //return driver.findElement(sortDropdown).getText();
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.sortDropdown)).getText();
    }
    public void selectDropdown(String option){
        System.out.println("Option: " + option);
        Select dropdownElement = new Select(this.sortDropdown);
        dropdownElement.selectByVisibleText(option);
    }
    public boolean clickResult(int index){
        this.getWait().until(ExpectedConditions.visibilityOfAllElements(this.resultCards));
        if(this.resultCards.size()>=index){
            this.getWait().until(ExpectedConditions.elementToBeClickable(resultCards.get(index))).click();
            //return this.getWait().until(ExpectedConditions.visibilityOf(this.flightSelectButton)).isDisplayed();
            //return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightSelectButton)).isDisplayed();
            return true;
        }else{
            return false;
        }
    }
    private String getFlightPrice(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightPrice)).getText();
    }


    public boolean checkOrderedLowest(){
        String firstResult = " ";
        String secondResult = " ";
        String thirdResult = " ";
        String fourthResult = " ";
        String fifthResult = " ";
        int firstInt = 0;
        int secondInt= 0;
        int thirdInt = 0;
        int fourthInt = 0;
        int fifthInt = 0;
        /*-Retrieve prices from each result-*/
        this.clickResult(0);
        firstResult = this.getFlightPrice();
        System.out.println(firstResult);
        this.clickCloseFlightPanel();
        this.scrollDown(scrollDownTimes);
        this.clickResult(1);
        secondResult = this.getFlightPrice();
        System.out.println(secondResult);
        this.clickCloseFlightPanel();
        Pattern p = Pattern.compile("\\d+");//Parse STRINGS with $ symbols into INT variables
        Matcher m = p.matcher(firstResult);//pasamos el primer string al matcher m
        while(m.find()) {
            firstInt = Integer.parseInt(m.group());//lo guardamos como INT
        }
        m = p.matcher(secondResult);
        while(m.find()) {
            secondInt = Integer.parseInt(m.group());
        }

        if(firstInt < secondInt){
            System.out.println("Lowest ordered correct: passed on second first check");
            scrollUp(scrollUpTimes);
            return true;
        }else {
        }
    }
}
