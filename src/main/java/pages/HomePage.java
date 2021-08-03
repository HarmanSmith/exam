package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By goingToBox = By.xpath("//button[@aria-label='Going to']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickGoingToButton(){
        driver.findElement(goingToBox).click();
    }
}
