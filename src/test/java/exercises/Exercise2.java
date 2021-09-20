package exercises;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.HotelsSearchPage;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTests {

    static private String destination = "のLAX";// Unicode
    static private String origin = "LAS";

    @Test
    public void exercise2Method(){

        homePage.clickFlights();
        homePage.clickHotels();
        assertTrue(homePage.travelersCheck());
        System.out.println("Step1 complete");
        //homePage.clickDepartureButton();
        //homePage.typeDeparture(origin);
        homePage.clickHotelsDestinationButton();
        homePage.typeHotelsDestination(destination);
        homePage.clickFlightsCalendarFrom();
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarNextMonth();
        homePage.clickFlightsCalendarDayStart();
        homePage.clickFlightsCalendarDayEnd_Exercise2();
        homePage.clickFlightsCalendarApply();
        HotelsSearchPage hotelsSearchPage = homePage.clickHotelsSearch();
        System.out.println("Step2 complete");
        assertTrue(hotelsSearchPage.checkLogo());
        System.out.println("logo ok");
        assertTrue(hotelsSearchPage.checkFilterArea());
        System.out.println("filter area ok");
        assertTrue(hotelsSearchPage.checkPropertyNameSearchBox());
        System.out.println("property name ok");
        assertTrue(hotelsSearchPage.checkSortDropdown());
        System.out.println("dropdown ok");
        assertTrue(hotelsSearchPage.checkTravelersButton());
        System.out.println("travelers button ok");
        System.out.println("Step 3 complete");
        //System.out.println(hotelsSearchPage.getDropdownText());
        hotelsSearchPage.selectDropdown("Price");
        waitMethod(5);
        System.out.println(hotelsSearchPage.getListSize());
        assertTrue(hotelsSearchPage.checkOrderedLowest());
        System.out.println("Step 4 complete");

    }
}
