package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/24/2017.
 */
public class AddEntitySubscriptionPage {

    WebDriver driver;

    By finishButton = By.xpath("//div[@class=\"panel-footer text-right\"]/button[2]");

    public AddEntitySubscriptionPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement finishButton(){

        return driver.findElement(finishButton);
    }
}
