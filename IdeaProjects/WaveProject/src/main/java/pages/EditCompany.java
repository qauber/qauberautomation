package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/16/2017.
 */
public class EditCompany {
    WebDriver driver;

    By UserName_icon=By.xpath("//div//a/span[@class='mr-sm ng-binding']");
    By  EditCompany_Icon=By.xpath("//div[@class='ng-scope']//button[text()='Edit Company']");
    By CompanyName = By.xpath("//input[@name='name']");
    By Update_button = By.xpath("//form//div[@class='panel-footer clearfix']//button");


    public EditCompany(WebDriver driver) {
        this.driver = driver;
    }

    public void setEditCompany() {
        driver.findElement(UserName_icon).click();
        driver.findElement(EditCompany_Icon).click();
        driver.findElement(CompanyName).clear();
        driver.findElement(CompanyName).sendKeys("New Company");
        driver.findElement(Update_button).click();

    }
}
