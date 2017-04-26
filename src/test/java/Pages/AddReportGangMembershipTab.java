package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/17/2017.
 */
public class AddReportGangMembershipTab {

    WebDriver driver;

    By stopLocation = By.xpath("//*[@name=\"locationOfStop\"]");
    By preview = By.xpath("//form/div[1]/div[2]/ol/li[8]");

    public AddReportGangMembershipTab(WebDriver driver){

        this.driver = driver;
    }

    //Set location in "Location of Stop" textbox

    public WebElement locationForStop(){

        return driver.findElement(stopLocation);
    }

    //Click on "Preview" tab

    public WebElement previewTab(){

        return driver.findElement(preview);
    }
}
