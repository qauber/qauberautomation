package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/12/17.
 */
public class Entities {
    WebDriver driver;

    public Entities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement UserPermissionControls() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.assignUserTo(entity)']//em[@class='fa fa-sitemap']"));
    }

    public WebElement UserRightsSelect() {
        return driver.findElement(By.xpath("//select[@ng-model='user.assignedRole']"));
    }

    public WebElement Savebutton() {
        return driver.findElement(By.xpath("//button[@ng-click='$assignCtrl.update(user)']//i[@class='fa fa-floppy-o']"));
    }

    public WebElement EntityName() {
        return driver.findElement(By.xpath("//a[@ng-click='entity.status || !app.account.isSuperAdminUser ? $ctrl.selectEntity(entity) : $ctrl.openOrgForm(entity.id)']"));
    }
    public WebElement AddEntity() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.addEntity()']"));
    }

    public WebElement EntityName1() {
        return driver.findElement(By.xpath("//tr[2][@ng-repeat='entity in $ctrl.entitiesOnPage']"));
    }

    public WebElement Deletebtn1() {
        return driver.findElement(By.xpath("//tr[2]//button[@ng-click='$ctrl.deleteEntity(entity)']"));
    }

    public WebElement ConfirmDelete() {
        return driver.findElement(By.xpath("//button[@ng-click='confirm()']"));
    }

}
