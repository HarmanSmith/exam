package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightSummaryPage extends BasePage{
    public FlightSummaryPage(WebDriver driver){
        super(driver);
    }


    @FindBy (className = "class.'uitk-text uitk-type-500 uitk-type-bold uitk-text-emphasis-theme")
    WebElement totalPrice;


    public boolean priceExists(){
        return this.getWait().until(ExpectedConditions.visibilityOf(totalPrice)).isDisplayed();
    }

    public int getTotalPriceInt(){
        String priceString = this.totalPrice.getText();
        int priceInt = 0;
        Pattern p = Pattern.compile("\\d+");//Parse STRINGS with $ symbols into INT variables
        Matcher m = p.matcher(priceString);//pasamos el primer string al matcher m
        while(m.find()) {
            priceInt = Integer.parseInt(m.group());//lo guardamos como INT
        }
        return priceInt;
    }


}
