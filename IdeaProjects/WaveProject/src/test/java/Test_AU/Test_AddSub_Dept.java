package Test_AU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddSubDepartment;
import pages.pages_AU.AU_Login;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/21/2017.
 */
public class Test_AddSub_Dept {
    WebDriver driver;
    String baseUrl = "http://testwave.qabidder.net/#/page/login";
    AU_Login objAU_Login;


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

    //adding dept
    @Test
    public void verifyAddingSubDepartment() throws InterruptedException {
        objAU_Login = new AU_Login(driver);
        objAU_Login.setLogin("random@mailinator.com", "testing");
        Thread.sleep(2000);
        AddSubDepartment objAddsubDepartment = new AddSubDepartment(driver);
        objAddsubDepartment.setAddSubDept();
    }
}


