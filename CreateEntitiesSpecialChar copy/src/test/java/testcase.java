import TestResources.PageResources;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

/**
 1. Login to testwave.
 2. Go to Entities, create entities.
 3. Enter only special characters in Entities name
 4. Finish all fields in create entities.
 5. Finish payment for entities using paypal
 6. Check Entities page to see if special character-named entity is created.
 7. Delete entity created as cleanup

 * Created by jaishree on 4/6/17.
 */
public class testcase {

    WebDriver driver; //creates an object driver to use in browser

    public PageResources pageResources;
    //gain access to Page class using Pageresource




    //private By closePopup = By.cssSelector(".ngdialog-close");

    @BeforeTest
    //setting up browser driver for test, logging in beforehand

    public void setup() throws InterruptedException {
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

    @Test
    public void AddingEntity() throws InterruptedException {
        //First Entity Creation
        pageResources.getMainNavigation().Entities().click();
        pageResources.getEntities().AddEntity().click();

        String splcharacters = "~`!@#$%^&*()-_=+[{]}|;:\'\",<.>/?";
        String ExpectedEntityName = RandomStringUtils.random( 10, splcharacters );

        Thread.sleep(1000);
        pageResources.getCreateEntities().EntityName().sendKeys(ExpectedEntityName);
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
        System.out.println("The value of entity entered is " + ExpectedEntityName);

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

        String ActualEntityName = pageResources.getEntities().EntityName().getText();
        System.out.println("Asserting Actual and Expected Entity Values...");
        Assert.assertEquals(ExpectedEntityName,ActualEntityName, "Strings are not the same");
        System.out.println("Entity with special characters created and passed successfully");
    }

    @AfterTest
    public void Cleanup() throws InterruptedException {
        //Deleting Entity 1
        Thread.sleep(5000);
        pageResources.getEntities().Deletebtn1().click();
        Thread.sleep(2000);
        pageResources.getEntities().ConfirmDelete().click();
        Thread.sleep(2000);
        System.out.println("Entity cleaned up after test");

        driver.close();
        driver.quit();
    }



}