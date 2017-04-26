package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/17/2017.
 */
public class AddReportSubjectInformationTab {

    WebDriver driver;

    By firstName = By.xpath("*//fieldset/div[2]/div[2]/div/div/input");
    By lastName = By.xpath("*//fieldset/div[2]/div[1]/div/div/input");
    By gangMembershipTab = By.xpath("*//form/div[1]/div[2]/ol/li[5]");

    public AddReportSubjectInformationTab(WebDriver driver){

        this.driver = driver;
    }

    //Set first name in "First Name" textbox

    public WebElement firstName(){

        return driver.findElement(firstName);
    }

    //Set last name in "Last Name" textbox

    public WebElement lastName(){

        return driver.findElement(lastName);
    }

    public WebElement gangMembershipTab(){

        return driver.findElement(gangMembershipTab);
    }
}
