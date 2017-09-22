import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sc on 5/31/2017.
 */
public class AndroidCalculator {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //capabilities that are mandatory
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("udid","TA93309ITV");
        capabilities.setCapability("udid", "emulator-5554");
        //capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");


        WebDriver dr = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        //Clicking on number 4

         dr.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        //Clicking on "+" sign
        dr.findElement(By.id("com.android.calculator2:id/op_add")).click();

        //Clicking on number 5
        dr.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        //Clicking on "=" sign
        dr.findElement(By.id("com.android.calculator2:id/eq")).click();
        //Getting the result
        String result = dr.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println("This is the result of the addition"+ result);

        Thread.sleep(3000);

        //Cleanup
        dr.quit();


    }

}