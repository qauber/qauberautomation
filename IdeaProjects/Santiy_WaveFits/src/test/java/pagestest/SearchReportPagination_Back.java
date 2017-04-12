package pagestest;

import org.openqa.selenium.By;
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

/**
 Verify that search report pagination: Navigate to the previous page is functional
 Precondition:
 1) At least have more than 1 page of the pagination
 2) Have 1 exist report ID to search through the pagination
 Steps
 1) User login
 2) Navigate to "Report" page
 3) Unchecked "Published On" checkbox

 ***Note*** Report ID that use for searching is picked from one of reports that created in the precondition
 */
public class SearchReportPagination_Back {
    public WebDriver driver;
    public PageResources pageResources;

    // reportIDArray is used for store new report ID that we created in the precondition steps
    // The report id that will be used to search through out the pages is picked from the array
    public String[] reportIDArray = new String[5];


    @BeforeTest
    public void setup() throws InterruptedException {
        // the required  data to input while adding report
        String lastName;
        String firstName;
        String location;

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        // Log in
        pageResources.getLoginPage().loginToWave("testingqauber@gmail.com", "testingqauber");
        Thread.sleep(8000);


        //Precondition:: Create reports more than 1 page, each page has 10 reports
        // Loop to make reports
       /* for (int i = 0; i < 5; i++){
            //Dynamic last name, first name and location
            lastName="Lastname"+generateRandomNameString();
            firstName="Firstname"+generateRandomNameString();
            location="location"+generateRandomNameString();
            // click on "Add Report" link
            pageResources.getAddReport().clickAddReportlink2();
            Thread.sleep(10000);
            //Choose entity
            pageResources.getAddReport().clickChooseEntity();
            Thread.sleep(5000);
            //Click on the subject information page
            pageResources.getAddReport().clickGotoSubjectInfoPage();
            Thread.sleep(5000);
            //Fill up last name
            pageResources.getAddReport().setLastName(lastName);
            Thread.sleep(5000);
            //Fill up first name
            pageResources.getAddReport().setFirstName(firstName);
            Thread.sleep(5000);
            //Go to the gang memeber page
            pageResources.getAddReport().clickGotoGangmemberPage();
            Thread.sleep(5000);
            // Fill up the location of stop
            pageResources.getAddReport().setLocationOfStop(location);
            Thread.sleep(5000);
            // click preview report
            pageResources.getAddReport().clickPreviewReport();
            Thread.sleep(6000);
            // Store report ID from the preview page
            String reportID=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']"))).getText();

            //After get the report id from each creation, the report id will be store in reportIDArray[i]
            reportIDArray[i]=reportID;
            System.out.println(reportIDArray[i]);
            // click Reports link to refhresh the page before add the new one
            pageResources.getAddReport().clickReports();
            // 1 step of publish report is still waiting to put below


        }*/

    }

    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(64);
    }

    @Test
    public void searchReportPagination() throws InterruptedException {


        //Click uncheck unpublished
        // driver.findElement(By.linkText("Reports"));
        // Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);

        // Get the element of the pagination
        List<WebElement> pagination = driver.findElements(By.xpath("//td[@align='center']//ul/li/a[@class='ng-binding']"));

        // Check if the pagination has more than 1 page
        if (pagination.size() != 0) {
            System.out.println(pagination.size());
            pagination.get((pagination.size() - 1)).click();
            Thread.sleep(30000);
            // Go through each page depends on the size () of the pagination
            WebElement BackButton = driver.findElement(By.xpath("//td[@align='center']//li[1][@class='ng-scope']/a"));

            for (int i = (pagination.size() - 1); i >= 0; i--) {
                System.out.println("######### Page " + (i + 1));
                List<WebElement> numberOfRow = driver.findElements(By.xpath("//tr[@pagination-id='reportsPagination']//div[@class='col-lg-12']"));
                if (i > 0) {
                    // Go through each row, *Note* each full page has 10 reports
                    for (int j = 1; j <= numberOfRow.size(); j++) {

                        Thread.sleep(3000);
                        //Store each report id while go through each row
                        String ReportIDName = driver.findElement(By.xpath("//tr[" + j + "]//div[@class='col-lg-12']/h4[@class='ng-binding']")).getText();

                        // print the report id in each row
                        System.out.println("ReportIDName " + ReportIDName + " in the row no." + j);

                        // set foundMatch as false
                        Boolean foundMatch = false;

                        // Search:: if the report id that we stored while looping each row contains the reportIDArray[index] that we created, foundMatch will change from false to true
                         String reportIDSearch="5389";
                        if (ReportIDName.contains(reportIDSearch)) {
                            foundMatch = true;
                            // using assertTrue to compare the condition, the expected result is "True",we should found the report id that we are searching for
                            // the actual result is foundMatch
                            try {
                                // the test will pass if the condition is true
                                Assert.assertTrue(foundMatch == true);
                                System.out.println("Found the Match in page no." + (i + 1) + " row no." + j);
                                System.out.println("Search ID is " + reportIDSearch + "\nFound ID " + ReportIDName);
                                // the driver will close when the search is found
                                // driver.close();
                                break;

                            } catch (Throwable t) {
                                org.testng.Assert.fail("expected and actual result do not match");

                            }

                        }
                    }

                    pagination.get((i - 1)).click();

                }

                else{
                    for (int j = 1; j <= numberOfRow.size(); j++) {

                        Thread.sleep(3000);
                        //Store each report id while go through each row
                        String ReportIDName = driver.findElement(By.xpath("//tr[" + j + "]//div[@class='col-lg-12']/h4[@class='ng-binding']")).getText();

                        // print the report id in each row
                        System.out.println("ReportIDName " + ReportIDName + " in the row no." + j);

                        // set foundMatch as false
                        Boolean foundMatch = false;

                        // Search:: if the report id that we stored while looping each row contains the reportIDArray[index] that we created, foundMatch will change from false to true
                        String reportID="5389";
                        if (ReportIDName.contains(reportID)) {
                            foundMatch = true;
                            // using assertTrue to compare the condition, the expected result is "True",we should found the report id that we are searching for
                            // the actual result is foundMatch
                            try {
                                // the test will pass if the condition is true
                                Assert.assertTrue(foundMatch == true);
                                System.out.println("Found the Match in page no." + (i + 1) + " row no." + j);
                                System.out.println("Serch ID is " + reportID + "\nFound ID " + ReportIDName);
                                // the driver will close when the search is found
                                // driver.close();
                                break;

                            } catch (Throwable t) {
                                org.testng.Assert.fail("expected and actual result do not match");

                            }



                        }


                    }

                    break;


                }



            }

            driver.close();


        }


    }


}