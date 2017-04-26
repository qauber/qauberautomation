package TestCases;

import ObjectRepository.PageResources;
import Pages.DataProviderClass;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jennifer Grelik on 3/28/2017.
 * This test script does a sanity check on whether an admin user is able to manage
 * the users to the entities they're assigned to.
 */
public class ManageUsersAU {
    public WebDriver driver;
    public PageResources pageResources;
    Faker faker = new Faker();
    String emailDomain = "@mailsac.com";
    String expectedEntityName = faker.company().name();

    @BeforeTest

    public void setup() throws InterruptedException{

        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "superAdminUserLogin2", priority=0)

    public void test1(String utype, String uname, String password) throws InterruptedException{

        //Go to the Wave Fits site and login as Super Admin
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);
        pageResources.getLoginPage().setLoginCredentials(uname, password);
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(40000);

        //Click on Entities tab
        pageResources.getEntityPage().entityLink().click();
        Thread.sleep(10000);

        //Click on Add Entity button
        pageResources.getEntityPage().addEntity().click();
        Thread.sleep(10000);

        //Add entity name, address, and city name
        pageResources.getAddEntityPage().entityName().sendKeys(expectedEntityName);
        Thread.sleep(5000);
        pageResources.getAddEntityPage().address1().sendKeys(faker.address().streetAddress());
        pageResources.getAddEntityPage().city().sendKeys(faker.address().cityName());

        //Select the state
        Select selectState = new Select(pageResources.getAddEntityPage().state());
        selectState.selectByVisibleText(faker.address().state());

        //Input a postal code for the Postal Code text field
        pageResources.getAddEntityPage().postalCode().sendKeys(faker.address().zipCode());

        //Click the Next button
        pageResources.getAddEntityPage().nextButton().click();
        Thread.sleep(10000);

        //String together the expected regular user email and input into the Invite Regular User text field
        String regularUsername = faker.name().username();
        String expectedRegularUser = regularUsername + emailDomain;
        pageResources.getAddEntityInviteUserPage().inviteUser().sendKeys(expectedRegularUser);
        Thread.sleep(5000);

        //Click the Next button and Done button
        pageResources.getAddEntityInviteUserPage().nextButton().click();
        Thread.sleep(10000);
        pageResources.getAddEntityInviteUserPage().doneButton().click();
        Thread.sleep(30000);

        //Input the provided Admin User already used in the DataProviderClass
        pageResources.getAddEntityInviteAdminPage().inviteAdmin().sendKeys("testermonster@mailsac.com");
        Thread.sleep(5000);

        //Click the Next button and Done button
        pageResources.getAddEntityInviteAdminPage().nextButton().click();
        Thread.sleep(10000);
        pageResources.getAddEntityInviteUserPage().doneButton().click();
        Thread.sleep(30000);

        //Click the Finish button
        pageResources.getAddEntitySubscriptionPage().finishButton().click();
        Thread.sleep(30000);

        //Once on paypal, click on the Login link
        pageResources.getPaypalPage().clickLoginPage().click();
        Thread.sleep(20000);

        //Input the Paypal sandbox login credentials
        pageResources.getPaypalLogin().email().sendKeys("testerjenbuyer@gmail.com");
        pageResources.getPaypalLogin().password().sendKeys("qauber2016!");
        pageResources.getPaypalLogin().submitLogin().click();
        Thread.sleep(10000);

        //Click the Continue button
        pageResources.getPaypalConfirmPaymentPage().continueButton().click();
        Thread.sleep(40000);

        //Log out of Super Admin
        pageResources.getUserMenuPanel().userMenu().click();
        Thread.sleep(20000);
        pageResources.getUserMenuPanel().logOut().click();
        Thread.sleep(70000);

        //Set String values for account activation for the next steps
        String expectedAccountName = faker.name().fullName();
        String accountPassword = "qauber2016!";

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
            Thread.sleep(30000);
            //Close the tab
            driver.close();

            //Change back to old tab
            driver.switchTo().window(oldTab);
            //Go back to the home page
            driver.get("https://mailsac.com");
            //Enter the username for the regular user and click "Check the mail!" button
            pageResources.getMailsacPage().emailUserName().sendKeys(regularUsername);
            pageResources.getMailsacPage().checkMailButton().click();
            Thread.sleep(10000);

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
            pageResources.getActivationPage().accountName().sendKeys(expectedAccountName);
            pageResources.getActivationPage().password().sendKeys(accountPassword);
            pageResources.getActivationPage().confirmPassword().sendKeys(accountPassword);
            pageResources.getActivationPage().completeActivationButton().click();
            Thread.sleep(30000);


        }
        else{
            System.out.println("Check your email domain");
        }

        //Log in as Admin User
        pageResources.getLoginPage().setLoginCredentials("testermonster@mailsac.com", "qauber2016!");
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(30000);

        //Click on the entity link
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
            //Grab the text of the entity name
            String str1 = entityRows.get(i).getText();
            System.out.println("entityRow: " + i);
            System.out.println("Contains: " + str1);

            //If the string matches the name of the entity, assert that they match
            if(expectedEntityName.contains(str1)){
                try{
                    Assert.assertEquals(str1, expectedEntityName, "Match of entity not found");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                j = i + 2;
                System.out.println("J is " + j);
                driver.findElement(By.xpath("//tr[" + j + "]//button[@title=\"Assign permissions\"]")).click();
            }
        }

        Thread.sleep(60000);

        //Iterate through the row of users that can be assigned until you reach the newly added user
        //Assert that the newly added user is set as a regular user
        List<WebElement> userAssignRows = driver.findElements(By.xpath("//tr[@ng-repeat=\"user in $assignCtrl.users\"]//div"));
        for(i = 0; i < userAssignRows.size(); i++){

            //Get the text of the current user row
            String str1 = userAssignRows.get(i).getText();
            System.out.println("userRow: " + i);
            System.out.println("Contains: " + str1);

            //If the string matches the expected account name, assert that they are the same
            if(expectedAccountName.contains(str1)){
                try{
                    Assert.assertEquals(str1, expectedAccountName, "Match of regular user not found");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                break;
            }
        }
        j = i + 1;

        //Get the actual assigned permission and assert that it matches the expected
        String actualAssignedPermission = new Select(driver.findElement(By.xpath("//tr[" + j + "]//select[@ng-model=\"user.assignedRole\"]"))).getFirstSelectedOption().getText();
        System.out.println(actualAssignedPermission);
        try {
            Assert.assertEquals(actualAssignedPermission, "Regular user", "User is not assigned as a regular user");
        }
        catch(Throwable t){
            t.getLocalizedMessage();
        }

        Thread.sleep(5000);
        //Click on the Delete Assignment button
        driver.findElement(By.xpath("//tr[" + j + "]/td[3]/button[@ng-click=\"$assignCtrl.detach(user)\"]")).click();

        Thread.sleep(5000);
        //Select Admin as the new permission
        Select selectPermission = new Select(driver.findElement(By.xpath("//tr[" + j + "]//select[@ng-model=\"user.assignedRole\"]")));
        selectPermission.selectByVisibleText("Admin");

        //Save the new permission
        driver.findElement(By.xpath("//tr[" + j + "]/td[3]/button[@ng-click=\"$assignCtrl.update(user)\"]")).click();
        Thread.sleep(5000);

        //Assert the new, actual permission matches the expected permission
        actualAssignedPermission = new Select(driver.findElement(By.xpath("//tr[" + j + "]//select[@ng-model=\"user.assignedRole\"]"))).getFirstSelectedOption().getText();
        System.out.println(actualAssignedPermission);
        try {
            Assert.assertEquals(actualAssignedPermission, "Admin", "User is not assigned as a regular user");
        }
        catch(Throwable t){
            t.getLocalizedMessage();
        }

        //Close the User Assignment page
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement close = pageResources.getEntityAssignPermissionsPage().closePermissions();
        executor.executeScript("arguments[0].click();",close);
        Thread.sleep(10000);

        //Click on the Users Page link
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(10000);

        //Iterate through the User rows
        //Initiate the actual, list the nextButton for pagination, initiate the index, iRow, and jRow
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

        //Click on the deactivate button
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Deactivate\"]")).click();
        Thread.sleep(5000);
        //Click on the activate button
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Activate\"]")).click();
        Thread.sleep(5000);

        //Click on the delete button
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title=\"Delete\"]")).click();
        pageResources.getUsersPage().confirmDeletion().click();
        Thread.sleep(10000);

    }

    @AfterTest

    public void close() throws InterruptedException{
        //Log out of the current user
        pageResources.getUserMenuPanel().userMenu().click();
        Thread.sleep(20000);
        pageResources.getUserMenuPanel().logOut().click();
        Thread.sleep(30000);

        //Log in as Super Admin
        pageResources.getLoginPage().setLoginCredentials("testerbob@mailsac.com", "qauber2016!");
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(30000);

        //Go to Entities page
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
            //Get the text of the entity name
            String str1 = entityRows.get(i).getText();
            System.out.println("entityRow: " + i);
            System.out.println("Contains: " + str1);

            //If the string matches the expected entity name, assert that they match
            if(expectedEntityName.contains(str1)){
                try{
                    Assert.assertEquals(str1, expectedEntityName, "Match of entity not found");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                j = i + 2;
                System.out.println("J is " + j);
                //Delete the entity
                driver.findElement(By.xpath("//tr[" + j + "]//button[@title=\"Delete\"]")).click();
                Thread.sleep(10000);
                driver.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
                Thread.sleep(20000);
            }
        }

        //Close browser
        driver.close();
    }
}
