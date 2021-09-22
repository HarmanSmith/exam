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
    //@FindBy(xpath ="//button[@data-stid='sticky-button']")
    //@FindBy(xpath ="//button[@data-stid='submit-hotel-reserve'][1]")
    @FindBy(xpath ="/html/body/div[2]/div[1]/div/div/main/div/div/div[1]/section/div[1]/div[4]/div/span/div[3]/div/div[1]/div[2]/div/div/div[2]/div[2]/button")
    WebElement reserveButton;
    @FindBy (xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/section/div[1]/div/div[2]/div[2]/form/button")
    WebElement payNow;

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
        scrollDown(20);
        this.reserveButton.click();
    }
    public HotelsCheckoutPage clickPay(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(payNow)).click();
        return new HotelsCheckoutPage(this.driver);
    }

}
