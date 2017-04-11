package TesetCasesAU;

import PageBase.BaseClass;
import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

/**
 * Created by kamkam on 3/19/2017.
 */
public class AddReport extends BaseClass{

    public WebDriver driver;
    public PageResources pageResources;


    @BeforeTest
        public void LaunchBrowser()
     {
         BaseClass ar= new BaseClass();
         ar.SetUp();
     }

    @Test(dataProviderClass = DataCredential.class, dataProvider = "SAU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        pageResources = new PageResources(driver);
        // driver.manage().window().maximize();
        Thread.sleep(3000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(3000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(3000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(3000);
    }
//    @AfterTest
//    public void CloseBrowser()
//    {
//        BaseClass ar= new BaseClass();
//        ar.Teardown();
//    }
    }