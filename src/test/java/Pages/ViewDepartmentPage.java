package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

/**
 * Created by Jenny on 3/19/2017.
 */
public class ViewDepartmentPage {

    WebDriver driver;

    By addSubDepartment = By.xpath("//h3/button");
    By addedSubDept = By.xpath("//tr[2]/td[1]/div/div[1]/a");
    By deleteSubDept = By.xpath("//tr[2]/td[2]/button[4][@title=\"Delete\"]");

    public ViewDepartmentPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement addSubDepartment(){

        return driver.findElement(addSubDepartment);
    }

    public WebElement addedSubDept(){

        return driver.findElement(addedSubDept);
    }

    public WebElement deleteSubDept(){

        return driver.findElement(deleteSubDept);
    }
}
