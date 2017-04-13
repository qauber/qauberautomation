package test_SanityCheck;

import helper.Sub_Dept_Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

/** Created by Anbu
 * TC: Create sub department
       Pre Condition:
       Login to site
       Have Entity & department under that.
       Steps:
       1.Click on Entities on the left panel
       2.Click on Entity
       3.click on Department
       4.Click " Add Department" button
       5.Enter Sub Department Name.
       */
public class Test_Create_SubDepartment {
    WebDriver driver;
    String baseUrl = "http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    Sub_Dept_Helper objSub_Dept_Helper;

    //LOcators for adding subdepartment
    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By click_On_company = By.xpath("//table//tbody//tr//td[1]//div//a");// Entity
    By click_on_dept = By.xpath("//table//tbody//tr//td[1]//div//a");  // 1st dept
    By AddDeptButton = By.xpath("//div[@class='content-wrapper ng-scope ng-fadeInUp']//button [text()='Add Department']");
    By SubDeptName = By.xpath("//form//input[@name='name']");
    //By Add_Button = By.cssSelector(".clearfix > button:nth-child(1)");


    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @AfterTest
    public void teardown() {
        driver.close();
    }


    @Test
    public void verifyAddingSubDepartment() throws InterruptedException {
        /** Login site*/
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("anbu@getnada.com", "testing");
        Thread.sleep(2000);
        /**  helper method to create new entity & department*/
        objSub_Dept_Helper = new Sub_Dept_Helper(driver);
        objSub_Dept_Helper.sau_Add_Company();

        /**Click Add department button to create sub department */

        driver.findElement(AddDeptButton).click();
        System.out.println("Clicking in AddDept Button...");
        String randomSubDept = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(SubDeptName).sendKeys(randomSubDept);
        Thread.sleep(1000);

        /** click "Add" button */
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-labeled pull-right ng-binding']")).click();
        Thread.sleep(2000);

        /** Verifying the subdepartment & Assert */

        String actualStr = driver.findElement(By.xpath("//table//tr[2]//div[@class='col-md-6']//a")).getText();
        Assert.assertEquals(actualStr, randomSubDept, "Subdept name didn't match");
        System.out.println("Assertion pass");
    }
}








