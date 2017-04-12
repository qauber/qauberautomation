package test_SanityCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;
import sanityCheck.Add_Report;
import sanityCheck.SearchReportBy_SubjectType;

import java.util.concurrent.TimeUnit;

/** TC: Search Reports by SubjectType
  Pre Conditions:
   Login to site
   Create reports with subject Type
  Steps:
  1.In the reports page after logged in uncheck the "Published on" checkbox
  2.Select the Subject type in the dropdown list
  Expected Result:
    Reports must be displayed according to the subject Type selection
 */
public class Test_SerachReportBy_SubjectType {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    Add_Report objAdd_Report;



    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        /** Login to site */
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("roja@getnada.com","testing");
        Thread.sleep(2000);


    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

    @Test(priority = 1)
    public void verifySearchReportBy_Other() throws InterruptedException {


        /** Adding report */
        objAdd_Report = new Add_Report(driver);
         objAdd_Report.addReport_Other("Anu","A","Cupertino");

         /**calling method which returns boolean result */
        SearchReportBy_SubjectType objSearchReportBy_SubjectType = new SearchReportBy_SubjectType(driver);
        boolean actualResult = objSearchReportBy_SubjectType.searchReportBy_Other();
        Thread.sleep(2000);
        /** Assert the Actual result */
        Assert.assertTrue(actualResult);
        System.out.println("Report found with Suspect type? " +actualResult);
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void verifySearchReportBy_Victim() throws InterruptedException {

        // Adding report
        objAdd_Report = new Add_Report(driver);
        objAdd_Report.addReport_Victim("Anu","A","Cupertino");
        // calling method which returns boolean result
        SearchReportBy_SubjectType objSearchReportBy_SubjectType = new SearchReportBy_SubjectType(driver);
        boolean actualResult = objSearchReportBy_SubjectType.searchReportBy_Victim();
        Thread.sleep(2000);
        Assert.assertTrue(actualResult);
        System.out.println("Report found with Suspect type? " +actualResult);
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    public void verifysearchReportBy_Suspect() throws InterruptedException {


        /** Adding report with suspect type (Suspect) */
        objAdd_Report = new Add_Report(driver);
        objAdd_Report.addReport_Suspect("Anu","A","Cupertino");
        // calling method which returns boolean result
        SearchReportBy_SubjectType objSearchReportBy_SubjectType = new SearchReportBy_SubjectType(driver);
        boolean actualResult = objSearchReportBy_SubjectType.searchReportBy_Suspect();
        Thread.sleep(2000);
        Assert.assertTrue(actualResult);
        System.out.println("Report found with Suspect type? " +actualResult);
        Thread.sleep(1000);
    }
    @Test(priority = 4)
    public void verifysearchReportBy_Witness() throws InterruptedException {


        /** Adding report */
        objAdd_Report = new Add_Report(driver);
        objAdd_Report.addReport_Witness("Anu","A","Cupertino");

        /** calling method which returns boolean result */
        SearchReportBy_SubjectType objSearchReportBy_SubjectType = new SearchReportBy_SubjectType(driver);
        boolean actualResult = objSearchReportBy_SubjectType.searchReportBy_Witness();
        /** Assert condition*/
        Assert.assertTrue(actualResult);
        System.out.println("Report found with Suspect type? " +actualResult);

    }
}
