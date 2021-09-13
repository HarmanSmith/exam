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

    private String destination = "のLAX";// Unicode
    private String origin = "LAS";

    @Test
    public void setDestination(){
        //---Step1.Start---
        homePage.clickFlights();
        homePage.clickDepartureButton();
        homePage.typeDeparture(origin);
        homePage.clickDestinationButton();
        homePage.typeDestination(destination);
        homePage.clickFlightsCalendarFrom();
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarDayStart();
        homePage.clickFlightsCalendarDayEnd();
        homePage.clickFlightsCalendarApply();

        FlightSearchPage flightSearchPage = homePage.clickFlightSearch();//---Step1.Complete---

        //---Step2.Start---
        System.out.println("Dropdown Elements: \n ----- \n" + flightSearchPage.getDropdownText()+"\n ------- ");//Debug print to console
        flightSearchPage.selectDropdown("Price (Lowest)"); //TODO: Step a. Assert this box exists
        flightSearchPage.checkList(flightSearchPage);//Get variables TODO: is this necessary?
        assertTrue(flightSearchPage.checkOrderedLowest());//Step 2.a. TODO: does it assert?
        assertTrue(flightSearchPage.checkSelectButton(flightSearchPage));//Step2.b.
        assertTrue(flightSearchPage.checkDuration(flightSearchPage));//Step2.c.
        assertTrue(flightSearchPage.checkBaggage(flightSearchPage, 1)); //Step2.d.
        //---Step2.Complete---
        flightSearchPage.selectDropdown("Price (Highest)");
        flightSearchPage.checkList(flightSearchPage);
        assertTrue(flightSearchPage.checkOrderedHighest());
        assertTrue(flightSearchPage.checkDuration(flightSearchPage));
        assertTrue(flightSearchPage.checkSelectButton(flightSearchPage));
        assertTrue(flightSearchPage.checkBaggage(flightSearchPage, 2));
    }

}
