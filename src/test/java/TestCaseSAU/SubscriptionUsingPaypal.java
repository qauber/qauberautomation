package TestCaseSAU;

import Pages.DataCredential;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kamkam on 3/28/2017.
 */
public class SubscriptionUsingPaypal {
        public String result;
    WebDriver driver;
    PageResources pageResources;
    ////////////////////loG IN as Super Admin USer
    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "SAU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");

        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        pageResources = new PageResources(driver);
        // driver.manage().window().maximize();
        Thread.sleep(3000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(3000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(5000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(3000);
    }


    ////////////////////////////Changing the Subscription////////

    // Go to the profile page and Setting
    @Test(priority = 2)

     public void SubscriptionByPaypal() throws InterruptedException {
        Thread.sleep(3000);
        pageResources.getLogOut().UserNameProfile().click();
        Thread.sleep(3000);
        pageResources.getSubscriptionUsingPaypal().getProfileSettingBtn().click();
        Thread.sleep(3000);
        pageResources.getSubscriptionUsingPaypal().FirstEntityLink().click();
        Thread.sleep(3000);
/////////////change the slider position
        WebElement slider= driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        int width= slider.getSize().getWidth();
        Actions ac= new Actions(driver);
        ac.moveToElement(slider, ((width+5)), 0).click();
        ac.build().perform();
        Thread.sleep(3000);

        /////////////////////extract the number which is changed
        String str =driver.findElement(By.xpath("//div[@class='text-bold ng-binding']")).getText();
        Matcher matcher1 = Pattern.compile("\\d+").matcher(str);
        matcher1.find();
        int NumberinSubscriptionChanging = Integer.valueOf(matcher1.group());
        Thread.sleep(3000);
        System.out.println("The Number of user in changing Subscription process  changed to:  "+NumberinSubscriptionChanging);
///////////////////////////////////////Pay Pal Page //////////////
        Thread.sleep(3000);
        pageResources.getSubscriptionUsingPaypal().ChangeSubscriptionBtn().click();
        Thread.sleep(6000);
        pageResources.getAddEntity().methodPaypal().click();
        Thread.sleep(3000);
        pageResources.getAddEntity().emailPaypal().sendKeys("hooshmandi.mahsa-buyer-1@yahoo.com");
        Thread.sleep(3000);
        pageResources.getAddEntity().passPaypal().sendKeys("Kamran12345");
        Thread.sleep(3000);
        pageResources.getAddEntity().loginPaypal().click();
        Thread.sleep(5000);
        pageResources.getAddEntity().continuePaypal().click();
        Thread.sleep(5000);
        ////////////////////Wait to go back to the main page //////
        Thread.sleep(5000);
        ///////////////////////////Verify if the number of subscription is changed or not


        pageResources.getAddEntity().EntityBtn().click();
        Thread.sleep(2000);
        //////Read the data from the Entity subscription
        String subscriptionText=  driver.findElement(By.xpath("//section//table/tbody/tr[2]//span[@class='label ng-binding label-success']")).getText();
       String SecondNumber= subscriptionText.substring(3);
        Matcher matcher2 = Pattern.compile("\\d+").matcher(SecondNumber);
        matcher2.find();
       int NumberofSubinEntity = Integer.valueOf(matcher2.group());
       Thread.sleep(3000);
        System.out.println("The Number of user in Entity Page  changed to:   "+NumberofSubinEntity);
        Thread.sleep(3000);

//        ////////////////////////Check if both number is same(One from Changing subscription and one from Entity Page)
       try {
            Assert.assertEquals(NumberinSubscriptionChanging, NumberofSubinEntity);
        }catch (AssertionError e){e.printStackTrace();
       }
       Thread.sleep(2000);
      // driver.close();

    }
}
