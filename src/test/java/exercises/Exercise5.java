package exercises;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.CruiseSearchPage;

import static org.testng.Assert.assertTrue;
public class Exercise5 extends BaseTests {
    static private String destination = "のLAX";// Unicode
    static private String origin = "LAS";
    @Test
    public void exercise5Method() {
        homePage.clickCruises();
        System.out.println("Step 1 ok");
        homePage.cruiseSelectDropdown("Europe");
        System.out.println("Step 2 ok");
        homePage.clickCruiseDeparture();
        homePage.clickCruiseNextMonth();
        homePage.clickCruiseDay();
        homePage.clickCruiseConfirmDate();
        CruiseSearchPage cruiseSearchPage = homePage.clickCruiseSearch();
        System.out.println("Step 3 ok");
        assertTrue(cruiseSearchPage.checkFilterByHeader());
        System.out.println("Filter header ok");
        assertTrue(cruiseSearchPage.checkTenToFourteenNights());
        System.out.println("10-14 button displayed");
        cruiseSearchPage.clickFilterTenTo14Nights();
        System.out.println("Clicked 10-14 nights");
        assertTrue(cruiseSearchPage.checkCruiseDiscounts());
        waitMethod(3);
    }
}
