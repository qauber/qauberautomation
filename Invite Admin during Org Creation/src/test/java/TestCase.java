import Pages.DataProviderClass;
import TestResources.PageResources;
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

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;


/**INVITE ADMIN USER DURING ORG CREATION
 * Preconditions: Setup the browser
 * Steps:
 * 1. Sign in as a super user
 * 2. Create a company, and entity1.
 * 3. After clicking on Next button after creating an entity, next screen has a field to enter Regular user
 * 4. Generate random alphanumeric string and append @mailinator.com, and write it into the field as email (Regular user)
 * 5. Click on next: goes to screen that asks you to invite admin users
 * 6. Generate random alphanumeric string, append @mailinator.com and write it into the field (Admin user)
 * 7. Click on next and complete paypal subscription. done.
 * 8. Go to Entities.
 * 9. Go to the Last created Entity and click on User permissions
 * 10. Verify: Search for the last email invited  on step 6 and get the rights of the same person
 * 11. Get it printed out: we finally print that test succeeds after the rights of the last invited email have the rights of an Admin
 * Created by jaishree on 3/23/17.
 */
public class TestCase {


    WebDriver driver; //creates an object driver to use in browser

    public PageResources pageResources;
    //gain access to Page class using Pageresource

    private By closePopup = By.cssSelector(".ngdialog-close");
    @BeforeTest
    //setting up browser driver for test

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources = new PageResources(driver); //new object that acts for PageResources powered by (driver)
    }
    //Straightaway signing in only inside @Test
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "SuperUserCreds")

    public void testcase(String email, String password) throws Exception {    //Open webpage, go to pageresources, call linked/nested functions and enter values

        driver.get("http://testwave.qabidder.net/#/page/login"); //URL
        Thread.sleep(4000);
        pageResources.getLogin().setUserName().sendKeys(email); //Username

        pageResources.getLogin().setPassword().sendKeys(password); //pwd

        pageResources.getLogin().clickLogin().click(); //Login
        Thread.sleep(4000);

        pageResources.getLogin().LoginNamecheck().click(); //click on Loginname
        Thread.sleep(4000);

        String actuallogin = pageResources.getLogin().Emailcheck().getText(); //Get the email associated with the signedin account, check credentials
        Thread.sleep(2000);

        //checking with assert if login is successful: with xpath of login


        try {
            Assert.assertEquals(actuallogin, email);
            //    If the message is displayed
            System.out.println("Login Successful");
        } catch (Exception e) {
            e.printStackTrace();
            //If the message is not displayed
            System.out.println("Login failed");
        }

        //Start creating entity
        pageResources.getMainNavigation().Entities().click();
        Thread.sleep(2000);
        pageResources.getMainNavigation().AddEntity().click();

        String Entityname = randomAlphanumeric(6).toLowerCase();
        pageResources.getCreateEntity().EntityName().sendKeys(Entityname);
        String Address1 = randomAlphanumeric(6).toLowerCase();
        pageResources.getCreateEntity().Address1().sendKeys(Address1);
        String City = randomAlphanumeric(6).toLowerCase();
        pageResources.getCreateEntity().City().sendKeys(City);

        pageResources.getCreateEntity().State().sendKeys("California");
        pageResources.getCreateEntity().PostalCode().sendKeys("12132");
        Thread.sleep(3000);
        //Store EntityName here
        String EntityName = pageResources.getCreateEntity().EntityName().getText();
        pageResources.getCreateEntity().Nextbutton().click();
        Thread.sleep(2000);

        //Enter the email for inviting regular users
        String n = randomAlphanumeric(6).toLowerCase();
        pageResources.getInviteRegularUsers().EmailField().sendKeys(n + "@mailinator.com");
        Thread.sleep(3000);

        Thread.sleep(2000);

        pageResources.getInviteRegularUsers().NextbuttonafterRegUsers().click();
        Thread.sleep(2000);
        //Store the regular user's email just in case.
        String RegularUserEmail = driver.findElement(By.xpath("//span[@class='ml-sm mr-sm ng-binding']")).getText();
        Thread.sleep(3000);
        System.out.println("Regular User Email Invited is " + RegularUserEmail);

        pageResources.getInviteRegularUsers().Donebutton().click();
        //pageResources.getInviteRegularUsers().Donebutton().click();
        Thread.sleep(6000);
        //Preparing and entering email to invite Admin users
        String another = randomAlphanumeric(6).toLowerCase();
        Thread.sleep(6000);
        pageResources.getInviteAdminUsers().EmailFieldA().sendKeys(another + "@mailinator.com");
        Thread.sleep(4000);
        pageResources.getInviteAdminUsers().NextbuttonafterAdminUsers().click();
        Thread.sleep(6000);
        //Storing the Admin user email
        String ExpectedAdminUserEmail = driver.findElement(By.xpath("//span[@class='ml-sm mr-sm ng-binding']")).getText();
        Thread.sleep(3000);
        //printing out the admin user email
        System.out.println("Admin User Invited is (Expected Name) " + ExpectedAdminUserEmail);

        pageResources.getInviteAdminUsers().Donebutton().click();
        Thread.sleep(5000);
        pageResources.getInviteAdminUsers().Finishbtn().click();
        Thread.sleep(2000);
        //FINISH PAYPAL PAYMENT
        /*Here the default option open for the current signed in user when he lands on Paypal is 'Create a new Paypal Account',
        which is we need to click on 'sign in with existing account*/

        pageResources.getPaypal().ExistingPaypalAccountSignin().click();
        Thread.sleep(2000);
        pageResources.getPaypal().PaypalEmail().clear();
        pageResources.getPaypal().PaypalEmail().sendKeys("horridfarter@mailinator.com");
        pageResources.getPaypal().PaypalPassword().sendKeys("horridfarter");
        pageResources.getPaypal().PaypalLoginButton().click();
        Thread.sleep(7000);
        pageResources.getPaypal().AgreeandContinue().click();
        Thread.sleep(5000);
        //Payment is complete successfully and we land on Entities page
        pageResources.getInviteAdminUsers().Entities().click();
        //Verification: Go to Entity Name created and go to Permissions
        pageResources.getInviteAdminUsers().LastCreatedEntityPermissions().click();
        Thread.sleep(10000);
        //Get the email of the last user invited
        String LastUserInvited = pageResources.getInviteAdminUsers().LastUserCreated().getText();
        System.out.println("The last invited user was (Actual Name) " + LastUserInvited);
        //Get the corresponding selected right/permission for the same user
        String PermissionforLastUserInvited = new Select(pageResources.getInviteAdminUsers().LastUserPermissions()).getFirstSelectedOption().getText();
        //Print it out
        System.out.println("The last invited user has the permissions of an " + PermissionforLastUserInvited);

        try {
            Assert.assertEquals(ExpectedAdminUserEmail, LastUserInvited);
            System.out.println("Admin User:" + LastUserInvited + ": Invited User confirmed to be the same");
        } catch (Throwable t) {
            org.testng.Assert.fail("Expected and Actual user emails do not match");
        }


        //Close the popup
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement close = driver.findElement(closePopup);
        Thread.sleep(5000);
        executor.executeScript("arguments[0].click();", close);
        Thread.sleep(5000);
    }


            //Cleanup: deleting entity and deleting users
        @AfterTest
        public void Cleanup() throws InterruptedException {

            pageResources.getMainNavigation().Entities().click();
            pageResources.getEntities().EntityDelete().click();
            pageResources.getEntities().DeleteConfirmation().click();

            Thread.sleep(3000);
            pageResources.getMainNavigation().Users().click();

            pageResources.getUsers().DeleteButton2().click();
            pageResources.getUsers().DeleteConfirm().click();
            Thread.sleep(2000);

            pageResources.getUsers().DeleteButton1().click();
            pageResources.getUsers().DeleteConfirm().click();
            Thread.sleep(2000);

            pageResources.getInviteAdminUsers().ProfileName().click();
            Thread.sleep(4000);
            pageResources.getInviteAdminUsers().Logout().click();
            //Close and quit
            driver.close();
            driver.quit();
        }






    }



