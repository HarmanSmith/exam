package exercises;

import base.BaseTests;
import org.testng.annotations.Test;

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
        homePage.clickFlightsCalendarNextMonth();
        //assertEquals
    }


}
