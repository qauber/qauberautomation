package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/23/17.
 */
public class CreateEntity {

    WebDriver driver;

    public CreateEntity(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement EntityName() {
        return driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.name']"));

    }

    public WebElement Country() {
        return driver.findElement(By.xpath("//select[@name='country']"));
    }

    public WebElement Address1() {
        return driver.findElement(By.xpath("//input[@name='address1']"));
    }

    public WebElement City() {
        return driver.findElement(By.xpath("//input[@name='city']"));
    }

    public WebElement State() {
        return driver.findElement(By.xpath("//select[@name='state']"));
    }

    public WebElement PostalCode() {
        return driver.findElement(By.xpath("//input[@name='zip']"));
    }

    public WebElement Nextbutton() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']"));
    }



}
