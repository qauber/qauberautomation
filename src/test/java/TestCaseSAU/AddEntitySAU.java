package TestCaseSAU;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testResources.PageResources;



public class AddEntitySAU {
    WebDriver driver;
    public PageResources pageResources;



    @Test(priority = 1)
    public void  LoginPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
       // driver.manage().window().maximize();
        pageResources = new PageResources(driver);
        Thread.sleep(3000);
        pageResources.getLoginPage().EmailId().sendKeys("wavefittest@mailinator.com ");
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys("Kamran12345");
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
    }

       @Test(priority = 2)
    public void AddEntity() throws Exception {
//        logIn = new LogIn(driver,pageResources);
//        logIn.launchBrowser();
        pageResources= new PageResources(driver);
        Thread.sleep(6000);
        pageResources.getAddEntity().EntityBtn().click();
        Thread.sleep(4000);
        pageResources.getAddEntity().addEntityButton().click();
        Thread.sleep(2000);
        pageResources.getAddEntity().EntityName().sendKeys(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        Thread.sleep(2000);
        pageResources.getAddEntity().Address().sendKeys(RandomStringUtils.randomAlphabetic(10));
        Thread.sleep(2000);
        pageResources.getAddEntity().City().sendKeys(RandomStringUtils.randomAlphabetic(10));
        Thread.sleep(2000);
        Select st= new Select(pageResources.addEntity.state());
        st.selectByIndex(3);
        pageResources.getAddEntity().City().sendKeys(RandomStringUtils.randomAlphabetic(10));
        Thread.sleep(2000);
        pageResources.getAddEntity().PostalCode().sendKeys(RandomStringUtils.randomAlphabetic(10));
        Thread.sleep(2000);
        pageResources.getAddEntity().NextStep().click();
        Thread.sleep(2000);
        pageResources.getAddEntity().InviteUser().sendKeys(RandomStringUtils.randomAlphabetic(10)+"@gmail.com");
        Thread.sleep(2000);
        pageResources.getAddEntity().NextPage1().click();
        Thread.sleep(2000);
        pageResources.getAddEntity().OK().click();
        Thread.sleep(2000);
        pageResources.getAddEntity().AdminUser().sendKeys("kamran.zp@gmail.com");
        Thread.sleep(2000);
        pageResources.getAddEntity().NextPage2().click();
        Thread.sleep(2000);
        pageResources.getAddEntity().ok1().click();
        Thread.sleep(2000);
           int x=20;
               WebElement slider= driver.findElement(By.xpath("//div[@role='slider']"));
               int width= slider.getSize().getWidth();
               Actions ac= new Actions(driver);
               ac.moveToElement(slider, ((width+15)), 0).click();
               ac.build().perform();

        pageResources.getAddEntity().Finish().click();
        Thread.sleep(4000);
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





    }


}
