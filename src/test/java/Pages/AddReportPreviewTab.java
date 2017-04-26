package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/17/2017.
 */
public class AddReportPreviewTab {

    WebDriver driver;

    By expectedReportId = By.xpath("//form/div[1]/div[2]/div[9]/div[1]/div/div[1]/div[3]/div");
    By publishReport = By.xpath("//*[@ng-click=\"wizard.commitReport()\"]");

    public AddReportPreviewTab(WebDriver driver){

        this.driver = driver;
    }

    //The "ReportID" field

    public WebElement expectedReportId(){

        return driver.findElement(expectedReportId);
    }

    //Click on "Publish Report" button

    public WebElement publishReport(){

        return driver.findElement(publishReport);
    }


}
