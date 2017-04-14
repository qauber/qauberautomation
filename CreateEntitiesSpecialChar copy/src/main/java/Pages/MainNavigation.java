package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/6/17.
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
        return driver.findElement(By.xpath("//a[@ng-click='toogleOffsidebar($event)']//em[@class='fa fa-caret-down']"));
    }

    public WebElement Users() {
        return driver.findElement(By.xpath("//span[text()='Users']"));
    }

    public WebElement Settings() {
        return driver.findElement(By.xpath("//a[@ng-click='select($event)']//em[@class='icon-equalizer fa-lg']"));
    }

    public WebElement SubscriptionNameinSettings() {
        return driver.findElement(By.xpath("//a[@ng-click='$ctrl.openEditSubForm(sub)']/span[@class='ng-binding']"));
    }

    public WebElement SubscriptionNumberofUsersinSettings() {
        return driver.findElement(By.xpath("//a[@ng-click='$ctrl.openEditSubForm(sub)']//span[@class='badge bg-info pull-right ng-binding']"));
    }

    public WebElement UserSilhouette() {
        return driver.findElement(By.xpath("//a[@ng-click='select($event)']//em[@class='icon-user fa-lg']"));
    }

    public WebElement Logout() {
        return driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
    }

}
