package TestCaseSAU;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

/**
 * Created by kamkam on 3/30/2017.
 */
public class ForgertPasswordSAU {

    public WebDriver driver;
    public PageResources pageResources;

////////////////OPen the Browser
    @BeforeTest
    public void LaunchBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(3000);
    }


    ///////////////////////////////////////////Forget Password////


    @Test
    public void ForgetPassword() throws InterruptedException {
        pageResources.getForgetPassPage().ForgetLink().click();
        Thread.sleep(3000);
        pageResources.getForgetPassPage().EmailAddress().sendKeys("zarzar@getnada.com");
        Thread.sleep(3000);
        pageResources.getForgetPassPage().ResetBtn().click();
        Thread.sleep(3000);
        driver.get("https://app.getnada.com/inbox/zarzar@getnada.com");

        pageResources.getForgetPassPage().EnterEmailOnGetnada().sendKeys("zarzar");
        Thread.sleep(1000);
        pageResources.getForgetPassPage().LetsGoBtnInGetNada().click();
        Thread.sleep(1000);

        pageResources.getForgetPassPage().FirstEmail().click();
        Thread.sleep(3000);
        //////current page
        String parentHandle= driver.getWindowHandle();

        ///////driver.switchTo().frame(driver.findElement(By.name("iFrameTitle")));

        driver.switchTo().frame(driver.findElement(By.id("idIframe")));
        Thread.sleep(3000);
        pageResources.getForgetPassPage().LinkofFirsEmail().click();
        Thread.sleep(3000);

        ///////switch to new window

        for(String winHandle:driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
        String Password= RandomStringUtils.randomAlphanumeric(10);
        pageResources.getForgetPassPage().PasswordtextBoxInChangingPass().sendKeys(Password);
        Thread.sleep(3000);
        pageResources.getForgetPassPage().ConfirmPassTextBoxInChangePass().sendKeys(Password);
        pageResources.getForgetPassPage().ChangePswBtn().click();
        Thread.sleep(3000);


////////////////////////////////////////Sign in with new password

        pageResources.getLoginPage().EmailId().sendKeys("zarzar@getnada.com");
        pageResources.getLoginPage().password().sendKeys(Password);
        pageResources.loginPage.SignIn().click();
        Thread.sleep(4000);

        ////////////////////////////////////////////////////////////////verification USing User name and password

        pageResources.getLogOut().UserNameProfile().click();
        Thread.sleep(3000);
        String Actual= driver.findElement(By.xpath("//div/div[2]/div/h5")).getText();
        try {
            Assert.assertEquals(Actual, "zarzar@getnada.com");
            System.out.println("User name email address is same");
        }
        catch(AssertionError e)
        {
            e.printStackTrace();
        }
        Thread.sleep(2000);
        pageResources.getLogOut().LogOutButton().click();

    }


}