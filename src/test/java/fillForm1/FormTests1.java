package fillForm1;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class FormTests1 extends BaseTests {

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
        //assertEquals
    }

    //@Test// como hacer para ejercicio numero 2?

}
