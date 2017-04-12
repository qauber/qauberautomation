package test_RU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pages_RU.RU_Login;
import pages.pages_RU.RU_Logout;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/20/2017.
 */
public class Test_RU_Logout {
    WebDriver driver;
    String baseUrl = "http://testwave.qabidder.net/#/page/login";
    RU_Login objRU_Login;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

    //Login to Site
    @Test(dataProviderClass = Data_Provider.class,dataProvider = "RU_Credentials")
    public void verifyRU_Login(String userType, String userEmail, String password) throws InterruptedException {
        // User logged in as Regular user
        objRU_Login = new RU_Login(driver);
        objRU_Login.setLogin(userEmail,password);
        Reporter.log("User Logged in to the site",true);

        //Clicking Sign out button
        RU_Logout ru_logout = new RU_Logout(driver);
        ru_logout.setLogout();

        // validate the Url after logged out
        Assert.assertTrue(driver.getCurrentUrl().equals(baseUrl));
        Reporter.log("Validation successful, User redirected to home login page",true);
    }

}
