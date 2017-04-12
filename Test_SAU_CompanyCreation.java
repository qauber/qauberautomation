package test_SanityCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddEntity;
import pages.HomeLogin;
import pages.SAU_CompanyCreation;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
TC:SAU Company Creation
Precondition:
 Valid login credentials
 Steps:

 */
public class Test_SAU_CompanyCreation {
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
        objHomeLogin.login("roja@getnada.com","testing");
        Thread.sleep(2000);

    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

    @Test
    public void verify_SAU_CompanyCreation() throws InterruptedException {
        SAU_CompanyCreation objSAU_CompanyCreation = new SAU_CompanyCreation(driver);
        objSAU_CompanyCreation.sau_Add_Company();
        //Thread.sleep(1000);


    }
}
