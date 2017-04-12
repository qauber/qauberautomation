package pagestest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;


/*
Verify that super admin can delete department
Preconditions
User is logged in with valid credentials as Super Admin on http://testwave.qabidder.net.
User must have already created one department
Steps
1) Click on "Entities" link on the main navigation panel.
2) Click on one of the Entity's name from the list.
3) Click on delete button on the last row of the department list


Expected Result
Super Admin should be able to delete the  department
 */


public class DELETE_DEPT_TEST {
    WebDriver driver;
    public PageResources pageResources;

    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);

        //Login as Super admin
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
        Thread.sleep(8000);
        //click on the entity link
        pageResources.getAddDepartment().AUclickEntitiesLink();
        Thread.sleep(30000);
        // Click on one of the entity name
        pageResources.getAddDepartment().clickEntityName();
        Thread.sleep(8000);
        // make sure to have at least 1 department
    }

    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }


   @Test(priority = 1)
    public void DeleteDEPTtest() throws InterruptedException {
        String expetedDeleteResult = "true";
        String deleteStatus ;

        //Store the old department name
        String DepartmentOldName = driver.findElement(By.xpath("(//table//tbody//tr//td[1]//div//a)[last()]")).getText();

        pageResources.getEdit_dept().clickDeleteDEPT();
        Thread.sleep(5000);
        //String deleteStatus = pageResources.getEdit_dept().clickConfirmDeleteDEPT();
        //Validation
        Thread.sleep(8000);

        String DepartmentName = driver.findElement(By.xpath("(//table//tbody//tr//td[1]//div//a)[last()]")).getText();
   // check if

   if (DepartmentOldName!=DepartmentName)
   {
       deleteStatus="true";
       try {
           Assert.assertEquals(expetedDeleteResult, deleteStatus);
           System.out.println("Admin deleted department name " + DepartmentOldName);
       } catch (Throwable t) {
           org.testng.Assert.fail("expected and actual result do not match");

       }
       driver.close();
   }

     }

    }

