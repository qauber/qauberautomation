package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/19/2017.
 */
public class UserPermissionsPage {

    WebDriver driver;

    By selectPermission = By.xpath("//tr[@class='ng-scope']/td[2]/select[@ng-model='entity.status']");
    By deletePermission = By.xpath("//tr[@class='ng-scope']/td[3]/button[2]");
    By savePermission = By.xpath("//tr[@class=\"ng-scope\"]/td[3]/button[@ng-click=\"assignEntity(entity)\"]");
    By assignedPermission = By.xpath("//tr[@class=\"ng-scope\"]/td[2]/div[@class=\"inline ng-scope\"]/div");
    By closePermissions = By.cssSelector(".ngdialog-close");

    public UserPermissionsPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement selectPermission(){

        return driver.findElement(selectPermission);
    }

    public WebElement deletePermission(){

        return driver.findElement(deletePermission);
    }

    public WebElement savePermission(){

        return driver.findElement(savePermission);
    }

    public WebElement assignedPermission(){

        return driver.findElement(assignedPermission);
    }

    public WebElement closePermissions(){

        return driver.findElement(closePermissions);
    }
}
