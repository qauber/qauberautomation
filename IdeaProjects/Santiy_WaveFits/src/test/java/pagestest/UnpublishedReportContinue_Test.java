package pagestest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
/*
Verify that user can continue an unpublished report

Steps:
1) User log in
2) Click on "Add Report" link in left navigation panel
3) Enter information to the adding report
4) Click on "Preview" tab
//Note** Don't click "Publish report" button
5) Click "Report" link
6) Search the unpublished report using Suspect's Last Name as they key search
7) Unchecked the "Published On" checkbox
8) Once found click "Edit" button
9) Complete the report
10) Click "Preview report" button
11)Click "Publish report" button
12) Click on "Report" link on the left navigation
13) The unpublished report should be displayed as the published report
 */
public class UnpublishedReportContinue_Test{


    public WebDriver driver, driver2;
    public PageResources pageResources;
    //for creating the unpublished report
    public String lastName="Lastname"+generateRandomNameString();
    public String firstName="Firstname"+generateRandomNameString();
    public String location="location"+generateRandomNameString();

    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");



        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        pageResources.getLoginPage().loginToWave("testingqauber@gmail.com", "testingqauber");
        Thread.sleep(10000);
        //Precondition is to have 1 unpublished report
        pageResources.getAddReport().AddUnpublishedReport (lastName, firstName,location);

        }
    // Random string generator
    public String generateRandomNameString() {
        return "M" + new BigInteger(16, new SecureRandom()).toString(64);
    }


    @Test( priority = 1)
    public void VerifyUnpublishedReport() throws InterruptedException {


        //Store Last name and Report ID from preview report, Last name will be used for searching the unpublished report and reportID will used for verifying
        String getReportIDFromPreview = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']")).getText();
        String lastNameonPreview=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Last Name']//div[@class='text-bold ng-binding']"))).getText();
        String firstNameonPreview=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='First Name']//div[@class='text-bold ng-binding']"))).getText();



        //go to report
        driver.findElement(By.cssSelector("li.ng-scope:nth-child(5) > a:nth-child(1) > span:nth-child(2)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);

        //Log out then log in again to continue the unpublished report
        pageResources.getLogoutPage().clickUserPanel();
        Thread.sleep(2000);
        pageResources.getLogoutPage().clickSignOut();
        Thread.sleep(2000);
        driver.close();
        //driver.quit();
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver2 = new FirefoxDriver();
        driver2.manage().window().maximize();
        driver2.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver2);
        Thread.sleep(8000);
        pageResources.getLoginPage().loginToWave("testingqauber@gmail.com", "testingqauber");
        Thread.sleep(10000);




        //Search report by enter Last name to "Suspect's Last Name" text field
         driver2.findElement(By.xpath("//div/input[@ng-model='slnSearchKey']")).sendKeys(lastNameonPreview);
        Thread.sleep(2000);

        //Click uncheck unpublished
        Thread.sleep(2000);
        driver2.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        // get size of the row element
        List<WebElement> numberOfResultRow = driver2.findElements(By.xpath("//div[2][@class='table-responsive']/table[@class='table table-bordered']//tr//h4"));
        // if result show up o row
        if (numberOfResultRow.size()>0 && numberOfResultRow.size()==1) {

            // store the unpublished report ID and status to
            String displayedUnpublishedReportID = driver2.findElement(By.xpath("//div[@class='col-lg-12']//h4[@class='ng-binding']")).getText();
            Thread.sleep(5000);
            String displayedUnpublishedReportStatus = driver2.findElement(By.xpath("//tr[1]//span[2][@ng-show='!report.status']")).getText();
            Thread.sleep(5000);

            //Click Edit button
            driver2.findElement(By.xpath("//a[@class='btn btn-info btn-sm mt-sm ng-scope']")).click();
            Thread.sleep(5000);

            String currentURL=driver2.getCurrentUrl();
            String reportIDfromURL=currentURL.substring(currentURL.lastIndexOf("=") + 1).trim();
            Thread.sleep(4000);

          //  String publishedReportID=displayedUnpublishedReportID;
          /*  if(driver.findElement(By.cssSelector(".ngdialog-content")).isDisplayed()) {
                WebElement element = driver.findElement(By.cssSelector(".btn-danger"));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click()", element);
            }*/

            // complete the report by filling the require information and click publish report
            pageResources.getAddReport().clickChooseEntity();
            Thread.sleep(2000);
            pageResources.getAddReport().clickGotoSubjectInfoPage();
            Thread.sleep(2000);
            pageResources.getAddReport().setLastName(lastName);
            Thread.sleep(2000);
            pageResources.getAddReport().setFirstName(firstName);
            Thread.sleep(2000);
            pageResources.getAddReport().clickGotoGangmemberPage();
            Thread.sleep(2000);
            pageResources.getAddReport().setLocationOfStop(location);
            Thread.sleep(2000);
            pageResources.getAddReport().clickPreviewReport();
            Thread.sleep(2000);

            pageResources.getAddReport().clickPublishReport();
            Thread.sleep(2000);
            driver2.findElement(By.cssSelector(".btn-success")).click();
            Thread.sleep(2000);

            //store the report ID and status after published it
            String publishedReportID=driver2.findElement(By.xpath("//div[@class='col-lg-12']//h4[@class='ng-binding']")).getText();

            Thread.sleep(5000);
            String pubilshedREportStatus = driver2.findElement(By.xpath("//tr[1]//div[4]/span[1][@ng-show='report.status']")).getText();
            Thread.sleep(5000);

            // Validation
 //#########################################################################################################################

            try { // compare the unpublished report ID VS. the published report ID
                Assert.assertEquals(displayedUnpublishedReportID, publishedReportID);
                System.out.println("Unpublished reportID :: " + displayedUnpublishedReportID + "\n After published, Report ID ::" + publishedReportID);
                System.out.println("URL that directed to the adding report contains report ID: "+ reportIDfromURL);
                // assert false for condition between the report staus when unpublished and after published
                Assert.assertFalse(pubilshedREportStatus == displayedUnpublishedReportStatus);
                System.out.println("Status of the unpublished report ID :: " + displayedUnpublishedReportID + " = " +displayedUnpublishedReportStatus );
                System.out.println("Status after published the report, report ID :: " + publishedReportID+ " = " + pubilshedREportStatus);
               driver2.close();
            } catch (Throwable t) {
                org.testng.Assert.fail("expected and actual result do not match");


            }
        }
         // if the result showed more than 1 row
        else if (numberOfResultRow.size()>1)
            {
                for (int i = 1; i ==numberOfResultRow.size(); i++) {

                    Thread.sleep(3000);
                    //After search if found the report, click edit button
                    if (numberOfResultRow.get(i).getText().contains(getReportIDFromPreview)) {

                        // store the unpublish report ID and status to
                        String displayedUnpublishedReportID = driver.findElement(By.xpath("//tr[" + i + "]/td//div[@'col-lg-12']")).getText();
                        String displayedUnpublishedReportStatus = driver.findElement(By.xpath("//tr[" + i + "]//span[2][@ng-show='!report.status']")).getText();


                        //Click Edit button
                        driver.findElement(By.xpath("//a[1][@title='Edit']")).click();
                        Thread.sleep(5000);


                        // complete the report by filling the require information and click publish report
                        pageResources.getAddReport().completeReport(lastName, firstName, location);
                        Thread.sleep(5000);

                        //store the report ID and status after published it
                        String publishedReportID = driver.findElement(By.xpath("//tr[1]//div[@ class='col-lg-12']")).getText();
                        String pubilshedREportStatus = driver.findElement(By.xpath("//tr[1]//div[4]/span[1][@ng-show='report.status']")).getText();


                        try {// Assertion for 2 things, one is report ID and 2 is the report status before and after published
                            Assert.assertEquals(displayedUnpublishedReportID, publishedReportID);
                            System.out.println("Unpublished reportID :: " + displayedUnpublishedReportID + "\n After published, Report ID ::" + publishedReportID);

                            Assert.assertFalse(pubilshedREportStatus == displayedUnpublishedReportStatus);
                            System.out.println("Status of the unpublished report ID :: " + displayedUnpublishedReportID + " = " + displayedUnpublishedReportID);
                            System.out.println("Status after published the report, report ID :: " + publishedReportID + " = " + pubilshedREportStatus);

                            driver.close();

                        } catch (Throwable t) {
                            org.testng.Assert.fail("expected and actual result do not match");


                        }
                    } else {
                        System.out.println("Couldn't find the unpublished report ID::" + getReportIDFromPreview);
                    }
                }
        }




    }
}