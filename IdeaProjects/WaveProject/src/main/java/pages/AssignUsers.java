package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by anbus on 3/16/2017.
 */
public class AssignUsers {
    WebDriver driver;

    By Users_Link = By.xpath("//a[@class='ng-scope']//span[text()='Users']");
    By AssignPermission_Icon = By.xpath("//td[@class='text-center']//em");
    By Rights_Dropdown = By.xpath("//div//table//select[@ng-model='entity.status']");
    By Save_Icon = By.xpath("//div//table//button[@ng-click='assignEntity(entity)']");
    By Close =By.xpath("//div//div[@class='ngdialog-close']");

    public AssignUsers(WebDriver driver) {

        this.driver = driver;
    }

    public void assignUsers() throws InterruptedException {
        driver.findElement(Users_Link).click();
        driver.findElement(AssignPermission_Icon).click();
        Select rightsDropDown = new Select(driver.findElement(Rights_Dropdown));
        rightsDropDown.selectByVisibleText("Regular User");
        driver.findElement(Save_Icon).click();
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].click();", driver.findElement(Close) );
    }
}
