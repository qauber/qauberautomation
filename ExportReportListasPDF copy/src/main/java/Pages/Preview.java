package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/6/17.
 */
public class Preview {
    private WebDriver driver;

    public Preview(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Publishbtn() {
        return driver.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']"));
    }

    public WebElement Confirmation() {
        return driver.findElement(By.xpath("//div[@class='ngdialog-content']//div[@class='ngdialog-message']//button[@ng-click='confirm()']"));
    }

}
