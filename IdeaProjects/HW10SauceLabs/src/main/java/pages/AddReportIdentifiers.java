package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by sc on 2/20/2017.
 */
public class AddReportIdentifiers {
    WebDriver dr;
    WebElement element;
    Select select;
    String[] newdate;
    public AddReportIdentifiers(WebDriver dr){
       this.dr = dr;

    }

    public WebElement nextButton(){

        return dr.findElement(By.xpath("//a[text()='Next']"));
    }

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }

    public WebElement tatoos(){

        return dr.findElement(By.name("Tattoos"));
    }

    public List<WebElement> checkbox(){
        return dr.findElements(By.xpath("//span[@class='fa fa-check']"));

    }

    public WebElement checkboxByIndex(int rowIndex){
        return checkbox().get(rowIndex);
    }

    public WebElement scars(){

        return dr.findElement(By.name("Scars"));
    }

    public WebElement needleMarks(){

        return dr.findElement(By.name("needleMarks"));
    }

    public WebElement tracks(){

        return dr.findElement(By.name("Tracks"));
    }

    public WebElement glasses(){

        return dr.findElement(By.name("Glasses"));
    }

    public WebElement mustache(){

        return dr.findElement(By.name("Mustache"));
    }

    public WebElement beard(){

        return dr.findElement(By.name("Beard"));
    }
    //moving to next page***********************
    public WebElement idInformationPage(){
        return dr.findElement(By.xpath("//div[@title='ID Information']"));
    }



}
