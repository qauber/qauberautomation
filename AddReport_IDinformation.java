package pages;


//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReport_IDinformation {
    WebDriver driver;

    //  ID Information page

    private By ID_InformationPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[4]");

    //ID Information section
    private By socialSecurity = By.xpath("//input[@name='socialSecurity']");
    private By driverLicense = By.xpath("//input[@name='driverLicense']");
    private By state = By.xpath("//select[@ng-model='wizard.report.dlState']"); // select drop down list
    private By otherIDNumber = By.xpath("//input[@name='other-id']");
    private By iDcountry = By.xpath("//select[@name='otherIdCountry']");
    private By stateTextField = By.xpath("//input[@name='otherIdState']");
    private By otherIDType = By.xpath("//input[@name='other-id-type']");

    // School Information section
    private By schoolName = By.xpath("//input[@name='school-name']");
    private By schoolAddress = By.xpath("//input[@name='school-address']");
    private By schoolCity = By.xpath("//input[@name='school-city']");
    private By schoolState = By.xpath("//select[@ng-model='wizard.report.schoolState']");
    private By schoolZip = By.xpath("//input[@name='school-zip']");
    private By schoolTelephone = By.xpath("//input[@name='schoolTelephone']");

    //Parent Information section
    private By parentName = By.xpath("//input[@name='parent-name']");
    private By parentAddress = By.xpath("//input[@name='parent-address']");
    private By parentCity = By.xpath("//input[@name='parent-city']");
    private By parentState = By.xpath("//select[@ng-model='wizard.report.parentState']");
    private By parentZip = By.xpath("//input[@name='parentZip']");
    private By parentTelephone = By.xpath("//input[@name='parentTelephone']");

    //Employer Information section
    private By subjectOccupation = By.xpath("//input[@name='occupation']");
    private By employerName = By.xpath("//input[@name='employer-name']");
    private By employerAddress = By.xpath("//input[@name='employer-address']");
    private By employerCity = By.xpath("//input[@name='employer-city']");
    private By employerState = By.xpath("//select[@ng-model='wizard.report.employerState']");
    private By employerZip = By.xpath("//input[@name='employer-zip']");
    private By employerTelephone = By.xpath("//input[@name='employerTelephone']");



    //###########################################################################################################
    public AddReport_IDinformation(WebDriver driver){
        this.driver=driver;
    }

    public void clickIDinformationPage(){

        WebElement element = driver.findElement(ID_InformationPage);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    //ID Information section
    public void  setSocialSecurity(String strSSN){driver.findElement(socialSecurity).sendKeys(strSSN);}
    public void  setDriverLicense(String strDriverLicense){driver.findElement(driverLicense).sendKeys(strDriverLicense);}
    public void  setState(String strState){driver.findElement(state).sendKeys(strState);}
    public void  setOtherIDNumber(String strOtherID){driver.findElement(otherIDNumber).sendKeys(strOtherID);}
    public void  setIDcountry(String strCountry){driver.findElement(iDcountry).sendKeys(strCountry);}
    public void  setStateTextField(String strState){driver.findElement(stateTextField ).sendKeys(strState);}
    public void  setOtherIDType (String strOtherIDType){driver.findElement(otherIDType).sendKeys(strOtherIDType);}

    // School Information section
    public void  setSchoolName(String strSchoolName){driver.findElement(schoolName).sendKeys(strSchoolName);}
    public void  setSchoolAddress(String strAddress){driver.findElement(schoolAddress).sendKeys(strAddress);}
    public void  setSchoolCity(String strCity){driver.findElement(schoolCity).sendKeys(strCity);}
    public void  setSchoolState(String strState){driver.findElement(schoolState).sendKeys(strState);}
    public void  setSchoolZip(String strState){driver.findElement(schoolZip).sendKeys(strState);}
    public void  setSchoolTelephone(String strTelephone){driver.findElement(schoolTelephone).sendKeys(strTelephone);}

    //Parent Information section
    public void  setParentName(String strName){driver.findElement(parentName).sendKeys(strName);}
    public void  setParentAddress(String strAddress){driver.findElement(parentAddress).sendKeys(strAddress);}
    public void  setParentCity(String strCity){driver.findElement(parentCity).sendKeys(strCity);}
    public void  setParentState(String strState){driver.findElement(parentState).sendKeys(strState);}
    public void  setParentZip(String strZip){driver.findElement(parentZip).sendKeys(strZip);}
    public void  setParentTelephone(String strTelephone){driver.findElement(parentTelephone).sendKeys(strTelephone);}

    //Employer Information section
    public void  setSubjectOccupation(String strOccupation){driver.findElement(subjectOccupation).sendKeys(strOccupation);}
    public void  setEmployerName(String strName){driver.findElement(employerName).sendKeys(strName);}
    public void  setEmployerAddress(String strAddress){driver.findElement(employerAddress).sendKeys(strAddress);}
    public void  setEmployerCity(String strCity){driver.findElement( employerCity).sendKeys(strCity);}
    public void  setEmployerState(String strState){driver.findElement(employerState).sendKeys(strState);}
    public void  setEmployerZip(String strZip){driver.findElement(employerZip).sendKeys(strZip);}
    public void  setEmployerTelephone(String strTelephone){driver.findElement(employerTelephone).sendKeys(strTelephone);}



}
