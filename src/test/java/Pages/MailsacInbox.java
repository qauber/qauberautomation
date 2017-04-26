package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/19/2017.
 */
public class MailsacInbox {
    /// MailsacInbox Object ///

    WebDriver driver;

    By latestMail = By.xpath("//tbody/tr[2]");

    public MailsacInbox(WebDriver driver){

        this.driver = driver;
    }

    public WebElement latestMail(){

        return driver.findElement(latestMail);
    }
}
