package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sc on 2/20/2017.
 */
public class AddReportIDInformation {

    WebDriver dr;
    WebElement element;
    String[] newdate;

    public AddReportIDInformation(WebDriver dr){

        this.dr = dr;
    }
     // ******************ID Information*********************
    public WebElement socialSecurity(){

        return dr.findElement(By.xpath("//input[@name='socialSecurity']"));
    }

    public WebElement driverLicense(){

        return dr.findElement(By.xpath("//input[@name='driverLicense']"));
    }

    public WebElement otherID(){

        return dr.findElement(By.xpath("//input[@name='other-id']"));
    }

    public Select state(){
       return  new Select(dr.findElement(By.xpath("//select[@ng-model='wizard.report.dlState']")));

    }

    public WebElement otherIDState(){
        return dr.findElement(By.xpath("//input[@name='otherIdState']"));
    }

    public Select country(){
        return  new Select(dr.findElement(By.xpath("//select[@name='otherIdCountry']")));

    }

//**************************************School Information ******************************
   public WebElement schoolName(){

        return dr.findElement(By.xpath("//input[@name='school-name']"));
   }




 //**********************************Parent Information***********************************
 public WebElement parentName(){

     return dr.findElement(By.xpath("//input[@name='parent-name']"));

 }

    public WebElement parentZip(){

        return dr.findElement(By.xpath("//input[@name='parentZip']"));
    }



//***********************Employer Information********************************************

    public WebElement subjectOccupation(){
     return dr.findElement(By.xpath("//input[@name='occupation']"));
}
    public WebElement employerName(){
     return dr.findElement(By.xpath("//input[@name='employer-name']"));
    }

    public Select employerstate(){
        return  new Select(dr.findElement(By.xpath("//select[@ng-model='wizard.report.employerState']")));

    }
    public WebElement employerZip(){

        return dr.findElement(By.xpath("//input[@name='employer-zip']"));
    }
//******************************Previous and Next Buttons**********************
public WebElement nextButton(){

    return dr.findElement(By.xpath("//a[text()='Next']"));
}

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }
   // moving to next page***********************
    public WebElement stopInformationPage(){
        return dr.findElement(By.xpath("//div[@title='Gang Membership']"));
    }

    public void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor)dr;
        jse.executeScript("scroll(0, 350);");

    }

    public void scrollUp(){
        JavascriptExecutor jse = (JavascriptExecutor)dr;
        jse.executeScript("scroll(0, -250);");

    }

    public void scrollToElement() throws InterruptedException {
        element = dr.findElement(By.xpath("//div[@title='Gang Membership']"));
        ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
    }


}
