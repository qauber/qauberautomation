package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/20/2017.
 */
public class AddEntityPage {

    WebDriver driver;

    By entityName = By.xpath("//*[@ng-model=\"$ctrl.org.name\"]");
    By address1 = By.xpath("//*[@name=\"address1\"]");
    By city = By.xpath("//*[@name=\"city\"]");
    By state = By.xpath("//*[@name=\"state\"]");
    By postalCode = By.xpath("//input[@name=\"zip\"]");
    By nextButton = By.xpath("//div[@class=\"panel-footer text-right\"]/button[2]");

    public AddEntityPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement entityName(){

        return driver.findElement(entityName);
    }

    public WebElement address1(){

        return driver.findElement(address1);
    }

    public WebElement city(){

        return driver.findElement(city);
    }

    public WebElement state(){

        return driver.findElement(state);
    }

    public WebElement postalCode(){

        return driver.findElement(postalCode);
    }

    public WebElement nextButton(){

        return driver.findElement(nextButton);
    }
}
