package pages;

//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.*;

public class AddReport {
    WebDriver driver ;
    // Click on "Add Reports" link
    private By addReportLink = By.xpath("html/body/div[2]/aside[1]/div/nav/ul/li[4]/a");
    private By addReportLink2 = By.linkText("Add Report");

    //Entity
    private By entityChoose = By.xpath("//div[2]/div/div/label[@class='ng-binding']");

    //Subject Information
    private By gotoSubjectInfoPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[2]/h4/div");
    private By caseID=By.xpath("//input[@name='caseNumber']");
    private By subspectType = By.xpath("//option[@value='Suspect']");
    private By lastName= By.name("lastName");
    private By firstName = By.name("firstName");
    //Distribution//Gang member
    private By gotoGangmemberpage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[5]");
    private By locationOfStop = By.name("locationOfStop");
    private By previewReport = By.xpath("//section//div/form/div[1]/div[2]/ol/li[8]");
    private By publishReport = By.xpath("//section/div/div/form/div[2]/button[1]");
    private By reportLink = By.linkText("Reports");



    public void  AddReport(WebDriver driver){
        this.driver=driver;

    }
    public void clickAddReportlink (){        driver.findElement(addReportLink).click();    }
    public void clickAddReportlink2 (){        driver.findElement(addReportLink2).click();    }
    public void clickReports(){        driver.findElement(reportLink).click();    }
    public void clickChooseEntity (){

        WebElement element = driver.findElement(entityChoose);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void clickGotoSubjectInfoPage(){
        driver.findElement(gotoSubjectInfoPage).click();
    }
    public void setLastName(String strlastName){
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(strlastName);
    }
    public void setFirstName(String strfirstName){

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(strfirstName);
    }
    public void clickGotoGangmemberPage(){
        driver.findElement(gotoGangmemberpage ).click();
    }
    public void setLocationOfStop(String strLocation){
        driver.findElement(locationOfStop).clear();
        driver.findElement(locationOfStop).sendKeys(strLocation);
    }
    public void clickPreviewReport(){
        driver.findElement(previewReport).click();
    }
    public void clickPublishReport(){
        driver.findElement(publishReport).click();
    }

    public void AddUnpublishedReport(String strLastname, String strFirstname, String strLocation) throws InterruptedException{
        Thread.sleep(3000);
        this.clickAddReportlink2();
        Thread.sleep(5000);
        this.clickChooseEntity();
        Thread.sleep(5000);
        this.clickGotoSubjectInfoPage();
        Thread.sleep(5000);
        this.setLastName(strLastname);
        Thread.sleep(5000);
        this.setFirstName(strFirstname);
        Thread.sleep(5000);
        this.clickGotoGangmemberPage();
        Thread.sleep(5000);
        this.setLocationOfStop(strLocation);
        Thread.sleep(5000);
        this.clickPreviewReport();
        Thread.sleep(5000);
    }
    public  String  completeReport(String strLastname, String strFirstname, String strLocation) throws InterruptedException{

        this.clickAddReportlink();
        Thread.sleep(5000);
        this.clickChooseEntity();
        Thread.sleep(2000);
        this.clickGotoSubjectInfoPage();
        Thread.sleep(2000);
        this.setLastName(strLastname);
        Thread.sleep(2000);
        this.setFirstName(strFirstname);
        Thread.sleep(2000);
        this.clickGotoGangmemberPage();
        Thread.sleep(2000);
        this.setLocationOfStop( strLocation);
        Thread.sleep(2000);

        this.clickPreviewReport();
        Thread.sleep(6000);
        String firstNameonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='First Name']//div[@class='text-bold ng-binding']"))).getText();
        String lastNameonReport=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Last Name']//div[@class='text-bold ng-binding']"))).getText();
        String reportID=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']"))).getText();

        String actualReportID=reportID+"."+firstNameonReport+" "+lastNameonReport;
       // this.clickPublishReport();
        Thread.sleep(5000);

        return actualReportID;
    }
}
