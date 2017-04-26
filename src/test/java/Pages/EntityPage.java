package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/19/2017.
 */
public class EntityPage {

    WebDriver driver;

    By entityLink = By.xpath("//a[@title='Entities']");
    By entityName = By.xpath("/html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[1]/div/div[1]/a");
    By addEntity = By.xpath("//*[@ng-click=\"$ctrl.addEntity()\"]");

    public EntityPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement entityLink(){

        return driver.findElement(entityLink);
    }

    public WebElement entityName(){

        return driver.findElement(entityName);
    }

    public WebElement addEntity(){

        return driver.findElement(addEntity);
    }
}
