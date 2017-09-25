package pages;

import helper.ReportHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by sc on 2/23/2017.
 */
public class Reports {
    WebDriver dr;
    ReportHelper reportHelper;


    public Reports(WebDriver dr) {
        this.dr = dr;

    }

    public WebElement checkBoxPublishedOn() {
        return dr.findElement(By.xpath("//input[@ng-model='enablePublishedOn']"));
    }

    public WebElement searchByLastName() {
        return dr.findElement(By.xpath("//input[@ng-model='slnSearchKey']"));
    }

    public WebElement searchByFirstName() {
        return dr.findElement(By.xpath("//input[@ng-model='sfnSearchKey']"));
    }

    public WebElement searchByCaseId() {
        return dr.findElement(By.xpath("//input[@ng-model='ciSearchKey']"));
    }

    public Select suspectType() {
        return new Select(dr.findElement(By.xpath("//select[@ng-model='stSearchKey']")));
    }

    public WebElement selectFromDate() {

        return dr.findElement(By.xpath("//input[@ng-model='searchFrom']"));
    }

    public WebElement selectToDate() {

        return dr.findElement(By.xpath("//input[@ng-model='searchTo']"));
    }

    public void createdFromDate(String date) {

        dr.findElement(By.xpath("//input[@ng-model='createdFrom']"));
    }

    public void createdToDate(String date) {

        dr.findElement(By.xpath("//input[@ng-model='createdTo']"));
    }

    public void containsText() {

        dr.findElement(By.xpath("//input[@ng-model='ctSearchKey']"));
    }

    public void clearButton() {

        dr.findElement(By.xpath("//span[text()='Clear']"));
    }

    public List<WebElement> paginationPrevButtonList() {

        // the pagenumber starts from 2 to view reports
        return dr.findElements(By.xpath("//a[@class='ng-binding']"));
    }

    public WebElement paginationPrevButtonByIndex(int index) {
        return paginationPrevButtonList().get(index);
    }

    public List<WebElement> paginationNextButtonList() {

        // the pagenumber starts from 2 to view reports
        return dr.findElements(By.xpath("//a[@class='ng-binding']"));
    }

    public WebElement paginationNextButtonByIndex(int index) {
        return paginationPrevButtonList().get(index);
    }

    public WebElement tableView(int index) {
        //index starts with 2.
        WebElement element = dr.findElement(By.xpath("//div[@ng-class='app.viewAnimation']"));
        List<WebElement> reportrow = element.findElements(By.xpath("//td"));
        return reportrow.get(index);
    }

    public void ensurePublishReports(int num) throws InterruptedException {

        // After Click on Reports Tab -- Count the number of Reports already shown
        // if number of ensure published reports is less than the reports shown in Application
        //Create the number of Reports

        //Check if Published Reports button is Selected, if it is, uncheck it and count number of reports
        Thread.sleep(10000);
        if (dr.findElement(By.xpath("//input[@ng-model='enablePublishedOn']")).isEnabled()) {
            Thread.sleep(5000);
            dr.findElement(By.xpath("//input[@ng-model='enablePublishedOn']")).click();
        }
        Thread.sleep(3000);
        JavascriptExecutor jse1 = (JavascriptExecutor) dr;
        jse1.executeScript("scroll(0, 450);");
        Thread.sleep(3000);

        if (num<10) {
            int count = 0;
            WebElement element = dr.findElement(By.xpath("//div[@ng-class='app.viewAnimation']"));
            List<WebElement> reportrow = element.findElements(By.xpath("//td"));
            for (int k = 3; k <= reportrow.size(); k++) {
                count = count + 1;
            }
            System.out.println("This is the count of no.of records on first page:");
            System.out.println(count);
            if (num>count){
                int num2 = num-count;
                reportHelper.CreateReports(num2);
            }

        }
        else if (num > 10) {

            //Go to each page by clicking next button and count number of Reports
            List<WebElement> paginationbutton = dr.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]"));
            if (paginationbutton.size() > 0) {
                JavascriptExecutor jse = (JavascriptExecutor) dr;
                jse.executeScript("scroll(0, 950);");
                Thread.sleep(5000);
                List<WebElement> pagenumbers = dr.findElements(By.xpath("//a[@class='ng-binding' and @ng-click='setCurrent(pageNumber)']"));
                int count1 = 0;
                for (int index = 1; index <= pagenumbers.size(); index++) {

                    // pagenumbers.get(index).click();
                    int count = 0;

                    WebElement element = dr.findElement(By.xpath("//div[@ng-class='app.viewAnimation']"));
                    List<WebElement> reportrow = element.findElements(By.xpath("//td"));
                    for (int k = 3; k <= reportrow.size(); k++) {
                        count = count + 1;
                       // System.out.println(reportrow.get(k-1).getText());
                    }
                    System.out.println("This is the count of Reports per page" + count);
                   // System.out.println(pagenumbers.get(index).getText());
                    if(index < pagenumbers.size()) {
                        pagenumbers.get(index).click();
                        Thread.sleep(5000);
                    }
                    count1 = count1 + count;

                }
                System.out.println("This is total count of Reports" + count1);
                if (num>count1){
                    int num2 = num-count1;
                    reportHelper.CreateReports(num2);
                }
            }


        } else
            System.out.println("There are no reports on the page");
            reportHelper.CreateReports(num);



    }

    // Bug WAVE-913
    public List<WebElement> viewButton(){

         return dr.findElements(By.xpath("//a[@title='View']"));
    }

    public WebElement viewButtonByIndex(int index){
        return viewButton().get(index);
    }

    public WebElement viewEyeColorContent(){
        return dr.findElement(By.xpath("//div[./span='Eye Color']/div"));
        //span[text()='Eye Color']//following::div[1]
    }

    public WebElement viewHairColor(){
        return dr.findElement(By.xpath("//span[text()='Hair Color']"));
    }





}