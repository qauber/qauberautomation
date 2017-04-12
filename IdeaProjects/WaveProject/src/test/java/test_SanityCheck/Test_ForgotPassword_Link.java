package test_SanityCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sanityCheck.Forgot_Password;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 4/6/2017.
 */
public class Test_ForgotPassword_Link {
    WebDriver driver;
    String baseUrl = "http://testwave.qabidder.net/#/page/login";


    @BeforeTest
    public void setUp() throws InterruptedException {
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

    @Test
    public void verifyForgot_Password_Link() throws InterruptedException {
        Forgot_Password objForgotpassword = new Forgot_Password(driver);
        objForgotpassword.forgot_Password();
    }

}
