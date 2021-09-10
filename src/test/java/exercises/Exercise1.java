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
        assertTrue(flightSearchPage.checkDuration(flightSearchPage));//Is duration field displayed?
        assertTrue(flightSearchPage.checkSelectButton(flightSearchPage));//Is select button clickable?
        assertTrue(flightSearchPage.checkBaggage(flightSearchPage, 1)); //Is baggage displayed?
        flightSearchPage.checkList(flightSearchPage, 1);//Get variables
        assertTrue(flightSearchPage.isOrderedLowest(firstResult, secondResult, thirdResult, fourthResult, fifthResult));//Assert by checking first second and third flights are in order!
        flightSearchPage.selectDropdown("Price (Highest)");
        assertTrue(flightSearchPage.checkDuration(flightSearchPage));
        assertTrue(flightSearchPage.checkSelectButton(flightSearchPage));
        assertTrue(flightSearchPage.checkBaggage(flightSearchPage, 2));
        flightSearchPage.checkList(flightSearchPage, 2);
        assertTrue(flightSearchPage.isOrderedHighest(firstResult, secondResult, thirdResult, fourthResult, fifthResult));
    }

}
