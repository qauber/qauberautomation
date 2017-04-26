package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/24/2017.
 */
public class PaypalConfirmPaymentPage {

    WebDriver driver;

    By continueButton = By.id("continue");

    public PaypalConfirmPaymentPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement continueButton(){

        return driver.findElement(continueButton);
    }
}
