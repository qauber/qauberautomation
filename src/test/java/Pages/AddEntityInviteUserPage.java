package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/24/2017.
 */
public class AddEntityInviteUserPage {

    WebDriver driver;

    By inviteUser = By.xpath("//form[@name=\"$ctrl.inviteUserForm\"]/div/div/input");
    By nextButton = By.xpath("//div[@class=\"panel-footer text-right\"]/button[2]");
    By doneButton = By.xpath("//*[@class='ngdialog ngdialog-theme-default ng-scope']/div[2]/div/button");

    public AddEntityInviteUserPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement inviteUser(){

        return driver.findElement(inviteUser);
    }

    public WebElement nextButton(){

        return driver.findElement(nextButton);
    }

    public WebElement doneButton(){

        return driver.findElement(doneButton);
    }
}
