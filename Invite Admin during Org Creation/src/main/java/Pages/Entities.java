package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/11/17.
 */
public class Entities {
    WebDriver driver;

    public Entities(WebDriver driver) {
        this.driver = driver;
    }

        public WebElement EntityDelete() {
        return driver.findElement(By.xpath("//tr[3]//button[@ng-click='$ctrl.deleteEntity(entity)']"));
        }

        public WebElement DeleteConfirmation() {
        return driver.findElement(By.xpath("//button[@ng-click='confirm()']"));
        }

}
