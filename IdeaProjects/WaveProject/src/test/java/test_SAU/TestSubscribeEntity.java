package test_SAU;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddEntity;
import pages.HomeLogin;
import pages.SubscribeEntity;

import java.util.concurrent.TimeUnit;


public class TestSubscribeEntity {

    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    AddEntity objAddEntity;
    //SubscribeEntity objSubscribeEntity;

    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
       // driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }
    //Subscribe Entity
    @Test
    public void verifySubscribeEntity() throws InterruptedException {
        // login as superAdmin
        objHomeLogin= new HomeLogin(driver);
        objHomeLogin.login("new@mailinator.com","testing");
        // Adding Entity
        objAddEntity= new AddEntity(driver);
        objAddEntity.add_entity();
        Thread.sleep(1000);
        //subscribe entity using paypal sandbox account
        SubscribeEntity objSubscribeEntity = new SubscribeEntity(driver);
        objSubscribeEntity.subscribe_entity();
    }
}
