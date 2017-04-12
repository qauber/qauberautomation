package test_RU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pages_RU.RU_Login;
import pages.pages_RU.View_Report;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/20/2017.
 */
public class TestRU_ViewReport {
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
    public void verifyViewReport() throws InterruptedException {
        objRU_Login = new RU_Login(driver);
        objRU_Login.setLogin("anbu@mailinator.com", "testing");
        Thread.sleep(2000);
        //String actual = driver.findElement(By.xpath("//div[@class='col-lg-12']//h4")).getText();

        View_Report objViewReport = new View_Report(driver);
        objViewReport.view_Report();
        //System.out.println("");
    }


}
