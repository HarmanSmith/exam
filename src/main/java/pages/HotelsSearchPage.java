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
    @FindBy(xpath="//span[@data-stid='price-lockup-text']")
    //@FindBy(xpath="//*[@id='app-layer-base']/div/main/div/div/div[1]/section/div[2]/div/div[2]/section[2]/ol/li[34]/div/div/div[2]/div/div[2]/div[2]/div/div/div[1]/span/span'")
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
    public int getListSize(){
        return this.resultCards.size();
    }

    private String getPriceString(int index){
        scrollDown(2);
        getWait().until(ExpectedConditions.visibilityOf(this.resultCards.get(index)));
        if(index<=resultCards.size()){
            return resultCards.get(index).getText();
        }else{
        return "0";}
    }

    private int getFlightPrice(String price){
        int contenedor = 0;
        Pattern p = Pattern.compile("\\d+");//Parse STRINGS with $ symbols into INT variables
        Matcher m = p.matcher(price);//pasamos el primer string al matcher m
        while(m.find()) {
            contenedor = Integer.parseInt(m.group());//lo guardamos como INT
        }
        return contenedor;
    }


    public boolean checkOrderedLowest(){
        int firstInt = getFlightPrice(getPriceString(0));
        int secondInt = getFlightPrice(getPriceString(1));
        if(firstInt < secondInt){
            System.out.println("Lowest: Pass on first check");
            return true;
        }else{
            int thirdInt = getFlightPrice(getPriceString(2));
            if(secondInt<thirdInt){
                System.out.println("Lowest: Pass on second check");
                return true;
            }else{
                int fourthInt=getFlightPrice(getPriceString(3));
                if(thirdInt<fourthInt){
                    System.out.println("Lowest: Pass on third check");
                    return true;
                }else{
                    int fifthInt=getFlightPrice(getPriceString(4));
                    if(fourthInt<fifthInt){
                        System.out.println("Lowest: Pass on fourth check");
                        return true;
                    }else{
                        System.out.println("Lowest: something went wrong with ordering");
                        return false;
                    }
                }
            }
        }
    }
       /*public boolean clickResult(int index){
        this.getWait().until(ExpectedConditions.visibilityOfAllElements(this.resultCards));
        if(this.resultCards.size()>=index){
            this.getWait().until(ExpectedConditions.elementToBeClickable(resultCards.get(index))).click();
            //return this.getWait().until(ExpectedConditions.visibilityOf(this.flightSelectButton)).isDisplayed();
            //return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightSelectButton)).isDisplayed();
            return true;
        }else{
            return false;
        }
    }*/
}
