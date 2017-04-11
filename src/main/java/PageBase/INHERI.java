package PageBase;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;


public class INHERI extends BaseClass {

     //WebDriver driver;
    public  PageResources pageResources;


    @BeforeTest
    public void LaunchBrowser()
    {
        SetUp();
    }
    @Test
    public void Login() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("Kamran.zp@gmail.com");

    }

}
