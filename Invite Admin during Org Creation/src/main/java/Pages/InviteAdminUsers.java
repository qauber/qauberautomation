package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/23/17.
 */
public class InviteAdminUsers {

    public WebDriver driver;

    public InviteAdminUsers(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement EmailFieldA() {
        return driver.findElement(By.xpath("//div[@class='form-group']//div[@class='bootstrap-tagsinput']//input[@type='text']"));

    }
    public WebElement NextbuttonafterAdminUsers() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']"));
    }

    public WebElement Donebutton() {
        return driver.findElement(By.xpath("//button[@ng-click='confirm()']"));
    }

    public WebElement Entities() {
        return driver.findElement(By.xpath("//span[@class='ng-binding'][text()='Entities']"));

    }

    public WebElement Finishbtn() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']"));
    }

    public WebElement LastCreatedEntityPermissions() {
        return driver.findElement(By.xpath("//tr[@ng-repeat='entity in $ctrl.entitiesOnPage'][last()]//button[@ng-click='$ctrl.assignUserTo(entity)']"));
    }

    public WebElement LastUserCreated() {
        return driver.findElement(By.xpath("//tr[@ng-repeat='user in $assignCtrl.users'][last()]//div[@class='word-break-all ng-binding']"));
    }

    public WebElement LastUserPermissions() {
        return driver.findElement(By.xpath("//tr[@ng-repeat='user in $assignCtrl.users'][last()]//select[@ng-model='user.assignedRole']"));
    }

    public WebElement ProfileName() {
        return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']"));
    }

    public WebElement Logout() {
        return driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
    }

}
