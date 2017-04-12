package test_SanityCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;
import sanityCheck.Add_Report;
import sanityCheck.SearchReportBy_CreatedDate;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 TC :verify search Reports by specific created date range
 Pre Condition:
 Login to site
 Add Report
 Steps:
 1.Un check the published on checkbox in reports page
 2.Select Start date from" Created from" calender
 3.Select End date from " Created to" calender
 Expected Result:
 The reports are displayed in specific  created date range
 */
public class Test_SearchReportBy_CreatedDate {
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
    public void verifySearchReportBy_CreatedDate() throws InterruptedException, ParseException {
        /** login to site  */

        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("anbu@getnada.com", "testing");
        Thread.sleep(2000);
        /** Adding report */
        objAdd_Report = new Add_Report(driver);
        objAdd_Report.addReport_Other("Anu","Anu","Cupertino");

       /** Calling the page method to access the result value */
        SearchReportBy_CreatedDate objSearchReportBy_CreatedDate = new SearchReportBy_CreatedDate(driver);
        boolean result = objSearchReportBy_CreatedDate.searchReportBy_CreatedDate();

        /** Assert condition true */
        Assert.assertTrue(result);
        System.out.println("########################TEST PASSED ###########################");
    }
}
