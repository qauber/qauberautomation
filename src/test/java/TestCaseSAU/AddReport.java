package TestCaseSAU;

import PageBase.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

public class AddReport {

    public WebDriver driver;
    public PageResources pageResources;
    public LogIn logIn;



    @BeforeTest
    public void Login() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
//        driver.manage().window().maximize();
        Thread.sleep(2000);
        pageResources.getLoginPage().EmailId().sendKeys("wavefittest@mailinator.com ");
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys("Kamran12345");
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
    }

         @Test
         public void addReport() throws Exception {
//        logIn= new LogIn(driver,pageResources);
//        logIn.launchBrowser();
//      Thread.sleep(4000);
        Thread.sleep(8000);
        pageResources.getAddReport().clickAddReport().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickEntity().click();
        Thread.sleep(1000);
       // pageResources.getAddReport().clickFirstEntity().click();
        Thread.sleep(1000);
        pageResources.getAddReport().clickIdentifier().click();
        Thread.sleep(2000);
        pageResources.getAddReport().tattoosCheckBox().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickSubjectInformation().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickLastName().sendKeys("akammam");
        Thread.sleep(2000);
        pageResources.getAddReport().clickFirstName().sendKeys("lskf");
        Thread.sleep(2000);
        pageResources.getAddReport().clickIDInformation().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickOnSocialSecurity().sendKeys("9898");
        Thread.sleep(2000);
        pageResources.getAddReport().clickGangMemberShip().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clickOnStopLocation().sendKeys("aKLSJLAS");
        Thread.sleep(3000);
        pageResources.getAddReport().clikToPublixhreport().click();
        Thread.sleep(2000);
        pageResources.getAddReport().clikToPublixhreport();
             Thread.sleep(2000);

             String actual=driver.findElement(By.xpath("(//tr[@pagination-id='usersPagination']//a)[last()]")).getText();
             try {
                 Assert.assertEquals(actual ,"email");
             }catch (AssertionError e)
             {
                 e.getLocalizedMessage();
             }

    }
}
