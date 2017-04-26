package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 4/3/2017.
 */
public class EntityAssignPermissionsPage {

    WebDriver driver;

    By closePermissions = By.cssSelector(".ngdialog-close");

    public EntityAssignPermissionsPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement closePermissions(){

        return driver.findElement(closePermissions);
    }
}
