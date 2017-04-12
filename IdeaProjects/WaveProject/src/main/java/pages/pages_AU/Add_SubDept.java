package pages.pages_AU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/21/2017.
 */
public class Add_SubDept {

    WebDriver driver;
    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By click_On_subEntity = By.xpath("//table//tbody//tr[2]//td[1]//div//a");
    By AddSubDept = By.xpath("//div[@class='content-wrapper ng-scope ng-fadeInUp']//button [text()='Add Department']");
    By SubDeptName = By.xpath("//form//input[@name='name']");
    By Add_Button = By.xpath("//div[@class='clearfix']//button[@type='submit']");

    public Add_SubDept(WebDriver driver) {

        this.driver = driver;
    }

    public void setAddSubDept() throws InterruptedException {
        driver.findElement(Entities).click();
        driver.findElement(click_On_subEntity).click();
        Thread.sleep(1000);
        driver.findElement(AddSubDept).click();
        driver.findElement(SubDeptName).sendKeys("mobileqa");
        driver.findElement(Add_Button).click();

    }
}
