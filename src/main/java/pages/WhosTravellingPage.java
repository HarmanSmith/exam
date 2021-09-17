package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WhosTravellingPage extends BasePage{
    public WhosTravellingPage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//img[@alt='www.travelocity.com']")
    WebElement websiteLogo;

public boolean checkLogo(){
    return this.getWait().until(ExpectedConditions.visibilityOf(websiteLogo)).isDisplayed();
}

}
