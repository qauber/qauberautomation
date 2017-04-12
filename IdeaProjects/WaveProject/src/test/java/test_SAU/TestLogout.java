package test_SAU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.HomeLogin;
import pages.Logout;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/17/2017.
 */
public class TestLogout {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    BaseClass bs;
    HomeLogin objHomeLogin;

    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        //Reporter.log("########### Browser Session Started ###########",true);
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Reporter.log("Application started",true);
    }
    @AfterTest
    public void teardown() {
        driver.close();
        //Reporter.log("########### Browser Session Ended  ##############", true);
    }


    @Test
    public void verifyLogout() throws InterruptedException {
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("new@mailinator.com", "testing");
        Thread.sleep(2000);

        Logout objLogout = new Logout(driver);
        objLogout.setLogout();
    }
}
