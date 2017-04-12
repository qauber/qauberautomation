package pagestest;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.io.File;
import org.apache.pdfbox.util.PDFTextStripper;


/*
Verify all information entered in report is shown on PDF
Preconditions
1) SA account created
2) At least one Entity created and subscribed
3) At least one report created
Steps
1) Login with valid SA credentials on http://testwave.qabidder.net/
2) Click "Reports" in Main Navigation menu
3) Open any published report by clicking on report's picture or "View" button
4) Click on "Download as PDF" button
5) Click on 'Add report' link then click on "Subject information" tab
6) Reduce window to half of screen.
7) Open downloaded PDF in NEW WINDOW
8) Leave window with open PDF report visible by fitting it to opposite half of screen
9) Verify that all fields names in 'Subject information' tab matches fields name in PDF
10) Repeat step 9 for 'Identifiers', 'ID Information', 'Distribution' and 'Vehicle' sections
Expected Result
Fields names in 'Add report' matches fields name in PDF.
 */

public class VerifyInfoReportandPDF {


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
        // Log in as super admin
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
        Thread.sleep(8000);

    }
    // Random string generator
    public String generateRandomNameString() {
        return "M" + new BigInteger(16, new SecureRandom()).toString(64);
    }


    @Test(dataProvider = "ReportRequiredDetail", dataProviderClass = Data_Provider.class, priority = 1)
    public void VerifyReportInfo( String strLastName, String strFirstName, String strLocation) throws Exception {
        Boolean checkStatus= true;

        // Input info to report
        String expectedLastName = strLastName + generateRandomNameString();
        String expectedFirstName = strFirstName + generateRandomNameString();
        String actualLoacation = strLocation + generateRandomNameString();
        Thread.sleep(20000);

        // Add report
        //Go to Add report page
        pageResources.getAddReport().clickAddReportlink();
        Thread.sleep(10000);
        //Choose entity
        pageResources.getAddReport().clickChooseEntity();
        Thread.sleep(8000);
        //Click on the subject information page
        pageResources.getAddReport().clickGotoSubjectInfoPage();
        Thread.sleep(8000);
        //Enter Last name
        pageResources.getAddReport().setLastName(expectedLastName);
        Thread.sleep(8000);
        //Enter first name
        pageResources.getAddReport().setFirstName(expectedFirstName);
        Thread.sleep(8000);
        //Click on Gang member page
        pageResources.getAddReport().clickGotoGangmemberPage();
        Thread.sleep(10000);
        //Enter location of stop
        pageResources.getAddReport().setLocationOfStop(actualLoacation);
        Thread.sleep(8000);

        Thread.sleep(3000);
        //Click Preview report
        pageResources.getAddReport().clickPreviewReport();
        Thread.sleep(8000);
        //Click Publish report
        pageResources.getAddReport().clickPublishReport();
        Thread.sleep(8000);

        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);
        // Click view report
        pageResources.getViewReport().clickViewReport();
        Thread.sleep(1000);

        Thread.sleep(2000);
        // click download PDF file
        Robot rb = new Robot();
        pageResources.getViewReport().clickExportReporttoPDF();
        // Robot class perform download file

        Thread.sleep(8000);
        rb.keyPress(KeyEvent.VK_D);
        Thread.sleep(2000);

        rb.keyRelease(KeyEvent.VK_D);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(8000);

        // store reportID from view page, use for identify the report in path when downloaded
        String actualReportID = driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']"))).getText();
       // download file name format
        String strFileName = "interview_report_" + actualReportID + ".pdf";



        // Extracting PDF file using PDFTextStripper class
        PDDocument pd = new PDDocument();
        try {
            // Open the target file into PDDocument object


            String outputFolder = System.getProperty("user.home") + File.separator + "Downloads" + File.separator ;

           pd= PDDocument.load( new File (outputFolder  + strFileName));
        } catch (Exception e) {
            System.out.println(e);
        }
        // Put pd which contains report detail in to PDFTextStripper, using method getText()
           PDFTextStripper pdf = new PDFTextStripper();
        //Store the extracted text in to string name pdfText
           String pdfText = pdf.getText(pd);
           System.out.println(pdfText);

        //strLastName,strFirstName,strLocation stored from the add report page
        // getting boolean value, If pdfText contains the entered last name = true , if not return false
        Boolean searchLN=pdfText.contains(expectedLastName);
        // getting boolean value, If pdfText contains the entered first name = true , if not return false
        Boolean searchFN=  pdfText.contains(expectedFirstName);
        // getting boolean value, If pdfText contains the entered location = true , if not return false
        Boolean seachLocation= pdfText.contains(actualLoacation);


            try {
                //using assertTrue to validate the test result by using checkStatus boolean variable = true

                 Assert.assertTrue(searchLN==checkStatus);
                System.out.println("The entered Last name "+expectedLastName);
                System.out.println("Found entered Last name in report is shown on PDF, Search result return :: "+searchLN);

                Assert.assertTrue(searchFN==checkStatus);
                System.out.println("The entered First name "+expectedFirstName);
                System.out.println("Found entered First name in report is shown on PDF, Search result return :: "+searchFN);
                Assert.assertTrue(seachLocation==checkStatus);
                System.out.println("The entered First name "+actualLoacation);
                System.out.println("Found entered Location in report is shown on PDF, Search result return :: "+seachLocation);

          } catch (Throwable t) {
             Assert.fail("the entered information are not found in PDF file");

          }
        driver.close();

    }

}