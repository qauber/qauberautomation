package PageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {

     WebDriver driver;


    public void SetUp()

    {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
    }


    public void Teardown()

    {
        driver.quit();
    }

}
