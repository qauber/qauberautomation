package test_SAU;


import helper.CleanUp_Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddEntity;
import pages.HomeLogin;
import pages.SubscribeEntity;
import testResources.PageResources;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAddEntity {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    //PageResources pageResources;
    HomeLogin objHomeLogin;
    AddEntity objAddEntity;


    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //pageResources = new PageResources(driver);
        driver.get(baseUrl);
        //By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");

    }
    @AfterTest
    public void teardown() throws InterruptedException {
        CleanUp_Entity objcleanUpEntity = new CleanUp_Entity(driver);
        objcleanUpEntity.cleanUp();

        driver.close();
    }
    //add entity
    @Test
    public void verifyAddEntity() throws InterruptedException {
       objHomeLogin = new HomeLogin(driver);
       objHomeLogin.login("roja@getnada.com","testing");
       Thread.sleep(2000);
       objAddEntity = new AddEntity(driver);
       objAddEntity.add_entity();
       System.out.println("New Entity is added");

    }
}
