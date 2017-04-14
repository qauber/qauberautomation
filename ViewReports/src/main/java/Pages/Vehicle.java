package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/29/17.
 */
public class Vehicle {
    private WebDriver driver;

    public Vehicle(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Nextbtn() {
        return By.xpath("//a[@ng-click='wizard.go(7)']").findElement(driver);
    }
}
