package exercises;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.HotelsCheckoutPage;
import pages.HotelsSearchPage;
import pages.HotelsSummaryPage;

import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTests {

    static private String destination = "のLAX";// Unicode
    static private String origin = "LAS";

    @Test
    public void exercise2Method(){

        homePage.clickFlights();
        homePage.clickHotels();
        assertTrue(homePage.travelersCheck());
        System.out.println("-Step1 complete");
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
        System.out.println("-Step2 complete");
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
        System.out.println("-Step 3 complete");
        //System.out.println(hotelsSearchPage.getDropdownText());
        hotelsSearchPage.selectDropdown("Price");
        waitMethod(5);
        //System.out.println("Results loaded: "+hotelsSearchPage.getListSize());
        assertTrue(hotelsSearchPage.checkOrderedLowest());
        System.out.println("-Step 4 complete");
        //System.out.println("Stars :"+hotelsSearchPage.getStarsString(0)+" and "+ hotelsSearchPage.getStarsString(1));
        String hotelName = hotelsSearchPage.getHotelName(hotelsSearchPage.findFirst3StarsHotel());
        int hotelPrice = hotelsSearchPage.getPriceForComparison(hotelsSearchPage.findFirst3StarsHotel());
        float hotelStars = hotelsSearchPage.getStarsFloat(hotelsSearchPage.getStarsString(hotelsSearchPage.findFirst3StarsHotel()));
        HotelsSummaryPage hotelsSummaryPage = hotelsSearchPage.clickFirst3StarsHotel();
        System.out.println("-Step 5 complete");
        hotelsSummaryPage.switchTabs();
        //System.out.println(hotelName);
        //System.out.println(hotelPrice);
        //System.out.println(hotelStars);
        assertTrue(hotelsSummaryPage.checkHotelName(hotelName));
        System.out.println("name ok");
        assertTrue(hotelsSummaryPage.checkHotelPrice(hotelPrice));
        System.out.println("price ok");
        assertTrue(hotelsSummaryPage.checkHotelStars(hotelStars));
        System.out.println("stars ok");
        System.out.println("-Step 6 complete");
        hotelsSummaryPage.clickFirstRoom();
        HotelsCheckoutPage hotelsCheckoutPage = hotelsSummaryPage.clickPay();
        assertTrue(hotelsCheckoutPage.checkHotelPrice());
        System.out.println("HotelPrice present");
        assertTrue(hotelsCheckoutPage.checkHotelRating());
        System.out.println("HotelRating present");
        assertTrue(hotelsCheckoutPage.checkCheckInTitle());
        System.out.println("HotelCheckin present");
        assertTrue(hotelsCheckoutPage.checkRoomCount());
        System.out.println("HotelRoomCount present");
        assertTrue(hotelsCheckoutPage.checkCompleteBookingButton());
        System.out.println("Booking button present");
        System.out.println("Exercise 2 complete");
    }
}
