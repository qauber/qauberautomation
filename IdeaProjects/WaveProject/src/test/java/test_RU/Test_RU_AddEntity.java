package test_RU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pages_RU.RU_Login;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/30/2017.
 */
public class Test_RU_AddEntity {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    RU_Login objRU_Login;

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
    public void verifyRU_Addentity(){

    }

}
