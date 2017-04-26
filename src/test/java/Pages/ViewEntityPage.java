package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/19/2017.
 */
public class ViewEntityPage {

    WebDriver driver;

    By addDepartment = By.xpath("/html/body/div[2]/section/div/h3/button");
    By departmentName = By.xpath("/html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[1]/div/div[1]/a");


    public ViewEntityPage(WebDriver driver){

        this.driver = driver;
    }

    // "Add Department" button

    public WebElement addDepartment(){

        return driver.findElement(addDepartment);
    }

    // Name of a department link listed

    public WebElement departmentName(){

        return driver.findElement(departmentName);
    }
}
