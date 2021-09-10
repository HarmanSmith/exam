package pages;

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

    private String firstResult = " ";
    private String secondResult = " ";
    private String thirdResult = " ";
    private String fourthResult = " ";
    private String fifthResult = " ";

    //Optimized Xpath
    @FindBy (id = "listings-sort")
    WebElement sortDropdown;
    @FindBy (xpath = "(//button[contains(@class,'uitk-card-link')])")
    List<WebElement> flightResults;

    @FindBy (xpath = "//button[@data-test-id='fare-type-select']")
    List<WebElement> flightPrice;
    @FindBy (xpath = "//button[@data-icon='tool-close']")
    WebElement closeFlightPanel;
    @FindBy (xpath = "//h3[@class='uitk-heading-7 uitk-flex-item']")
    WebElement flightDuration;
    @FindBy (xpath = "//button[@data-test-id='select-button']")
    WebElement flightSelectButton;
    @FindBy (xpath = "//td[@class='uitk-table-react-cell uitk-spacing uitk-spacing-padding-blockstart-three uitk-table-react-cell-border-none uitk-table-react-cell-textalign-right uitk-table-react-cell-verticalalign-top']//span[@class='uitk-text uitk-type-300']")
    List<WebElement> flightBaggageButton;



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

    //--------------ACCESSING RESULT USING LIST
    public boolean clickResult(int index){
        this.getWait().until(ExpectedConditions.visibilityOfAllElements(this.flightResults));
        if(this.flightResults.size()>index){
            this.flightResults.get(index).click();
            return this.getWait().until(ExpectedConditions.visibilityOf(this.flightSelectButton)).isDisplayed();
        }else{
            return false;
        }
    }

    private void clickCloseFlightPanel(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.closeFlightPanel)).click();
    }

    public String getFlightPrice(int index){
        //System.out.println("Entered Case 1");
        return this.getWait().until(ExpectedConditions.elementToBeClickable(this.flightPrice.get(index))).getText();
    }

    public WebElement getFlightSelectButton(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightSelectButton));
    }

    public boolean isOrderedLowest(){
        int firstInt = 0;
        String first = " ";
        int secondInt = 0;
        String second = " ";
        int thirdInt = 0;
        String third = " ";
        int fourthInt = 0;
        String fourth = " ";
        int fifthInt = 0;
        String fifth = " ";
        //Parse STRINGS with $ symbols into INT variables
        Pattern p = Pattern.compile("\\d+");
        //pasamos el primer string al matcher m
        Matcher m = p.matcher(first);
        while(m.find()) {
            //lo guardamos como INT
            firstInt = Integer.parseInt(m.group());
        }
        m = p.matcher(second);
        while(m.find()) {
            secondInt = Integer.parseInt(m.group());
        }
        m = p.matcher(third);
        while(m.find()) {
            thirdInt = Integer.parseInt(m.group());
        }
        m = p.matcher(fourth);
        while(m.find()) {
            fourthInt = Integer.parseInt(m.group());
        }
        m = p.matcher(fifth);
        while(m.find()) {
            fifthInt = Integer.parseInt(m.group());
        }
        if(firstInt < secondInt){
            System.out.println("Lowest ordered correct: passed on second first check");
            return true;
        }else if(secondInt < thirdInt){
            System.out.println("Lowest ordered correct: passed on second check");
            return true;
        }else if(thirdInt < fourthInt){
            System.out.println("Lowest ordered correct: passed on second third check");
            return true;
        }else if(fourthInt < fifthInt){
            System.out.println("Lowest ordered correct: passed on second fourth check");
            return true;
        }
        System.out.println("Lowest ordered incorrect: didn't pass 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
        return false;
    }
    public boolean isOrderedHighest(){
        int firstInt = 0;
        String first = " ";
        int secondInt = 0;
        String second = " ";
        int thirdInt = 0;
        String third = " ";
        int fourthInt = 0;
        String fourth = " ";
        int fifthInt = 0;
        String fifth = " ";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(first);
        while(m.find()) {
            firstInt = Integer.parseInt(m.group());
        }
        m = p.matcher(second);
        while(m.find()) {
            secondInt = Integer.parseInt(m.group());
        }
        m = p.matcher(third);
        while(m.find()) {
            thirdInt = Integer.parseInt(m.group());
        }
        m = p.matcher(fourth);
        while(m.find()) {
            fourthInt = Integer.parseInt(m.group());
        }
        m = p.matcher(fifth);
        while(m.find()) {
            fifthInt = Integer.parseInt(m.group());
        }
        if(firstInt > secondInt){
            System.out.println("Highest ordered correct: passed on second first check");
            return true;
        }else if(secondInt > thirdInt){
            System.out.println("Highest ordered correct: passed on second second check");
            return true;
        }else if(thirdInt > fourthInt){
            System.out.println("Highest ordered correct: passed on second third check");
            return true;
        }else if(fourthInt > fifthInt){
            System.out.println("Highest ordered correct: passed on second fourth check");
            return true;
        }
        System.out.println("Highest ordered incorrect: didn't pass. 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
        return false;
    }

    //TODO: CHECK IF WORKS
    public void checkList(FlightSearchPage flightSearchPage){
        flightSearchPage.clickResult(1);
        this.firstResult = flightSearchPage.getFlightPrice(1);
        System.out.println(this.firstResult);
        flightSearchPage.clickCloseFlightPanel();
        flightSearchPage.clickResult(2);
        this.secondResult = flightSearchPage.getFlightPrice(2);
        System.out.println(this.secondResult);
        flightSearchPage.clickCloseFlightPanel();
        flightSearchPage.clickResult(3);
        this.thirdResult = flightSearchPage.getFlightPrice(3);
        System.out.println(this.thirdResult);
        flightSearchPage.clickCloseFlightPanel();
        flightSearchPage.clickResult(4);
        this.fourthResult = flightSearchPage.getFlightPrice(4);
        System.out.println(this.fourthResult);
        flightSearchPage.clickCloseFlightPanel();
        flightSearchPage.clickResult(5);
        this.fifthResult = flightSearchPage.getFlightPrice(5);
        System.out.println(this.fifthResult);
        flightSearchPage.clickCloseFlightPanel();
    }
    public boolean checkDuration(FlightSearchPage flightSearchPage){
        int contador = 0;
        for(int i = 1; i < 7; i++){
            flightSearchPage.clickResult(i);
            contador = contador + durationAdd(flightSearchPage);
        }
        if(contador >= 5)
        {
        System.out.println("Duration OK - 1");
        return true;}else {
            return false;
        }
    }
    private int durationAdd(FlightSearchPage flightSearchPage){
        //System.out.println("Duration text: " + flightSearchPage.getFlightDuration().getText());
        if(flightSearchPage.getFlightDuration().isDisplayed()){
            return 1;
        }else{return 0;}
    }
    private WebElement getFlightDuration(){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightDuration));
    }
    private int selectAdd(FlightSearchPage flightSearchPage){
        if(flightSearchPage.getFlightSelectButton().isDisplayed()){
            //System.out.println("Select button found");
            return 1;
        }else{
            //System.out.println("select not found");
            return 0;}
    }


    public boolean checkSelectButton(FlightSearchPage flightSearchPage){
        int contador = 0;
        for(int i = 1; i < 7; i++){
            flightSearchPage.clickResult(i);
            contador = contador + selectAdd(flightSearchPage);
        }
        if(contador >= 5)
        {System.out.println("Select Button OK");
            return true;
        }else{return false;}
    }
    public boolean checkBaggage(FlightSearchPage flightSearchPage, int option){
        int contador = 0;
        /*switch(option) {
            case 1:*/
        for(int i = 1; i < 7; i++) {
            flightSearchPage.clickResult(i);
            contador = contador + baggageAdd(flightSearchPage, 1); //only checks first baggage option
        }
        if (contador >= 5)
        {System.out.println("Baggage OK - 2");
            return true;
        } else {return false;}
    }
    private int baggageAdd(FlightSearchPage flightSearchPage, int index){
        if(flightSearchPage.getFlightBaggageButton(index).isDisplayed()){
            //Select button found
            return 1;
        }else{
            //select not found
            return 0;}
    }
    private WebElement getFlightBaggageButton(int index){
        return this.getWait().until(ExpectedConditions.elementToBeClickable(flightBaggageButton.get(index)));
    }
}



//----------------------------------------------------------------------------------------------------------------------
//-----------------------------OLD code

//private By sortDropdown = new By.ById("listings-sort");
    /*
    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li[1]/div/button")
    WebElement flightPriceAlt;

    @FindBy (xpath= "//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/div[1]/button/svg")
    WebElement closeFlightPanelAlt;

    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div[1]/section/main/div[6]/section/div[2]/div/div[2]/div[1]/h3")
    WebElement flightDurationAlternative;

    @FindBy (xpath = "//*[@id='app-layer-base']/div[2]/div[3]/div/section/main/div[6]/section/div[2]/div/div[3]/div[3]/div/div/ul/li[1]/div/div/div[2]/table/tbody/tr[2]/td[2]/span/span")
    WebElement flightBaggageButtonAlt;

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

    */

/*public WebElement getFlightDurationAlternative(){return this.flightDurationAlternative;}*/


    /*
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
    }*/
/*    private int baggageAddAlt(FlightSearchPage flightSearchPage){
        if(flightSearchPage.getFlightBaggageButtonAlt().isDisplayed()){
            //System.out.println("Select button found");
            return 1;
        }else{
            //System.out.println("select not found");
            return 0;}
    }*/
//----------------------------------------------------------------------------------------------------------------------