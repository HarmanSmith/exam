package exercises;

import base.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.HomePage;
import java.util.regex.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTests {

    private String destination = "のLAX";// Unicode ftw ;)
    private String origin = "LAS";
    private String firstResult = " ";
    private String secondResult = " ";
    private String thirdResult = " ";
    private String fourthResult = " ";
    private String fifthResult = " ";

    @Test
    public void setDestination(){
        homePage.clickFlights();
        //homePage.clickRoundtripButton();
        homePage.clickDepartureButton();
        homePage.typeDeparture(origin);
        homePage.clickDestinationButton();
        homePage.typeDestination(destination);
        homePage.clickFlightsCalendarFrom();
        //waitMethod(1);
        homePage.clickFlightsCalendarNextMonth();
        //waitMethod(1);
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarDayStart();
        homePage.clickFlightsCalendarDayEnd();
        homePage.clickFlightsCalendarApply();

        FlightSearchPage flightSearchPage = homePage.clickFlightSearch();

        System.out.println("Dropdown Elements: \n ----- \n" + flightSearchPage.getDropdownText()+"\n ------- ");//Imprimimos el dropdown
        flightSearchPage.selectDropdown("Price (Lowest)");
        assertTrue(checkDuration(flightSearchPage, 1));//Is duration field displayed?
        assertTrue(checkSelectButton(flightSearchPage));//Is select button clickable?
        assertTrue(checkBaggage(flightSearchPage, 1)); //Is baggage displayed?
        checkList(flightSearchPage, 1);//Get variables
        assertTrue(isOrderedLowest(firstResult, secondResult, thirdResult, fourthResult, fifthResult));//Assert by checking first second and third flights are in order!
        flightSearchPage.selectDropdown("Price (Highest)");
        assertTrue(checkDuration(flightSearchPage, 2));
        assertTrue(checkSelectButton(flightSearchPage));
        assertTrue(checkBaggage(flightSearchPage, 2));
        checkList(flightSearchPage, 2);
        assertTrue(isOrderedHighest(firstResult, secondResult, thirdResult, fourthResult, fifthResult));
    }

    //METODO: checkear ordenados por lowest
    private boolean isOrderedLowest(String first, String second, String third, String fourth, String fifth){
        int firstInt = 0;
        int secondInt = 0;
        int thirdInt = 0;
        int fourthInt = 0;
        int fifthInt = 0;
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
        if(firstInt < secondInt){
            System.out.println("Lowest ordered correct: first check pass");
            return true;
        }else if(secondInt < thirdInt){
            System.out.println("Lowest ordered correct: second check pass");
            return true;
        }else if(thirdInt < fourthInt){
            System.out.println("Lowest ordered correct: third check pass");
            return true;
        }else if(fourthInt < fifthInt){
            System.out.println("Lowest ordered correct: fourth check pass");
            return true;
        }
        System.out.println("Lowest ordered incorrect: didn't pass 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
        return false;
    }
    private boolean isOrderedHighest(String first, String second, String third, String fourth, String fifth){
        int firstInt = 0;
        int secondInt = 0;
        int thirdInt = 0;
        int fourthInt = 0;
        int fifthInt = 0;
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
            //System.out.println("Numbers 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
            System.out.println("Highest ordered correct: first check pass");
            return true;
        }else if(secondInt > thirdInt){
            //System.out.println("Numbers 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
            System.out.println("Highest ordered correct: second check pass");
            return true;
        }else if(thirdInt > fourthInt){
            //System.out.println("Numbers 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
            System.out.println("Highest ordered correct: third check pass");
            return true;
        }else if(fourthInt > fifthInt){
            //System.out.println("Numbers 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
            System.out.println("Highest ordered correct: fourth check pass");
            return true;
        }
        System.out.println("Highest ordered incorrect: didn't pass. 1°_" + firstInt + " 2°_" + secondInt + " 3°_" + thirdInt + " 4°_" + fourthInt + " 5°_" + fifthInt);
        return false;
    }
    private void checkList(FlightSearchPage flightSearchPage, int setting){
                flightSearchPage.clickFirstResult();
                this.firstResult = flightSearchPage.getFlightPrice(setting);
                System.out.println(this.firstResult);
                //flightSearchPage.clickCloseFlightPanel(setting);
                flightSearchPage.clickSecondResult();
                this.secondResult = flightSearchPage.getFlightPrice(setting);
                System.out.println(this.secondResult);
                //flightSearchPage.clickCloseFlightPanel(setting);
                flightSearchPage.clickThirdResult();
                this.thirdResult = flightSearchPage.getFlightPrice(setting);
                System.out.println(this.thirdResult);
                //flightSearchPage.clickCloseFlightPanel(setting);
                flightSearchPage.clickFourthResult();
                this.fourthResult = flightSearchPage.getFlightPrice(setting);
                System.out.println(this.fourthResult);
                //flightSearchPage.clickCloseFlightPanel(setting);
                flightSearchPage.clickFifthResult();
                this.fifthResult = flightSearchPage.getFlightPrice(setting);
                System.out.println(this.fifthResult);
                //flightSearchPage.clickCloseFlightPanel(setting);
    }
    private boolean checkDuration(FlightSearchPage flightSearchPage, int option){
        int contador = 0;
        switch(option){
            case 1:
            flightSearchPage.clickFirstResult();
            contador = contador + durationAdd(flightSearchPage);
            flightSearchPage.clickSecondResult();
            contador = contador + durationAdd(flightSearchPage);
            flightSearchPage.clickThirdResult();
            contador = contador + durationAdd(flightSearchPage);
            flightSearchPage.clickFourthResult();
            contador = contador + durationAdd(flightSearchPage);
            flightSearchPage.clickFifthResult();
            contador = contador + durationAdd(flightSearchPage);
            if(contador >= 5){
                System.out.println("Duration OK - Ordered Lowest");
                return true;}
            else{return false;}
            case 2:
                flightSearchPage.clickFirstResult();
                contador = contador + durationAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickSecondResult();
                contador = contador + durationAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickThirdResult();
                contador = contador + durationAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickFourthResult();
                contador = contador + durationAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickFifthResult();
                contador = contador + durationAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                if(contador >= 5){
                    System.out.println("Duration OK - Ordered Highest");
                    return true;}
                else{return false;}
            default:
                return false;
        }

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
    private int baggageAdd(FlightSearchPage flightSearchPage){
        if(flightSearchPage.getFlightBaggageButton().isDisplayed()){
            //System.out.println("Select button found");
            return 1;
        }else{
            //System.out.println("select not found");
            return 0;}
    }
    private int baggageAddAlt(FlightSearchPage flightSearchPage){
        if(flightSearchPage.getFlightBaggageButtonAlt().isDisplayed()){
            //System.out.println("Select button found");
            return 1;
        }else{
            //System.out.println("select not found");
            return 0;}
    }
    private boolean checkSelectButton(FlightSearchPage flightSearchPage){
        int contador = 0;
        flightSearchPage.clickFirstResult();
        contador = contador + selectAdd(flightSearchPage);
        flightSearchPage.clickCloseFlightPanel(1);
        flightSearchPage.clickSecondResult();
        contador = contador + selectAdd(flightSearchPage);
        flightSearchPage.clickCloseFlightPanel(1);
        flightSearchPage.clickThirdResult();
        contador = contador + selectAdd(flightSearchPage);
        flightSearchPage.clickCloseFlightPanel(1);
        flightSearchPage.clickFourthResult();
        contador = contador + selectAdd(flightSearchPage);
        flightSearchPage.clickCloseFlightPanel(1);
        flightSearchPage.clickFifthResult();
        contador = contador + selectAdd(flightSearchPage);
        flightSearchPage.clickCloseFlightPanel(1);
        if(contador >= 5){
            System.out.println("Select Button OK");
            return true;}
        else{return false;}
    }
    private boolean checkBaggage(FlightSearchPage flightSearchPage, int option){
        int contador = 0;
        switch(option) {
            case 1:
                flightSearchPage.clickFirstResult();
                contador = contador + baggageAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickSecondResult();
                contador = contador + baggageAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickThirdResult();
                contador = contador + baggageAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickFourthResult();
                contador = contador + baggageAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickFifthResult();
                contador = contador + baggageAdd(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                if (contador >= 5) {
                    System.out.println("Baggage OK - Ordered lowest");
                    return true;
                } else {
                    return false;
                }
            case 2:
                flightSearchPage.clickFirstResult();
                contador = contador + baggageAddAlt(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickSecondResult();
                contador = contador + baggageAddAlt(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickThirdResult();
                contador = contador + baggageAddAlt(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickFourthResult();
                contador = contador + baggageAddAlt(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                flightSearchPage.clickFifthResult();
                contador = contador + baggageAddAlt(flightSearchPage);
                flightSearchPage.clickCloseFlightPanel(1);
                if (contador >= 5) {
                    System.out.println("Baggage OK - Ordered Highest");
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    /*private int durationAddAlternative(FlightSearchPage flightSearchPage){
        System.out.println("Duration text 2: " + flightSearchPage.getFlightDuration().getText());
        if(flightSearchPage.getFlightDurationAlternative().getText() != null){
            return 1;
        }else{return 0;}
    }*/
}
