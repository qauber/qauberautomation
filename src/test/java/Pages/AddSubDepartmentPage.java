package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/19/2017.
 */
public class AddSubDepartmentPage {

    WebDriver driver;

    By inviteEmail = By.cssSelector("input.form-control:nth-child(2)");
    By sendInvite = By.cssSelector(".clearfix > button:nth-child(1)");

    public AddSubDepartmentPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement inviteEmail(){

        return driver.findElement(inviteEmail);
    }

    public WebElement sendInvite(){

        return driver.findElement(sendInvite);
    }

}
