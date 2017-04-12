package test_SAU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AssignUsers;
import pages.HomeLogin;
import pages.pages_RU.RU_Login;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/19/2017.
 */
public class TestAssignUsers {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;

    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

    @Test
    public void verifyAssign_Users() throws InterruptedException {
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("new@mailinator.com","testing");
        Thread.sleep(2000);
        AssignUsers objAssignUsers = new AssignUsers(driver);
        objAssignUsers.assignUsers();
    }
}

