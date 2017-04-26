package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/24/2017.
 */
public class PaypalLogin {

    WebDriver driver;

    By email = By.id("login_email");
    By password = By.id("login_password");
    By submitLogin = By.id("submitLogin");

    public PaypalLogin(WebDriver driver){

        this.driver = driver;
    }

    public WebElement email(){

        return driver.findElement(email);
    }

    public WebElement password(){

        return driver.findElement(password);
    }

    public WebElement submitLogin(){

        return driver.findElement(submitLogin);
    }

}
