package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightSearchPage extends BasePage{
    public FlightSearchPage(WebDriver driver){
        super(driver);
    }

    static private int scrollUpTimes = 12;
    static private int scrollDownTimes = 3;


    @FindBy (id = "listings-sort")
    WebElement sortDropdown;

    @FindBy (xpath = "(//button[contains(@class,'uitk-card-link')])")
    List<WebElement> flightResults;

    /*@FindBy (xpath = "//button[@data-test-id='fare-type-select']")
    List<WebElement> flightPrice;*/

    @FindBy (css = "[data-test-id='details-and-fares-footer'] .uitk-lockup-price") // se puede usar css
    //@FindBy (xpath = "//div[contains(@class, 'left-align')]/section/span[contains(@class, 'lockup')]")
    WebElement flightPrice;
    @FindBy (xpath = "//button[@data-icon='tool-close']")
    WebElement closeFlightPanel;
    @FindBy (xpath = "//span[contains(@class, 'uitk-text uitk-type-300 uitk-flex-item uitk-text-emphasis-theme')]")
    WebElement flightDuration;
    @FindBy (xpath = "//button[@data-test-id='select-button']")
    WebElement flightSelectButton;
    @FindBy (xpath = "//button[contains(@data-test-id, 'select-button')]")
    WebElement flightSelectButton2;
    @FindBy (xpath = "//td[@class='uitk-table-react-cell uitk-spacing uitk-spacing-padding-blockstart-three uitk-table-react-cell-border-none uitk-table-react-cell-textalign-right uitk-table-react-cell-verticalalign-top']//span[@class='uitk-text uitk-type-300']")
    List<WebElement> flightBaggageButton;
    @FindBy (xpath = "//a[contains(@data-test-id, 'forcedChoiceNoThanks')]")
    WebElement noThanksButton;
    /*---------------Interactions with website-------------------*/
    public void selectDropdown(String option){
        System.out.println("Option: " + option);
        Select dropdownElement = new Select(this.sortDropdown);
        dropdownElement.selectByVisibleText(option);
        //return new FlightSearchPage(this.driver);
    }
    public boolean clickResult(int index){
        this.getWait().until(ExpectedConditions.visibilityOfAllElements(this.flightResults));
        if(this.flightResults.size()>=index){
            this.getWait().until(ExpectedConditions.elementToBeClickable(flightResults.get(index))).click();
            //return this.getWait().until(ExpectedConditions.visibilityOf(this.flightSelectButton)).isDisplayed();
            return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightSelectButton)).isDisplayed();
        }else{
            return false;
        }
    }
    public void clickResult2(int index){
        this.getWait().until(ExpectedConditions.elementToBeClickable(flightResults.get(index))).click();
    }

    public void clickSelectFlightButton(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightSelectButton)).click();
    }
    private void clickCloseFlightPanel(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.closeFlightPanel)).click();
    }
    public FlightSummaryPage clickNoThanks(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.noThanksButton)).click();
        return new FlightSummaryPage(this.driver);
    }
    /*public void refreshList(){
        this.flightResults = reInitializeStaleElement(flightResults);
    }*/
    /*-----------------Retrieve info---------------------*/
    public String getDropdownText(){
        //return driver.findElement(sortDropdown).getText();
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.sortDropdown)).getText();
    }
    private String getFlightPrice(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightPrice)).getText();
    }

    private WebElement getFlightBaggageButton(int index){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightBaggageButton.get(index)));
    }
    private WebElement getFlightSelectButton(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightSelectButton));
    }

    private WebElement getFlightDuration(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightDuration));
    }


    /*---------------------CHECKS-----------------------*/


    //¿are variables firstResult~etc already initialized by the time this code is run?
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

            this.scrollDown(scrollDownTimes);
            this.clickResult(2);
            thirdResult = this.getFlightPrice();
            m = p.matcher(thirdResult);
            while(m.find()) {
                thirdInt = Integer.parseInt(m.group());
            }
            System.out.println(thirdResult);
            this.clickCloseFlightPanel();
            this.scrollDown(scrollDownTimes);
            if(secondInt < thirdInt){System.out.println("Lowest ordered correct: passed on second check");
            scrollUp(scrollUpTimes);
            return true;}else {

                this.clickResult(3);
                fourthResult = this.getFlightPrice();
                System.out.println(fourthResult);

                m = p.matcher(fourthResult);
                while(m.find()) {
                    fourthInt = Integer.parseInt(m.group());
                }
                this.clickCloseFlightPanel();
                if (thirdInt < fourthInt) {
                    System.out.println("Lowest ordered correct: passed on second third check");
                    scrollUp(scrollUpTimes);
                    return true;
                } else {

                    this.scrollDown(scrollDownTimes);
                    this.clickResult(4);
                    fifthResult = this.getFlightPrice();
                    m = p.matcher(fifthResult);
                    while(m.find()) {
                        fifthInt = Integer.parseInt(m.group());
                    }
                    System.out.println(fifthResult);
                    this.clickCloseFlightPanel();
                    if (fourthInt < fifthInt) {
                        System.out.println("Lowest ordered correct: passed on second fourth check");
                        scrollUp(scrollUpTimes);
                        return true;
                    }
                }
            }
        }
        System.out.println("Lowest ordered incorrect: didn't pass 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
        scrollUp(scrollUpTimes);
        return false;
    }
    public boolean checkDuration(FlightSearchPage flightSearchPage){
        int contador = 0;
        for(int i = 0; i < 6; i++){
            flightSearchPage.clickResult(i);
            contador = contador + durationAdd(flightSearchPage);
            clickCloseFlightPanel();
        }
        if(contador >= 5)
        {
        System.out.println("Duration OK - 1");
        scrollUp(scrollUpTimes);
        return true;}else {
            scrollUp(scrollUpTimes);
            return false;
        }
    }
    public boolean checkSelectButton(FlightSearchPage flightSearchPage){
        int contador = 0;
        for(int i = 0; i < 6; i++){
            flightSearchPage.clickResult(i);
            contador = contador + selectAdd(flightSearchPage);
            clickCloseFlightPanel();
        }
        if(contador >= 5)
        {System.out.println("Select Button OK");
            //clickCloseFlightPanel();
            scrollUp(scrollUpTimes);
            return true;
        }else{
            //clickCloseFlightPanel();
            scrollUp(scrollUpTimes);
            return false;}
    }
    public boolean checkBaggage(FlightSearchPage flightSearchPage, int option){
        int contador = 0;
        for(int i = 0; i < 6; i++) {
            flightSearchPage.clickResult(i);
            contador = contador + baggageAdd(flightSearchPage, 1); //for now; only checks first baggage
            clickCloseFlightPanel();
        }
        if (contador >= 5)
        {
            System.out.println("Baggage OK - 2");
            scrollUp(scrollUpTimes);
            return true;
        } else {
            scrollUp(scrollUpTimes);
            return false;}
    }

    public boolean checkOrderedDurationShort(){
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
        scrollUp(12);
        this.clickResult(0);
        firstResult = this.getFlightDuration().getText();
        System.out.println(firstResult);
        this.clickCloseFlightPanel();
        this.scrollDown(scrollDownTimes);
        this.clickResult(1);
        secondResult = this.getFlightDuration().getText();
        System.out.println(secondResult);
        this.clickCloseFlightPanel();
        firstInt = regexDuration(firstResult);
        secondInt = regexDuration(secondResult);
        if(firstInt < secondInt){
            System.out.println("Lowest ordered correct: passed on second first check");
            scrollUp(scrollUpTimes);
            return true;
        }else {
            this.scrollDown(scrollDownTimes);
            this.clickResult(2);
            thirdResult = this.getFlightDuration().getText();
            thirdInt = regexDuration(thirdResult);
            System.out.println(thirdResult);
            this.clickCloseFlightPanel();
            if (secondInt < thirdInt) {
                System.out.println("Lowest ordered correct: passed on second check");
                scrollUp(scrollUpTimes);
                return true;
            } else {

                this.scrollDown(scrollDownTimes);
                this.clickResult(3);
                fourthResult = this.getFlightDuration().getText();
                fourthInt = regexDuration(fourthResult);
                System.out.println(fourthResult);
                this.clickCloseFlightPanel();
                if (thirdInt < fourthInt) {
                    System.out.println("Lowest ordered correct: passed on second third check");
                    scrollUp(scrollUpTimes);
                    return true;
                } else {
                    this.scrollDown(scrollDownTimes);
                    this.clickResult(4);
                    fifthResult = this.getFlightDuration().getText();
                    fifthInt = regexDuration(fifthResult);
                    System.out.println(fifthResult);
                    this.clickCloseFlightPanel();
                    if (fourthInt < fifthInt) {
                        System.out.println("Lowest ordered correct: passed on second fourth check");
                        scrollUp(scrollUpTimes);
                        return true;
                    }
                }

        }

            System.out.println("Lowest ordered incorrect: didn't pass 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
            scrollUp(scrollUpTimes);
            return false;
        }
    }

    /*---------Private utility methods---------------*/

    private int regexDuration(String unprocessedText){
        int result = 0;
        //Example String: 1h 7m (Nonstop)
        Pattern pattern = Pattern.compile("((?<hour>\\d*)h)?\\s*((?<minute>\\d*)m)?");// 2 groups minute and seconds
        Matcher matcher = pattern.matcher(unprocessedText);
        if (matcher.find())
        {
            String hourString = matcher.group("hour");
            if (hourString == null) {// in case there's no match
                hourString = "0";
            }
            String minuteString = matcher.group("minute");
            if (minuteString == null) {
                minuteString = "0";
            }
            result = Integer.parseInt(hourString)*60 + Integer.parseInt(minuteString);
        }
        return result;
    }
    private int durationAdd(FlightSearchPage flightSearchPage){
        //System.out.println("Duration text: " + flightSearchPage.getFlightDuration().getText());
        if(flightSearchPage.getFlightDuration().isDisplayed()){
            return 1;
        }else{return 0;}
    }
    private int selectAdd(FlightSearchPage flightSearchPage){
        if(flightSearchPage.getFlightSelectButton().isDisplayed()){
            //System.out.println("Select button found");
            return 1;
        }else{
            //System.out.println("select not found");
            return 0;}
    }
    private int baggageAdd(FlightSearchPage flightSearchPage, int index){
        if(flightSearchPage.getFlightBaggageButton(index).isDisplayed()){
            //Select button found
            return 1;
        }else{
            //select not found
            return 0;}
    }


}


//----------------------------------------------------------------------------------------------------------------------
//-----------------------------OLD code---------------------------------------------------------------------------------


// REGEX extract info from .getText() example below:
    /*Select and show fare information for JetBlue Airways flight, departing at 1:08pm from Las Vegas, arriving at 2:15pm
     in Los Angeles, Priced at $91 Roundtrip per traveler.  1 hour 7 minutes total travel time, Nonstop, 2 cleaning and
     safety practice.*/

//----------------------------------------------------------------------------------------------------------------------