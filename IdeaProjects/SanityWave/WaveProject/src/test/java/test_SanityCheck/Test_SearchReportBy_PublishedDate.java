package test_SanityCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;
import sanityCheck.Add_Report;
import sanityCheck.SearchReportBy_PublishedDate;

import java.util.concurrent.TimeUnit;

/** Created by Anbu
 TC :verify search Reports by Published date range
 Pre Condition:
 Login to site
 Add Report
 Steps:
 1.Select Start date from" Published on" calender
 3.Select End date from " Published on" calender
 Expected Result:
 The reports are displayed in specific  published  date range */

public class Test_SearchReportBy_PublishedDate {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    Add_Report objAdd_Report;


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
    public void verifySearchReportBy_PublishedDate() throws InterruptedException {
        /** login to site  */
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("roja@getnada.com","testing");
        Thread.sleep(2000);

        /** Adding report */
        objAdd_Report = new Add_Report(driver);
        objAdd_Report.addReport_Witness("hello","A","Cupertino");
        Thread.sleep(2000);

        /** Getting boolean result from searchReport by published date page class */
        SearchReportBy_PublishedDate objSearchReportBy_PublishedDate = new SearchReportBy_PublishedDate(driver);
        boolean result = objSearchReportBy_PublishedDate.searchReportBy_PublishedOn_Date();
        /**Assert condition */
        Assert.assertTrue(result);
        System.out.println("########### TEST PASSED ###########");

    }


}
