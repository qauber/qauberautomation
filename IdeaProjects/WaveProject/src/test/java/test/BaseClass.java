package test;

import org.openqa.selenium.By;
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
    By UserName = By.xpath("//input[@id='exampleInputEmail1']");
    By Password = By.xpath("//input[@id='exampleInputPassword1']");
    By Login = By.xpath("//form[@name='login.loginForm']//button");

   public BaseClass(){
        this.driver= new FirefoxDriver();
    }

    @BeforeMethod
    public void setUp()
    {
        //driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        Reporter.log("########### Browser Session Started ###########",true);
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Reporter.log("Application started",true);
    }
    @AfterMethod
    public void teardown() {
        driver.close();
        Reporter.log("########### Browser Session Ended  ##############", true);
    }

    public void loginToApp() throws InterruptedException {
        driver.findElement(UserName).sendKeys("anbu@getnada.com");
        driver.findElement(Password).sendKeys("testing");
        Thread.sleep(2000);
        driver.findElement(Login).click();
        System.out.println("Login Successful from base class...");
    }

}
