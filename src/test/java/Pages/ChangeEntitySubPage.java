package Pages;

import ObjectRepository.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/28/2017.
 */
public class ChangeEntitySubPage {

    WebDriver driver;

    By cancelSubscription = By.xpath("//*[@class=\"ngdialog ngdialog-theme-default ng-scope\"]/div[2]/div[1]/button[@ng-click=\"$ctrl.cancelSub()\"]");
    By closePage = By.cssSelector(".ngdialog-close");

    public ChangeEntitySubPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement cancelSubscription(){

        return driver.findElement(cancelSubscription);
    }

    public WebElement closePage(){

        return driver.findElement(closePage);
    }
}
