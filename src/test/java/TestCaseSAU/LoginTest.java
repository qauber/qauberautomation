package TestCaseSAU;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testResources.PageResources;

public class LoginTest {


    public WebDriver driver;
    public PageResources pageResources;
  //  public PageBase.LogOut logOut;

    @DataProvider(name = "Credential")
    public Object[][] loginUser() {
        Object[][] data = new Object[1][2];

        data[0][0]="wavefittest@mailinator.com";
        data[0][1]="Kamran12345";
        return data;
    }

//    @BeforeTest
//    public void launchBrowser() throws InterruptedException {
//
//        driver = new ChromeDriver();
//        driver.get("http://testwave.qabidder.net/#/page/login");
//        pageResources = new PageResources(driver);
////        driver.manage().window().maximize();
//    }

    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "RU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
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


    @Test
    public void InviteUSr()
    {

    }



}
