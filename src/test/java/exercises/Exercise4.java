package exercises;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
public class Exercise4 extends BaseTests {
    static private String destination = "のLAX";// Unicode
    static private String origin = "LAS";

    @Test
    public void exercise4Method() {

        homePage.clickFlights();
        homePage.clickDepartureButton();
        homePage.typeDeparture(origin);
        homePage.clickDestinationButton();
        homePage.typeDestination(destination);
        homePage.clickAddHotel();
        homePage.clickFlightsCalendarFrom();
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarDayStart();
        homePage.clickFlightsCalendarDayEnd_Exercise2();
        homePage.clickFlightsCalendarApply();
        homePage.clickFlightSearch_Exercise4();
        assertTrue(homePage.getHotelErrorText());
        System.out.println("Exercise 4 complete");
    }
}
