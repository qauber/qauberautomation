package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/29/17.
 */
public class MainNavigation {
    private WebDriver driver;

    public MainNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Entities() {
        return driver.findElement(By.xpath("//span[text()='Entities']"));

    }

    public WebElement AddReports() {
        return driver.findElement(By.xpath("//span[text()='Add Report']"));
    }

    public WebElement ProfileName() {
        return driver.findElement(By.xpath("//a[@ng-click='toogleOffsidebar($event)']//span[@class='mr-sm ng-binding']"));
    }

    public WebElement Logout() {
        return driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
    }


}
