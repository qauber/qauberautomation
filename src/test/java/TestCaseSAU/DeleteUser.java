package TestCaseSAU;

import Pages.DataCredential;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.List;

/**
 * Created by kamkam on 4/3/2017.
 */
public class DeleteUser {

    public PageResources pageResources;
    public WebDriver driver;
     int k;
    String email;
    String psw;


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
        Thread.sleep(3000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(3000);
    }

    //////////////////Invite User /////////

        @Test(priority = 2)
        public void InviteUser () throws InterruptedException {
         Thread.sleep(8000);
        pageResources.getAddUsersPage().users().click();
        Thread.sleep(3000);
        pageResources.getAddUsersPage().InviteUser().click();
        Thread.sleep(2000);
        String uname = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        email = uname + "@getnada.com";
        pageResources.getAddUsersPage().SendEmailInviteUser().sendKeys(email);
        Thread.sleep(2000);
        pageResources.getAddUsersPage().SendInvitatonButton().click();
        Thread.sleep(2000);
    }

        /////////////////////Activate User from Getnada/////////


     @Test(priority = 3)
        public void ActivateUser() throws InterruptedException {
         driver.get("https://app.getnada.com/login");
         String ParentWindowsHandeles= driver.getWindowHandle();

         pageResources.getForgetPassPage().EnterEmailOnGetnada().sendKeys(email);
         Thread.sleep(2000);

         pageResources.getForgetPassPage().LetsGoBtnInGetNada().click();
            //////click on the link for Invitation
         Thread.sleep(2000);
         driver.findElement(By.xpath(".//*[@id='body']//span[text()='Invite to FITS']")).click();
         Thread.sleep(2000);
         /////click on the link for activation
         driver.switchTo().frame(driver.findElement(By.id("idIframe")));
         Thread.sleep(2000);
         driver.findElement(By.xpath("html/body/a")).click();
          for(String winHandle:driver.getWindowHandles())
          {
              driver.switchTo().window(winHandle);
          }
          ////// click on the Confirmation Button
         Thread.sleep(2000);
          driver.findElement(By.xpath("//form/button")).click();
         Thread.sleep(2000);
         driver.close();
          driver.switchTo().window(ParentWindowsHandeles);

          driver.findElement(By.xpath(".//*[@id='sidebar-container']//li[1]/a")).click();
         Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='body']//span[text()='Activate Your Account']")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.id("idIframe")));
        driver.findElement(By.xpath("html/body/p[5]/a")).click();
        for(String windHandles: driver.getWindowHandles())
         {
             driver.switchTo().window(windHandles);
         }
         ///////Active an account by insert USerName and password
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(RandomStringUtils.randomAlphabetic(5));
         psw= RandomStringUtils.randomAlphanumeric(10);
         Thread.sleep(2000);
         driver.findElement(By.xpath(".//*[@id='id-password']")).sendKeys(psw);
        driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(psw);
         Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@ ng-click='activateRegularUser()']")).click();
         Thread.sleep(2000);
     }

    @Test(priority = 4, dataProviderClass = DataCredential.class, dataProvider = "SAU")
    public void LoginSeconTime(String Person, String UserName, String Password) throws InterruptedException {
        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        pageResources = new PageResources(driver);
        Thread.sleep(2000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void AddUser() throws Exception {

       pageResources.getAddUsersPage().users().click();
        Thread.sleep(3000);
       List<WebElement> NOP = driver.findElements(By.xpath("//td//ul//li//a"));
        Thread.sleep(2000);

        if ((NOP.size() - 2) > 1) {
            WebElement NextBtn = driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a"));
            Outer:
            while (NextBtn.isEnabled()) {
                Thread.sleep(2000);
                List<WebElement> NOR = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody/tr"));

                System.out.println("Number of Row per each page is" + NOR.size());
                Thread.sleep(1000);
                for (int j = 2; j < NOR.size() - 2; j++) {
                    if (NOR.get(j).getText().contains(email)) {
                        Thread.sleep(2000);
                        k = j + 1;
                        Thread.sleep(1000);
                        /////click on the Sandwich Button
                        driver.findElement(By.xpath("//a[@class='hidden-xs']/em[@class='fa fa-navicon']")).click();
                        Thread.sleep(2000);
                        break Outer;

                    }
                }
                    /////click on the next button
                driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a")).click();
            }
            ///// click on the DeleteButton
            Thread.sleep(2000);
            driver.findElement(By.xpath("//tr[" + k + "]//button[4]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@ng-click='confirm()']")).click();
        } else {
            List<WebElement> NOR = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody/tr"));
            Thread.sleep(1000);
            for (int j = 2; j < NOR.size(); j++) {
                if (NOR.get(j).getText().contains(email)) {
                    Thread.sleep(3000);
                    k = j;
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//a[@class='hidden-xs']/em[@class='fa fa-navicon']")).click();
                    Thread.sleep(2000);
                }
            }
            Thread.sleep(4000);
            driver.findElement(By.xpath("//tr[" + k + "]//button[4]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[@ng-click='confirm()']")).click();
        }
        Thread.sleep(4000);
       pageResources.getLogOut().UserNameProfile().click();
        Thread.sleep(2000);
        pageResources.getLogOut().LogOutButton().click();
        Thread.sleep(2000);
        pageResources.getLoginPage().EmailId().sendKeys(email);
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys(psw);
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(2000);
        WebElement ErrorMesage= driver.findElement(By.xpath("//div[@ng-show='login.authMsg']"));

        try
        {
            Assert.assertTrue(ErrorMesage.isEnabled());
            System.out.println("Error Message is displayed");

        }catch (AssertionError e){e.printStackTrace();  System.out.println("Error Message is not displayed");}

    }
}