package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/17/2017.
 */
public class ReportsPage {

    WebDriver driver;

    By actualReportId = By.xpath("*//tr[1]/td/div/div/div[1]/div/h4");
    By viewReport = By.xpath("*//tr[1]/td/div/div/div[2]/div[5]/a[1]");

    public ReportsPage(WebDriver driver){

        this.driver = driver;
    }

    //The actual, published ReportID

    public WebElement actualReportId(){

        return driver.findElement(actualReportId);
    }

    public WebElement viewReport(){

        return driver.findElement(viewReport);
    }
}
