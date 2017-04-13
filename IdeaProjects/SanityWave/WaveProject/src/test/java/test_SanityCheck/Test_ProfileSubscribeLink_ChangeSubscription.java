package test_SanityCheck;

import helper.Subscription_Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLogin;

import java.util.concurrent.TimeUnit;

/** Created by Anbu
 TC: Subscription link in Profile panel
 Pre condition:
 1.Login
 2.Subscribed Entity
 Steps:
 1.Click on profile menu
 2.Click on Subscribe menu icon(profile menu collapse)
 3.Click profile menu
 4.Click on Subscribe link
 5.Click " change subscription"
 6.Move the slider to change subscription
 7.Click finish
 8.Pay through paypal link
 */
public class Test_ProfileSubscribeLink_ChangeSubscription {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    HomeLogin objHomeLogin;
    Subscription_Helper objSubscription_Helper;

    By UserName_icon=By.xpath("//div//a/span[@class='mr-sm ng-binding']");
    By subscribeLink_Icon = By.xpath("//div[@class='ng-isolate-scope']//li[2]/a");
    By subscription_Link = By.xpath("//div//a//span[@class='badge bg-info pull-right ng-binding']");
    By cancel_Subscription_Button = By.xpath("//div[@class='ngdialog-message']//button[text()='CANCEL Subscription']");
    By subscribe_Number = By.xpath("//div[@class='media bb pl-sm pr-sm ng-scope']//a//span[2]");
    By slider = By.xpath("//div[@class='slider-handle min-slider-handle round']");
    By change_Subscription_Button = By.xpath("//div[@class='ngdialog-message']//button[text()='CHANGE Subscription']");
    By paypal_email = By.xpath("//input[@id='login_email']");
    By paypal_pwd = By.xpath("//input[@id='login_password']");
    By login = By.xpath("//input[@id='submitLogin']");
    By Agree_button = By.xpath("//input[@id='continue']");
    By PaypalLogin_link = By.xpath("//input[@id='loadLogin']");



    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        objHomeLogin = new HomeLogin(driver);
        objHomeLogin.login("anbu@getnada.com","testing");
        Thread.sleep(2000);

    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

    @Test
    public void verifyChange_Subscription() throws InterruptedException {
        /** Calling helper function to create entity & subscription*/
        objSubscription_Helper = new Subscription_Helper(driver);
        objSubscription_Helper.sau_Add_Company();
        Thread.sleep(3000);

        /**click user icon in profile panel */
        driver.findElement(UserName_icon).click();
        Thread.sleep(1000);
        /** click Subscription link Icon */
        driver.findElement(subscribeLink_Icon).click();
        Thread.sleep(1000);
        String expectedStr = driver.findElement(subscribe_Number).getText();
        System.out.println("Subscription numbers  displayed before change " + expectedStr);
        Thread.sleep(1000);
        /**click on subscription link */
        driver.findElement(subscription_Link).click();
        Thread.sleep(1000);
       /** Finding slider to move to change subscription */
        WebElement sliderTool = driver.findElement(slider);
        int width = sliderTool.getSize().getWidth();
        Actions ac = new Actions(driver);
        ac.moveToElement(sliderTool, ((width +2)), 0).click();
        ac.build().perform();
        System.out.println("Slider moved");
       /** click "Change Subscription " Button */
        driver.findElement(change_Subscription_Button).click();
        Thread.sleep(3000);
        driver.findElement(paypal_email).clear();
        /**Paypal login credentials */
        driver.findElement(paypal_email).sendKeys("anbu.sundara-buyer@gmail.com");
        driver.findElement(paypal_pwd).sendKeys("tester17!");
        /** Click login */
        driver.findElement(login).click();
        Thread.sleep(3000);
        /** Agree the terms & click agree button */
        driver.findElement(Agree_button).click();
        Thread.sleep(4500);
        /** Verifying the Subscription numbers changed
         * click user icon in profile panel */
        driver.findElement(UserName_icon).click();
        Thread.sleep(1000);
        /** click Subscription link Icon */
        driver.findElement(subscribeLink_Icon).click();
        Thread.sleep(1000);
        String actualStr = driver.findElement(subscribe_Number).getText();
        System.out.println("Subscription numbers  displayed after change " + actualStr);
        Thread.sleep(1000);
       /** Assert  */
        Assert.assertNotEquals(actualStr,expectedStr,"Strings match");


    }
}
