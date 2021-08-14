package exercises;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.HomePage;

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
        waitMethod(1);
        homePage.clickFlightsCalendarNextMonth();
        waitMethod(1);
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarDayStart();
        homePage.clickFlightsCalendarDayEnd();
        homePage.clickFlightsCalendarApply();

        FlightSearchPage flightSearchPage = homePage.clickFlightSearch();
        waitMethod(5);
        //System.out.println(flightSearchPage.getDropdownText());
        waitMethod(2);
        flightSearchPage.clickFirstResult();
        System.out.println(flightSearchPage.getFlightPrice());
        waitMethod(2);
        flightSearchPage.clickSecondResult();
        System.out.println(flightSearchPage.getFlightPrice());
        waitMethod(2);
        flightSearchPage.clickThirdResult();
        System.out.println(flightSearchPage.getFlightPrice());
        waitMethod(2);
        assertTrue(flightSearchPage.getDropdownText().contains("Price (Lowest)"));
        //Assert by checking first second and third flights are in order!
    }


}
