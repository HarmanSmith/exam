package exercises;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FlightSearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTests {

    private String destination = "LLAX";
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
        waitMethod(1);
        homePage.clickFlightsCalendarNextMonth();
        waitMethod(1);
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarDayStart();
        homePage.clickFlightsCalendarDayEnd();
        homePage.clickFlightsCalendarApply();
        FlightSearchPage flightSearchPage = homePage.clickFlightSearch();
        System.out.println(flightSearchPage.getDropdownText());
        assertTrue(flightSearchPage.getDropdownText().contains("Price (Lowest)"));

    }


}