package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/19/2017.
 */
public class MailsacUnblockLinksnImages {
    /// MailsacUnblockLinksnImages Objects ///

    WebDriver driver;

    By registrationLink = By.xpath("//div[1]/a");
    By activationLink = By.xpath("//a[contains(text(), 'http://testwave.qabidder.net/#/page/activate')]");

    public MailsacUnblockLinksnImages(WebDriver driver){

        this.driver = driver;
    }

    public WebElement registrationLink(){

        return driver.findElement(registrationLink);
    }

    public WebElement activationLink(){

        return driver.findElement(activationLink);
    }
}
