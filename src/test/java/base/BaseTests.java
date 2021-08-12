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

    //for screen size (phone is 375x812, pc is 1280x720)
    private int width;
    private int height;

    public void setPhoneScreen(){
        width = 375;
        height = 812;
        Dimension size = new Dimension(width, height);
        driver.manage().window().setSize(size);
    }
    public void setLaptopScreen(){
        width = 1280;
        height = 720;
        Dimension size = new Dimension(width, height);
        driver.manage().window().setSize(size);
    }

    public void setMaximizedScreen(){
        driver.manage().window().maximize();
    }
    //for manual waiting
    public void waitMethod(int seconds){
        int milliseconds = seconds*1000;
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){
            System.out.println("Algo ocurrió intentando esperar");
        }
    }
    //Setup testing
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //setPhoneScreen();
        setMaximizedScreen();
        driver.get("https://www.travelocity.com");
        homePage = new HomePage(driver);
        System.out.println("Title: \"" + driver.getTitle() + "\"");
    }
    @AfterClass
    public void tearDown(){
        //esperamos unos segundos para chequear la pagina antes de cerrar
        System.out.println("Quitting");
        waitMethod(5);
        driver.quit();
    }
}
