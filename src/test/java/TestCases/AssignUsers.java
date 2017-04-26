package TestCases;

import ObjectRepository.PageResources;
import Pages.DataProviderClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;

/**
 * Created by Jennifer Grelik on 3/27/2017.
 * This test script is for the sanity check for verifying if the Super Admin is able to assign users on the Users Paga
 */
public class AssignUsers {

    public WebDriver driver;
    public PageResources pageResources;
    String n = RandomStringUtils.randomAlphanumeric(12, 18).toLowerCase();
    String expectedEmail = n + "@mailinator.com";

    @BeforeTest

    public void setup() throws InterruptedException{

        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
    }

    @Test(dataProviderClass= DataProviderClass.class,dataProvider="superAdminUserLogin2",priority=0)

    public void login(String utype, String uname, String password) throws InterruptedException{

        //Get URL
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(10000);
        //Fill in email and password
        pageResources.getLoginPage().setLoginCredentials(uname,password);
        //Click the "Login" button
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(30000);
    }

    @Test(priority=1)

    public void assignUser() throws InterruptedException{

        //Go to Users page
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(10000);

        //Click the "Invite User" button
        pageResources.getUsersPage().inviteUser().click();
        Thread.sleep(5000);
        //Enter the randomly generated email into the "Invite Email" field.
        pageResources.getInviteUserPage().inviteEmail().sendKeys(expectedEmail);
        Thread.sleep(5000);
        //Click the "Send Invite" button
        pageResources.getInviteUserPage().sendInvite().click();
        Thread.sleep(15000);

        //Get the name of the last username at the button and use an assert to confirm the added users was added
        String actual = null;
        int index;
        int iRow;
        int jRow = 0;
        List<WebElement> nextButton = driver.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]"));
        System.out.println("nextButtons: " + nextButton.size());
        Thread.sleep(5000);

        //If the nextButton exists, or is greater than 0
        if (nextButton.size() > 0) {
            //Scroll down the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 950);");
            Thread.sleep(100);
            //Grab and list all the pagination pages
            List<WebElement> pagenumbers = driver.findElements(By.xpath("//a[@class='ng-binding' and @ng-click='setCurrent(pageNumber)']"));
            System.out.println("pagenumbers: " + pagenumbers.size());

            //Loop through the pagination pages
            for (index = 1; index <= pagenumbers.size(); index++) {
                //While looping through, grab the list of table rows on each page
                List<WebElement> userRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
                System.out.println("rowCount: " + userRows.size());

                //Loop through the list of table rows on each pagination page
                for (iRow = 1; iRow <= (userRows.size() - 2); iRow++) {
                    //While going through each row, grab the username of the current table row and convert it to a string
                    WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                    System.out.println("Current userRow is: " + iRow);
                    String username = currentRow.getText();
                    System.out.println(username);

                    //If the current username matches the expected
                    if (username.equals(expectedEmail)) {
                        //Set the current username as the actual result
                        actual = currentRow.getText();
                        System.out.println("Actual has been found: " + actual);
                        jRow = iRow;
                    }
                }
                //If the actual result is still null and the nextButton does not equal 0, then click the nextButton
                if(actual == null && nextButton.size() != 0){
                    nextButton.get(0).click();
                }
            }
        }
        else{
            //If the nextButton is not enabled on the first page, scroll down the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 950);");
            Thread.sleep(100);

            //Grab and list all the table rows of users
            List<WebElement> userRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
            System.out.println("rowCount: " + userRows.size());

            //Loop through the table rows
            for (iRow = 1; iRow <= (userRows.size() - 2) && actual == null; iRow++) {
                //While going through each row, grab the username of the current row and set it as a string
                WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                System.out.println("Current userRow is: " + iRow);
                String username = currentRow.getText();
                System.out.println(username);

                //If the username matches the expected result, set the string as the actual result
                if (username.equals(expectedEmail)) {
                    actual = currentRow.getText();
                    System.out.println("Actual has been found: " + actual);
                    jRow = iRow;
                }
            }
        }
        System.out.println("The actual is: " + actual);
        System.out.println("The expected is: " + expectedEmail);

        //After the loop has ended, assert that the actual email matches the string of the expected email
        try{
            Assert.assertEquals(actual, expectedEmail, "First fail, invited user does not exist");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }
        Thread.sleep(5000);

        //Click the "Assign Permissions" button for the actual row selected
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title = 'Assign permissions']")).click();
        Thread.sleep(10000);

        //Create a short WebElement variable for the "Select Permission" drop-down
        //Set the selectPermission WebElement as a new select and select the "Regular User" option
        WebElement selectPermission = pageResources.getUserPermissionsPage().selectPermission();
        Select selectType = new Select(selectPermission);
        selectType.selectByVisibleText("Regular User");
        //Click the "Save" button to save the new permission
        pageResources.getUserPermissionsPage().savePermission().click();
        Thread.sleep(5000);

        //Store the selected permission as a string and get the actual permission saved as a string
        String expectedPermission = "Regular User";
        String actualPermission = pageResources.getUserPermissionsPage().assignedPermission().getText();
        //Assert that the correct permission was saved
        try{
            Assert.assertEquals(actualPermission, expectedPermission, "Second fail, permission was not assigned correctly");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }

        //Click the "Close" button
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement close = pageResources.getUserPermissionsPage().closePermissions();
        executor.executeScript("arguments[0].click();",close);
        Thread.sleep(5000);
    }

    @AfterTest

    public void close() throws InterruptedException{

        //Get the name of the last username at the button and use an assert to confirm the added users was added
        String actual = null;
        int index;
        int iRow;
        int jRow = 0;
        List<WebElement> nextButton = driver.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]"));
        System.out.println("nextButtons: " + nextButton.size());
        Thread.sleep(5000);

        //If the nextButton exists, or is greater than 0
        if (nextButton.size() > 0) {
            //Scroll down the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 950);");
            Thread.sleep(100);
            //Grab and list all the pagination pages
            List<WebElement> pagenumbers = driver.findElements(By.xpath("//a[@class='ng-binding' and @ng-click='setCurrent(pageNumber)']"));
            System.out.println("pagenumbers: " + pagenumbers.size());

            //Loop through the pagination pages
            for (index = 1; index <= pagenumbers.size(); index++) {
                //While looping through, grab the list of table rows on each page
                List<WebElement> userRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
                System.out.println("rowCount: " + userRows.size());

                //Loop through the list of table rows on each pagination page
                for (iRow = 1; iRow <= (userRows.size() - 2); iRow++) {
                    //While going through each row, grab the username of the current table row and convert it to a string
                    WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                    System.out.println("Current userRow is: " + iRow);
                    String username = currentRow.getText();
                    System.out.println(username);

                    //If the current username matches the expected
                    if (username.equals(expectedEmail)) {
                        //Set the current username as the actual result
                        actual = currentRow.getText();
                        System.out.println("Actual has been found: " + actual);
                        jRow = iRow;
                    }
                }
                //If the actual result is still null and the nextButton does not equal 0, then click the nextButton
                if(actual == null && nextButton.size() != 0){
                    nextButton.get(0).click();
                }
            }
        }
        else{
            //If the nextButton is not enabled on the first page, scroll down the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 950);");
            Thread.sleep(100);

            //Grab and list all the table rows of users
            List<WebElement> userRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
            System.out.println("rowCount: " + userRows.size());

            //Loop through the table rows
            for (iRow = 1; iRow <= (userRows.size() - 2) && actual == null; iRow++) {
                //While going through each row, grab the username of the current row and set it as a string
                WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                System.out.println("Current userRow is: " + iRow);
                String username = currentRow.getText();
                System.out.println(username);

                //If the username matches the expected result, set the string as the actual result
                if (username.equals(expectedEmail)) {
                    actual = currentRow.getText();
                    System.out.println("Actual has been found: " + actual);
                    jRow = iRow;
                }
            }
        }
        System.out.println("The actual is: " + actual);
        System.out.println("The expected is: " + expectedEmail);

        //After the loop has ended, assert that the actual email matches the string of the expected email
        try{
            Assert.assertEquals(actual, expectedEmail, "First fail, invited user does not exist");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }
        Thread.sleep(5000);

        //Delete the user
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Delete\"]")).click();
        Thread.sleep(5000);
        pageResources.getUsersPage().confirmDeletion().click();
        Thread.sleep(5000);

        //Close the browser
        driver.close();
    }
}
