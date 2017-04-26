package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/28/2017.
 */
public class UserSettingsPanel {

    WebDriver driver;

    By settingsLink = By.xpath("//aside[@class=\"offsidebar ng-scope\"]/nav/div/ul/li[2]/a");
    By entitySubLink = By.xpath("//aside[@class=\"offsidebar ng-scope\"]/nav/div/div/div[2]/div/div/div/div/div[2]/a");

    public UserSettingsPanel(WebDriver driver){

        this.driver = driver;
    }

    public WebElement settingsLink(){

        return driver.findElement(settingsLink);
    }

    public WebElement entitySubLink(){

        return driver.findElement(entitySubLink);
    }
}
