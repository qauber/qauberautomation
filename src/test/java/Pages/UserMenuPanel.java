package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/20/2017.
 */
public class UserMenuPanel {

    WebDriver driver;

    By userMenu = By.xpath("//a[@ng-click=\"toogleOffsidebar($event)\"]");
    By logOut = By.xpath("//button[@ng-click=\"app.logout()\"]");

    public UserMenuPanel(WebDriver driver){

        this.driver = driver;
    }

    public WebElement userMenu(){

        return driver.findElement(userMenu);
    }

    public WebElement logOut(){

        return driver.findElement(logOut);
    }
}
