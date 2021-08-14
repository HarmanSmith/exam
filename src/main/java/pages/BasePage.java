package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait = null;

    //construct
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.getDriver(), this);
        if(this.wait==null){
            this.wait = new WebDriverWait(this.driver, 30);
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }


}