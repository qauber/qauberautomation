package TestCaseRU;

import Pages.DataCredential;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;


public class AddReportRU {
    public WebDriver driver;
    public PageResources pageResources;
//    public LogIn logIn;


    @Test(priority = 1,dataProviderClass = DataCredential.class, dataProvider = "SAU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {

        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        //driver.manage().window().maximize();
        Thread.sleep(4000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(3000);
    }

    @Test(priority = 2,dataProviderClass = DataCredential.class,dataProvider = "AddReport")
    public void addReportRU(String LastName,String FirstName,String SocialSecurity,String StopLocation,String CaseID) throws Exception {
//        logIn = new LogIn(driver, pageResources);
//        logIn.launchBrowser();
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
        String ReportIdNumber=pageResources.getAddReport().ReportID().getText();
        Thread.sleep(2000);
        pageResources.getAddReport().clikToPublixhreport().click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Reports']")).click();
        Thread.sleep(2000);
        String  Actual = driver.findElement(By.xpath("//div[@class='col-lg-12']//h4[1]")).getText();
        System.out.println(Actual);
        String Expected =  ReportIdNumber+"."+" "+FirstName +" "+LastName ;
        try {
            Assert.assertEquals(Expected, Actual);
            System.out.println("Pass");

        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.print("Fail");
        }


    }
}
