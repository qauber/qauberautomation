package PageBase;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import testResources.PageResources;


public class LogIn {

    public WebDriver driver;
    public PageResources pageResources;

    public LogIn(WebDriver driver, PageResources pageResources) {
        this.driver = driver;
        this.pageResources=pageResources;

    }

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
}