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
 * TC: Edit sub department
       Pre Condition:
       Login to site
       Have Entity & department under that.
       Steps:
       1.Click on Entities on the left panel
       2.Click on Entity
       3.click on Department
       4.Click " Edit Icon" button of Sub department which need to be edited
       5.Clear the Existing name
       6.Enter  new Sub Department Name.
       7.Click "Save " Button
       */
public class Test_Edit_SubDepartment {
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
    By Add_Button = By.xpath("//div[@class='ngdialog-message' ]//form//button");
    By save_Button = By.xpath("//div[@class='clearfix']//button");




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
    public void verifyEditSubDepartment() throws InterruptedException {
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("anbu@getnada.com", "testing");
        Thread.sleep(2000);
        objSub_Dept_Helper = new Sub_Dept_Helper(driver);
        objSub_Dept_Helper.sau_Add_Company();

        //Click Add department button to create sub department
        Thread.sleep(1000);
        driver.findElement(AddDeptButton).click();

        String randomSubDept = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(SubDeptName).sendKeys(randomSubDept);
        Thread.sleep(1000);

        driver.findElement(Add_Button).click();
        Thread.sleep(2000);
        System.out.println(" ##### Sub Department is created ##### " + randomSubDept);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody//tr[2]//button[2]")).click();
        System.out.println("Sub department edit icon is clicked");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div//input[@name='name']")).clear();
        Thread.sleep(1000);
        String newSubDept = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(By.xpath("//div//input[@name='name']")).sendKeys(newSubDept);
        Thread.sleep(1000);
        driver.findElement(save_Button).click();
        Thread.sleep(2000);
        String actualStr = driver.findElement(By.xpath("//table//tr[2]//div[@class='col-md-6']//a")).getText();
        Assert.assertEquals(actualStr, newSubDept, "Subdept name didn't match");
        System.out.println("Assertion pass, Edit was successful");


    }
}
