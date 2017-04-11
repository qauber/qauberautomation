package TestCaseSAU;

import Pages.DataCredential;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.util.List;


public class AssignUser {
    WebDriver driver;
    public PageResources pageResources;
    public int k;

//loG IN
    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "RU")
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

    @Test(priority = 2)
    public void AddUser() throws Exception {
        Thread.sleep(8000);
        pageResources.getAddUsersPage().users().click();
        Thread.sleep(3000);
        pageResources.getAddUsersPage().InviteUser().click();
        Thread.sleep(2000);
        String uname = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        String email = uname + "@gmail.com";
        pageResources.getAddUsersPage().SendEmailInviteUser().sendKeys(email);
        Thread.sleep(2000);
        pageResources.getAddUsersPage().SendInvitatonButton().click();
        Thread.sleep(6000);
        List<WebElement> NOP = driver.findElements(By.xpath("//td//ul//li//a"));
        Thread.sleep(2000);

        if ((NOP.size() - 2) > 1) {
            WebElement NextBtn = driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a"));
            Outer:
            while (NextBtn.isEnabled()) {
                Thread.sleep(2000);
                List<WebElement> NOR = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody/tr"));

                System.out.print("Number of Row per each page is"+NOR.size());
                Thread.sleep(1000);
                for (int j = 2; j < NOR.size() - 2; j++)
                {
                    if (NOR.get(j).getText().contains("asdfkgf@gmail.com"))
                    {
                        Thread.sleep(3000);
                        k = j + 1;
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//a[@class='hidden-xs']/em[@class='fa fa-navicon']")).click();
                        Thread.sleep(2000);
                        break Outer;

                    }
                }

                driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a")).click();
            }
            Thread.sleep(4000);
            driver.findElement(By.xpath("//tr[" + k + "]//button[1]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath(".//*[@id='ngdialog3']/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/select")).sendKeys("Regular User");
            Thread.sleep(2000);
            pageResources.getAddUsersPage().SaveBtn().click();
            Thread.sleep(3000);

           Thread.sleep(3000);
           JavascriptExecutor executor = (JavascriptExecutor) driver;
           WebElement close = pageResources.getAddUsersPage().closePopup();
           executor.executeScript("arguments[0].click();", close);
            Thread.sleep(1000);

        } else
             {
            List<WebElement> NOR = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody/tr"));
            Thread.sleep(1000);
            for (int j = 2; j < NOR.size(); j++)
            {
                if (NOR.get(j).getText().contains(email))
                {
                    Thread.sleep(3000);
                    k = j ;
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//a[@class='hidden-xs']/em[@class='fa fa-navicon']")).click();
                    Thread.sleep(2000);
                }
            }
            Thread.sleep(4000);
            driver.findElement(By.xpath("//tr[" + k + "]//button[1]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath(".//*[@id='ngdialog3']/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/select")).sendKeys("Regular User");
            Thread.sleep(2000);
            pageResources.getAddUsersPage().SaveBtn().click();
            Thread.sleep(1000);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebElement close = pageResources.getAddUsersPage().closePopup();
            executor.executeScript("arguments[0].click();", close);
            Thread.sleep(1000);
            System.out.println("There is only one page");

            }

    }
}

