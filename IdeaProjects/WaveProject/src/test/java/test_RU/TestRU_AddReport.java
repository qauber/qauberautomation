package test_RU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pages_RU.Add_Report;
import pages.pages_RU.RU_Login;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/20/2017.
 */
public class TestRU_AddReport {
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



    @Test(dataProviderClass = Data_Provider.class,dataProvider = "Add_Report_Data")
    public void verifyAddReport(String lastName,String firstName,String LocationtoStop) throws InterruptedException {
        // Regular user logged in
        objRU_Login= new RU_Login(driver);
        objRU_Login.setLogin("anbu@mailinator.com","testing");
        Thread.sleep(2000);

        // create report with mandatory fields
        Add_Report objAdd_report = new Add_Report(driver);
        String expected  =objAdd_report.addReport(lastName,firstName,LocationtoStop);
        System.out.println("Expected String:" + expected);

        // getting string from report title after report creation
        String actual = driver.findElement(By.xpath("//div[@class='col-lg-12']//h4")).getText();

        // spilting the report title with report id & user name
        String actual_result = actual.substring(actual.lastIndexOf('.') + 1).trim();

        // only user name separated for verification
        System.out.println("Actual String:" +actual_result);
        Assert.assertEquals(expected,actual_result,"String don't match");
        Reporter.log("Generated report name matches with user name,Assertion success",true);




    }
}
