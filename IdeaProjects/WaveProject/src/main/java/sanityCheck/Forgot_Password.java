package sanityCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

/**
 * Created by anbus on 4/5/2017.
 */
public class Forgot_Password {
    WebDriver driver;
    By forgot_Password_Link = By.xpath("//form//div[last()]//a[text()='Forgot your password?']");
    By email_field = By.xpath("//input[@name='email']");
    By reset_button = By.xpath("//button[text()='Reset']");
    By reset_Confirm_Msg = By.xpath("//div[@class='alert alert-success text-center ng-binding']");
    By new_ResetMail = By.xpath("//div//small//span[text()='NEW']");
    By UserName = By.xpath("//input[@id='exampleInputEmail1']");
    By Password = By.xpath("//input[@id='exampleInputPassword1']");
    By Login = By.xpath("//form[@name='login.loginForm']//button");
    By Logout_button = By.xpath("//div[@class='text-center p ng-scope']//button");
    By UserName_icon=By.xpath("//div//a/span[@class='mr-sm ng-binding']");



    public Forgot_Password(WebDriver driver){
        this.driver = driver;
    }

    public void forgot_Password() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(forgot_Password_Link).click();
        driver.findElement(email_field).sendKeys("anbu@getnada.com");
        Thread.sleep(1000);
        driver.findElement(reset_button).click();
        boolean result = driver.findElement(reset_Confirm_Msg).isDisplayed();
        System.out.println("reset email sent msg displayed  :" +result);
        Thread.sleep(2000);
        String getnadaUrl = "https://app.getnada.com/inbox/anbu@getnada.com";
        driver.get(getnadaUrl);
        Thread.sleep(1000);
        driver.findElement(By.id("emailaddress")).sendKeys("anbu");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div//button[@class='btn-blue btn-outlined btn btn-lg btn-default']")).click();
        Thread.sleep(1000);
        driver.findElement(new_ResetMail).click();
        Thread.sleep(1000);
        // iframe with id
        driver.switchTo().frame(driver.findElement(By.id("idIframe")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("html//body//p//a")).click();
        Thread.sleep(3000);
        //switch back to current window
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        // entering new password
        String newPwd = " testing";
        driver.findElement(By.id("id-password")).sendKeys(newPwd);
        Thread.sleep(1000);
        driver.findElement(By.name("password_confirm")).sendKeys(newPwd);
        driver.findElement(By.className("btn btn-block btn-primary mt-lg")).click();
        Thread.sleep(1000);

        //logging back with new password
        driver.findElement(UserName).sendKeys("anbu@mailinator.com");
        driver.findElement(Password).sendKeys(newPwd);
        driver.findElement(Login).click();
        Thread.sleep(2000);
        System.out.println(" user logged in successful with new password");
        driver.findElement(UserName_icon).click();
        Thread.sleep(500);
        driver.findElement(Logout_button).click();

    }
}
