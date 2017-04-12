package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddDepartment{

    WebDriver driver;

    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By click_On_Entity = By.xpath("//table//tbody//tr[3]//td[1]//div//a");
    By AddDept = By.xpath("//div[@class='content-wrapper ng-scope ng-fadeInUp']//button [text()='Add Department']");
    By DeptName = By.xpath("//form//input[@name='name']");
    By Add_Button = By.xpath("//div[@class='clearfix']//button[@type='submit']");

    public AddDepartment(WebDriver driver) {

        this.driver = driver;
    }

    public void setAddDept() throws InterruptedException {
        driver.findElement(Entities).click();
        driver.findElement(click_On_Entity).click();
        Thread.sleep(1000);
        driver.findElement(AddDept).click();
        driver.findElement(DeptName).sendKeys("marketing");
        driver.findElement(Add_Button).click();

    }
}
