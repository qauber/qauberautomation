package TestCaseSAU;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by kamkam on 3/30/2017.
 */
public class SignUpWithGoogleLoging {

    WebDriver driver;
    public PageResources pageResources;


    @BeforeTest
    public void LaunchBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(3000);

    }

    @Test(dataProviderClass = DataCredential.class,dataProvider = "SignInViaGoogleAccount")
    public void RegisterOnGoogle(String GoogleEmail, String GooglePassWord,String WavePass) throws InterruptedException {
        pageResources.getSauSignUp().Register().click();
        Thread.sleep(3000);
        String winHandleBefore = driver.getWindowHandle();
        pageResources.getSignUpGooglePage().GoogleButton().click();
        Thread.sleep(3000);
         Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);
        Thread.sleep(3000);
        pageResources.getSignUpGooglePage().EmailInGooglePage().sendKeys(GoogleEmail);
        pageResources.getSignUpGooglePage().NextBtnInGooglePage().click();
        Thread.sleep(2000);
        pageResources.getSignUpGooglePage().PasswordInGoogle().sendKeys(GooglePassWord);
        Thread.sleep(2000);
        pageResources.getSignUpGooglePage().SignInBtnInGoogle().click();
        Thread.sleep(1000);
        Thread.sleep(4000);
        driver.switchTo().window(winHandleBefore);
        Thread.sleep(2000);
        pageResources.getSauSignUp().AccountPSW().sendKeys(WavePass);
        Thread.sleep(1000);
        pageResources.getSauSignUp().PassConfirm().sendKeys(WavePass);
        Thread.sleep(1000);
        pageResources.getSauSignUp().Continue().click();

    }
}








