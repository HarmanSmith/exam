package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    //construct
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.getDriver(), this);
        this.wait = new WebDriverWait(this.driver, 5);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }


}