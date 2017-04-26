package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/19/2017.
 */
public class ActivationPage {
    /// ActivationPage Objects ///

    WebDriver driver;

    By accountName = By.xpath("//input[@name=\"account_name\"]");
    By password = By.xpath("//input[@id=\"id-password\"]");
    By confirmPassword = By.xpath("//input[@name=\"account_password_confirm\"]");
    By completeActivationButton = By.xpath("//button[contains(text(), 'Complete activation')]");

    public ActivationPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement accountName(){

        return driver.findElement(accountName);
    }

    public WebElement password(){

        return driver.findElement(password);
    }

    public WebElement confirmPassword(){

        return driver.findElement(confirmPassword);
    }

    public WebElement completeActivationButton(){

        return driver.findElement(completeActivationButton);
    }
}
