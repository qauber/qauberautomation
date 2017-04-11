package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/15/2017.
 */
public class AddReport {

    WebDriver driver;

    public AddReport(WebDriver driver) {
        this.driver = driver;
    }

    By ReportBtn = By.xpath("//span[text()='Reports']");
    By clickAddReport = By.xpath("//span[text()='Add Report']");
    By clickEntity = By.xpath("//li[@class='col-md-1 ph0 active']");
    By clickFirstEntity = By.xpath("//label[text()='SVzfdsdg']");
    //click Identifier
    By clickIdentifier = By.xpath("//form/div[1]/div[2]/ol/li[3]");
    By tattoosCheckBox = By.xpath("//div[1]/div[1]/div/div/span/label/span");
    By xcarsCheckBox = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset/div[1]/div[2]/div/div/span/label/span");
    By needleMarkesCheckBox = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset/div[1]/div[3]/div/div/span/label/span");
    By tracksCheckBox = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset/div[1]/div[4]/div/div/span/label/span");
    By glassesCheckBox = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset/div[2]/div[1]/div/div/span/label/span");
    By mustacheCheckBox = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset/div[2]/div[2]/div/div/span/label/span");
    By bearedCheckBox = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset/div[2]/div[3]/div/div/span/label/span");
    By clickNexttoIDInformation = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/ul/li[2]/a");
    ///Subject Information
    By clickSubjectInformation = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/ol/li[2]");
    By clickCaseID = By.xpath("//fieldset/div[1]/div[1]/div/input");
    By clickLastName = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[3]/fieldset/div[2]/div[1]/div/div/input");
    By clickFirstName = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[3]/fieldset/div[2]/div[2]/div/div/input");
    By getClickNexttoIdentifier = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[3]/ul/li[2]/a");
    /////////Click on ID Information
    By clickIDInformation = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/ol/li[4]");
    By clickOnSocialSecurity = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[1]/div[1]/div[1]/form-group/div/input");
    By clickNexttoGangMemberShip = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/ul/li[2]/a");
    //////Gang MemberShip
    By clickGangMemberShip = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/ol/li[5]");
    By clickOnStopLocation = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[2]/div[2]/div/div/div/input");
    By clixktoNexttoVehicle = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/ul/li[2]/a");
    ////////Vehicle
    By clickonVehicle = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/ol/li[6]");
    By clickVehickLicence = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[7]/fieldset/div/div[1]/div[1]/div/div/input");
    /////Photos
    By clickOnPhotos = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/ol/li[7]");
    //////Preview
    By clickonPreview = By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/ol/li[8]");
    By clikToPublixhreport = By.xpath("//button[@ng-click='wizard.commitReport()']");
    By RadioBtn = By.xpath("//label/span[@class='fa fa-circle']");
    By ReportID = By.xpath("//div[1]/div/div[1]/div[3]/div");
    //////////////////////////////////////////////////
// first line of report page
    By ActualReportInfo = By.xpath("//tr[1]//div[@ class='col-lg-12']");
    By ReportText = By.xpath("//tbody/tr[1]/td/div/div/div[1]/div/h4");

    public WebElement ReportBtn() {
        return driver.findElement(ReportBtn);
    }

    public WebElement ReportText() {
        return driver.findElement(ReportText);
    }

    public WebElement ActualReportInfo() {
        return driver.findElement(ActualReportInfo);
    }

    public WebElement ReportID() {
        return driver.findElement(ReportID);
    }

    public WebElement RadioBtn() {
        return driver.findElement(RadioBtn);
    }

    public WebElement clickVehickLicence() {
        return driver.findElement(clickVehickLicence);
    }

    public WebElement clikToPublixhreport() {
        return driver.findElement(clikToPublixhreport);
    }

    public WebElement clickonPreview() {
        return driver.findElement(clickonPreview);
    }

    public WebElement clickOnPhotos() {
        return driver.findElement(clickOnPhotos);
    }

    public WebElement clickonVehicle() {
        return driver.findElement(clickonVehicle);
    }

    public WebElement clixktoNexttoVehicle() {
        return driver.findElement(clixktoNexttoVehicle);
    }

    public WebElement clickOnStopLocation() {
        return driver.findElement(clickOnStopLocation);
    }

    public WebElement clickGangMemberShip() {
        return driver.findElement(clickGangMemberShip);
    }

    public WebElement clickNexttoGangMemberShip() {
        return driver.findElement(clickNexttoGangMemberShip);
    }

    public WebElement clickOnSocialSecurity() {
        return driver.findElement(clickOnSocialSecurity);
    }

    public WebElement clickIDInformation() {
        return driver.findElement(clickIDInformation);
    }

    public WebElement getClickNexttoIdentifier() {
        return driver.findElement(getClickNexttoIdentifier);
    }

    public WebElement clickFirstName() {
        return driver.findElement(clickFirstName);
    }

    public WebElement clickLastName() {
        return driver.findElement(clickLastName);
    }

    public WebElement clickCaseID() {
        return driver.findElement(clickCaseID);
    }

    public WebElement clickSubjectInformation() {
        return driver.findElement(clickSubjectInformation);
    }

    public WebElement clickNexttoIDInformation() {
        return driver.findElement(clickNexttoIDInformation);
    }

    public WebElement bearedCheckBox() {
        return driver.findElement(bearedCheckBox);
    }

    public WebElement mustacheCheckBox() {
        return driver.findElement(mustacheCheckBox);
    }

    public WebElement glassesCheckBox() {
        return driver.findElement(glassesCheckBox);
    }

    public WebElement tracksCheckBox() {
        return driver.findElement(tracksCheckBox);
    }

    public WebElement needleMarkesCheckBox() {
        return driver.findElement(needleMarkesCheckBox);
    }

    public WebElement xcarsCheckBox() {
        return driver.findElement(xcarsCheckBox);
    }

    public WebElement tattoosCheckBox() {
        return driver.findElement(tattoosCheckBox);
    }

    public WebElement clickIdentifier() {
        return driver.findElement(clickIdentifier);
    }

    public WebElement clickFirstEntity() {
        return driver.findElement(clickFirstEntity);
    }

    public WebElement clickAddReport() {
        return driver.findElement(clickAddReport);
    }

    public WebElement clickEntity() {
        return driver.findElement(clickEntity);
    }


}
