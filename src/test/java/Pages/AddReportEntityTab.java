package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.parser.Entity;

/**
 * Created by Jenny on 3/17/2017.
 */
public class AddReportEntityTab {

    WebDriver driver;

    By entity = By.xpath("*//fieldset/div[2]/div/div/label/span");
    By subjectInformationTab = By.xpath("*//form/div[1]/div[2]/ol/li[2]");

    public AddReportEntityTab(WebDriver driver){

        this.driver = driver;
    }

    public WebElement entity(){

        return driver.findElement(entity);
    }

    public WebElement subjectInformationTab(){

        return driver.findElement(subjectInformationTab);
    }


}
