package pages.pages_RU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/18/2017.
 */
public class RU_Login {
    WebDriver driver;

    By UserName = By.xpath("//input[@id='exampleInputEmail1']");
    By Password = By.xpath("//input[@id='exampleInputPassword1']");
    By Login = By.xpath("//form[@name='login.loginForm']//button");
    By UserName_icon=By.xpath("//div//a/span[@class='mr-sm ng-binding']");


    public RU_Login(WebDriver driver) {

        this.driver = driver;
    }

    public void setLogin(String UserMail, String Pwd) throws InterruptedException {
        driver.findElement(UserName).sendKeys(UserMail);
        driver.findElement(Password).sendKeys(Pwd);
        Thread.sleep(2000);
        driver.findElement(Login).click();
        Thread.sleep(1000);

    }

}
