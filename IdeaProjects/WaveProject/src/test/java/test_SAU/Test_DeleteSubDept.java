package test_SAU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DeleteSubDept;
import pages.Edit_SubDept;
import pages.HomeLogin;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/24/2017.
 */
public class Test_DeleteSubDept {
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
    //delete subdept
    @Test
    public void verifyDeleteSubDepartment() throws InterruptedException {
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("random@mailinator.com", "testing");
        Thread.sleep(2000);
        DeleteSubDept objDeleteSubDept = new DeleteSubDept(driver);
        objDeleteSubDept.deleteSubDept();
    }
}
