package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/6/17.
 */
public class SubjectInformation {
    private WebDriver driver;

    public SubjectInformation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement LastName() {
        return driver.findElement(By.xpath("//input[@name='lastName'][@type='text']"));

    }

    public WebElement FirstName() {
        return driver.findElement(By.xpath("//input[@name='firstName'][@type='text']"));
    }

    public WebElement Nextbtn() {
        return driver.findElement(By.xpath("//a[@ng-click='wizard.go(3)']"));
    }


}
