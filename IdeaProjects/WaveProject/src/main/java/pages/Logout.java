package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/16/2017.
 */
public class Logout {
    WebDriver driver;

    By Logout_button = By.xpath("//div[@class='text-center p ng-scope']//button");
    By UserName_icon=By.xpath("//div//a/span[@class='mr-sm ng-binding']");



    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void setLogout() throws InterruptedException {
        driver.findElement(UserName_icon).click();
        Thread.sleep(500);
        driver.findElement(Logout_button).click();
        System.out.println("User Logged out");
    }





}
