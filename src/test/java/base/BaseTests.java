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

    private static WebDriver driver;
    protected HomePage homePage;

    //for screen size
    private int width;
    private int height;

    //--Screen sizes--
    private void setPhoneScreen(){
        width = 375;
        height = 812;
        Dimension size = new Dimension(width, height);
        driver.manage().window().setSize(size);
    }
    private void setLaptopScreen(){
        width = 1280;
        height = 720;
        Dimension size = new Dimension(width, height);
        driver.manage().window().setSize(size);
    }
    private void setMaximizedScreen(){
        driver.manage().window().maximize();
    }

    //for manual waiting!
    public void waitMethod(int seconds){
        int milliseconds = seconds*1000;
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){
            System.out.println("Algo ocurrió intentando esperar");
        }
    }
    //Setup
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver93.exe");
        driver = new ChromeDriver();
        setMaximizedScreen();
        driver.get("https://www.travelocity.com");
        homePage = new HomePage(driver);
        //Debug: HECK for PAGE LOGO
        System.out.println("Title: \"" + driver.getTitle() + "\"");
    }
    @AfterClass
    public void tearDown(){
        //esperamos unos segundos para chequear la pagina antes de cerrar
        System.out.println("Quitting");
        waitMethod(3);
        driver.quit();
    }
}
