package test_SAU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.Data_Provider;
import testResources.PageResources;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/17/2017.
 */
public class TestLogin {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    PageResources pageResources ;

    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        pageResources = new PageResources(driver);
        driver.get(baseUrl);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }
    //Login to Site
    @Test(dataProviderClass = Data_Provider.class,dataProvider = "SimpleDataProvider")
    public void verifyLogin(String UserType,String userEmail,String Password) throws InterruptedException {
        pageResources.getHomeLogin().enterUserName(userEmail);
        pageResources.getHomeLogin().enterPassword(Password);
        Thread.sleep(3000);
        pageResources.getHomeLogin().clickLoginButton();
        Reporter.log("User Logged into the Application", true);
        String expectedstr = userEmail;
        System.out.println("Super Admin User" +" " + userEmail + "Logged in Sucessfully");

        // After logging in cliock on user icon to verify the Email
        By UserName_icon = By.xpath("//div//a/span[@class='mr-sm ng-binding']");
        driver.findElement(UserName_icon).click();
        Thread.sleep(1000);

        String actualstr = driver.findElement(By.xpath("//div[2]/div/h5")).getText();
        System.out.println("Actal Email after loggedin:" + actualstr);
        Assert.assertEquals(expectedstr, actualstr, " Super Admin user email is not matching");
        Reporter.log("User Email is verified", true);
    }

}
