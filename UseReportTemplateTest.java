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

/**Created By Em
Verify that Use Report Template function is funtional
Precondition:
1) user can log in as any type of user
2) 1 report is created

Steps
1) Login
2) Click "View" button on the report
3) Click "Use as Template" button
4) verify if data from view report has display in the subject information page in Add report

expected result:
Use as template will transfer data from the subject section to the Add report in the subject inforamtion page
 */

public class UseReportTemplateTest {


    public WebDriver driver;
    public PageResources pageResources;

    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        //Log in
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
        Thread.sleep(8000);

    }

    public String generateRandomNameString() {
        return "M" + new BigInteger(16, new SecureRandom()).toString(64);
    }


    @Test( priority = 1)
    public void UseReportTemplate() throws Exception {

        //go to report
        Thread.sleep(2000);

        //Click uncheck unpublished
        Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        // Click view report
        pageResources.getViewReport().clickViewReport();
        Thread.sleep(1000);
        //store text from each matching fields to verify the entered text from the ad report page
        String firstNameonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='First Name']//div[@class='text-bold ng-binding']"))).getText();
        String lastNameonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Last Name']//div[@class='text-bold ng-binding']"))).getText();
        String reportIDonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']"))).getText();
        Thread.sleep(4000);


        //Store text from View report
        String infoTemplate = driver.findElement(By.xpath("id('reportBody')/div[1]/div")).getText();
        Thread.sleep(4000);

        // Click on Use as template button
        driver.findElement(By.xpath("//div[@class='col-md-12']/button[@ng-click='useAsTemplate(report)']")).click();

        Thread.sleep(4000);

        // Click on Subject Information Page
        driver.findElement(By.xpath("//li[2][@ class='col-md-1 ph0']")).click();
        Thread.sleep(4000);
        //strLastName,strFirstName,strLocation stored from the add report page
        String getLastnameFromTemplate=driver.findElement(By.name("lastName")).getAttribute("value");
        Thread.sleep(4000);
       String getFirstnameFromTemplate=driver.findElement(By.name("firstName")).getAttribute("value");
        Thread.sleep(4000);

        //Get current URL to get the report ID from adding report page to verify that it was sent from the same report ID from view report page
        // example format of URL that display on adding report page: http://testwave.qabidder.net/#/app/report-form?templateId=4973
        String currentURL=driver.getCurrentUrl();
        String reportIDfromURL=currentURL.substring(currentURL.lastIndexOf("=") + 1).trim();
        Thread.sleep(4000);

        // Click on Subject Information Page
      driver.findElement(By.xpath("//li[5][@ class='col-md-1 ph0']")).click();

        Thread.sleep(4000);

        Boolean checkLastnamefromTempleStatus=infoTemplate.contains(getLastnameFromTemplate);
        Boolean checkFirstnamefromTempleStatus=infoTemplate.contains(getFirstnameFromTemplate);
        try {
            Assert.assertEquals(reportIDfromURL,reportIDonReport);
            System.out.println("Information sent from template reportID ::" +reportIDonReport);
            System.out.println("ReportID from URL in adding report page ::" +reportIDfromURL);


            Assert.assertTrue(checkLastnamefromTempleStatus==true);
            System.out.println("###################################################");
            System.out.println("Last name sent from use report template ::"+getLastnameFromTemplate+ "\nLast name received on the subject information page:: "+lastNameonReport);
            System.out.println("USE REPORT AS TEMPLATE SUCCESS"+"\n\n");

            Assert.assertTrue(checkFirstnamefromTempleStatus==true);
            System.out.println("First name sent from use report template ::"+getFirstnameFromTemplate+ "\nFirst name received on the subject information page:: "+firstNameonReport);
            System.out.println("USE REPORT AS TEMPLATE SUCCESS"+"\n\n");


        } catch (Throwable t) {
            Assert.fail("USE REPORT AS TEMPLATE FAILED");

        }
        driver.close();
    }

}