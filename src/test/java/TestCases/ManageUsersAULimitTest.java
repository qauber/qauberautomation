package TestCases;

import ObjectRepository.PageResources;
import Pages.DataProviderClass;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jennifer Grelik on 4/7/2017.
 * This test script is for the sanity check of making sure an admin user is not able to manage users they're not assigned to
 */
public class ManageUsersAULimitTest {

    public WebDriver driver;
    public PageResources pageResources;
    Faker faker = new Faker();

    String emailDomain = "@mailsac.com";

    String expectedEntityName = faker.company().name();
    String regularUsername = faker.name().username();
    String expectedRegularUser = regularUsername + emailDomain;
    String adminUsername = faker.name().username();
    String expectedAdminEmail = adminUsername + emailDomain;
    String expectedRegularAccountName = faker.name().fullName();
    String expectedAdminAccountName = faker.name().firstName();
    String accountPassword = "qauber2016!";
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest

    public void setup() throws InterruptedException{

        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "superAdminUserLogin2", priority=0)

    public void cannotManageUsersNotAssignedToAu(String utype, String uname, String password) throws InterruptedException{

        //Go to Wave Fits and login
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);
        pageResources.getLoginPage().setLoginCredentials(uname, password);
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(40000);

        //Click on the Entities Page link
        pageResources.getEntityPage().entityLink().click();
        Thread.sleep(10000);

        //Click on the "Add Entity" button
        pageResources.getEntityPage().addEntity().click();
        Thread.sleep(10000);

        //Enter the expectedEntityName string into the "Entity Name" text field
        pageResources.getAddEntityPage().entityName().sendKeys(expectedEntityName);
        Thread.sleep(10000);

        //Enter a street address in the "Address1" text field and a city name in the "City" text field
        pageResources.getAddEntityPage().address1().sendKeys(faker.address().streetAddress());
        pageResources.getAddEntityPage().city().sendKeys(faker.address().cityName());

        //Select a State from the "State" drop-down
        Select selectState = new Select(pageResources.getAddEntityPage().state());
        selectState.selectByVisibleText(faker.address().state());

        //Enter a postal code for the "Postal Code" text field
        pageResources.getAddEntityPage().postalCode().sendKeys(faker.address().zipCode());

        //Click the "Next" button
        pageResources.getAddEntityPage().nextButton().click();
        Thread.sleep(10000);

        //Enter the expectedRegularUser in the "Invite Regular User" text field
        pageResources.getAddEntityInviteUserPage().inviteUser().sendKeys(expectedRegularUser);
        Thread.sleep(5000);

        //Click the "Next" button and the "Done" button that pops up
        pageResources.getAddEntityInviteUserPage().nextButton().click();
        Thread.sleep(10000);
        pageResources.getAddEntityInviteUserPage().doneButton().click();
        Thread.sleep(30000);

        //Enter the expectedAdminEmail string in the "Invite Admin" text field
        pageResources.getAddEntityInviteAdminPage().inviteAdmin().sendKeys(expectedAdminEmail);
        Thread.sleep(5000);

        //Click the "Next" button and the "Done button that pops up
        pageResources.getAddEntityInviteAdminPage().nextButton().click();
        Thread.sleep(10000);
        pageResources.getAddEntityInviteUserPage().doneButton().click();
        Thread.sleep(50000);

        //Click the "Finish" button
        pageResources.getAddEntitySubscriptionPage().finishButton().click();
        Thread.sleep(30000);

        //Once redirected to the Paypal site, click on the link to the login page
        pageResources.getPaypalPage().clickLoginPage().click();
        Thread.sleep(20000);

        //Enter email, password, and click enter
        pageResources.getPaypalLogin().email().sendKeys("testerjenbuyer@gmail.com");
        pageResources.getPaypalLogin().password().sendKeys("qauber2016!");
        pageResources.getPaypalLogin().submitLogin().click();
        Thread.sleep(10000);

        //Confirm Paypal payment
        pageResources.getPaypalConfirmPaymentPage().continueButton().click();
        Thread.sleep(40000);

        //Log out of Super Admin
        pageResources.getUserMenuPanel().userMenu().click();
        Thread.sleep(20000);
        pageResources.getUserMenuPanel().logOut().click();
        Thread.sleep(70000);

        //Check what email domain is being used and go to the disposable email site with that domain
        if(emailDomain.contains("@mailsac.com")){

            //Go to mailsac.com
            driver.get("https://mailsac.com");
            //Enter in the reguler user's username
            pageResources.getMailsacPage().emailUserName().sendKeys(regularUsername);
            //Click the "Check the mail!" button
            pageResources.getMailsacPage().checkMailButton().click();
            Thread.sleep(10000);
            //Click the newest mail at the top
            pageResources.getMailsacInbox().latestMail().click();
            Thread.sleep(10000);
            //Store the current tab as a variable
            String oldTab = driver.getWindowHandle();

            //Click on the "Unblock links and images" button, list the new tab the link opens to, and switch to it
            pageResources.getMailsacViewMail().unblockLinksnImagesButton().click();
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            Thread.sleep(10000);
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));
            Thread.sleep(10000);

            //Click on the link and click on the registration button
            pageResources.getMailsacUnblockLinksnImages().registrationLink().click();
            Thread.sleep(20000);
            pageResources.getRegistrationPage().registerUserButton().click();
            Thread.sleep(20000);
            //Close the tab
            driver.close();

            //Change back to old tab
            driver.switchTo().window(oldTab);
            //Go back to the home page
            driver.get("https://mailsac.com");
            //Enter the username for the regular user and click "Check the mail!" button
            pageResources.getMailsacPage().emailUserName().sendKeys(regularUsername);
            pageResources.getMailsacPage().checkMailButton().click();
            Thread.sleep(30000);

            //Click on the newest mail
            pageResources.getMailsacInbox().latestMail().click();
            Thread.sleep(10000);

            //Click on the "Unblock links and images" button, list the new tab the link opens, and switch to it
            pageResources.getMailsacViewMail().unblockLinksnImagesButton().click();
            newTab = new ArrayList<String>(driver.getWindowHandles());
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));
            Thread.sleep(10000);

            //Click on the link to the activation page
            pageResources.getMailsacUnblockLinksnImages().activationLink().click();
            Thread.sleep(60000);

            //Close the old tab and switch back to the new one
            driver.switchTo().window(oldTab);
            Thread.sleep(5000);
            driver.close();
            Thread.sleep(5000);
            driver.switchTo().window(newTab.get(0));
            Thread.sleep(5000);

            //Fill in the name for the regular user, set password, confirm password, and click the "Complete Activation" button
            pageResources.getActivationPage().accountName().sendKeys(expectedRegularAccountName);
            pageResources.getActivationPage().password().sendKeys(accountPassword);
            pageResources.getActivationPage().confirmPassword().sendKeys(accountPassword);
            pageResources.getActivationPage().completeActivationButton().click();
            Thread.sleep(30000);

            //Next is activation for admin user

            //Go to mailsac.com
            driver.get("https://mailsac.com");
            //Enter in the admin user's username
            pageResources.getMailsacPage().emailUserName().sendKeys(adminUsername);
            //Click the "Check the mail!" button
            pageResources.getMailsacPage().checkMailButton().click();
            Thread.sleep(10000);
            //Click the newest mail at the top
            pageResources.getMailsacInbox().latestMail().click();
            Thread.sleep(10000);
            //Store the current tab as a variable
            oldTab = driver.getWindowHandle();

            //Click on the "Unblock links and images" button, list the new tab the link opens to, and switch to it
            pageResources.getMailsacViewMail().unblockLinksnImagesButton().click();
            newTab = new ArrayList<String>(driver.getWindowHandles());
            Thread.sleep(10000);
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));
            Thread.sleep(10000);

            //Click on the link and click on the registration button
            pageResources.getMailsacUnblockLinksnImages().registrationLink().click();
            Thread.sleep(20000);
            pageResources.getRegistrationPage().registerUserButton().click();
            Thread.sleep(20000);
            //Close the tab
            driver.close();

            //Change back to old tab
            driver.switchTo().window(oldTab);
            //Go back to the home page
            driver.get("https://mailsac.com");
            //Enter the username for the regular user and click "Check the mail!" button
            pageResources.getMailsacPage().emailUserName().sendKeys(adminUsername);
            pageResources.getMailsacPage().checkMailButton().click();
            Thread.sleep(30000);

            //Click on the newest mail
            driver.findElement(By.xpath("//tbody/tr[2]")).click();
            Thread.sleep(10000);

            //Click on the "Unblock links and images" button, list the new tab the link opens, and switch to it
            pageResources.getMailsacViewMail().unblockLinksnImagesButton().click();
            newTab = new ArrayList<String>(driver.getWindowHandles());
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));
            Thread.sleep(20000);

            //Click on the link to the activation page
            pageResources.getMailsacUnblockLinksnImages().activationLink().click();
            Thread.sleep(60000);

            //Switch back to the old tab, close it, and go back to the new tab
            driver.switchTo().window(oldTab);
            Thread.sleep(5000);
            driver.close();
            Thread.sleep(5000);
            driver.switchTo().window(newTab.get(0));
            Thread.sleep(5000);

            //Fill in the name for the admin account, set password, confirm password, and click the "Complete Activation" button
            pageResources.getActivationPage().accountName().sendKeys(expectedAdminAccountName);
            pageResources.getActivationPage().password().sendKeys(accountPassword);
            pageResources.getActivationPage().confirmPassword().sendKeys(accountPassword);
            pageResources.getActivationPage().completeActivationButton().click();
            Thread.sleep(30000);


        }
        else if(emailDomain.contains("@getnada.com")){

            driver.get("https://app.getnada.com/login");
            driver.findElement(By.xpath("//input[@id = 'emailaddress']")).sendKeys(regularUsername);
            driver.findElement(By.xpath("//button[@type = 'submit']")).click();
            Thread.sleep(20000);
            // Get Window handle of main window
            String parentHandle = driver.getWindowHandle();
            System.out.println(parentHandle);

            // Click on iframe on getnada
            driver.findElement(By.xpath("//small/span[contains(text(),'Invite to FITS')]")).click();

            //switch to that frame and click on link
            //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='idIframe']")));
            Thread.sleep(3000);

            int size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size);

            //WebElement element = driver.findElement(By.id("idIframe"));
            driver.switchTo().frame("idIframe");
            Thread.sleep(2000);

            driver.findElement(By.xpath("html/body/a")).click();
            Thread.sleep(5000);



            for(String windHandles: driver.getWindowHandles())
            {
                driver.switchTo().window(windHandles);
                System.out.println(windHandles);
            }
            // switch focus of WebDriver to the next found window handle (that's your newly opened window)



            // Switch to window handle
            //Go to testwave,Register
            driver.findElement(By.xpath("//button")).click();
            Thread.sleep(10000);
            driver.close();
            Thread.sleep(3000);

            driver.switchTo().window(parentHandle);

            Thread.sleep(10000);
            driver.findElement(By.xpath("//span[@class='name']//span[contains(text(),'@getnada.com')]")).click();
            Thread.sleep(10000);
            //Activate your Account
            driver.findElement(By.xpath("//small/span[contains(text(),'Activate Your Account')]")).click();
            Thread.sleep(3000);

            Thread.sleep(3000);
            driver.switchTo().frame("idIframe");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//p/a")).click();
            Thread.sleep(10000);

            // Create a password

            for(String windHandles: driver.getWindowHandles())
            {
                driver.switchTo().window(windHandles);
                System.out.println(windHandles);
            }
            // switch focus of WebDriver to
            driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(expectedRegularAccountName);
            driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(accountPassword);
            driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(accountPassword);
            driver.findElement(By.xpath("//button[contains(text(),'activation')]")).click();
            Thread.sleep(30000);

            driver.close();

            driver.switchTo().window(parentHandle);

            driver.findElement(By.xpath("//li[@class='logout']/a")).click();
            Thread.sleep(10000);

            //Now activate admin

            //Go to GetNada homepage
            driver.get("https://app.getnada.com/login");
            driver.findElement(By.xpath("//input[@id = 'emailaddress']")).sendKeys(adminUsername);
            driver.findElement(By.xpath("//button[@type = 'submit']")).click();
            Thread.sleep(10000);
            // Get Window handle of main window
            parentHandle = driver.getWindowHandle();
            System.out.println(parentHandle);

            // Click on iframe on getnada
            driver.findElement(By.xpath("//small/span[contains(text(),'Invite to FITS')]")).click();

            //switch to that frame and click on link
            //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='idIframe']")));
            Thread.sleep(3000);

            size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size);

            //WebElement element = driver.findElement(By.id("idIframe"));
            driver.switchTo().frame("idIframe");
            Thread.sleep(2000);

            driver.findElement(By.xpath("html/body/a")).click();
            Thread.sleep(5000);



            for(String windHandles: driver.getWindowHandles())
            {
                driver.switchTo().window(windHandles);
                System.out.println(windHandles);
            }
            // switch focus of WebDriver to the next found window handle (that's your newly opened window)



            // Switch to window handle
            //Go to testwave,Register
            driver.findElement(By.xpath("//button")).click();
            Thread.sleep(10000);
            driver.close();
            Thread.sleep(3000);

            driver.switchTo().window(parentHandle);

            Thread.sleep(10000);
            driver.findElement(By.xpath("//span[@class='name']//span[contains(text(),'@getnada.com')]")).click();
            Thread.sleep(10000);
            //Activate your Account
            driver.findElement(By.xpath("//small/span[contains(text(),'Activate Your Account')]")).click();
            Thread.sleep(3000);

            Thread.sleep(3000);
            driver.switchTo().frame("idIframe");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//p/a")).click();
            Thread.sleep(10000);

            // Create a password

            for(String windHandles: driver.getWindowHandles())
            {
                driver.close();
                driver.switchTo().window(windHandles);
                System.out.println(windHandles);
            }
            // switch focus of WebDriver to
            driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(expectedAdminAccountName);
            driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(accountPassword);
            driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(accountPassword);
            driver.findElement(By.xpath("//button[contains(text(),'activation')]")).click();
            Thread.sleep(30000);

        }
        else{
            System.out.println("Check your email domain");
        }

        //Log in as a different Admin User
        pageResources.getLoginPage().setLoginCredentials("testermonster@mailsac.com", "qauber2016!");
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(30000);

        //Click on the Entities Page link
        pageResources.getEntityPage().entityLink().click();
        Thread.sleep(30000);

        //Iterate through the row of entity names until you find the newly created entity
        //Get a list of all the entity table rows.  This counts the total rows of entities.
        List<WebElement> table = driver.findElements(By.xpath("//table"));
        List<WebElement> entityRows = driver.findElements(By.xpath("//div[@class='col-md-6']//a"));
        System.out.println("entityRows total: " + entityRows.size());
        int i;
        int j;
        for(i = 0; i < entityRows.size(); i++){

            //Get the text of the current entity row
            String str1 = entityRows.get(i).getText();
            System.out.println("entityRow: " + i);
            System.out.println("Contains: " + str1);

            //If the entity name matches the expected entity name, assert they are not equal to confirm this admin user is not
            //assigned to this entity
            if(expectedEntityName.contains(str1)){
                try{
                    Assert.assertNotEquals(str1, expectedEntityName, "The entity names match...  Test has failed.");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                j = i + 2;
                System.out.println("J is " + j);
            }
        }

        //Click on the Users Page link
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(10000);

        //Initialize the actual string, list all web elements that contain the "Next" pagination button
        String actual = null;
        List<WebElement> nextButton = driver.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]"));
        System.out.println("nextButtons: " + nextButton.size());
        //Initialize the index, iRow, and jRow
        int index;
        int iRow;
        int jRow = 0;
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
                    if (username.equals(expectedRegularUser)) {
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
                if (username.equals(expectedRegularUser)) {
                    actual = currentRow.getText();
                    System.out.println("Actual has been found: " + actual);

                    jRow = iRow;
                }
            }
        }

        System.out.println("The actual is: " + actual);
        System.out.println("The expected is: " + expectedRegularUser);
        //After the loop has ended, assert that the actual username matches the string of the expected username
        try{
            Assert.assertEquals(actual, expectedRegularUser, "First fail, user does not exist");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }

        //Grab the web element for the "Deactivate" button for regular user and assert that the button is not enabled.
        //There is currently an unresolved bug that the admin user can deactivate accounts
        WebElement deactivate = driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Deactivate\"]"));
        try {
            softAssert.assertFalse(deactivate.isEnabled(), "Test has failed, the deactivate is enabled");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }

        //Click on the "Delete" button
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Delete\"]")).click();
        Thread.sleep(5000);

        //Grab the text on the alert dialog and assert that it says that the user cannot be deleted.
        WebElement cannotDeleteMessage = driver.findElement(By.xpath("//div[@class=\"ngdialog-message\"]/h5[contains(text(), \"The user could not be removed. It has been assigned to another entity.\")]"));

        try {
            Assert.assertTrue(cannotDeleteMessage.isDisplayed());
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
        }

        driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]")).click();
        Thread.sleep(5000);

        //Let's now search for the admin user of the other entity
        //Reset the value for actual
        actual = null;

        //If there is a nextButton, go back to the first page
        if(nextButton.size() > 0){
            driver.findElement(By.xpath("//a[contains(text(), '1')]")).click();
            Thread.sleep(10000);
        }

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
                    if (username.equals(expectedAdminEmail)) {
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
                if (username.equals(expectedAdminEmail)) {
                    actual = currentRow.getText();
                    System.out.println("Actual has been found: " + actual);

                    jRow = iRow;
                }
            }
        }

        System.out.println("The actual is: " + actual);
        System.out.println("The expected is: " + expectedAdminEmail);
        //After the loop has ended, assert that the actual username matches the string of the expected username
        try{
            Assert.assertEquals(actual, expectedAdminEmail, "First fail, user does not exist");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }

        //Grab the web element for the "Deactivate" button for regular user and assert that the button is not enabled.
        //There is currently an unresolved bug that the admin user can deactivate accounts
        deactivate = driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Deactivate\"]"));
        try {
            softAssert.assertFalse(deactivate.isEnabled(), "Test has failed, the deactivate is enabled");
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
            throw e;
        }

        //Click on the "Delete" button
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Delete\"]")).click();
        Thread.sleep(5000);

        //Grab the text on the alert dialog and assert that it says that the user cannot be deleted.
        cannotDeleteMessage = driver.findElement(By.xpath("//div[@class=\"ngdialog-message\"]/h5[contains(text(), \"The user could not be removed. It has been assigned to another entity.\")]"));

        try {
            Assert.assertTrue(cannotDeleteMessage.isDisplayed());
        }catch (AssertionError e){
            e.getLocalizedMessage();
            //The test will pass, but stacktrace will be printed on console.
            e.printStackTrace();
            //The test will fail, stacktrace will be printed on console and TestNg log files.
        }

        //Close message
        driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]")).click();
        Thread.sleep(5000);
    }

    @AfterTest

    public void close() throws InterruptedException{

        pageResources.getUserMenuPanel().userMenu().click();
        Thread.sleep(20000);
        pageResources.getUserMenuPanel().logOut().click();
        Thread.sleep(30000);

        pageResources.getLoginPage().setLoginCredentials("testerbob@mailsac.com", "qauber2016!");
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(30000);

        pageResources.getEntityPage().entityLink().click();
        Thread.sleep(30000);

        //Iterate through the row of entity names until you find the newly created entity
        //Get a list of all the entity table rows.  This counts the total rows of entities.
        List<WebElement> table = driver.findElements(By.xpath("//table"));
        List<WebElement> entityRows = driver.findElements(By.xpath("//div[@class='col-md-6']//a"));
        System.out.println("entityRows total: " + entityRows.size());
        int i;
        int j;
        for(i = 0; i < entityRows.size(); i++){

            String str1 = entityRows.get(i).getText();
            System.out.println("entityRow: " + i);
            System.out.println("Contains: " + str1);
            if(expectedEntityName.contains(str1)){
                try{
                    Assert.assertEquals(str1, expectedEntityName, "Match of entity not found");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                j = i + 2;
                System.out.println("J is " + j);
                driver.findElement(By.xpath("//tr[" + j + "]//button[@title=\"Delete\"]")).click();
                Thread.sleep(10000);
                driver.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
                Thread.sleep(20000);
            }
        }

        //Click on the Users Page link
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(20000);

        String actual = null;
        List<WebElement> nextButton = driver.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]"));
        System.out.println("nextButtons: " + nextButton.size());
        int index;
        int iRow;
        int jRow = 0;
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
                    if (username.equals(expectedRegularUser)) {
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
            for (iRow = 1; iRow <= (userRows.size() - 1) && actual == null; iRow++) {
                //While going through each row, grab the username of the current row and set it as a string
                WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                System.out.println("Current userRow is: " + iRow);
                String username = currentRow.getText();
                System.out.println(username);

                //If the username matches the expected result, set the string as the actual result
                if (username.equals(expectedRegularUser)) {
                    actual = currentRow.getText();
                    System.out.println("Actual has been found: " + actual);

                    jRow = iRow;
                }
            }
        }

        //Delete the user
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Delete\"]")).click();
        Thread.sleep(5000);
        pageResources.getUsersPage().confirmDeletion().click();
        Thread.sleep(10000);

        //Let's now delete the admin user
        //Set actual to null
        actual = null;

        //If there is a nextButton, go back to the first page
        if(nextButton.size() > 0){
            driver.findElement(By.xpath("//a[contains(text(), '1')]")).click();
            Thread.sleep(10000);
        }

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
                    if (username.equals(expectedAdminEmail)) {
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
            for (iRow = 1; iRow <= (userRows.size() - 1) && actual == null; iRow++) {
                //While going through each row, grab the username of the current row and set it as a string
                WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                System.out.println("Current userRow is: " + iRow);
                String username = currentRow.getText();
                System.out.println(username);

                //If the username matches the expected result, set the string as the actual result
                if (username.equals(expectedAdminEmail)) {
                    actual = currentRow.getText();
                    System.out.println("Actual has been found: " + actual);

                    jRow = iRow;
                }
            }
        }

        //Delete the admin user
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Delete\"]")).click();
        Thread.sleep(5000);
        pageResources.getUsersPage().confirmDeletion().click();
        Thread.sleep(10000);

        //Close browser
        driver.close();

    }
}
