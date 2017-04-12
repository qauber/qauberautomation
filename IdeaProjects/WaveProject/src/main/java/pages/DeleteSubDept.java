package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by anbus on 3/24/2017.
 */
public class DeleteSubDept {
    WebDriver driver;
    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By click_On_company = By.xpath("//table//tbody//tr//td[1]//div//a");// 7th row entity "hallo#"
    By click_on_dept = By.xpath("//table//tbody//tr[2]//td[1]//div//a");  // 1st dept
    By click_on_SubDept = By.xpath("//table//tbody//tr[2]//td[1]//div//a");
    By AddDeptButton = By.xpath("//div[@class='content-wrapper ng-scope ng-fadeInUp']//button [text()='Add Department']");
    By SubDeptName = By.xpath("//form//input[@name='name']");
    By Add_Button = By.xpath("//div[@class='clearfix']//button[@type='submit']");
    By edit_icon = By.xpath("//div//td[@class='text-center']//button[2]");

    By delete_Icon = By.xpath("//div//td[@class='text-center']//button[4]");
    By confirm_Delete_Button = By.xpath("//div[@class='text-center']//button[text()='Delete']");
    By save_Button = By.xpath("//div[@class='clearfix']//button");


    public DeleteSubDept(WebDriver driver) {

        this.driver = driver;
    }

    public void deleteSubDept() throws InterruptedException {
        driver.findElement(Entities).click(); // click on left panel
        Thread.sleep(2000);
        driver.findElement(click_On_company).click(); // company --hallo#
        Thread.sleep(3000);
        driver.findElement(click_on_dept).click(); // mobile dept

         Thread.sleep(2000);
        String expectedStr = driver.findElement(By.xpath("//table//tbody//tr[2]//td[1]//div//a")).getText();
        //System.out.print("Actual:" + actualStr + " " + " Expected: " + randomStr);
        System.out.println(" Sub department  name before deletion: " + expectedStr);

        driver.findElement(delete_Icon).click();
        driver.findElement(confirm_Delete_Button).click();
        Thread.sleep(1000);
        Assert.assertFalse(driver.findElement(By.xpath("//table//tbody//tr[2]//td[1]//div//a")).getText().contains(expectedStr));
        System.out.println("Sub department is deleted");


    }

}
