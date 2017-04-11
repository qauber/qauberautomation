package TestCaseRU;

import Pages.DataCredential;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//login,add report, view report,

/**
 * Created by kamkam on 3/22/2017.
 */
public class ViewReport {

    WebDriver driver;
    public PageResources pageResources;
    PDDocument pd;
    String  reportNo;
    public String ReportID;
    public  String Fname,Lname;
    public String CaseIdInserted;
    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "SAU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        //driver.manage().window().maximize();
        Thread.sleep(2000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(4000);
        pageResources.getLoginPage().UserNameProfile().click();
        Thread.sleep(3000);
        String Actual = pageResources.getLoginPage().EmailCheck().getText();
        Thread.sleep(3000);
        try {
            Assert.assertEquals(Actual, UserName);
            System.out.println("Login Test is Passsed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ////////////////////////////////Add a Report//////////////
    @Test(priority = 2, dataProviderClass = DataCredential.class, dataProvider = "AddReport")
    public void addReportRU(String LastName, String FirstName, String SocialNo, String StopLocation, String caseId) throws Exception {
//        logIn = new LogIn(driver, pageResources);
//        logIn.launchBrowser();
        Lname=LastName;
        Fname= FirstName;
        CaseIdInserted=caseId;
        pageResources = new PageResources(driver);
        Thread.sleep(5000);
        pageResources.getAddReport().clickAddReport().click();
        Thread.sleep(3000);
        pageResources.getAddReport().RadioBtn().click();
        Thread.sleep(3000);
        pageResources.getAddReport().clickIdentifier().click();
        Thread.sleep(2000);
        pageResources.getAddReport().tattoosCheckBox().sendKeys();
        Thread.sleep(2000);
        pageResources.getAddReport().clickSubjectInformation().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickCaseID().sendKeys(caseId);
        Thread.sleep(2000);
        pageResources.getAddReport().clickLastName().sendKeys(LastName);
        Thread.sleep(2000);
        pageResources.getAddReport().clickFirstName().sendKeys(FirstName);
        Thread.sleep(2000);
        pageResources.getAddReport().clickIDInformation().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickOnSocialSecurity().sendKeys(SocialNo);
        Thread.sleep(2000);
        pageResources.getAddReport().clickGangMemberShip().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickOnStopLocation().sendKeys(StopLocation);
        Thread.sleep(2000);
        pageResources.getAddReport().clickonPreview().click();
        Thread.sleep(2000);
         ReportID=pageResources.getAddReport().ReportID().getText();
        Thread.sleep(2000);
        System.out.println("Report ID during Adding Report is:  "+ReportID);
        pageResources.getAddReport().clikToPublixhreport().click();
        Thread.sleep(4000);
        pageResources.getAddReport().ReportText().click();
        Thread.sleep(2000);
        ////////////////////Reading the First row in the Reports
        String ActualResult = pageResources.getAddReport().ReportText().getText();
        Thread.sleep(1000);
        //Seperate the First name and Last Name
        String Actual = ActualResult.substring(ActualResult.lastIndexOf('.') + 1).trim();
        System.out.println("Actual result Which is in the First Row and First Name and Lat Name is separated:   "+Actual);
        String Expected = FirstName + " " + LastName;
        System.out.println("Expected result include First Name and Last Name which inserted in Adding report Process:   "+ Expected);
        ////// Match if the combination of First Name and Last Name is same in both Adding Report AND reading from the first row in the Reports
        try {
            Assert.assertEquals(Actual, Expected);
            System.out.println("Add Report Test is Passed");
        }catch (AssertionError e){e.printStackTrace();}


    }

    ////////////////////////////////////VIEW REPORT//////////////////////////////
    @Test(priority = 3)
    public void Viewreport() throws InterruptedException, IOException {
        ///Click on Reports button
        pageResources.getViewReport().ReportBtn().click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        /// Click on View button of the first Report
        pageResources.getViewReport().ViewBtn().click();
        Thread.sleep(3000);
        ///Click on the view button
        pageResources.getViewReport().Download().click();
        //Get the report ID from the view Page
        reportNo = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']")).getText();
        System.out.println("Report Id in View Report page is: "+reportNo);
        Thread.sleep(5000);
        ////Assert if the report is correctly downloaded and it is in the reperesent address
        String FileName = "interview_report_" + reportNo;

        File f = new File("D:\\Users\\kamkam\\Downloads\\" + FileName + ".pdf");

        try
        {
            Assert.assertTrue(f.exists());
            System.out.println(" PDF File is Available in the local driver");
        }catch (AssertionError e){e.printStackTrace(); System.out.println("No PDF File Available in the local driver");}


        //////////////////verify if report ID in preview page is same as with the Report ID which is made in the Adding report
        try
        {
            Assert.assertEquals(reportNo,ReportID);
            System.out.println("The Report ID is the same as when the report made");
        }catch (AssertionError e){e.printStackTrace();}
        ////////////////////////open the pdf and check if the First name and last name are in the pdf
        pd = PDDocument.load(new File("D:\\Users\\kamkam\\Downloads\\" + FileName + ".pdf"));
        System.out.println("Number of page:" + pd.getNumberOfPages());
        PDFTextStripper pdf = new PDFTextStripper();
        String PDFText = pdf.getText(pd);
        //////////////Print out the content of the pdf which is downloaded
        System.out.println("PDF CONTENT IS:     \n\n " + PDFText.trim());
        Thread.sleep(2000);
        //////Read the first name and password from AddingReport
        String ExpectedCombinationFnameLName = Lname + " " + Fname;

        System.out.println("The Expected First name and password is(From Adding Report)    " + ExpectedCombinationFnameLName);

        ///////////////////Check if the Pdf containd the ecpected resu;t
        try
        {
            Assert.assertTrue(PDFText.contains(ExpectedCombinationFnameLName ));
            //////Assert if the Case id is in the pdf file two
            Assert.assertTrue(PDFText.contains(CaseIdInserted));
            System.out.println("Expected Words is Founded in the pdf file");
        }
        catch (AssertionError e){e.printStackTrace();}


    }






}

