package exercises;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HotelsSearchPage;

import static org.testng.Assert.assertTrue;

public class Exercise3 extends BaseTests {
    static private String destination = "Montevideo, Uruguay";// Unicode

    @Test
    public void exercise3Method() {

        homePage.clickFlights();
        homePage.clickHotels();
        System.out.println("-Step 1 complete");
        homePage.typeHotelsDestination(destination);
        System.out.println("-Step 2 complete");
        HotelsSearchPage hotelsSearchPageUruguay = homePage.clickHotelsSearch();
        assertTrue(hotelsSearchPageUruguay.checkSponsorDisclaimer());
        System.out.println("Sponsored result ok");
        assertTrue(hotelsSearchPageUruguay.checkDiscountAvailable());
        System.out.println("Discount available");
        System.out.println("-Step 3 complete");

    }
}
