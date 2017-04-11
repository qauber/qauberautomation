package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/20/2017.
 */
public class ViewReport {

    WebDriver driver;
    public ViewReport(WebDriver driver) {
        this.driver = driver;
    }



    By reportBtn= By.xpath("//span[text()='Reports']");
    By  ViewBtn= By.xpath("html/body/div[2]/section/div/div[3]/div[2]/table/tbody/tr[1]/td/div/div/div[2]/div[5]/a[1]");
    By DownloadPdf=By.xpath("//button[@ng-click='makePdf(report)']");


    public WebElement Download (){return  driver.findElement(DownloadPdf);}
    public WebElement ReportBtn() {
        return  driver.findElement(reportBtn);
    }
    public WebElement ViewBtn ()
    {
        return driver.findElement(ViewBtn);
    }



}
