package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/11/17.
 */
public class Entities{

    private WebDriver driver;

    public Entities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement AddEntity() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.addEntity()']"));
    }

    public WebElement UserPermissions() {
        return driver.findElement(By.xpath("//tr[2]//button[@ng-click='$ctrl.assignUserTo(entity)']"));
    }

    public WebElement Deletebtn1() {
        return driver.findElement(By.xpath("//tr[2]//button[@ng-click='$ctrl.deleteEntity(entity)']"));
    }

    public WebElement ConfirmDelete() {
        return driver.findElement(By.xpath("//button[@ng-click='confirm()']"));
    }



}

