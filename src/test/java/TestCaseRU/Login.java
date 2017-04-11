package TestCaseRU;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;


public class Login {

    public WebDriver driver;
    public PageResources pageResources;


    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider ="RU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(4000);
        pageResources.getLoginPage().UserNameProfile().click();
        Thread.sleep(2000);
       String Actual= pageResources.getLoginPage().EmailCheck().getText();
        Thread.sleep(2000);
        try {
            Assert.assertEquals(Actual,UserName);
            System.out.print("Log in Test is Passsed");
        }catch (Exception e)
        { e.printStackTrace();}

    }
}
