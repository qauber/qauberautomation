package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/24/17.
 */
public class IDInformation {

    WebDriver driver;

    public IDInformation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Nextbtn() {
        return driver.findElement(By.xpath("//a[@ng-click='wizard.go(5)']"));
    }


}
