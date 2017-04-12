package pages;

//*Created By Em
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddReport_Subject {
    WebDriver driver;

    // Entity page
    By entityRadioButton = By.xpath("//div/label[@class='ng-binding']/input[@ng-model='wizard.report.key']");


    //###############################################################################################################################
    // Suspect Information page
    private By subjectInformationPage= By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[2]");
    private By caseIDRadio = By.xpath("//input[@name='caseNumber']");
    private By suspectTypeSelect = By.xpath("//select[@ng-model='wizard.report.suspectType']");
    private By lastNameText = By.xpath("//input[@name='lastName']");
    private By firstNameText = By.xpath("//input[@name='firstName']");
    private By middleNameText = By.xpath("//input[@name='middleName']");
    private By nickname_AKA = By.xpath("//input[@name='Nickname']");
    private By dateOfBirth = By.xpath("//input[@ng-model='wizard.report.dob']");
    private By age = By.xpath("//input[@name='Age']");
    private By sex = By.xpath("//select[@ng-model='wizard.report.sex']");
    private By race = By.xpath("//select[@ng-model='wizard.report.race']");
    private By height_ft = By.xpath("//input[@name='Height']");
    private By weight_lbs = By.xpath("//input[@name='Weight']");
    private By build = By.xpath("//select[@ng-model='wizard.report.build']");
    private By hairColor = By.xpath("//select[@ng-model='wizard.report.hairColor']");
    private By hairLength = By.xpath("//select[@ng-model='wizard.report.hairLength']");
    private By hairStyle = By.xpath("//select[@ng-model='wizard.report.hairStyle']");
    private By eyeColor = By.xpath("//select[@ng-model='wizard.report.eyeColor']");
    private By complexion = By.xpath("//select[@ng-model='wizard.report.complexion']");
    private By teeth = By.xpath("//select[@ng-model='wizard.report.teeth']");
    private By handPreference = By.xpath("//select[@ng-model='wizard.report.handPreference']");
    private By primaryLanguage = By.xpath("//input[@name='primary-language']");
    private By streetAddress = By.xpath("//input[@name='street-address']");
    private By subjectCountry = By.xpath("//select[@ng-model='wizard.report.country']");
    private By subjectCity = By.xpath("//input[@name='city']");
    private By subjectState = By.xpath("//div[@class='controls']/select[@ name='state']");
    private By subjectZip = By.xpath("//input[@name='zip']");
    private By subjectTelephone = By.xpath("//input[@name='phone']");
    private By subjectEmail = By.xpath("//input[@name='email']");
    private By subjectDriverRadio = By.xpath("//label[contains(.,' Driver')]");
    private By subjectPassenger = By.xpath("//label[contains(.,' Passenger')]");
    private By Pedestrian = By.xpath("//label[contains(.,' Pedestrian')]");
    private By addReportLink= By.xpath("//span[contains(.,'Add Report')]");

    public AddReport_Subject(WebDriver driver){
        this.driver=driver;
    }

    //###########################################################################################################
    public void clickAddReportLink(){        driver.findElement(addReportLink).click();    }
    public void chooseEntity (){        driver.findElement(entityRadioButton ).click();    }
    public void clickSubjectPage() {        driver.findElement(subjectInformationPage ).click();    }
    public void setCaseID (String strCaseID){        driver.findElement(caseIDRadio ).sendKeys(strCaseID);    }
    public void setSuspectTypeSelect (String strSubspectType){        driver.findElement(suspectTypeSelect ).sendKeys(strSubspectType);    }
    public void setLastNameText (String strLastname){        driver.findElement(lastNameText).sendKeys(strLastname);    }
    public void setFirstNameText (String strFirstname){        driver.findElement(firstNameText).sendKeys(strFirstname);    }
    public void setMiddleNameText (String strMiddlename){        driver.findElement(middleNameText).sendKeys(strMiddlename);    }
    public void setNickname_AKA (String strNickname){        driver.findElement(nickname_AKA).sendKeys(strNickname);    }
    public void setDateOfBirth (String strDate){
        driver.findElement(dateOfBirth).clear();
        driver.findElement(dateOfBirth).sendKeys(strDate);
    }
    public void setAge (String strAge){        driver.findElement(age).sendKeys(String.valueOf(strAge));    }
    public void setSex (String strSex){        driver.findElement(sex).sendKeys(strSex);    }
    public void setRace(String strRace){        driver.findElement(race).sendKeys(strRace);    }
    public void setHeight_ft(String heightinFT){
        driver.findElement(height_ft).clear();
        driver.findElement(height_ft).sendKeys(heightinFT);
    }
    public void setWeight_lbs(String weightinLbs){
        driver.findElement(weight_lbs).clear();
        driver.findElement(weight_lbs).sendKeys(weightinLbs);    }
    public void setBuild(String strBuild){        driver.findElement(build).sendKeys(strBuild);    }
    public void setHairColor(String strHairColor){        driver.findElement(hairColor).sendKeys(strHairColor);    }
    public void setHairLength(String strHairLenght){        driver.findElement(hairLength).sendKeys(strHairLenght);    }
    public void setHairStyle(String strHairStyle){        driver.findElement(hairStyle).sendKeys(strHairStyle);    }
    public void setEyeColor(String strEyeColor){        driver.findElement(eyeColor).sendKeys(strEyeColor);    }
    public void setComplexion(String strComplexion){        driver.findElement(complexion).sendKeys(strComplexion);    }
    public void setTeeth(String strTeeth){        driver.findElement(teeth).sendKeys(strTeeth);    }
    public void setHandPreference(String strHandPrefer){        driver.findElement(handPreference).sendKeys(strHandPrefer);    }
    public void setPrimaryLanguage(String strPrimaryLang){        driver.findElement(primaryLanguage).sendKeys(strPrimaryLang);    }
    public void setStreetAddress(String strStreetAddress){        driver.findElement(streetAddress).sendKeys(strStreetAddress);    }
    public void setSubjectCountry(String strCOuntry){        driver.findElement(subjectCountry).sendKeys(strCOuntry);    }
    public void setSubjectCity(String strCity){        driver.findElement(subjectCity).sendKeys(strCity);    }
    public void setSubjectState(String strState){

        driver.findElement(subjectState).sendKeys(strState);    }
    public void setSubjectZip(String strZip){        driver.findElement(subjectZip).sendKeys(strZip);    }
    public void setSubjectTelephone(String strTelephone){        driver.findElement(subjectTelephone).sendKeys(strTelephone);    }
    public void setSubjectEmail(String strEmail){        driver.findElement(subjectEmail).sendKeys(strEmail);    }

    //Radio button
    public void setSubjectDriverRadio (){        driver.findElement(subjectDriverRadio).click();    }
    public void clickSubjectPassenger(){        driver.findElement(subjectPassenger).click();    }
    public void setPedestrian(){        driver.findElement(Pedestrian).click();    }

















}
