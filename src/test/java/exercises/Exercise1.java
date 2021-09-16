package exercises;

import base.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.FlightSearchPage;
import pages.FlightSummaryPage;
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
        flightSearchPage.clickResult(0);
        flightSearchPage.clickSelectFlightButton();
        System.out.println("Step4 complete");
        //---Step4.Complete---
        //---Step5.Start---
        System.out.println("Attempting to click result");
        waitMethod(3);
        flightSearchPage.clickResult(2);
        System.out.println("Clicked result");
        System.out.println("Attempting to click select");
        flightSearchPage.clickSelectFlightButton();
        System.out.println("Clicked select");
        System.out.println("No thanks button");
        FlightSummaryPage flightSummaryPage = flightSearchPage.clickNoThanks();
        System.out.println("No thanks successful");

        //---Step5.Complete---
        //---Step6.Start---
        assertTrue(flightSummaryPage.priceExists());
        System.out.println("Step6.a. complete");


        /*flightSearchPage.selectDropdown("Price (Highest)");//ejercicio no pide ordered by highest
        //flightSearchPage.checkList(flightSearchPage);
        assertTrue(flightSearchPage.checkOrderedHighest());
        assertTrue(flightSearchPage.checkDuration(flightSearchPage));
        assertTrue(flightSearchPage.checkSelectButton(flightSearchPage));
        assertTrue(flightSearchPage.checkBaggage(flightSearchPage, 2));*/
    }

}
