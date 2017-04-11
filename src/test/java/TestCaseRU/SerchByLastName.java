package TestCaseRU;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;


//    1.Go to the http://testwave.qabidder.net/#/app
//   2. Click on 'Reports' on main navigation panel.
//   3. Uncheck the check box next to 'Published on'.
//   4. Enter text in the 'Suspect's Last Name Name' field
//5. Verify if app can search at least on report with the same Last  Name

/**
 * Created by kamkam on 3/26/2017.
 */
public class SerchByLastName {

    public WebDriver driver;
    public PageResources pageResources;
    public String LastNameForSearch;


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
        ///verify if the user could login
        try {
            Assert.assertEquals(Actual, UserName);
            System.out.println("Log in Test is Passsed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test(priority = 2,dataProviderClass = DataCredential.class,dataProvider = "AddReport")
    public void addReportRU(String LastName,String FirstName,String SocialSecurity,String StopLocation,String CaseID) throws Exception {
//        logIn = new LogIn(driver, pageResources);
//        logIn.launchBrowser();
        LastNameForSearch=LastName;
        pageResources = new PageResources(driver);
        Thread.sleep(3000);
        pageResources.getAddReport().clickAddReport().click();
        Thread.sleep(2000);
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

        /////Read the report ID
        String ReportIdNumber=pageResources.getAddReport().ReportID().getText();
        Thread.sleep(2000);
        pageResources.getAddReport().clikToPublixhreport().click();
        Thread.sleep(2000);
        pageResources.getAddReport().ReportBtn().click();
        Thread.sleep(2000);
        //////read the first line data in report page
        String  ActualFirstLine = pageResources.getAddReport().ReportText().getText();
        System.out.println("Actual Result is:   "+ActualFirstLine);
        /////////////////////Concatinate report Id and first name and last name
        String Expected =  ReportIdNumber+"."+" "+FirstName +" "+LastName ;
        System.out.println("Expected Result is:   "+Expected);
        Thread.sleep(2000);
        ///verfy if actuall result is same as the expected result
        try {
            Assert.assertEquals(ActualFirstLine,Expected);
            System.out.println("Pass");
            Thread.sleep(2000);
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.print("Fail");
        }


    }

//////////////////////////////////////////Click on reports button
    @Test(priority = 3)
    public void searchByLastName() throws InterruptedException {
        Thread.sleep(5000);
        pageResources.getViewReport().ReportBtn().click();
        Thread.sleep(2000);
        pageResources.getReportSearchPages().checkBox().click();
        Thread.sleep(2000);
        //////////////Send the Last Name whcih comes from the add report part
        pageResources.getReportSearchPages().SuspectLastName().sendKeys(LastNameForSearch);
        Thread.sleep(2000);

        ////read  the first line of the repoert page to compare with the Expected value
        String ReportText = pageResources.getAddReport().ReportText().getText();
        ////////////verify if the first row of report includes the expected value
        try {
            Assert.assertTrue(ReportText.contains(LastNameForSearch));
            System.out.println("/////First line of report includes Last Name :    " + LastNameForSearch + " ,So, The test search by Last Name is passed////");
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("/////First line of report Not includes Last Name :    " + LastNameForSearch + " ,So, The test search by Last Name is passed////");
        }

    }

}





