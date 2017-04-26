package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/24/2017.
 */
public class AddEntityInviteAdminPage {

    WebDriver driver;

    By inviteAdmin = By.xpath("//form[@name=\"$ctrl.inviteAdminForm\"]/div/div/input");
    By nextButton = By.xpath("//div[@class=\"panel-footer text-right\"]/button[2]");

    public AddEntityInviteAdminPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement inviteAdmin(){

        return driver.findElement(inviteAdmin);
    }

    public WebElement nextButton(){

        return driver.findElement(nextButton);
    }
}
