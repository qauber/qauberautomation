package pages.pages_RU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/20/2017.
 */
public class RU_Logout {
    WebDriver driver;

    By Logout_button = By.xpath("//div[@class='text-center p ng-scope']//button");
    By UserName_icon=By.xpath("//div//a/span[@class='mr-sm ng-binding']");



    public RU_Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void setLogout() throws InterruptedException {
        driver.findElement(UserName_icon).click();
        Thread.sleep(500);
        driver.findElement(Logout_button).click();
    }
}
