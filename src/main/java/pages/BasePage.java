package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class BasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait = null;//singleton

    //construct
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.getDriver(), this);
        if(this.wait==null){ //singleton
            this.wait = new WebDriverWait(this.driver, 120);
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public void switchTabs(){
        ArrayList<String> newTb = new ArrayList<String>(this.driver.getWindowHandles());
        //switch to new tab
        this.driver.switchTo().window(newTb.get(1));
    }

    protected void scrollDown(int times){
        for(int i = 0; i <= times; i++) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
        }
    }
    protected void scrollUp(int times){
        for(int i = 0; i <= times; i++) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.UP);
        }
    }
    /*protected void clickElement(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }
    private void waitForElementToBeClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }*/
}