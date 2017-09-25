package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sc on 2/21/2017.
 */
public class AddReportStopInformation {

    WebDriver dr;
    WebElement element;
    Select select;
    String[] newdate;


    public AddReportStopInformation(WebDriver dr) {

        this.dr=dr;
    }
//**********************************Distribution*********************************
    public WebElement gangUnit(){
        return dr.findElement(By.xpath("//label[text()='Gang Unit']"));
    }

    public WebElement sexCrimes(){
        return dr.findElement(By.xpath("//label[text()='Sex Crimes']"));
    }

    public WebElement robbery(){
        return dr.findElement(By.xpath("//label[text()='Robbery']"));
    }

    public WebElement narco(){
        return dr.findElement(By.xpath("//label[text()='Narco']"));
    }
    public WebElement viceIntel(){
        return dr.findElement(By.xpath("//label[text()='Vice / Intel']"));
    }

//******************************Stop Information***********************************


   public WebElement reasonForStop(){
        return dr.findElement(By.xpath("//input[@name='reasonForStop']"));
   }
    public WebElement locationOfStop(){
        return dr.findElement(By.xpath("//input[@name='locationOfStop']"));
    }

    public WebElement dispositionOfStop(){
        return dr.findElement(By.xpath("//input[@name='dispositionofStop']"));
    }
//*********************************Gang Criteria**************************************
    public WebElement gangName(){
        return dr.findElement(By.xpath("//input[@name='gang-name']"));
    }
    public WebElement howLong(){
        return dr.findElement(By.xpath("//input[@name='howLong']"));
    }
    public WebElement selfAdmission(){
        return dr.findElement(By.xpath("//label[text()='Self Admission']"));
    }

    public WebElement frequentingGang(){
        return dr.findElement(By.xpath("//label[text()='Frequenting Gang Area']"));
    }

    public WebElement gangMemberInformant(){
        return dr.findElement(By.xpath("//label[text()='Gang Member By Reliable Informant']"));
    }
    public WebElement gangTattoos(){
        return dr.findElement(By.xpath("//label[text()='Gang Tattoos']"));
    }
    public WebElement gangClothing(){
        return dr.findElement(By.xpath("//label[text()='Gang Clothing']"));
    }
    public WebElement gangRegistrant(){
        return dr.findElement(By.xpath("//label[text()='Gang Registrant']"));
    }
    public WebElement affiliatingWithGang(){
        return dr.findElement(By.xpath("//label[text()='Affiliating With Gang Members']"));
    }
//*********************************Parole/Probation Status**********************************
    public WebElement onParole(){
        return dr.findElement(By.xpath("//label[text()='On Parole']"));
    }
    public WebElement onProbation(){
        return dr.findElement(By.xpath("//label[text()='On Probation']"));
    }

//********************************Previous and Next Buttons***********************************
public WebElement nextButton(){

    return dr.findElement(By.xpath("//a[text()='Next']"));
}

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }
    //moving to next page***********************
    public WebElement vehiclePage(){
        return dr.findElement(By.xpath("//div[@title='Vehicle']"));
    }

}