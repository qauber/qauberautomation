package test_SAU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EditCompany;
import pages.HomeLogin;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/17/2017.
 */
public class TestEditCompany {
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
    //Edit company
    @Test
    public void verifyEditCompany() throws InterruptedException {
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("new@mailinator.com", "testing");
        Thread.sleep(2000);

        EditCompany objEditCompany = new EditCompany(driver);
        objEditCompany.setEditCompany();
    }
}
