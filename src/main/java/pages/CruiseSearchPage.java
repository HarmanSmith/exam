package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CruiseSearchPage extends BasePage {
    public CruiseSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@class='filter-by-header']")
    WebElement filterByHeader;
    @FindBy(id = "length-10-14-ember868-label")
    WebElement filter10to14nights;
    @FindBy(xpath = "//div[@class='flex-card']")
    List<WebElement> cruiseCards;
    @FindBy(xpath = "//div[@class='promotion-tag-icon']")
    List<WebElement> discountIcon;

    public void clickFilterTenTo14Nights() {
        getWait().until(ExpectedConditions.elementToBeClickable(filter10to14nights)).click();
    }

    public boolean checkFilterByHeader() {
        return getWait().until(ExpectedConditions.visibilityOf(filterByHeader)).isDisplayed();
    }

    public boolean checkTenToFourteenNights() {
        return getWait().until(ExpectedConditions.visibilityOf(filter10to14nights)).isDisplayed();
    }

    public boolean checkCruiseDiscounts() {
        if (getWait().until(ExpectedConditions.visibilityOf(discountIcon.get(0))).isDisplayed()) {
            System.out.println("Discount results found");
            return true;
        } else if (getWait().until(ExpectedConditions.visibilityOf(cruiseCards.get(0))).isDisplayed()) {
            System.out.println("Discount not found but regular cruises found");
            return true;
        } else {
            System.out.println("Something went wrong");
            return false;
        }
    }

}

