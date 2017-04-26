package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/19/2017.
 */
public class MailsacPage {
    /// MailsacPage Objects ///

    WebDriver driver;

    By emailUserName = By.xpath("//input[@ng-model=\"myinbox\"]");
    By checkMailButton = By.xpath("//button[@ng-click=\"navToInbox(myinbox, postfix)\"]");


    public MailsacPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement emailUserName(){

        return driver.findElement(emailUserName);
    }

    public WebElement checkMailButton(){

        return driver.findElement(checkMailButton);
    }
}
