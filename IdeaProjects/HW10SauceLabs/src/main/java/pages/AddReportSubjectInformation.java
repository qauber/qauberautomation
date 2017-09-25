package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by sc on 2/20/2017.
 */
public class AddReportSubjectInformation {


    WebDriver dr;
    WebElement element;
    Select select;
    String[] newdate;

    public AddReportSubjectInformation(WebDriver dr){

        this.dr=dr;

    }

    public WebElement nextButton(){

        return dr.findElement(By.xpath("//a[text()='Next']"));
    }

    public WebElement caseID(){
        return dr.findElement(By.xpath("//input[@name='caseNumber']"));
    }

    public void suspectType(String type){
        select = new Select(dr.findElement(By.xpath("\\div[@class='controls']")));
        select.selectByValue(type);
    }

    public WebElement lastNameField(){
         return dr.findElement(By.xpath("//input[@name='lastName']"));
    }

    public WebElement firstNameField(){

        return dr.findElement(By.name("firstName"));
    }

    public WebElement middleNameField(){

        return dr.findElement(By.name("middleName"));
    }

    public WebElement dateOfBirthField() {
        return dr.findElement(By.xpath("//label[text()='Date of Birth']"));
    }
    // Enter the date with space
    public String date(String date){
        String[] newdate=date.split("");


        String newdate1 = newdate[0]+newdate[1]+"/"+newdate[2]+newdate[3]+"/"+newdate[4]+newdate[5]+newdate[6]+newdate[7];
        return newdate1;

    }

    public WebElement ageField(){

        return dr.findElement(By.name("Age"));
    }

    public Select hairColor(){
        return new Select(dr.findElement(By.xpath("//select[@ng-model='wizard.report.hairColor']")));
    }

    public Select eyeColor(){
        return new Select(dr.findElement(By.xpath("//select[@ng-model='wizard.report.eyeColor']")));
    }

    public WebElement previousButton(){

        return dr.findElement(By.xpath("//a[text()='Previous']"));
    }

    //moving to next page***********************
    public WebElement identifierPage(){
        return dr.findElement(By.xpath("//div[@title='Identifiers']"));
    }

}
