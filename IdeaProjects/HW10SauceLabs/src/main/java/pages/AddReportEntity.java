package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by sc on 2/17/2017.
 */
public class AddReportEntity {

 WebDriver dr;
 WebElement element;
 Select select;
 String[] newdate;

 public AddReportEntity(WebDriver dr){

     this.dr = dr;
    }

    public List<WebElement> entityNameList(){

     return dr.findElements(By.xpath("//input[@ng-model='wizard.report.key']"));

    }

    public WebElement entityNamelistByIndex(int rowIndex){

        return entityNameList().get(rowIndex);

    }

    public WebElement nextButton(){

        return dr.findElement(By.xpath("//a[text()='Next']"));
    }

   // moving to next page***********************
    public WebElement subjectInformationPage(){
        return dr.findElement(By.xpath("//div[@title='Subject Information']"));
    }


}
