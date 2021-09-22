package exercises;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.CruiseCabinPage;
import pages.CruiseSearchPage;

import static org.testng.Assert.assertTrue;
public class Exercise5 extends BaseTests {
    static private String destination = "Europe";// Unicode
    //static private String origin = "LAS";
    @Test
    public void exercise5Method() {
        homePage.clickCruises();
        System.out.println("Step 1 ok");
        homePage.cruiseSelectDropdown(destination);
        System.out.println("Step 2 ok");
        homePage.clickCruiseDeparture();
        homePage.clickCruiseNextMonth();
        homePage.clickCruiseDay();
        homePage.clickCruiseConfirmDate();
        CruiseSearchPage cruiseSearchPage = homePage.clickCruiseSearch();
        System.out.println("Step 3 ok");
        waitMethod(5);
        assertTrue(cruiseSearchPage.checkFilterByHeader());
        System.out.println("Filter header ok");
        assertTrue(cruiseSearchPage.checkTenToFourteenNights());
        //cruiseSearchPage.returnToMainFrame();
        System.out.println("10-14 button displayed");
        System.out.println("Step 4 ok");
        cruiseSearchPage.clickFilterTenTo14Nights();
        waitMethod(2);
        //cruiseSearchPage.returnToMainFrame();
        System.out.println("Clicked 10-14 nights");
        System.out.println("Step 5 ok");
        assertTrue(cruiseSearchPage.checkCruiseDiscounts());
        System.out.println("Step 6 ok");
        cruiseSearchPage.clickSortDates();
        waitMethod(5);
        CruiseCabinPage cruiseCabinPage = cruiseSearchPage.clickCruiseCard(0);
        System.out.println("Step 7 ok");
        assertTrue(cruiseCabinPage.checkShipNameIsPresent());
        System.out.println("shipn name is present");
        assertTrue(cruiseCabinPage.checkShipDepartureIsPresent());
        System.out.println("Ship departure is present");
        assertTrue(cruiseCabinPage.checkShipReturnIsPresent());
        System.out.println("Step 8 ok");
        System.out.println("Exercise 5 completed");
    }
}
