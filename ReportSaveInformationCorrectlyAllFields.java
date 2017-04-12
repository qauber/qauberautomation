package pagestest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;


/** *Created By Em
Verify all information from every fields that entered in report is shown on View report
Preconditions
1) SA account created
2) At least one Entity created and subscribed
3) At least one report created
Steps
1) Login with valid SA credentials on http://testwave.qabidder.net/
2) Click "Add Reports" in Main Navigation menu
3) Fill up all information
4) Click on "Preview" tab
5) Click on "Publish Report"
6) Click on "Report" in Main Navigation menu
7) Click "View" button of the created report
8) Verify if entered information are shown in the View report page

Expected Result
Fields names in 'Add report' matches fields name in View report.
 */

public class ReportSaveInformationCorrectlyAllFields {


    public WebDriver driver;
    public PageResources pageResources;

    // Array subject stores attribute value on each element when user entered data in the Adding report subject page
    public String[] subject = new String[29];
    public String [] identifiers = new String[14];
    public String [] idInformation= new String[26];
    public String [] gangMember= new String[31];
    public String [] vehicle = new String[8];
    public  String[] addPhoto = new String[1];
   // public String [] reportText = new String[107];

    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        // Login as super admin

        pageResources.getLoginPage().loginToWave("testingqauber@gmail.com", "testingqauber");

         Thread.sleep(8000);
       pageResources.getAddReportSubject().clickAddReportLink();
       Thread.sleep(4000);
    }
    // Random string generator
    public String generateRandomNameString() {
        return  new BigInteger(16, new SecureRandom()).toString(64);
    }


 @Test(dataProvider = "AddSubjectInformation", dataProviderClass = Data_Provider.class, priority = 1)
    public void AddSubjectInfo(String strCaseID, String strSuspectType, String strLastName, String strFirstName, String strMiddleName,String strNickName,
                               String strDateOfBirth,String Age, String strSex,String strRace,String heightFT,String weightLB,String strBuild,String strHairColor,
                               String strHairLength,String strHairStyle, String strEyeColor,String strComplexion, String strTeeth,String strHandPreference,
                               String strPrimaryLang, String strAddress,String strCountry, String strCity, String strState, String strZip, String strTel, String strEmail )
            throws InterruptedException {


        // Input all information for all fields into  the subject information page

        pageResources.getAddReportSubject().chooseEntity();
     // subject[0]=driver.findElement(By.xpath("//div/label[@class='ng-binding']/input[@ng-model='wizard.report.key']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().clickSubjectPage();
       Thread.sleep(8000);
        pageResources.getAddReportSubject().setCaseID(strCaseID+generateRandomNameString());
        subject[0]=driver.findElement(By.xpath("//input[@name='caseNumber']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSuspectTypeSelect(strSuspectType);
        subject[1]= driver.findElement(By.xpath ("//select[@ng-model='wizard.report.suspectType']")).getAttribute("value");
       Thread.sleep(3000);
       pageResources.getAddReportSubject().setLastNameText(strLastName);
      subject[2]=driver.findElement(By.xpath ("//input[@name='lastName']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setFirstNameText( strFirstName);
      subject[3]=driver.findElement(By.xpath ("//input[@name='firstName']")).getAttribute("value");
       Thread.sleep(3000);

        pageResources.getAddReportSubject().setMiddleNameText(strMiddleName);
      subject[4]=driver.findElement(By.xpath ("//input[@name='middleName']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setNickname_AKA(strNickName);
      subject[5]=driver.findElement(By.xpath ("//input[@name='Nickname']")).getAttribute("value");
       Thread.sleep(3000);

        pageResources.getAddReportSubject().setDateOfBirth(strDateOfBirth );
      subject[6]=driver.findElement(By.xpath ("//input[@ng-model='wizard.report.dob']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setAge(Age);
      subject[7]=driver.findElement(By.xpath ("//input[@name='Age']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSex(strSex);
      subject[8]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.sex']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setRace(strRace);
      subject[9]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.race']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setHeight_ft(heightFT);
      subject[10]=driver.findElement(By.xpath ("//input[@name='Height']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setWeight_lbs(weightLB);
      subject[11]=driver.findElement(By.xpath ("//input[@name='Weight']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setBuild(strBuild);
      subject[12]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.build']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setHairColor(strHairColor);
      subject[13]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.hairColor']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setHairLength(strHairLength);
      subject[14]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.hairLength']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setHairStyle(strHairStyle);
      subject[15]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.hairStyle']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setEyeColor(strEyeColor);
      subject[16]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.eyeColor']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setComplexion(strComplexion);
      subject[17]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.complexion']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setTeeth(strTeeth);
      subject[18]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.teeth']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setHandPreference(strHandPreference);
      subject[19]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.handPreference']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setPrimaryLanguage(strPrimaryLang);
      subject[20]=driver.findElement(By.xpath ("//input[@name='primary-language']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setStreetAddress(strAddress);
      subject[21]=driver.findElement(By.xpath ("//input[@name='street-address']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSubjectCountry(strCountry);
      subject[22]=driver.findElement(By.xpath ("//select[@ng-model='wizard.report.country']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSubjectCity(strCity);
      subject[23]=driver.findElement(By.xpath ("//input[@name='city']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSubjectState(strState);
      subject[24]=driver.findElement(By.xpath ("//div[@class='controls']/select[@ name='state']")).getAttribute("value");
       Thread.sleep(5000);
        pageResources.getAddReportSubject().setSubjectZip(strZip);
      subject[25]=driver.findElement(By.xpath ("//input[@name='zip']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSubjectTelephone(strTel);
      subject[26]=driver.findElement(By.xpath ("//input[@name='phone']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().setSubjectEmail(strEmail);
      subject[27]=driver.findElement(By.xpath ("//input[@name='email']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportSubject().clickSubjectPassenger();
      subject[28]=driver.findElement(By.xpath ("//label[contains(.,' Pedestrian')]")).getText();
       Thread.sleep(3000);


    }
    @Test(dataProvider = "AddIdentifiers", dataProviderClass = Data_Provider.class, priority = 2)
    public void AddIdentifiersInfo(String strTattoo, String strScar, String strNeedleMark, String strTrack,String strGlasses,
     String strMustache,String strBeard ) throws Exception {

        pageResources.getAddReportIdentifiers().clickOnIdentifiersPage();
        Thread.sleep(5000);
        pageResources.getAddReportIdentifiers().setTattooCheckbox();
        identifiers[0]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.tattoos']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setTattooTextField( strTattoo);
        identifiers[1]=driver.findElement(By.xpath("//input[@name='Tattoos']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setScarCheckbox();
        identifiers[2]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.scars']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setScarTextField( strScar);
        identifiers[3]=driver.findElement(By.xpath("//input[@name='Scars']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setNeedleMarksCheckbox();
        identifiers[4]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.needleMarks']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setNeedleTextField(strNeedleMark);
        identifiers[5]=driver.findElement(By.xpath("//input[@name='needleMarks']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setTracksCheckbox();
        identifiers[6]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.tracks']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setTracksTextField(strTrack);
        identifiers[7]=driver.findElement(By.xpath("//input[@name='Tracks']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setGlassesCheckbox();
        identifiers[8]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.glasses']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setGlassesTextField(strGlasses);
        identifiers[9]=driver.findElement(By.xpath("//input[@name='Glasses']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setMustacheCheckbox();
        identifiers[10]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.mustache']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setMustacheTextField(strMustache);
        identifiers[11]=driver.findElement(By.xpath("//input[@name='Mustache']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setBeardCheckbox();
        identifiers[12]=driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.beard']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportIdentifiers().setBeardTextField(strBeard);
        identifiers[13]=driver.findElement(By.xpath("//input[@name='Beard']")).getAttribute("value");
        Thread.sleep(3000);

    }
    @Test(dataProvider = "AddReportIDInformation", dataProviderClass = Data_Provider.class, priority = 3)
    public void AddIDInfo(String strSSN, String strDrivingLicense, String strState, String strOtherIDNumber,String strIDcountry,String strOtherState,String strOtherIDType,
                          String strSchoolName,String strSchoolAddress,String strSchoolCity,String strSchoolState,String strSchoolZip,String strSchoolTelephone,
                          String strParentName,String strParentAddress, String strParentCity,String strParentState, String strParentZip,String strParentTelephone,
                          String strOccupation, String strEmployerName,String strEmployerAddress, String strEmployerCity,String strEmployerState,  String strEmployerZip, String strEmployerTel )
            throws Exception {


        //ID Information section
        pageResources.getAddReportIDinformation().clickIDinformationPage();
        Thread.sleep(8000);
        pageResources.getAddReportIDinformation().setSocialSecurity(strSSN);
        idInformation[0]=driver.findElement(By.xpath("//input[@name='socialSecurity']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setDriverLicense(strDrivingLicense);
        idInformation[1]=driver.findElement(By.xpath("//input[@name='driverLicense']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setState(strState);
        idInformation[2]=driver.findElement(By.xpath("//select[@ng-model='wizard.report.dlState']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setOtherIDNumber(strOtherIDNumber);
        idInformation[3]=driver.findElement(By.xpath("//input[@name='other-id']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setIDcountry(strIDcountry);
        idInformation[4]=driver.findElement(By.xpath("//select[@name='otherIdCountry']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setStateTextField(strOtherState);
        idInformation[5]=driver.findElement(By.xpath("//input[@name='otherIdState']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setOtherIDType(strOtherIDType);
        idInformation[6]=driver.findElement(By.xpath("//input[@name='other-id-type']")).getAttribute("value");
        Thread.sleep(3000);
        // School Information section
        pageResources.getAddReportIDinformation().setSchoolName(strSchoolName);
        idInformation[7]=driver.findElement(By.xpath("//input[@name='school-name']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setSchoolAddress(strSchoolAddress);
        idInformation[8]=driver.findElement(By.xpath("//input[@name='school-address']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setSchoolCity(strSchoolCity);
        idInformation[9]=driver.findElement(By.xpath("//input[@name='school-city']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setSchoolState(strSchoolState);
        idInformation[10]=driver.findElement(By.xpath("//select[@ng-model='wizard.report.schoolState']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setSchoolZip(strSchoolZip);
        idInformation[11]=driver.findElement(By.xpath("//input[@name='school-zip']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setSchoolTelephone(strSchoolTelephone);
        idInformation[12]=driver.findElement(By.xpath("//input[@name='schoolTelephone']")).getAttribute("value");
        Thread.sleep(3000);
        //Parent Information section
        pageResources.getAddReportIDinformation().setParentName(strParentName);
        idInformation[13]=driver.findElement(By.xpath("//input[@name='parent-name']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setParentAddress(strParentAddress);
        idInformation[14]=driver.findElement(By.xpath("//input[@name='parent-address']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setParentCity(strParentCity);
        idInformation[15]=driver.findElement(By.xpath("//input[@name='parent-city']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setParentState(strParentState);
        idInformation[16]=driver.findElement(By.xpath("//select[@ng-model='wizard.report.parentState']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setParentZip(strParentZip);
        idInformation[17]=driver.findElement(By.xpath("//input[@name='parentZip']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setParentTelephone(strParentTelephone);
        idInformation[18]=driver.findElement(By.xpath("//input[@name='parentTelephone']")).getAttribute("value");
        Thread.sleep(3000);
        //Employer Information section
        pageResources.getAddReportIDinformation().setSubjectOccupation(strOccupation);
        idInformation[19]=driver.findElement(By.xpath("//input[@name='occupation']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setEmployerName(strEmployerName);
        idInformation[20]=driver.findElement(By.xpath("//input[@name='employer-name']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setEmployerAddress(strEmployerAddress);
        idInformation[21]=driver.findElement(By.xpath("//input[@name='employer-address']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setEmployerCity(strEmployerCity);
        idInformation[22]=driver.findElement(By.xpath("//input[@name='employer-city']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setEmployerState(strEmployerState);
        idInformation[23]=driver.findElement(By.xpath("//select[@ng-model='wizard.report.employerState']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setEmployerZip(strEmployerZip);
        idInformation[24]=driver.findElement(By.xpath("//input[@name='employer-zip']")).getAttribute("value");
        Thread.sleep(3000);
        pageResources.getAddReportIDinformation().setEmployerTelephone(strEmployerTel);
        idInformation[25]=driver.findElement(By.xpath("//input[@name='employerTelephone']")).getAttribute("value");
        Thread.sleep(3000);


    }

    //Gang Membership Page
   @Test(dataProvider = "AddGangMembershipInfo", dataProviderClass = Data_Provider.class, priority = 4)
    public void AddGangMemberInfo(String strOtherDistribution, String strReasonToStop, String strSLocationOfStop, String strDispositionOfStop,String strGangName,String strHowLong,String strParoleOfficerName,
     String strParoleOfficerPhone,String strProbationOfficerName,String strProbationOfficerPhone,String strOtherInformation,String strOfficerID, String strBeat
                          ) throws Exception {

        // GangMembership section

        pageResources.getAddReportGangMembership().clickGangMembershipPage();
        Thread.sleep(8000);
        pageResources.getAddReportGangMembership().clickGangUnitCheckbox();
        gangMember[0]= driver.findElement(By.xpath("//label[contains(.,'Gang Unit')]")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportGangMembership().clickSexCrimesCheckbox();
       gangMember[1]= driver.findElement(By.xpath("//label[contains(.,'Sex Crimes')]")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportGangMembership().clickRobberyCheckbox();
       gangMember[2]= driver.findElement(By.xpath("//label[contains(.,'Robbery')]")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportGangMembership().clickNarcoCheckbox();
       gangMember[3]= driver.findElement(By.xpath("//input[@ng-model='wizard.report.narco']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportGangMembership().clickViceIntelCheckbox();
       gangMember[4]= driver.findElement(By.xpath("//label[contains(.,'Vice / Intel')]")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportGangMembership().clickOtherDistributionCheckbox();
       gangMember[5]= driver.findElement(By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.other']")).getText();
        Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setOtherDistributionTextField(strOtherDistribution);
       gangMember[6]= driver.findElement(By.xpath("//input[@name='otherDistribution']")).getAttribute("value");
        Thread.sleep(3000);

        //Stop Information section
        pageResources.getAddReportGangMembership().setReasonForStop(strReasonToStop);
       gangMember[7]= driver.findElement(By.xpath("//input[@name='reasonForStop']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setLocationOfStop2(strSLocationOfStop);
       gangMember[8]= driver.findElement(By.xpath("//input[@name='locationOfStop']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setDispositionOfStop(strDispositionOfStop);
       gangMember[9]= driver.findElement(By.xpath("//input[@name='dispositionOfStop']")).getAttribute("value");
       Thread.sleep(3000);
        //Gang Membership Criteria section
        pageResources.getAddReportGangMembership().setGangName(strGangName);
       gangMember[10]= driver.findElement(By.xpath("//input[@name='gang-name']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setHowLong(strHowLong);
       gangMember[11]= driver.findElement(By.xpath("//input[@name='howLong']")).getAttribute("value");
       Thread.sleep(3000);

        //Select a minimum of two from below to validate section
        pageResources.getAddReportGangMembership().clickSelfAdmission();
       WebElement selfAdmission=driver.findElement(By.xpath("//div[1][@ class='col-md-4']//input[@ng-model='wizard.report.selfAdmission']"));
        if(selfAdmission.isSelected()){ gangMember[12]= "self Admission";}
       Thread.sleep(4000);

        pageResources.getAddReportGangMembership().clickFrequentingGangArea();
        WebElement FrequentingGangArea = driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.frequentingGangArea']"));
       if(FrequentingGangArea.isSelected()){gangMember[13]="Frequenting Gang Area";}
       Thread.sleep(5000);

        pageResources.getAddReportGangMembership().clickDisplayingHandSymbolsOrSigns();
        WebElement DisplayingHandSymbolsOrSigns= driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.displayingGangSigns']"));
       if(DisplayingHandSymbolsOrSigns.isSelected()){gangMember[14]= "Displaying Hand Symbols Or Signs";}
       Thread.sleep(5000);

        pageResources.getAddReportGangMembership().clickGangMemberByReliableInformant();
       WebElement byReliableInformant = driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.byReliableInformant']"));
       if(byReliableInformant.isSelected()){gangMember[15]= "Gang Member By Reliable Informant";}

       pageResources.getAddReportGangMembership().clickGangTattoos();
       WebElement GangTattoos = driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.gangTattoos']"));
       if(GangTattoos.isSelected()){gangMember[16]= "Gang Tattoos";}
        Thread.sleep(4000);


        pageResources.getAddReportGangMembership().clickGangClothing();
       WebElement GangClothing= driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.gangClothing']"));
       if(GangClothing.isSelected()){gangMember[17]= "Gang Clothing";}
       Thread.sleep(4000);

        pageResources.getAddReportGangMembership().clickAffiliatingWithGangMembers();
       WebElement AffiliatingWithGangMembers = driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.affiliatingWithGangMembers']"));
       if( AffiliatingWithGangMembers.isSelected()){gangMember[18]= "Affiliating With Gang Members";}

       Thread.sleep(4000);
       pageResources.getAddReportGangMembership().clickParticipatingInGangCrime();
       WebElement ParticipatingInGangCrime= driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.participatingInGangCrime']"));
       if( ParticipatingInGangCrime.isSelected()){gangMember[19]= "Participating In Gang Crime";}

       Thread.sleep(4000);
        pageResources.getAddReportGangMembership().clickGangRegistrant();
       WebElement GangRegistrant= driver.findElement(By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.gangRegistrant']"));
       if( ParticipatingInGangCrime.isSelected()){gangMember[20]= "Gang Registrant";}
       Thread.sleep(4000);

        // Parole / Probation Status section
        pageResources.getAddReportGangMembership().clickOnParole();
       gangMember[21]= driver.findElement(By.xpath("//label[contains(.,'On Parole')]")).getText();
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setOnParoleOfficerName(strParoleOfficerName);
       gangMember[22]= driver.findElement(By.xpath("//input[@name='paroleOfficer']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setOnParoleOfficerPhone(strParoleOfficerPhone);
       gangMember[23]= driver.findElement(By.xpath("//input[@name='paroleOfficerPhone']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().clickOnProbation();
       gangMember[24]= driver.findElement(By.xpath("//label[contains(.,'On Probation')]")).getText();
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setOnProbationOfficerName(strProbationOfficerName);
       gangMember[25]= driver.findElement(By.xpath("//input[@name='probation-officer']")).getAttribute("value");
       Thread.sleep(3000);
        pageResources.getAddReportGangMembership().setOnProbationOfficerPhone(strProbationOfficerPhone);
       gangMember[26]= driver.findElement(By.xpath("//input[@name='probationOfficerPhone']")).getAttribute("value");
       Thread.sleep(3000);

        //Other Information section
        pageResources.getAddReportGangMembership().setOtherInformation(strOtherInformation);
       gangMember[27]= driver.findElement(By.xpath("//textarea[@name='other-information']")).getAttribute("value");
       Thread.sleep(3000);

       gangMember[28]= driver.findElement(By.xpath("//input[@placeholder='Officer Name']")).getAttribute("value");
       Thread.sleep(3000);

        pageResources.getAddReportGangMembership().setOfficerID(strOfficerID);
       gangMember[29]=driver.findElement(By.xpath("//input[@name='officerID']")).getAttribute("value");
       Thread.sleep(3000);

       pageResources.getAddReportGangMembership().getOfficerName();
       Thread.sleep(3000);
       //Attribute for Offer name

        pageResources.getAddReportGangMembership().setBeat(strBeat);
       gangMember[30]= driver.findElement(By.xpath("//input[@name='beat']")).getAttribute("value");
       Thread.sleep(3000);

    }

     //Vehicle Page
     @Test(dataProvider = "AddVehicleInfo", dataProviderClass = Data_Provider.class, priority = 5)
     public void AddVehicleInfo(String strVehicleLicense, String strVehicleMake, String strVehicleModel,
      String strVehicleBodyStyle,String VehicleYear,String strVehicleColor,String strVehicleState, String strVehicleOddities) throws Exception {

         pageResources.getAddReportVehicle().clickVehiclePage();
         Thread.sleep(8000);
         pageResources.getAddReportVehicle().setVehicleLicense(strVehicleLicense);
         vehicle[0]=driver.findElement(By.xpath("//input[@name='vehicleLicense']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleMake(strVehicleMake);
         vehicle[1]=driver.findElement(By.xpath("//input[@name='vehicleMake']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleModel(strVehicleModel);
         vehicle[2]=driver.findElement(By.xpath("//input[@name='vehicleModel']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleBodyStyle(strVehicleBodyStyle);
         vehicle[3]=driver.findElement(By.xpath("//input[@name='vehicleBodystyle']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleYear(VehicleYear);
         vehicle[4]=driver.findElement(By.xpath("//input[@name='vehicleYear']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleColor(strVehicleColor);
         vehicle[5]=driver.findElement(By.xpath("//input[@name='vehicleColor']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleState(strVehicleState);
         vehicle[6]=driver.findElement(By.xpath("//select[@ng-model='wizard.report.vehicleState']")).getAttribute("value");
         Thread.sleep(3000);
         pageResources.getAddReportVehicle().setVehicleOddities(strVehicleOddities);
         vehicle[7]=driver.findElement(By.xpath("//input[@name='vehicleOddities']")).getAttribute("value");
         Thread.sleep(3000);

     }

     //Add Photo Page
    @Test(priority = 6)
     public void AddPhoto() throws Exception {
        String outputFolder = System.getProperty("user.home") + File.separator  ;
      String PictureFilePath= outputFolder+"IdeaProjects\\Santiy_WaveFits\\Suspect.JPG";


         pageResources.getAddReportAddPhoto().clickPhotosPage();
         Thread.sleep(8000);
         pageResources.getAddReportAddPhoto().clickAddPhotoButton();

         //put path to your image in a clipboard
         StringSelection ss = new StringSelection(PictureFilePath);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

         //imitate mouse events like ENTER, CTRL+C, CTRL+V
         Robot robot = new Robot();
         robot.delay(250);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.delay(50);
         robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(50);
        addPhoto[0]=driver.findElement(By.xpath("//li[@ ng-repeat='photo in picker.photos']//span[@class='ng-binding']")).getText();
        Thread.sleep(5000);
        System.out.print(addPhoto[0]);
     }
    @Test(priority = 7)
    public void PreviewAndPublishReport() throws Exception {
        pageResources.getAddReportPreviewPublishReport().clickReportPreview();
        Thread.sleep(5000);
      pageResources.getAddReportPreviewPublishReport().clickPublishReport();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);

    }


    @Test(priority = 8)
    public void ReportValidating() throws Exception {


        driver.findElement(By.xpath("//a[@title='View']")).click();
        Thread.sleep(5000);
       String report= driver.findElement(By.tagName("body")).getText();
        Boolean checkStatus= false;
       for (int i= 0; i<29 ; i++) {
           if (report.contains(subject[i]))
               checkStatus= true;
               try {
                   Assert.assertTrue(checkStatus == true);
                   System.out.println("Found " + subject[i] + " in the View report text");


               } catch (Throwable t) {
                   Assert.fail("Could not find " + subject[i] + " in the View report text");


               }

       }
        for (int i= 0; i<14 ; i++) {
            if (report.contains(identifiers[i]))
                checkStatus= true;
            try {
                Assert.assertTrue(checkStatus == true);
                System.out.println("Found " + identifiers[i] + " in the View report text");


            } catch (Throwable t) {
                Assert.fail("Could not find " + identifiers[i] + " in the View report text");


            }

        }




        for (int i= 0; i<26 ; i++) {
            if (report.contains(idInformation[i]))
                checkStatus= true;
            try {
                Assert.assertTrue(checkStatus == true);
                System.out.println("Found " + idInformation[i] + " in the View report text");


            } catch (Throwable t) {
                Assert.fail("Could not find " + idInformation[i] + " in the View report text");


            }

        }



        for (int i= 0; i<31 ; i++) {
            if (report.contains(gangMember[i]))
                checkStatus= true;
            try {
                Assert.assertTrue(checkStatus == true);
                System.out.println("Found " + gangMember[i] + " in the View report text");


            } catch (Throwable t) {
                Assert.fail("Could not find " + gangMember[i] + " in the View report text");


            }

        }


        for (int i= 0; i<8 ; i++) {
            if (report.contains(vehicle[i]))
                checkStatus= true;
            try {
                Assert.assertTrue(checkStatus == true);
                System.out.println("Found " + vehicle[i] + " in the View report text");


            } catch (Throwable t) {
                Assert.fail("Could not find " + vehicle[i] + " in the View report text");


            }

        }

        for (int i= 0; i<1 ; i++) {
            if (report.contains(addPhoto[i]))
                checkStatus= true;
            try {
                Assert.assertTrue(checkStatus == true);
                System.out.println("Found " + addPhoto[i] + " in the View report text");


            } catch (Throwable t) {
                Assert.fail("Could not find " + addPhoto[i] + " in the View report text");


            }

        }

       driver.close();

    }


     }


