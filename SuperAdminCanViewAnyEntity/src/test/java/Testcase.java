import Pages.*;
import TestResources.PageResources;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.testng.Assert.assertTrue;


/**   SUPER ADMIN CAN VIEW ALL ENTITIES ON ENTITY PAGE
 * Preconditions: Setup the browser. Sign in as super user, create 5 entities.
 * Steps:
 * 1. Sign in as a super user.
 * 2. Go to Entities.
 * 3. View the entity page, and search the page for the five entities and compare the names, assert that they are present.
 * 4. Super user is hence able to view all entities.
 * 5. Get it printed out: we finally print that test succeeds after step 4.
 * Created by jaishree on 3/30/17.
 */

public class Testcase
{

    WebDriver driver; //creates an object driver to use in browser

    public PageResources pageResources;
    //gain access to Page class using Pageresource

    public String[] EntityNamer = new String[2];
    public String ExpectedEntityNameOne;


    //private By closePopup = By.cssSelector(".ngdialog-close");

    @BeforeTest
    //setting up browser driver for test, logging in beforehand

    public void setup() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources = new PageResources(driver); //new object that acts for PageResources powered by (driver)
        driver.get("http://testwave.qabidder.net/#/page/login"); //URL
        pageResources.getLogin().setUserName().sendKeys("superuser@getnada.com");
        pageResources.getLogin().setPassword().sendKeys("superuser");
        Thread.sleep(2000);
        pageResources.getLogin().clickLogin().click();
        Thread.sleep(3000);

    }
        @Test(priority = 1)
        //In Priority 1, from lines 69-112 we create the first entity which has a different Paypal payments setting enabled since it is
        //first time. In lines 115-166, we create four more entities using a for loop(the paypal payment settings are
        //constant for all of them. If the first entity had also been created in the loop, there would have been need for manual
        //intervention.
        public void AddingEntity () throws InterruptedException
        {
            //First Entity Creation
            pageResources.getMainNavigation().Entities().click();
            pageResources.getEntities().AddEntity().click();
            ExpectedEntityNameOne = randomAlphanumeric(6).toLowerCase();
            Thread.sleep(1000);
            pageResources.getCreateEntities().EntityName().sendKeys(ExpectedEntityNameOne);
            Thread.sleep(1000);
            String Address1 = randomAlphanumeric(6).toLowerCase();
            Thread.sleep(1000);
            pageResources.getCreateEntities().Address1().sendKeys(Address1);
            String City = randomAlphanumeric(6).toLowerCase();
            Thread.sleep(1000);
            pageResources.getCreateEntities().City().sendKeys(City);
            pageResources.getCreateEntities().State().sendKeys("Utah");
            Thread.sleep(1000);
            pageResources.getCreateEntities().PostalCode().sendKeys("64504");
            Thread.sleep(2000);
            System.out.println("The value of entity this time is " + ExpectedEntityNameOne);

            pageResources.getCreateEntities().Nextbutton().click();
            Thread.sleep(2000);
            String RegularUsername = randomAlphanumeric(6).toLowerCase();
            pageResources.getInviteRegularUser().EmailField().sendKeys(RegularUsername + "@getnada.com");
            pageResources.getInviteRegularUser().NextbuttonafterRegUsers().click();
            Thread.sleep(4000);
            pageResources.getInviteRegularUser().Donebutton().click();
            String AdminUsername = randomAlphanumeric(6).toLowerCase();
            Thread.sleep(3000);
            pageResources.getInviteAdminUser().EmailFieldA().sendKeys(AdminUsername + "@getnada.com");
            Thread.sleep(4000);
            pageResources.getInviteAdminUser().NextbuttonafterAdminUsers().click();
            Thread.sleep(3000);
            pageResources.getInviteAdminUser().Donebutton().click();
            Thread.sleep(3000);
            pageResources.getInviteAdminUser().Finishbtn().click();
            Thread.sleep(3000);

            pageResources.getPaypal().ExistingPaypalAccountSignin().click();
            pageResources.getPaypal().PaypalEmail().clear();
            pageResources.getPaypal().PaypalEmail().sendKeys("horridfarter@mailinator.com");
            pageResources.getPaypal().PaypalPassword().sendKeys("horridfarter");
            pageResources.getPaypal().PaypalLoginButton().click();
            Thread.sleep(7000);
            pageResources.getPaypal().AgreeandContinue().click();
            Thread.sleep(5000);


            for (int i = 0; i < 1; i++) { //Setting i<n, depending on how many iterations we want. I've set this to 1
                //Creating Entity Two, if you need more, increase the value of n in (i<n) in line 116
                pageResources.getMainNavigation().Entities().click();
                pageResources.getEntities().AddEntity().click();
                EntityNamer[i] = randomAlphanumeric(7).toLowerCase();
                System.out.println("The value of entity this time is " + EntityNamer[i]);
                Thread.sleep(1000);
                //System.out.println("The value of entity name this time is"+EntityNamer[i]);
                pageResources.getCreateEntities().EntityName().sendKeys(EntityNamer[i]);
                Thread.sleep(1000);
                //Since this is an iteration, storing the entity name each time is only
                // possible after having declared it as an array in line 38

                String Address12 = randomAlphanumeric(6).toLowerCase();
                Thread.sleep(1000);
                pageResources.getCreateEntities().Address1().sendKeys(Address12);
                String City2 = randomAlphanumeric(6).toLowerCase();
                Thread.sleep(1000);
                pageResources.getCreateEntities().City().sendKeys(City2);
                pageResources.getCreateEntities().State().sendKeys("Utah");
                Thread.sleep(1000);
                pageResources.getCreateEntities().PostalCode().sendKeys("64504");
                Thread.sleep(5000);
                Thread.sleep(3000);

                pageResources.getCreateEntities().Nextbutton().click();
                Thread.sleep(2000);
                String RegularUsername2 = randomAlphanumeric(6).toLowerCase();
                pageResources.getInviteRegularUser().EmailField().sendKeys(RegularUsername2 + "@getnada.com");
                pageResources.getInviteRegularUser().NextbuttonafterRegUsers().click();
                Thread.sleep(4000);
                pageResources.getInviteRegularUser().Donebutton().click();
                String AdminUsername2 = randomAlphanumeric(6).toLowerCase();
                Thread.sleep(2000);
                pageResources.getInviteAdminUser().EmailFieldA().sendKeys(AdminUsername2 + "@getnada.com");
                Thread.sleep(2000);
                pageResources.getInviteAdminUser().NextbuttonafterAdminUsers().click();
                Thread.sleep(4000);
                pageResources.getInviteAdminUser().Donebutton().click();
                Thread.sleep(7000);
                pageResources.getInviteAdminUser().Finishbtn().click();
                Thread.sleep(5000);

                pageResources.getPaypal().PaypalEmail().clear();
                pageResources.getPaypal().PaypalEmail().sendKeys("horridfarter@mailinator.com");
                pageResources.getPaypal().PaypalPassword().sendKeys("horridfarter");
                pageResources.getPaypal().PaypalLoginButton().click();
                Thread.sleep(7000);
                pageResources.getPaypal().AgreeandContinue().click();
                Thread.sleep(5000);
            }
        }

    //Straightaway signing in only inside @Test. Verifying that n Entities all created are viewable.
    @Test(priority = 2,dataProviderClass = DataProviderClass.class, dataProvider = "SuperUserCreds")

    public void testcase(String email, String password) throws Exception
    {    //Open webpage, go to pageresources, call linked/nested functions and enter values

        driver.get("http://testwave.qabidder.net/#/page/login"); //URL
        Thread.sleep(8000);
        //Since we're already signed into the superusercreds @Test1, @Test2 doesn't need lines 178-183.
//        pageResources.getLogin().setUserName().sendKeys(email); //Username
//
//        pageResources.getLogin().setPassword().sendKeys(password); //pwd
//
//        pageResources.getLogin().clickLogin().click(); //Login
//        Thread.sleep(4000);

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
        //Going into Entities, and getting the xpath of Entity names, and grabbing names. Comparing them with entity names
        // that we have provided previously during the creation of the Entities

        pageResources.getMainNavigation().Entities().click();
        String ActualEntityOne = driver.findElement(By.xpath("//tr[2][@ng-repeat='entity in $ctrl.entitiesOnPage']")).getText();
        //To compare ActualEntityOne with ExpectedEntityNameOne
        try {
            assertTrue(ActualEntityOne.contains(ExpectedEntityNameOne));
            //for now commenting this: Assert.assertEquals(ActualEntityOne, ExpectedEntityNameOne);
            //If entity names are the same
            System.out.println(ExpectedEntityNameOne+" First Entity Visibility: Verified");
        } catch (Exception e) {
            e.printStackTrace();
            //If the entity does not match
            System.out.println("Entity Mismatch");
        }

       String ActualEntityTwo = driver.findElement(By.xpath("//tr[3][@ng-repeat='entity in $ctrl.entitiesOnPage']")).getText();
        //To compare Actual Entity Two with Expected Entity 2 provided in Array EntityNamer[] in the for loop
        try {
            assertTrue(ActualEntityTwo.contains(EntityNamer[0]));
             // Assert.assertEquals(ActualEntityTwo, EntityNamer[0]);
            //If entity names are the same
            System.out.println(EntityNamer[0]+" Second Entity Visibility: Verified");
        } catch (Exception e) {
            e.printStackTrace();
            //If the entity does not match
            System.out.println("Entity Mismatch");
        }
        //The following lines are commented as i<1 in line 116. When i<5, the following lines can be un-commented
//        String ActualEntityThree = driver.findElement(By.xpath("//tr[4][@ng-repeat='entity in $ctrl.entitiesOnPage']")).getText();
//
//        try {
//            assertTrue(ActualEntityThree.contains(EntityNamer[1]));
//            //If entity names are the same
//            System.out.println(EntityNamer[1]+" Third Entity Visibility: Verified");
//        } catch (Exception e) {
//            e.printStackTrace();
//            //If the entity does not match
//            System.out.println("Entity Mismatch");
//        }

//        String ActualEntityFour = driver.findElement(By.xpath("//tr[5][@ng-repeat='entity in $ctrl.entitiesOnPage']")).getText();
//
//        try {
//            assertTrue(ActualEntityFour.contains(EntityNamer[2]));
//            //If entity names are the same
//            System.out.println(EntityNamer[2]+" Fourth Entity Visibility: Verified");
//        } catch (Exception e) {
//            e.printStackTrace();
//            //If the entity does not match
//            System.out.println("Entity Mismatch");
//        }
//
//        String ActualEntityFive = driver.findElement(By.xpath("//tr[6][@ng-repeat='entity in $ctrl.entitiesOnPage']")).getText();
//
//        try {
//            assertTrue(ActualEntityFive.contains(EntityNamer[3]));
//            //If entity names are the same
//            System.out.println(EntityNamer[3]+" Fifth Entity Visibility: Verified");
//        } catch (Exception e) {
//            e.printStackTrace();
//            //If the entity does not match
//            System.out.println("Entity Mismatch");
//        }

        System.out.println("All entities created are visible to the Super User. Verified");

        //Cleanup
        //Deleting the entities

        //Deleting Entity 2
        pageResources.getEntities().Deletebtn2().click();
        Thread.sleep(2000);
        pageResources.getEntities().ConfirmDelete().click();
        Thread.sleep(3000);

        //Deleting Entity 1
        Thread.sleep(5000);
        pageResources.getEntities().Deletebtn1().click();
        Thread.sleep(2000);
        pageResources.getEntities().ConfirmDelete().click();
        Thread.sleep(2000);


        driver.close();
        driver.quit();


    }
}