package exercises;

import base.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.FlightSummaryPage;
import pages.HomePage;
import pages.WhosTravellingPage;

import java.util.ArrayList;
import java.util.regex.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTests {

    static private String destination = "のLAX";// Unicode
    static private String origin = "LAS";

    @Test
    public void exercise1Method(){
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

        FlightSearchPage flightSearchPage = homePage.clickFlightSearch();
        System.out.println("Step1 complete");
        //---Step2.Start---
        System.out.println("Dropdown Elements: \n ----- \n" + flightSearchPage.getDropdownText()+"\n ------- ");//Debug print to console
        flightSearchPage.selectDropdown("Price (Lowest)");
        assertTrue(flightSearchPage.checkOrderedLowest());//Step 2.a.
        System.out.println("Step2.a. complete");
        assertTrue(flightSearchPage.checkSelectButton(flightSearchPage));//Step2.b.
        System.out.println("Step2.b. complete");
        assertTrue(flightSearchPage.checkDuration(flightSearchPage));//Step2.c.
        System.out.println("Step2.c. complete");
        assertTrue(flightSearchPage.checkBaggage(flightSearchPage, 1)); //Step2.d.
        System.out.println("Step2.d. complete");
        //---Step2.Complete---
        //---Step3.Start---
        flightSearchPage.selectDropdown("Duration (Shortest)");
        assertTrue(flightSearchPage.checkOrderedDurationShort());
        System.out.println("Step3.a. complete");
        //---Step3.Complete---
        //---Step4.Start---
        flightSearchPage.selectDropdown("Duration (Shortest)");
        flightSearchPage.clickResult(0);
        flightSearchPage.clickSelectFlightButton();
        System.out.println("Step4 complete");
        //---Step4.Complete---
        //---Step5.Start---
        System.out.println("Attempting to click thirdresult");
        waitMethod(10);
        flightSearchPage.clickResult(2);
        System.out.println("Clicked result");
        System.out.println("Attempting to click select");
        flightSearchPage.clickSelectFlightButton();
        System.out.println("Clicked select");
        System.out.println("No thanks button attempt");
        FlightSummaryPage flightSummaryPage = flightSearchPage.clickNoThanks();
        System.out.println("No thanks button successful");

        //---Step5.Complete---
        //---Step6.Start---
        System.out.println("Attempting to switch tabs");
        flightSummaryPage.switchTabs(); // Fixed issue with tabs
        System.out.println("Switch tabs successful");
        //flightSummaryPage.printSomethingDebug();
        assertTrue(flightSummaryPage.priceExists());
        System.out.println("Step6.a. complete");
        System.out.println("size is: "+flightSummaryPage.getFlightInfoSize());
        assertTrue(flightSummaryPage.checkFlightInformation(0));
        System.out.println("DeparturaInformationCorrect");
        assertTrue(flightSummaryPage.checkFlightInformation(1));
        System.out.println("ReturnInformationCorrect");
        System.out.println("Step6.b. complete");
        assertTrue(flightSummaryPage.checkPriceGuarantee());
        System.out.println("Step6.c. complete");
        WhosTravellingPage whosTravellingPage = flightSummaryPage.clickCheckout();
        System.out.println("STEP7 Complete");
        assertTrue(whosTravellingPage.checkLogo());
        System.out.println("Logo ok");
        assertTrue(whosTravellingPage.checkCompleteBooking());
        System.out.println("Booking Ok");
        assertTrue(whosTravellingPage.checkWhosTravellingHeader());
        System.out.println("Header Ok");
        assertTrue(whosTravellingPage.checkYourPriceSummary());
        System.out.println("Price summary ok");
        assertTrue(whosTravellingPage.checkInsuranceCheckbox());
        System.out.println("Insurance ok");
        System.out.println("STEP8 Complete");
        System.out.println("Exercise 1 complete");
    }

}
