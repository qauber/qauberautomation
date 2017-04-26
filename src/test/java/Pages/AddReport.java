package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Jennifer Grelik on 3/16/2017.
 */
public class AddReport {
    ///// AddReport Objects /////

    WebDriver driver;

    By addReport = By.xpath("//*[@title=\"Add Report\"]");
    By addReportAU = By.xpath("/html/body/div[2]/aside[1]/div/nav/ul/li[4]/a");

    public AddReport(WebDriver driver){

        this.driver = driver;
    }

    //Click "Add Report" link

    public WebElement addReport(){

       return driver.findElement(addReport);
    }

    //Click "Add Report" link as organization admin

    public WebElement addReportAU(){

        return driver.findElement(addReportAU);
    }
}
