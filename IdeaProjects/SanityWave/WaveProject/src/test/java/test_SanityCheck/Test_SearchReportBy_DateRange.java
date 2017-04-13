package test_SanityCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;
import sanityCheck.Add_Report;
import sanityCheck.SearchReportBy_DateRange;

import java.util.concurrent.TimeUnit;

/**
 * Created by anbus on 3/27/2017.
 */
public class Test_SearchReportBy_DateRange {
    WebDriver driver;
    String baseUrl = "http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    Add_Report objAdd_Report;

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

    @Test
    public void verifySearchReportBy_DateRange() throws InterruptedException {
        // login to site
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("anbu@mailinator.com", "testing");
        Thread.sleep(2000);

        // Adding report
        objAdd_Report = new Add_Report(driver);
        objAdd_Report.addReport_Witness("Anu","A","Cupertino");

        SearchReportBy_DateRange objSearchReportBy_DateRange = new SearchReportBy_DateRange(driver);
        boolean result = objSearchReportBy_DateRange.searchReportBy_DateRange();


        // Assert condition true
        Assert.assertTrue(result);
        System.out.println("########################TEST PASSED ###########################");
    }
}





