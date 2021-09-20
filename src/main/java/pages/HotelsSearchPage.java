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
    List<WebElement> priceCards;
    @FindBy(xpath = "//span[@data-stid='content-hotel-reviews-rating']")
    List<WebElement> starsCards;
    @FindBy(xpath = "//a[@data-stid='open-hotel-information']")
    List<WebElement> buttonCards;
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
        return this.priceCards.size();
    }

    private String getPriceString(int index){
        scrollDown(2);
        getWait().until(ExpectedConditions.visibilityOf(this.priceCards.get(index)));
        if(index<=priceCards.size()){
            return priceCards.get(index).getText();
        }else{
        return "0";}
    }

    private String getStarsString(int index){
        getWait().until(ExpectedConditions.visibilityOf(this.starsCards.get(index)));
        return starsCards.get(index).getText();
    }
    private float getStarsFloat(String puntaje){
        String[] separacion = puntaje.split("/");
        float valor = Float.parseFloat(separacion[0]);
        return valor;
    }
    private int findFirst3StarsHotel(){
        float firstStars = getStarsFloat(getStarsString(0));
        if(firstStars < 3) {
            for (int i = 1; i < 15; i++) {
                scrollDown(1);
                float starsFloat = getStarsFloat(getStarsString(i));
                if(starsFloat >= 3){return i;}
            }
        } return 0;
    }
    public HotelsSummaryPage clickFirst3StarsHotel(){
        getWait().until(ExpectedConditions.visibilityOf(buttonCards.get(findFirst3StarsHotel()))).click();
        return new HotelsSummaryPage(this.driver);
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
            System.out.println("Ordered Lowest: Check passed on first check");
            return true;
        }else{
            int thirdInt = getFlightPrice(getPriceString(2));
            if(secondInt<thirdInt){
                System.out.println("Ordered Lowest: Check passed on second check");
                return true;
            }else{
                int fourthInt=getFlightPrice(getPriceString(3));
                if(thirdInt<fourthInt){
                    System.out.println("Ordered Lowest: Check passed on third check");
                    return true;
                }else{
                    int fifthInt=getFlightPrice(getPriceString(4));
                    if(fourthInt<fifthInt){
                        System.out.println("Ordered Lowest: Check passed on fourth check");
                        return true;
                    }else{
                        System.out.println("Something went wrong with ordering");
                        return false;
                    }
                }
            }
        }
    }
}
