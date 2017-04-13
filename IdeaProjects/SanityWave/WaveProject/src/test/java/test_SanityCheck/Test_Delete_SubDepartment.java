package test_SanityCheck;

import helper.Sub_Dept_Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

/** Created by Anbu
 /* TC: Delete sub department
 Pre Condition:
 Login to site
 Have Entity & department under that.
 Steps:
 1.Click on Entities on the left panel
 2.Click on Entity
 3.click on Department
 4.Click " Delete Icon" button of Sub department which need to be deleted
 5.Click "Delete" button
 */

public class Test_Delete_SubDepartment {
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
    By Add_Button = By.xpath("//div[@class='clearfix']//button[@type='submit']");
    By save_Button = By.xpath("//div[@class='clearfix']//button");
    By confirm_Delete_Button = By.xpath("//div[@class='text-center']//button[text()='Delete']");


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
    public void verifyDeleteSubDepartment() throws InterruptedException {
        /** Login to site */
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("roja@getnada.com", "testing");
        Thread.sleep(2000);
        /** adding entity & department */
        objSub_Dept_Helper = new Sub_Dept_Helper(driver);
        objSub_Dept_Helper.sau_Add_Company();
        Thread.sleep(1000);

        /**Click Add department button to create sub department */
        driver.findElement(AddDeptButton).click();

        /** Sending random string as Sub department name */
        String randomSubDept = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(SubDeptName).sendKeys(randomSubDept);
        Thread.sleep(2000);

        /** click "Add" button */
        driver.findElement(Add_Button).click();
        Thread.sleep(2000);
        System.out.println(" ##### Sub Department is created ##### " + randomSubDept);

        /**clicking delete button */
        driver.findElement(By.xpath("//tbody//tr[2]//button[4]")).click();
        Thread.sleep(2000);
        driver.findElement(confirm_Delete_Button).click();
        Thread.sleep(1000);

        String actualRes = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody//td")).getText();
        System.out.println(actualRes);
        Assert.assertNotEquals(randomSubDept,actualRes,"Dept is not deleted");
        System.out.println(" Sub department is deleted");


    }
}
