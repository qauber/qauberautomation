package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 4/11/17.
 */
public class MainNavigation {

    private WebDriver driver;

    public MainNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Entities() {
        return driver.findElement(By.xpath("//span[text()='Entities']"));
    }
}
