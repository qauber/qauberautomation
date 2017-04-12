package pagestest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

/**Created By Em
Precondition:
1)user login
2) has 1 exist department under the entity

Edit department name

Tile:Verify that EDIT DEPT is succeed
Steps:
1) Choose 1 department name under any entity  to edit
3) Enter the department name
4) Click on save button

Expected result::
User is able to edit the department name


 */

public class EDIT_DEPT_TEST {
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
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
        Thread.sleep(8000);
    }
    //Precondition
    public void createDept() throws InterruptedException
    {   //Create dynamic department name
        String deptName="Dept"+generateRandomNameString();
        // Click on the entity link on the left navigation
        pageResources.getAddDepartment().AUclickEntitiesLink();
        Thread.sleep(30000);
        //Click on one of the entity name
        pageResources.getAddDepartment().clickEntityName();
        Thread.sleep(30000);
        //Click on "Add department" button
        pageResources.getAddDepartment().clickAddDeptButton();
        Thread.sleep(3000);
        // Enter the department mane
        pageResources.getAddDepartment().setDepartmentName(deptName);
        Thread.sleep(8000);
        //Click add department
        pageResources.getAddDepartment().clickAddDept();
        Thread.sleep(8000);
        // Close the pop up
        pageResources.getAddDepartment().clickClosePopup();
        Thread.sleep(8000);

    }

    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }


    @Test(dataProvider = "DepartmentName", dataProviderClass = Data_Provider.class, priority = 1)
    public void EditDEPTtest(String departmentName) throws InterruptedException {
        String newDepartmentName = departmentName+ generateRandomNameString();

        //Click Entities link
        pageResources.getEdit_dept().AUclickEntitiesLink(); Thread.sleep(30000);
        pageResources.getEdit_dept().clickSelectEntityName();Thread.sleep(5000);

        pageResources.getEdit_dept().clickEditDeptButton();
        Thread.sleep(8000);
        // the department old name
       String expectedDepartmentName= driver.findElement(By.cssSelector("input.form-control:nth-child(2)")).getAttribute("value");
        pageResources.getEdit_dept().setDepartmentName(newDepartmentName);
        Thread.sleep(8000);
        pageResources.getEdit_dept().clickSaveDeptName();
        //Validation

        Thread.sleep(20000);

        // List<WebElement> nextPageButton = driver.findElements(By.xpath("//td/dir-pagination-controls[@pagination-id='usersPagination']/ul/li[4]/a"));

        String departmenetNewNameText = driver.findElement(By.xpath("//tr[3]/td[1]/div/div[1][@class='col-md-8']/a")).getText();
        String EntityAboveDepartment= driver.findElement(By.xpath("//ol/li[2]/span[@class='ng-binding']")).getText();


        try {
            //compare the entered name is the same as the name of department after edited
            Assert.assertEquals(newDepartmentName, departmenetNewNameText);
            System.out.println("Admin updated department name under the entity name  " + EntityAboveDepartment +"  from  " + expectedDepartmentName + "  to  " + departmenetNewNameText);
        } catch (Throwable t) {
            org.testng.Assert.fail("expected and actual result do not match");

        }


    }
    @AfterTest
    public void cleanUp()
    { //driver.findElement(By.xpath("//table/tbody/tr[11]/td[2]/button[4]")).click();
        //  driver.findElement(By.cssSelector(".btn-danger")).click();

        driver.close();

    }
}

