package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sc on 2/21/2017.
 */
public class AddReportCommit {
    WebDriver dr;
    WebElement element;
    String[] newdate;

    public AddReportCommit(WebDriver dr){

        this.dr = dr;

    }

    public WebElement reportCommit(){

        return dr.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']"));
    }
    //****************Next and Previous Buttons*******************************
    public WebElement nextButton(){

        return dr.findElement(By.xpath("//a[text()='Next']"));
    }

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }
}
