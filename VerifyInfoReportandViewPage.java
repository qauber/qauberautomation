package pagestest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.math.BigInteger;
import java.security.SecureRandom;
/*
*Created By Em
Verify all information entered in report is shown on View report
Preconditions
1) SA account created
2) At least one Entity created and subscribed
3) At least one report created
Steps
1) Login with valid SA credentials on http://testwave.qabidder.net/
2) Click "Add Reports" in Main Navigation menu
3) Fill up all information
4) Click on "Preview" tab
5) Click on "Publish Report"
6) Click on "Report" in Main Navigation menu
7) Click "View" button of the created report
8) Verify if entered information are shown in the View report page

Expected Result
Fields names in 'Add report' matches fields name in View report.
 */

public class VerifyInfoReportandViewPage {


    public WebDriver driver;
    public PageResources pageResources;

    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        // Login as super admin
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
        Thread.sleep(8000);

    }
    // Random string generator
    public String generateRandomNameString() {
        return "M" + new BigInteger(16, new SecureRandom()).toString(64);
    }


    @Test(dataProvider = "ReportRequiredDetail", dataProviderClass = Data_Provider.class, priority = 1)
    public void VerifyReportInfo(String strLastName, String strFirstName, String strLocation) throws Exception {
        Boolean checkStatus= true;

        // Input required info to report:Last name, First name and Location of stop
        String actaulLastName = strLastName + generateRandomNameString();
        String actaulFirstName = strFirstName + generateRandomNameString();
        String actualLoacation = strLocation + generateRandomNameString();
        Thread.sleep(20000);

        // Add report page
        //Click on "Add Report" link
        pageResources.getAddReport().clickAddReportlink();
        Thread.sleep(10000);
        //Choose entity
        pageResources.getAddReport().clickChooseEntity();
        Thread.sleep(8000);
        //Click subject information page
        pageResources.getAddReport().clickGotoSubjectInfoPage();
        Thread.sleep(8000);
        //Enter Last name
        pageResources.getAddReport().setLastName(actaulLastName);
        Thread.sleep(8000);
        //Enter first name
        pageResources.getAddReport().setFirstName(actaulFirstName);
        Thread.sleep(8000);
        //Click Gang member page
        pageResources.getAddReport().clickGotoGangmemberPage();
        Thread.sleep(10000);
        //enter the location of stop
        pageResources.getAddReport().setLocationOfStop(actualLoacation);
        Thread.sleep(8000);

        Thread.sleep(3000);
        //Click Preview report page
        pageResources.getAddReport().clickPreviewReport();
        Thread.sleep(3000);
        //Click publish
        pageResources.getAddReport().clickPublishReport();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);

//########################################################################################
        //Validation
        // Click view report
        pageResources.getViewReport().clickViewReport();
        Thread.sleep(1000);

        //store text from each matching fields to verify the entered text from the ad report page
        String firstNameonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='First Name']//div[@class='text-bold ng-binding']"))).getText();
        String lastNameonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Last Name']//div[@class='text-bold ng-binding']"))).getText();
        Thread.sleep(4000);
        String locationOfstop= driver.findElement(By.xpath("id('reportBody')/div[8]//div[2]/div/div[@ class='text-bold ng-binding']")).getText();
        Thread.sleep(4000);


       //strLastName,strFirstName,strLocation stored from the add report page
        //Store return value in boolean from contains method
        //Use contain method to test Last name from add report page VS. last name in view report
        Boolean searchLN=lastNameonReport.contains(actaulLastName);
        //Use contain method to test First name from add report page VS. First name in view report
        Boolean searchFN=firstNameonReport.contains(actaulFirstName);
        //Use contain method to test Location of stop from add report page VS. Location of stop in view report
        Boolean searchLocation= locationOfstop.contains(actualLoacation);
        // If view report page has no contain of the entered info, it will be return false value
        // only if View report contain words that were entered in while creating the report then AssertTrue will give result as Passed
      try { // assertTure condition has to be true only to pass
                 Assert.assertTrue(searchLN==checkStatus);

                System.out.println("Entered Last name::"+actaulLastName+ "\nLast name on view report:: "+lastNameonReport);
                System.out.println("Found entered Last name in report is shown on View report, Search result return :: "+searchLN+"\n\n");

                Assert.assertTrue(searchFN==checkStatus);
                System.out.println("Entered First name::"+actaulFirstName+ "\nFirst name on view report:: "+firstNameonReport);
                System.out.println("Found entered Last name in report is shown on View report, Search result return :: "+searchFN+"\n\n");


                Assert.assertTrue(searchLocation==checkStatus);
                System.out.println("Entered Location of stop:: "+ actualLoacation + "\nLocation of stop name on view report:: "+locationOfstop);
                System.out.println("Found entered Last name in report is shown on View report, Search result return :: "+searchLocation+"\n\n");

          } catch (Throwable t) {
             Assert.fail("the entered information are not found in View report");

          }
        driver.close();
    }

}