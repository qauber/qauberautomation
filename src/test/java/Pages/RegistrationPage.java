package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/19/2017.
 */
public class RegistrationPage {
    /// RegistraionPage Objects ///

    WebDriver driver;

    By registerUserButton = By.xpath("//button[@ng-click=\"reg.registerRegularUser()\"]");

    public RegistrationPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement registerUserButton(){

        return driver.findElement(registerUserButton);
    }
}
