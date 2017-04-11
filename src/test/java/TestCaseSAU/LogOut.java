package TestCaseSAU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;


public class LogOut {
    public WebDriver driver;
    public PageResources pageResources;

    @Test(priority = 1)
    public void Login() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        //driver.manage().window().maximize();
        Thread.sleep(8000);
        pageResources.getLoginPage().EmailId().sendKeys("wavefittest@mailinator.com ");
        Thread.sleep(4000);
        pageResources.getLoginPage().password().sendKeys("Kamran12345");
        Thread.sleep(4000);
        pageResources.getLoginPage().SignIn().click();
    }
    @Test(priority = 2)
    public void LogOut()  throws Exception {
//        logIn = new LogIn(driver,pageResources );
//        logIn.launchBrowser();

        Thread.sleep(3000);
        pageResources.getLogOut().UserNameProfile().click();
        Thread.sleep(3000);
        String Actual= driver.findElement(By.xpath("//div/div[2]/div/h5")).getText();
       try {
           Assert.assertEquals(Actual, "wavefittest@mailinator.com");}
           catch(AssertionError e)
        {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        pageResources.getLogOut().LogOutButton().click();
    }
}