package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/11/17.
 */
public class Users {
    private WebDriver driver;

    public Users(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement DeleteButton2() {
        return driver.findElement(By.xpath("//tr[4]//em[@class='fa fa-trash']"));
    }

    public WebElement DeleteButton1() {
        return driver.findElement(By.xpath("//tr[3]//em[@class='fa fa-trash']"));
    }

    public WebElement DeleteConfirm() {
        return driver.findElement(By.xpath("//button[@ng-click='confirm()']"));
    }
}
