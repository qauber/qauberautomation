package test_SanityCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;

import java.util.concurrent.TimeUnit;

/*
TC :SiteLOgo leads to reports
LOgin
get page title
 */
public class Test_Logo_Leads_Reports {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By siteLogo = By.xpath("//a//div[@class='brand-logo']");
    By Users_Link = By.xpath("//a[@class='ng-scope']//span[text()='Users']");



    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

    @Test
    public void verifyLogo_Leads_ReportsPage() throws InterruptedException {
        //Login to site
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("roja@getnada.com","testing");
        Thread.sleep(1000);
        System.out.println(" page title After logged in:"+driver.getCurrentUrl());
        // click on Entities click
        driver.findElement(Entities).click();
        Thread.sleep(2000);

        // click on LOGO
        driver.findElement(siteLogo).click();
        System.out.println(" page title after clicking logo:"+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("reports"));
        System.out.println("Redirected to Reports page after clicking Logo");
        // click on Users link
        driver.findElement(Users_Link).click();
        System.out.println(" page title after clicking users:"+driver.getCurrentUrl());

       //Click on logo
        driver.findElement(siteLogo).click();
        System.out.println(" page title after clicking logo:"+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("reports"));
        System.out.println("Redirected to Reports page after clicking Logo");






    }

}
