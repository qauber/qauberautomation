package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/24/17.
 */
public class ReportInformation {


    private WebDriver driver;

    public ReportInformation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement DownloadPDF() {
        return driver.findElement(By.xpath("//button[@ng-click='makePdf(report)']"));
    }


    public WebElement Name() {
        return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']"));
    }

    public WebElement Logout() {
        return driver.findElement(By.xpath("//button[@ng-click='app.logout()']"));
    }
}

