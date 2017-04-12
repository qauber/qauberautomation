package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/23/2017.
 */
public class BaseClass {
    WebDriver driver;
    //Login to SiteWebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";

   public BaseClass(WebDriver driver){
       //super();
       this.driver = driver;
   }

    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        Reporter.log("########### Browser Session Started ###########",true);
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Reporter.log("Application started",true);
    }
    @AfterTest
    public void teardown() {
        driver.close();
        Reporter.log("########### Browser Session Ended  ##############", true);
    }
}
