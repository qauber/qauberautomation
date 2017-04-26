package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/24/2017.
 */
public class PaypalPage {

    WebDriver driver;

    By clickLoginPage = By.cssSelector("#loadLogin");

    public PaypalPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement clickLoginPage(){

        return driver.findElement(clickLoginPage);
    }
}
