package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/19/2017.
 */
public class MailsacViewMail {
    /// MailsacViewMail Objects ///

    WebDriver driver;

    By unblockLinksnImagesButton = By.xpath("//a[contains(text(), 'Unblock links and images')]");

    public MailsacViewMail(WebDriver driver){

        this.driver = driver;
    }

    public WebElement unblockLinksnImagesButton(){

        return driver.findElement(unblockLinksnImagesButton);
    }
}
