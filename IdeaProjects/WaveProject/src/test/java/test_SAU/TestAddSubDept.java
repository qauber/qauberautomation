package test_SAU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddDepartment;
import pages.AddSubDepartment;
import pages.HomeLogin;

import java.util.concurrent.TimeUnit;


public class TestAddSubDept {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;



    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("random@mailinator.com","testing");
        Thread.sleep(2000);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }
    //adding subdept
    @Test
    public void verifyAddingSubDepartment() throws InterruptedException {

        AddSubDepartment objAddsubDepartment= new AddSubDepartment(driver);
        objAddsubDepartment.setAddSubDept();
    }
}
