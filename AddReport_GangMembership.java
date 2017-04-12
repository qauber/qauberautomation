package pages;


//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReport_GangMembership {
    WebDriver driver;
//Gang Membership page

    private By distributionPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[5]");

    private By gangUnitCheckbox = By.xpath("//label[contains(.,'Gang Unit')]");
    private By sexCrimesCheckbox = By.xpath("//label[contains(.,'Sex Crimes')]");
    private By robberyCheckbox = By.xpath("//label[contains(.,'Robbery')]");
    private By narcoCheckbox = By.xpath("//input[@ng-model='wizard.report.narco']");
    private By viceIntelCheckbox = By.xpath("//label[contains(.,'Vice / Intel')]");
    private By otherDistributionCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.other']");
    private By otherDistributionTextField = By.xpath("//input[@name='otherDistribution']");


    //Stop Information section
    private By reasonForStop = By.xpath("//input[@name='reasonForStop']");
    private By locationOfStop = By.xpath("//input[@name='locationOfStop']");
    private By dispositionOfStop = By.xpath("//input[@name='dispositionOfStop']");

    // Gang Membership Criteria section
    private By gangName = By.xpath("//input[@name='gang-name']");
    private By howLong = By.xpath("//input[@name='howLong']");

    //Select a minimum of two from below to validate section
    private By selfAdmission = By.xpath("//div[1][@ class='col-md-4']//input[@ng-model='wizard.report.selfAdmission']");
    private By frequentingGangArea = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.frequentingGangArea']");
    private By displayingHandSymbolsOrSigns = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.displayingGangSigns']");
    private By gangMemberByReliableInformant = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.byReliableInformant']");
    private By gangTattoos = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.gangTattoos']");
    private By gangClothing = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.gangClothing']");
    private By affiliatingWithGangMembers = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.affiliatingWithGangMembers']");
    private By participatingInGangCrime = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.participatingInGangCrime']");
    private By gangRegistrant = By.xpath("//label[@class='needsclick']/input[@ng-model='wizard.report.gangRegistrant']");

    // Parole / Probation Status section
    private By onParole = By.xpath("//label[contains(.,'On Parole')]");
    private By paroleOfficer= By.xpath("//input[@name='paroleOfficer']");
    private By paroleOfficerPhone= By.xpath("//input[@name='paroleOfficerPhone']");
    private By onProbation = By.xpath("//label[contains(.,'On Probation')]");
    private By probationOfficer=By.xpath("//input[@name='probation-officer']");
    private By probationOfficerPhone=By.xpath("//input[@name='probationOfficerPhone']");

    //Other Information section
    private By otherInformation = By.xpath("//textarea[@name='other-information']");
    private By officerName = By.xpath("//input[@name='officerName']");
    private By officerID = By.xpath("//input[@name='officerID']");
    private By beat = By.xpath("//input[@name='beat']");

    //###########################################################################################################

    public AddReport_GangMembership(WebDriver driver){
        this.driver=driver;
    }
    public void  clickGangMembershipPage(){

        WebElement element = driver.findElement(distributionPage);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickGangUnitCheckbox(){

        WebElement element = driver.findElement(gangUnitCheckbox);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickSexCrimesCheckbox(){

        WebElement element = driver.findElement(sexCrimesCheckbox);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickRobberyCheckbox (){

        WebElement element = driver.findElement(robberyCheckbox );
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickNarcoCheckbox(){

        WebElement element = driver.findElement(narcoCheckbox);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickViceIntelCheckbox(){

        WebElement element = driver.findElement(viceIntelCheckbox);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickOtherDistributionCheckbox(){

        WebElement element = driver.findElement(otherDistributionCheckbox);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  setOtherDistributionTextField(String strOtherDistribution) {driver.findElement(otherDistributionTextField ).sendKeys(strOtherDistribution);}

    //Stop Information section
    public void  setReasonForStop(String strReason){driver.findElement(reasonForStop).sendKeys( strReason);}
    public void  setLocationOfStop2(String strLocation){driver.findElement(locationOfStop).sendKeys(strLocation);}
    public void  setDispositionOfStop(String strDipostion){driver.findElement(dispositionOfStop).sendKeys(strDipostion);}

    // Gang Membership Criteria section
    public void  setGangName(String strGangName){driver.findElement(gangName).sendKeys(strGangName);}
    public void  setHowLong(String strHowLong){driver.findElement( howLong).sendKeys(strHowLong);}

    //Select a minimum of two from below to validate section
    public void  clickSelfAdmission(){
        WebElement element = driver.findElement(selfAdmission);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickFrequentingGangArea(){
        WebElement element = driver.findElement(frequentingGangArea);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickDisplayingHandSymbolsOrSigns(){

        WebElement element = driver.findElement(displayingHandSymbolsOrSigns);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickGangMemberByReliableInformant(){

        WebElement element = driver.findElement(gangMemberByReliableInformant);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);}

    public void  clickGangTattoos (){
        WebElement element=driver.findElement(gangTattoos );
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);}

    public void  clickGangClothing(){

        WebElement element=driver.findElement(gangClothing);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickAffiliatingWithGangMembers(){

        WebElement element=driver.findElement(affiliatingWithGangMembers);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickParticipatingInGangCrime(){

        WebElement element=driver.findElement(participatingInGangCrime);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  clickGangRegistrant(){
        WebElement element=driver.findElement(gangRegistrant);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

    // Parole / Probation Status section
    public void  clickOnParole(){driver.findElement(onParole).click();}
    public void  setOnParoleOfficerName(String strName){driver.findElement(paroleOfficer).sendKeys(strName);}
    public void  setOnParoleOfficerPhone(String strPhone){driver.findElement( paroleOfficerPhone).sendKeys(strPhone);}
    public void  clickOnProbation(){driver.findElement(onProbation).click();}
    public void  setOnProbationOfficerName(String strName){driver.findElement(probationOfficer).sendKeys(strName);}
    public void  setOnProbationOfficerPhone(String strPhone){driver.findElement( probationOfficerPhone).sendKeys(strPhone);}


    //Other Information section
    public void  setOtherInformation(String strOtherInfo){driver.findElement(otherInformation).sendKeys(strOtherInfo);}
    public void  getOfficerName(){driver.findElement(officerName).getAttribute("value");}
    public void  setOfficerID(String strID){driver.findElement(officerID).sendKeys(strID);}
    public void  setBeat(String strBeat){driver.findElement(beat).sendKeys(strBeat);}

}
