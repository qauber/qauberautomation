package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/6/17.
 */
public class ViewReports {
    WebDriver driver;
    public ViewReports(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Reports() {
        return driver.findElement(By.xpath("//span[text()='Reports']"));
    }

    public WebElement SuspectLastName() {
        return driver.findElement(By.xpath("//input[@ng-model='slnSearchKey']"));
    }

    public WebElement SuspectFirstName() {
        return driver.findElement(By.xpath("//input[@ng-model='sfnSearchKey']"));
    }

    public WebElement ViewButton() {
        return driver.findElement(By.xpath("//a[@title='View']"));
    }


}
