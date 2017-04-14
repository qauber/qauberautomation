package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by jaishree on 3/23/17.
 */
public class MainNavigation {


    private WebDriver driver;

    public MainNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Entities() {
        return driver.findElement(By.xpath("//span[text()='Entities']"));

    }

    public WebElement Users() {
        return driver.findElement(By.xpath("//span[text()='Users']"));
    }

    public WebElement AddEntity() {
        return driver.findElement(By.xpath("//button[@ng-click='$ctrl.addEntity()']"));


    }

}