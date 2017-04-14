package TestCaseSAU;

import PageBase.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

/**
 * Created by kamkam on 3/24/2017.
 */
public class ProfielPanel {


    public WebDriver driver;
    public PageResources pageResources;
    public LogIn logIn;

    @BeforeTest
    public void Login() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
       // driver.manage().window().maximize();
        Thread.sleep(8000);
        pageResources.getLoginPage().EmailId().sendKeys("wavefittest@mailinator.com ");
       Thread.sleep(4000);
        pageResources.getLoginPage().password().sendKeys("Kamran12345");
        Thread.sleep(4000);
//            String color = pageResources.getLoginPage().SignIn().getCssValue("color");
//            String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
//            int hexValue1=Integer.parseInt(hexValue[0]);
//            hexValue[1] = hexValue[1].trim();
//            int hexValue2=Integer.parseInt(hexValue[1]);
//            hexValue[2] = hexValue[2].trim();
//            int hexValue3=Integer.parseInt(hexValue[2]);
//            String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
//            System.out.print("The color is:"+actualColor);
//            pageResources.getLoginPage().SignIn().click();

    }


    @Test()
    public void LogOut() throws Exception {
        Thread.sleep(3000);
        pageResources.getLogOut().UserNameProfile().click();
        Thread.sleep(3000);
        String Actual= driver.findElement(By.xpath("//div/div[2]/div/h5")).getText();
        try {
            Assert.assertEquals(Actual, "wavefittest@mailinator.com");}
        catch(AssertionError e)
        {
            e.printStackTrace();
        }
        Thread.sleep(8000);
        pageResources.getLogOut().LogOutButton().click();
    }
}
