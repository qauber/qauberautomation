package TestCaseSAU;

import Pages.DataCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.concurrent.TimeUnit;

/**
 * Created by kamkam on 4/4/2017.
 */
public class TrialFlag {
    public PageResources pageResources;
   public WebDriver driver;
    Color color;
    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

     @Test(priority = 1,dataProviderClass = DataCredential.class,dataProvider = "SAU" )
        public void login( String Person,String UsName,String Psw) throws Exception
     {driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         Thread.sleep(2000);
       pageResources.getLoginPage().EmailId().sendKeys(UsName);
         Thread.sleep(2000);
       pageResources.getLoginPage().password().sendKeys(Psw);
         Thread.sleep(2000);

         String color =pageResources.getLoginPage().SignIn().getCssValue("color");
                 //         String s1 = color.substring(5);
//         StringTokenizer st = new StringTokenizer(s1);
//         int r = Integer.parseInt(st.nextToken(",").trim());
//         int g = Integer.parseInt(st.nextToken(",").trim());
//         int b = Integer.parseInt(st.nextToken(",").trim());
//         Color c = new Color(r, g, b);
//         String hex = "#"+Integer.toHexString(c.getRGB()).substring(2);
         System.out.println(color);

         Thread.sleep(2000);

       pageResources.getLoginPage().SignIn().click();
     }

     @Test(priority = 2)
    public void FlagTest() throws InterruptedException {

         pageResources.getLogOut().UserNameProfile().click();
         Thread.sleep(2000);
         String color1 =pageResources.getLogOut().TrialFlag().getCssValue("color");

         //         String s1 = color.substring(5);
//         StringTokenizer st = new StringTokenizer(s1);
//         int r = Integer.parseInt(st.nextToken(",").trim());
//         int g = Integer.parseInt(st.nextToken(",").trim());
//         int b = Integer.parseInt(st.nextToken(",").trim());
//         Color c = new Color(r, g, b);
//         String hex = "#"+Integer.toHexString(c.getRGB()).substring(2);
         System.out.println("Color 1 is "+color1);

        WebElement Trialflag1= pageResources.getLogOut().TrialFlag();
         try
         {
             Assert.assertTrue(Trialflag1.isDisplayed());
             System.out.println("The flag is exist");
         }catch (AssertionError e){e.printStackTrace();}
         driver.close();


     }

}
