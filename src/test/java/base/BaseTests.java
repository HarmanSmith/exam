package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    private int width = 375;
    private int height = 812;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.travelocity.com");
        Dimension size = new Dimension(width, height);
        //driver.manage().window().setSize(size); not needed
        homePage = new HomePage(driver);
        //System.out.println(driver.getTitle()); not needed
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
