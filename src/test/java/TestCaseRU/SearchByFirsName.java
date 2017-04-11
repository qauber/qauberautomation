package TestCaseRU;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;

/**
 * Created by kamkam on 3/28/2017.
 */
public class SearchByFirsName {

    public WebDriver driver;
    public PageResources pageResources;
    public String FirstNameForSearch;


//      Serch the reports by First Name
// /    1.Go to the http://testwave.qabidder.net/#/app
//   2. Click on 'Reports' on main navigation panel.
//   3. Uncheck the check box next to 'Published on'.
//   4. Enter text in the 'Suspect's First Name' field
    //5. Verify if app can search at least on report with the same First Name


    /////////////////////////////////////////Loging
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
        Thread.sleep(2000);
        String Actual = pageResources.getLoginPage().EmailCheck().getText();
        Thread.sleep(2000);
        try {
            Assert.assertEquals(Actual, UserName);
            System.out.println("Loging  Test is Passsed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
///////////////////////////////////////ADD Report
    @Test(priority = 2,dataProviderClass = DataCredential.class,dataProvider = "AddReport")
    public void addReportRU(String LastName,String FirstName,String SocialSecurity,String StopLocation,String CaseID) throws Exception {

        FirstNameForSearch=FirstName;
        pageResources = new PageResources(driver);
        Thread.sleep(3000);
        pageResources.getAddReport().clickAddReport().click();
        Thread.sleep(3000);
        pageResources.getAddReport().RadioBtn().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickIdentifier().click();
        Thread.sleep(2000);
        pageResources.getAddReport().tattoosCheckBox().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickSubjectInformation().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickCaseID().sendKeys(CaseID);
        Thread.sleep(2000);
        pageResources.getAddReport().clickLastName().sendKeys(LastName);
        Thread.sleep(2000);
        pageResources.getAddReport().clickFirstName().sendKeys(FirstName);
        Thread.sleep(2000);
        pageResources.getAddReport().clickIDInformation().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickOnSocialSecurity().sendKeys(SocialSecurity);
        Thread.sleep(2000);
        pageResources.getAddReport().clickGangMemberShip().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickOnStopLocation().sendKeys(StopLocation);
        Thread.sleep(2000);
        pageResources.getAddReport().clickonPreview().click();
        Thread.sleep(2000);
        /////Read all Rows of report and save it here
        //List<WebElement>AllRowsInReportPage=driver.findElements(By.xpath("//div[@class='col-lg-12']//h4"));

        ////////////////////////////////reading Report ID Number from Add report
        String ReportIdNumber=pageResources.getAddReport().ReportID().getText();
        Thread.sleep(2000);
        pageResources.getAddReport().clikToPublixhreport().click();
        Thread.sleep(2000);
        pageResources.getAddReport().ReportBtn().click();
        Thread.sleep(2000);
        String  ActualFirstRowReport=pageResources.getAddReport().ReportText().getText();
        System.out.println("Actual is :      "+ActualFirstRowReport);
        String ExpectedReport =  ReportIdNumber+"."+" "+FirstName +" "+LastName ;
        System.out.println("Expected  is :   "+ExpectedReport);
        Thread.sleep(2000);
        try {

            Assert.assertEquals(ActualFirstRowReport,ExpectedReport);
            System.out.println("Pass");
            Thread.sleep(2000);
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("Fail");
        }


    }

    @Test(priority = 3)
    public void searchByLastName() throws InterruptedException {
        Thread.sleep(5000);
        pageResources.getViewReport().ReportBtn().click();
        Thread.sleep(2000);
        pageResources.getReportSearchPages().checkBox().click();
        Thread.sleep(2000);
        pageResources.getReportSearchPages().SuspectFirstName().sendKeys(FirstNameForSearch);
        Thread.sleep(2000);
        String ReportText = pageResources.getAddReport().ReportText().getText();

        try {
            Assert.assertTrue(ReportText.contains(FirstNameForSearch));
            System.out.println("/////First line of Report page includes Last Name :    " + FirstNameForSearch + " ,So, The test search by Last Name is passed////");
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("/////First line of report includes Last Name :    " + FirstNameForSearch + " ,So, The test search by Last Name is passed////");
        }

    }
}

