package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 4/6/2017.
 */
public class Login {
    WebDriver driver;

    By UserName = By.xpath("//input[@id='exampleInputEmail1']");
    By Password = By.xpath("//input[@id='exampleInputPassword1']");
    By Login = By.xpath("//form[@name='login.loginForm']//button");

    public void login(String userMail,String password) throws InterruptedException {
        driver.findElement(UserName).sendKeys(userMail);
        driver.findElement(Password).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(Login).click();
    }
}
