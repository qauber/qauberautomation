package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jenny on 3/19/2017.
 */
public class AddDepartmentPage {

    WebDriver driver;

    By inputDepartment = By.xpath("//*[@id=\"ngdialog1\"]/div[2]/div[1]/form/div[1]/input");
    By addButton = By.xpath("//*[@id=\"ngdialog1\"]/div[2]/div[1]/form/div[2]/button");

    public AddDepartmentPage(WebDriver driver){

        this.driver = driver;
    }
}
