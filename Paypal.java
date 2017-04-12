package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/30/17.
 */
public class Paypal {
    private WebDriver driver;

    public Paypal(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement ExistingPaypalAccountSignin() {
        return driver.findElement(By.xpath("//input[@id='loadLogin']"));
    }

    public WebElement PaypalEmail() {
        return driver.findElement(By.xpath("//input[@id='login_email']"));
    }

    public WebElement PaypalPassword() {
        return driver.findElement(By.xpath("//input[@id='login_password']"));
    }

    public WebElement PaypalLoginButton() {
        return driver.findElement(By.xpath("//input[@id='submitLogin']"));
    }

    public WebElement AgreeandContinue() {
        return driver.findElement(By.xpath("//input[@id='continue']"));
    }

}


