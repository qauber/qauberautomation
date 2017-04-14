package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/26/17.
 */
public class ViewSpecificReport {
    WebDriver driver;
    public ViewSpecificReport (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement DownloadasPDF() {
        return driver.findElement(By.xpath("//button[@ng-click='makePdf(report)']"));

    }
    public WebElement LastName() {
        return driver.findElement(By.cssSelector("#reportBody > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)"));
    }

    public WebElement FirstName() {
        return driver.findElement(By.cssSelector("#reportBody > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2)"));
    }

    public WebElement ReportNumber() {
        return driver.findElement(By.cssSelector("#reportBody > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
    }

    public WebElement CreatedDate() {
        return driver.findElement(By.cssSelector("#reportBody > div:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
    }

    public WebElement CreatedTime() {
        return driver.findElement(By.cssSelector("#reportBody > div:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
    }

    public WebElement OfficerName() {
        return driver.findElement(By.cssSelector("#reportBody > div:nth-child(13) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2)"));
    }

}
