package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/19/2017.
 */
public class InviteUserPage {
    ///// InviteUserPage Objects /////

    WebDriver driver;

    By inviteEmail = By.xpath("//input[@ng-model='inviteEmail']");
    By sendInvite = By.xpath("//button[@ng-click='validateForm() && confirm(inviteEmail)']");

    public InviteUserPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement inviteEmail(){

        return driver.findElement(inviteEmail);
    }

    public WebElement sendInvite(){

        return driver.findElement(sendInvite);
    }
}
