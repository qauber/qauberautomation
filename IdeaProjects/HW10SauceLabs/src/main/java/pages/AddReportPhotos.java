package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sc on 2/21/2017.
 */
public class AddReportPhotos {
    WebDriver dr;
    WebElement element;
    String[] newdate;

    public AddReportPhotos(WebDriver dr) {

        this.dr=dr;
    }

    //****************Next and Previous Buttons*******************************
    public WebElement nextButton(){

        return dr.findElement(By.xpath("//a[text()='Next']"));
    }

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }

    public WebElement photo(){

        return dr.findElement(By.xpath("//snap[text()='Add photo']"));
    }

    //moving to next page***********************
    public WebElement previewPage(){
        return dr.findElement(By.xpath("//div[@title='Preview']"));
    }

}
