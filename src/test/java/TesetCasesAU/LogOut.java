package TesetCasesRU;

import Pages.DataCredential;
import PageBase.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.concurrent.TimeUnit;

/**
 * Created by kamkam on 3/19/2017.
 */
public class LogOut {

    WebDriver driver;
    public PageResources pageResources;
    public PageBase.LogOut logOut;
    public LogIn logIn;
    public LogOut() { this.driver = driver; }
    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "USernameAndPassword")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getLoginPage().password().sendKeys(Password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources.getLoginPage().SignIn().click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test(priority = 2)
    public void LoginRU() throws Exception {

        Thread.sleep(6000);
        logOut= new PageBase.LogOut(driver,pageResources);
        logOut.LogOut();
    }

}
