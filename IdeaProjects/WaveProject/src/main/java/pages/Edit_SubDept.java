package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by anbus on 3/24/2017.
 */
public class Edit_SubDept {
    WebDriver driver;

    By edit_icon = By.xpath("//tbody//tr[2]//button[2]");

    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By click_On_company = By.xpath("//table//tbody//tr//td[1]//div//a");// Entity
    By click_on_dept = By.xpath("//table//tbody//tr[2]//td[1]//div//a");  // 1st dept
    By click_on_SubDept = By.xpath("//table//tbody//tr[2]//td[1]//div//a");
    By AddDeptButton = By.xpath("//div[@class='content-wrapper ng-scope ng-fadeInUp']//button [text()='Add Department']");
    By SubDeptName = By.xpath("//form//input[@name='name']");
    By Add_Button = By.xpath("//div[@class='clearfix']//button[@type='submit']");
    By save_Button = By.xpath("//div[@class='clearfix']//button");


    public Edit_SubDept(WebDriver driver) {

        this.driver = driver;
    }

    public void editSubDept() throws InterruptedException {
        driver.findElement(Entities).click(); // click on left panel
        driver.findElement(click_On_company).click(); // company
        Thread.sleep(2000);
        driver.findElement(click_on_dept).click(); // mobile dept
        Thread.sleep(1000);
        // click on sub dept edit button
        driver.findElement(By.xpath("//tbody//tr[2]//button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div//input[@name='name']")).clear();
        Thread.sleep(1000);
        String randomStr = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(By.xpath("//div//input[@name='name']")).sendKeys(randomStr);

        driver.findElement(SubDeptName).sendKeys(randomStr);
        driver.findElement(save_Button).click();
        Thread.sleep(2000);

        String actualStr = driver.findElement(By.xpath("//tbody//tr[2]//a")).getText();
        System.out.println("Newly edited subdept in  row:" + actualStr);
        System.out.println("Expected sub department name:" + randomStr);

        Assert.assertEquals(actualStr,randomStr);
        System.out.println(" Sub department  name is edited");

    }
}
