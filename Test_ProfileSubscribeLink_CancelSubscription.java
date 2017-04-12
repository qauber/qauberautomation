package test_SanityCheck;

import helper.Subscription_Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

/**
TC: Subscription link in Profile panel
 Pre condition:
 1.Login
 2.Subscribed Entity
 Steps:
 1.Click on profile menu
 2.Click on Subscribe menu icon(profile menu collapse)
 3.Click profile menu
 4.Click on Subscribe link
 5.Click " cancel subscription"

 */
public class Test_ProfileSubscribeLink_CancelSubscription {
    WebDriver driver;
    int k;
    String baseUrl = "http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    Subscription_Helper objSubscription_Helper;

    By UserName_icon = By.xpath("//div//a/span[@class='mr-sm ng-binding']");
    By subscribeLink_Icon = By.xpath("//div[@class='ng-isolate-scope']//li[2]/a");
    By subscription_Link = By.xpath("//div[@class='media bb pl-sm pr-sm ng-scope']//a");
    By cancel_Subscription_Button = By.xpath("//div[@class='ngdialog-message']//button[text()='CANCEL Subscription']");
    By confirm_button = By.xpath("//div[@class='text-center']//button[text()='YES']");

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("roja@getnada.com", "testing");
        Thread.sleep(2000);

    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

    @Test
    public void verifyCancel_Subscription() throws InterruptedException {
        /** Calling helper function to subscribe entity*/
        objSubscription_Helper = new Subscription_Helper(driver);
        String result = objSubscription_Helper.sau_Add_Company();
        Thread.sleep(3000);


        /**click user icon in profile panel */
        driver.findElement(UserName_icon).click();
        Thread.sleep(1000);
        /** click Subscription link Icon */
        driver.findElement(subscribeLink_Icon).click();
        Thread.sleep(1000);
        boolean expected_element = driver.findElement(subscription_Link).isDisplayed();
        System.out.println("Subscription link is displayed " + expected_element);
        Thread.sleep(1000);
        /** click on subscription link */
        driver.findElement(subscription_Link).click();
        Thread.sleep(1000);
        driver.findElement(cancel_Subscription_Button).click();
        Thread.sleep(1000);
        driver.findElement(confirm_button).click();
        Thread.sleep(3000);

        List<WebElement> allRows = driver.findElements(By.xpath("//table//tr[@class='ng-scope']"));
        System.out.println(" No of rows found :" + allRows.size());

        for (int j = 1; j < allRows.size(); j++) {
            System.out.println("Row num :" + j);
            if (allRows.get(j).getText().contains(result)) {
                System.out.println("Found newly added Entity at " + j + "row");
                k = j + 1;
                String expected = "canceled";
                String actual = driver.findElement(By.xpath("//table//tr[" + k + "]//td[3]//span")).getText();
                Assert.assertEquals(expected, actual, "Strings not matching");

            }
        }
    }
}












