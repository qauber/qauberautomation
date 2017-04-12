package test_RU;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.pages_RU.RU_Login;
import test.*;

import java.util.concurrent.TimeUnit;


public class Test_RU_Login  {
     WebDriver driver;

    //Login to SiteWebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";


    @BeforeTest
    public void setUp()
    {
        //driver = new FirefoxDriver();
        driver= new ChromeDriver();

        Reporter.log("########### Browser Session Started ###########",true);
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Reporter.log("Application started",true);
    }
    @AfterTest
    public void teardown() {
        driver.close();
        Reporter.log("########### Browser Session Ended  ##############", true);
    }

    //This TC verify user loggedin successfully & validate the user email
    @Test(dataProviderClass = Data_Provider.class,dataProvider = "RU_Credentials")
    public void verifyRU_Login(String userType, String userEmail, String password) throws InterruptedException {
        RU_Login objRU_Login = new RU_Login(driver);
        objRU_Login.setLogin(userEmail, password);
        Reporter.log("User Logged into the Application", true);
        String expectedstr = userEmail;
        System.out.println("Regular User" +" " + userEmail + "Logged in Sucessfully");

        // After logging in cliock on user icon to verify the Email
        By UserName_icon = By.xpath("//div//a/span[@class='mr-sm ng-binding']");
        driver.findElement(UserName_icon).click();
        Thread.sleep(1000);

        String actualstr = driver.findElement(By.xpath("//div[2]/div/h5")).getText();
        System.out.println("Actal Email after loggedin:" + actualstr);
        System.out.println("Expected Email :" + expectedstr);

        Assert.assertEquals(expectedstr, actualstr, " Regular user email is not matching");
        Reporter.log("User Email is verified", true);
        }
    }

