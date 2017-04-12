package pagestest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;


/*
Verify Super Admin can 'Add Department' to entity
Preconditions
User is logged in with valid credentials as Super Admin on http://testwave.qabidder.net.
User must have already created an organization.
Steps
1) Click on "Entities" link on the main navigation panel.
2) Click on one of the organization's name from the list.
3) Click on "Add Department" button
4)Enter "Add department" name in the text field.
5)Click on the "Create" button.

Expected Result
Super Admin should be able to create department under The entity's name.
 */
public class CREATE_DEPT_Test {


    public WebDriver driver;
    public PageResources pageResources;

    @BeforeTest


    public void setup()throws InterruptedException{

        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        //Login as super user
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com","superangry");
        Thread.sleep(8000);
    }

    // random string generator
    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }


    @Test(dataProvider = "DepartmentName", dataProviderClass = Data_Provider.class, priority = 1)
    public void CreateDept(String strDepartmentName) throws InterruptedException {
        // The expected name of the department = strDepartmentName from data provider + random string
        String expectedDepartmentName = strDepartmentName + generateRandomNameString();
        //Click entity link
        pageResources.getAddDepartment().AUclickEntitiesLink();
        Thread.sleep(20000);
        //Click the entity name
        pageResources.getAddDepartment().clickEntityName();
        Thread.sleep(20000);
        //click department button
        pageResources.getAddDepartment().clickAddDeptButton();
        Thread.sleep(3000);
        //Input department name
        pageResources.getAddDepartment().setDepartmentName(expectedDepartmentName);
        Thread.sleep(8000);
        //Click add department
        pageResources.getAddDepartment().clickAddDept();
        Thread.sleep(8000);
        //Close pop up
        pageResources.getAddDepartment().clickClosePopup();
        Thread.sleep(8000);

        //Validation
        //Get the actual result by storing the department name from the last added department
        String actualDepartmentName = driver.findElement(By.xpath("(//table//tbody//tr//td[1]//div//a)[last()]")).getText();

       //By.xpath("//table//tbody//tr//td[1]//div//a")
        Thread.sleep(3000);
        try {
            Assert.assertEquals(expectedDepartmentName, actualDepartmentName);
            System.out.println("Admin entered::" + expectedDepartmentName + "  Created new department name::" + actualDepartmentName);

        } catch (Throwable t) {
            org.testng.Assert.fail("expected and actual result do not match");

        }

    }
    @AfterTest

        public void cleanUp() throws InterruptedException
        {   // click delete button
            List<WebElement> nextPageButton = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']/li[@class='ng-scope']/a"));
            if(nextPageButton.size() != 0) {
                for (int i = 0; i < nextPageButton.size(); i++) {
                    nextPageButton.get(i).click();
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("(//tr//button[@ title='Delete'])[last()]")).click();
                    Thread.sleep(5000);
                    pageResources.getAddEntity().clickConfirmDelete();
                    Thread.sleep(5000);
                }
            }
            else{ driver.findElement(By.xpath("(//tr//button[4][@ title='Delete'])[last()]")).click();
                Thread.sleep(5000);

                pageResources.getAddEntity().clickConfirmDelete();
                Thread.sleep(5000);
            }

            driver.close();
        }







}
