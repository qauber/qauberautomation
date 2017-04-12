package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Em on 4/8/2017.
 */
public class SetURL {
    protected WebDriver driver;
    public SetURL (WebDriver driver)
    {  this.driver=driver;
    }

    public WebDriver conectURL(){
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        return driver;

    }
}
