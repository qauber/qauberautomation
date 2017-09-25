package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sc on 2/21/2017.
 */
public class AddReportVehicle {

    WebDriver dr;
    WebElement element;
    String[] newdate;

   public AddReportVehicle(WebDriver dr) {

       this.dr=dr;
   }

    //****************Next and Previous Buttons*******************************
    public WebElement nextButton(){

        return dr.findElement(By.xpath("//a[text()='Next']"));
    }

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }

    //******************************Vehicle Information**********************************

    public WebElement vehicleLicense(){
        return dr.findElement(By.xpath("//input[@name='vehicleLicense']"));
    }

    public WebElement vehicleMake(){
        return dr.findElement(By.xpath("//input[@name='vehicleMake']"));
    }
    public WebElement vehicleModel(){
        return dr.findElement(By.xpath("//input[@name='vehicleModel']"));
    }
    public WebElement vehicleYear(){
        return dr.findElement(By.xpath("//input[@name='vehicleYear']"));
    }
    public Select vehicleState(){
        return new Select(dr.findElement(By.xpath("//select[@ng-model='wizard.report.vehicleState']")));
    }

    //moving to next page***********************
    public WebElement photosPage(){
        return dr.findElement(By.xpath("//div[@title='Photos']"));
    }


}
