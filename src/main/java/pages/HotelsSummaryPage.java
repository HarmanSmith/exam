package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelsSummaryPage extends BasePage{
    String oldHotelName;

    public HotelsSummaryPage(WebDriver driver){super(driver);
    }

    @FindBy(xpath = "//div[@data-stid='content-hotel-title']/h1")
    WebElement hotelName;
    @FindBy(xpath = "//meta[@itemprop='ratingValue']")//rating is in "content" attribute
    WebElement hotelRating;
    @FindBy(xpath = "//span[@data-stid='price-lockup-text']")
    List<WebElement> priceCards;//price is in html text
    @FindBy(xpath ="//button[@data-stid='submit-hotel-reserve']")
    List<WebElement> reserveButtons;

    public boolean checkHotelName(String name){
        System.out.println(name + " and " + getWait().until(ExpectedConditions.visibilityOf(hotelName)).getText() );
        if(name.equals(getWait().until(ExpectedConditions.visibilityOf(hotelName)).getText())){
        return true;
        }else{return false;}
    }
    public boolean checkHotelPrice(int price){
        for(int i = 0; i<=priceCards.size();i++){

            scrollDown(15);
            try{
                Thread.sleep(5000);
            }catch(Exception e){
                System.out.println("Algo ocurrió intentando esperar");
            }
            int contenedor = 0;
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(this.priceCards.get(i).getText());
            while(m.find()) {
                contenedor = Integer.parseInt(m.group());
            }
            System.out.println("Precios "+i+": "+price + " and " + contenedor );
            if(contenedor == price){
                scrollUp(18);
                return true;
            }
        }
        scrollUp(12);
        return false;
    }
    public boolean checkHotelStars(float stars){
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("Algo ocurrió intentando esperar");
        }
        float valorTemporal = Float.parseFloat(hotelRating.getAttribute("content"));
        System.out.println(stars+" and "+valorTemporal);
        if (stars <= valorTemporal){
            return true;
        }
        return false;
    }
    public void clickFirstRoom(){
        getWait().until(ExpectedConditions.elementToBeClickable(reserveButtons.get(0))).click();
    }

}
