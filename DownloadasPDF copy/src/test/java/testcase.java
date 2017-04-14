
import Pages.DataProvidersClass;

import TestResources.PageResources;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;


/**Download as PDF
 * Precondition: Login as a superuser, create an entity;
 * 1. Add a Report
 * 2. Click on View
 * 3. On View, click on Download as PDF
 * 4. Verify the content
 *
 */
public class testcase {
    WebDriver driver; //creates an object driver to use in browser
    public PageResources pageResources; //gain access to Page class using Pageresource
    public String InitialString;//declaring global variables for both @BeforeTest and @Test to access for verification
    public int GeneratedReportNumber; //comparison of values, that is.
    PDDocument pd;

    @BeforeTest
    //setting up browser driver for test, executing Preconditions:

    // logging in as RU, adding a report, viewing the report

    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources = new PageResources(driver); //new object that acts for PageResources powered by (driver)
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(4000);
        pageResources.getLogin().setUserName().sendKeys("superuser@getnada.com");
        pageResources.getLogin().setPassword().sendKeys("superuser");
        pageResources.getLogin().clickLogin().click();
        Thread.sleep(5000);
        pageResources.getLogin().LoginNamecheck().click();
        Thread.sleep(4000);

        String actuallogin = pageResources.getLogin().Emailcheck().getText(); //verifying credentials
        Thread.sleep(3000);
        System.out.println("The login email is " + actuallogin);
        Thread.sleep(3000);

        //Create entity

        pageResources.getLogin().Entities().click();
        Thread.sleep(3000);
        pageResources.getLogin().AddEntity().click();
        Thread.sleep(1000);
        String EntityName = randomAlphanumeric(6).toLowerCase();
        pageResources.getCreateEntities().EntityName().sendKeys(EntityName);
        Thread.sleep(1000);
        String Address1 = randomAlphanumeric(6).toLowerCase();
        Thread.sleep(1000);
        pageResources.getCreateEntities().Address1().sendKeys(Address1);
        String City = randomAlphanumeric(6).toLowerCase();
        Thread.sleep(1000);
        pageResources.getCreateEntities().City().sendKeys(City);
        pageResources.getCreateEntities().State().sendKeys("Utah");
        Thread.sleep(1000);
        pageResources.getCreateEntities().PostalCode().sendKeys("64504");
        Thread.sleep(2000);
        System.out.println("The value of entity entered is " + EntityName);

        pageResources.getCreateEntities().Nextbutton().click();
        Thread.sleep(2000);
        pageResources.getInviteRegularUser().NextbuttonafterRegUsers().click();
        Thread.sleep(3000);
        pageResources.getInviteAdminUser().NextbuttonafterAdminUsers().click();
        Thread.sleep(3000);
        pageResources.getInviteAdminUser().Finishbtn().click();
        Thread.sleep(3000);

        pageResources.getPaypal().ExistingPaypalAccountSignin().click();
        pageResources.getPaypal().PaypalEmail().clear();
        pageResources.getPaypal().PaypalEmail().sendKeys("horridfarter@mailinator.com");
        pageResources.getPaypal().PaypalPassword().sendKeys("horridfarter");
        pageResources.getPaypal().PaypalLoginButton().click();
        Thread.sleep(7000);
        pageResources.getPaypal().AgreeandContinue().click();
        Thread.sleep(7000);


        //Adding reports

        pageResources.getAddReports().AddingReports().click(); //starting to add reports
        Thread.sleep(2000);
        pageResources.getAddReports().NameofEntity(0).click();
        Thread.sleep(2000);
        pageResources.getAddReports().Nextbtn().click();
        Thread.sleep(2000);
        String LastName = randomAlphanumeric(6).toLowerCase();
        pageResources.getSubjectInformation().LastName().sendKeys(LastName);
        String FirstName = randomAlphanumeric(6).toLowerCase();
        pageResources.getSubjectInformation().FirstName().sendKeys(FirstName);
        pageResources.getSubjectInformation().Nextbtn().click();
        Thread.sleep(5000);
        pageResources.getIdentifiers().Nextbtn().click();
        Thread.sleep(5000);
        pageResources.getIdInformation().Nextbtn().click();

        String state = randomAlphanumeric(6).toLowerCase();
        pageResources.getDistribution().LocationOfstop().sendKeys(state);
        Thread.sleep(2000);
        pageResources.getDistribution().Nextbtn().click();
        Thread.sleep(3000);
        pageResources.getVehicle().Nextbtn().click();
        Thread.sleep(2000);
        pageResources.getPhotos().Nextbtn().click();
        Thread.sleep(2000);

        //Getting First Name, Last Name, Expected Report Number(this one generated by the system), from the preview and printing em out

        String expectedfirstName = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='First Name']//div[@class='text-bold ng-binding']")).getText();
        String expectedlastName = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Last Name']//div[@class='text-bold ng-binding']")).getText();
        String expectedreportnumber = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']")).getText().trim();
        String expectedreportname = expectedfirstName + " " + expectedlastName;
        System.out.println("Expected report name is " + expectedreportname);
        System.out.println("Expected report number is " + expectedreportnumber);
        Thread.sleep(6000);

        pageResources.getPreview().Publishbtn().click(); //Publishing the report
        Thread.sleep(2000);
        pageResources.getPreview().Confirmation().click();
        Thread.sleep(2000);

        //Retrieving the value of the generated Report ID + Name displayed by xpath
        InitialString = driver.findElement(By.xpath("//div[@class='col-lg-12']//h4[@class='ng-binding']")).getText();
        //Retrieving the Report number(int) alone from the whole string
        Matcher matcher1 = Pattern.compile("\\d+").matcher(InitialString);
        matcher1.find();
        GeneratedReportNumber = Integer.valueOf(matcher1.group());
        Thread.sleep(3000);
        //Printing the report number out
        System.out.println("The Report number :  " + GeneratedReportNumber);
        Thread.sleep(5000);

        pageResources.getViewReports().ViewButton().click();
        Thread.sleep(5000);
        //Getting the URL of the page: format: http://testwave.qabidder.net/#/app/report/5087
        String url = driver.getCurrentUrl();
        //Isolating the number part: 5087 in this URL example, as an int
        Matcher matcher2 = Pattern.compile("\\d+").matcher(url);
        matcher2.find();
        int URLReportNumber = Integer.valueOf(matcher2.group());
        Thread.sleep(3000);
        System.out.println("The Report number :  " + URLReportNumber);
        //Report particulars
        String ReportNumber = pageResources.getViewSpecificReport().ReportNumber().getText();
        String CreatedDate = pageResources.getViewSpecificReport().CreatedDate().getText();
        String CreatedTime = pageResources.getViewSpecificReport().CreatedTime().getText();
        String ReportFirstName = pageResources.getViewSpecificReport().FirstName().getText();
        String ReportLastName = pageResources.getViewSpecificReport().LastName().getText();
        String OfficerName = pageResources.getViewSpecificReport().OfficerName().getText();
        //Printing em out
        System.out.println("Report number: " + ReportNumber);
        System.out.println("Date Created: " + CreatedDate);
        System.out.println("Time Created: " + CreatedTime);
        System.out.println("First name on Viewed Report: " + ReportFirstName);
        System.out.println("Last name on Viewed Report: " + ReportLastName);
        System.out.println("Officer Name on Duty: " + OfficerName);

        //Verification: does the URLReportID match the generated report number for the details we entered?
        try {
            Assert.assertEquals(URLReportNumber, GeneratedReportNumber);
            System.out.println("Expected report numbers match, View Report test successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Reports do not match");
        }

    }

    @Test //(Actual Test starts after preconditions are met: After Login, Add report, view report:  test Download as PDF function)

    public void testcase() throws Exception, IOException {    //Open webpage, go to pageresources, call linked/nested functions and enter values

        //Store string variables for Expected First Name and Last Name from the 'View Reports': these should be the values on the PDF
        String ExpectedpdfFirstName = driver.findElement(By.cssSelector("#reportBody > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).getText();
        String ExpectedpdfLastName = driver.findElement(By.cssSelector("#reportBody > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).getText();
        //Download the PDF!
        pageResources.getViewSpecificReport().DownloadasPDF().click();
        Thread.sleep(3000);
        //Getting the autogenerated report number xxxx from the report which is open and still bein' viewed
        String DocReportNumber = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']")).getText();
        //When the reports downloaded the filename's format is like interview_report_xxxx and so: stringing them along.
        String Filename = "interview_report_" + DocReportNumber;
        //Defining this filename with path
        File f = new File("/Users/jaishree/Downloads/" + Filename + ".pdf");
        //Generic?
        if (f.exists()) {
            System.out.println("PDF File is Available on the device");
        } else {
            System.out.println("No PDF File found");
        }
        //Loading pdf file for reading
        pd = PDDocument.load(new File("/Users/jaishree/Downloads/" + Filename + ".pdf"));
        //Number of pages
        System.out.println("Number of pages on PDF:" + pd.getNumberOfPages());
        //Gettin' relevant text
        PDFTextStripper pdf = new PDFTextStripper();
        String PDFText = pdf.getText(pd);
        //printing after trimming text just in case else it seems to have issues
        System.out.println("PDF CONTENT: " + PDFText.trim());
        Thread.sleep(2000);
        //Stringing first and last name
        String Expected = ExpectedpdfLastName + " " + ExpectedpdfFirstName;
        System.out.println("The Expected Text is: " + Expected);

        //Is this the right pdf? Verifying
        if (PDFText.contains(Expected)) {
            System.out.println("Expected Report Information verified to be present in pdf download");
        } else {
            System.out.println("Expected Report Information does not exist in pdf download");
        }

    }

    @AfterTest
    public void Cleanup() throws InterruptedException {
        //Deleting Entity 1
        Thread.sleep(5000);
        pageResources.getLogin().Entities().click();
        pageResources.getEntities().Deletebtn1().click();
        Thread.sleep(2000);
        pageResources.getEntities().ConfirmDelete().click();
        Thread.sleep(2000);
        System.out.println("Entity cleaned up after test");

        driver.close();
        driver.quit();

    }


}