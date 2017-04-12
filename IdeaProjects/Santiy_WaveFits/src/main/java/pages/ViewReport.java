package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ViewReport {

    WebDriver driver ;
    private By reportLink = By.xpath("//a[@ng-href='#/app/reports']");
    private By viewReport = By.xpath("//table/tbody/tr[1]/td/div/div/div[2]/div[5]/a[1]");
    private By ReportID = By.xpath("id('reportBody')/div[1]/div/div[1]/div[3]/div");
    private By exportReportasPDF= By.xpath("//div[1]/div/div/button[2][@ ng-click='makePdf(report)']");
    private By expectedResult =By.xpath("//table/tbody/tr[1]//div[1]/div/h4");

    public void ViewReport(WebDriver driver){this.driver=driver;}
    public void clickReportLink(){driver.findElement(reportLink).click();}
    public void clickViewReport(){driver.findElement(viewReport).click();}
    public void clickExportReporttoPDF(){   driver.findElement(exportReportasPDF).click();}
    public String setReportID(){return driver.findElement(ReportID).getText();}

    public String getExpectedReportID() { return driver.findElement(expectedResult ).getText(); }

}
