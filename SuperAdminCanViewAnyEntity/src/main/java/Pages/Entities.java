package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/30/17.
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
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.deleteEntity(entity)']"));
        }

        public WebElement Deletebtn2() {
        return driver.findElement(By.xpath("//tr[3]//button[@ng-click='$ctrl.deleteEntity(entity)']"));
        }

        public WebElement ConfirmDelete() {
        return driver.findElement(By.xpath("//button[@ng-click='confirm()']"));
    }




    public void CloseXButton() throws InterruptedException {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            WebElement close = driver.findElement(By.xpath("//div[@class='ngdialog-close']"));
            Thread.sleep(5000);
            executor.executeScript("arguments[0].click();", close );
            Thread.sleep(5000);

        }

        public WebElement ProfileName() {
            return driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
        }

        public WebElement Logout() {
            return driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
        }
    }






