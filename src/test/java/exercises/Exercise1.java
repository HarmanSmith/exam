package exercises;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.HomePage;
import java.util.regex.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTests {

    private String destination = "のLAX";// Unicode ftw ;)
    private String origin = "LAS";

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

        System.out.println(flightSearchPage.getDropdownText());//Imprimimos el dropdown
        flightSearchPage.clickFirstResult();
        String firstResult = flightSearchPage.getFlightPrice();
        flightSearchPage.clickSecondResult();
        String secondResult = flightSearchPage.getFlightPrice();
        flightSearchPage.clickThirdResult();
        String thirdResult = flightSearchPage.getFlightPrice();
        flightSearchPage.clickFourthResult();
        String fourthResult = flightSearchPage.getFlightPrice();
        flightSearchPage.clickFifthResult();
        String fifthResult = flightSearchPage.getFlightPrice();

        //imprimimos resultados para ver que tal
        System.out.println(firstResult);
        System.out.println(secondResult);
        System.out.println(thirdResult);
        System.out.println(fourthResult);
        System.out.println(fifthResult);
        //OBSOLETE: assertTrue(flightSearchPage.getDropdownText().contains("Price (Lowest)"));
        //Assert by checking first second and third flights are in order!
        assertTrue(isOrderedLowest(firstResult, secondResult, thirdResult, fourthResult, fifthResult));
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
        System.out.println("Lowest ordered incorrect: didn't pass");
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
            System.out.println("Highest ordered correct: first check pass");
            return true;
        }else if(secondInt > thirdInt){
            System.out.println("Highest ordered correct: second check pass");
            return true;
        }else if(thirdInt > fourthInt){
            System.out.println("Highest ordered correct: third check pass");
            return true;
        }else if(fourthInt > fifthInt){
            System.out.println("Highest ordered correct: fourth check pass");
            return true;
        }
        System.out.println("Highest ordered incorrect: didn't pass");
        return false;
    }
}
