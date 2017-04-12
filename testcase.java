import Pages.DataProvidersClass;
import TestResources.PageResources;
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

/**Export Reports List as PDF
 * Precondition:
 * Login as super user. Create entity.
 * And then, Create 1 or 2 reports as a super user
 *Steps:
 * 1. Login, go to reports
 * 2. Get the Report IDs of the published ones on the page
 * 3. Store the Report IDs as 'Expected'
 * 4. Download Export Report list as PDF
 * 5. Check if said PDF is downloaded
 * 6. Extract PDF content
 * 7. Check if report IDs in step 3 (using an assert contains) are displayed in the order of creation
 * (recently created report comes on top)
 *
 * Created by jaishree on 4/6/17.
 */
public class testcase {

    WebDriver driver; //creates an object driver to use in browser
    public PageResources pageResources; //gain access to Page class using Pageresource
    public int GeneratedReportNumber; //comparison of values, that is.
    PDDocument pd;
    public String ExpectedReportNumber;
    public Boolean checkstatus= false;


    @Test
    //setting up browser driver for test, executing Preconditions: logging in as RU, adding a report, viewing the report

    public void testcase() throws InterruptedException, Exception, IOException {
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
        //Creating entities:
        pageResources.getLogin().Entities().click();
        Thread.sleep(1000);
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
        Thread.sleep(3000);
        String state = randomAlphanumeric(6).toLowerCase();
        Thread.sleep(5000);
        pageResources.getDistribution().LocationOfstop().sendKeys(state);
        Thread.sleep(4000);
        pageResources.getDistribution().Nextbtn().click();
        Thread.sleep(3000);
        pageResources.getVehicle().Nextbtn().click();
        Thread.sleep(4000);
        pageResources.getPhotos().Nextbtn().click();
        Thread.sleep(5000);

        //Getting First Name, Last Name, Expected Report Number(this one generated by the system), from the preview and printing em out

        String expectedfirstName = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='First Name']//div[@class='text-bold ng-binding']")).getText();
        String expectedlastName = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Last Name']//div[@class='text-bold ng-binding']")).getText();
        ExpectedReportNumber = driver.findElement(By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']")).getText().trim();
        String expectedreportname = expectedfirstName + " " + expectedlastName;
        System.out.println("Expected report name is " + expectedreportname);
        System.out.println("Expected report number is " + ExpectedReportNumber);
        Thread.sleep(3000);
        pageResources.getPreview().Publishbtn().click();
        pageResources.getPreview().Confirmation().click();
        //Publishing the report
        Thread.sleep(3000);


//(Actual Test starts after preconditions are met: After Login, Add report, export list as PDF)
        //Open webpage, go to pageresources, call linked/nested functions and enter values
        pageResources.getReports().ExportReportsListasPDF().click();
        //When the reports downloaded the filename's format is like search_result
        String Filename = "search_result";
//        //Defining this filename with path
        File f = new File("/Users/jaishree/Downloads/" + Filename + ".pdf");
//        //Generic?
        Thread.sleep(4000);
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
        String Expected = ExpectedReportNumber;
        System.out.println("The Expected Text is: " + Expected);

        //Is this the right pdf? Verifying
        if (PDFText.contains(Expected)) {
            checkstatus = true;
            System.out.println("Expected Report Information verified to be present in pdf download");
        } else {
            System.out.println("Expected Report Information does not exist in pdf download");
        }

        //Asserting if name on preview and name on pdf are the same.
        try {
            Assert.assertTrue(checkstatus == true);
            System.out.println("Report number is constant across Preview and PDF");
            System.out.println("Report number on both displayed as " + ExpectedReportNumber);
        } catch (Exception e) {
            e.printStackTrace();
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
