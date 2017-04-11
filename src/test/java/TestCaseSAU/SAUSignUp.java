package TestCaseSAU;


import Pages.DataCredential;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.concurrent.TimeUnit;

public class SAUSignUp {

   public WebDriver driver;
    public PageResources pageResources;
    public String EmailUnique;

    @BeforeTest
    public void launchBrowser() throws InterruptedException {

        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
       driver=  new ChromeDriver();
       driver.get("http://testwave.qabidder.net/#/page/login");
       pageResources = new PageResources(driver);
//       driver.manage().window().maximize();
    }
    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "Register")
        public  void SignUp (String Name,String Email, String Psw, String ConfirmPsw ) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         pageResources.getSauSignUp().Register().click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         pageResources.getSauSignUp().SAname().sendKeys(Name);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        EmailUnique = Email;
         pageResources.getSauSignUp().AccountEmail().sendKeys(Email+"@mailinator.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         pageResources.getSauSignUp().AccountPSW().sendKeys(Psw);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         pageResources.getSauSignUp().PassConfirm().sendKeys(ConfirmPsw);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         pageResources.getSauSignUp().Continue().click();

     }
    @Test(priority = 2)
    public  void SignUp ( ) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().AcoountNameReg().sendKeys(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().PhoneReg().sendKeys("654789");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().EmailReg().sendKeys("zarzarkam@gmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().AddressReg().sendKeys("285 Main Ave");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().CityReg().sendKeys("San Jsoe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().StateReg().sendKeys("California");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().PostalReg().sendKeys("123456789");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getSauSignUp().ConfirmationReg().click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String Finish=pageResources.getSauSignUp().FinishConfirmation().getText();
        try {
            Assert.assertEquals(Finish, "Registration successful.");
            System.out.println("Confirmation Passed");
        }catch (AssertionError e)
        {
            e.printStackTrace();
        }
    }


    @Test(priority = 3)
    public  void SignUpConfirmation ( ) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver=  new ChromeDriver();
        driver.get("https://www.mailinator.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(EmailUnique);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.findElement(By.xpath("//button[@class='btn btn-dark']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6 col-xs-11 outermail']//div[@class='innermail ng-binding']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/p[5]/a[@target='_other']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }



}
