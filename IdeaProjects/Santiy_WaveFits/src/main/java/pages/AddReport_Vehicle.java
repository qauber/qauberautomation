package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReport_Vehicle {
    WebDriver driver;
   //Vehicle page

    private By vehiclePage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[6]");
    private By vehicleLicense = By.xpath("//input[@name='vehicleLicense']");
    private By vehicleMake = By.xpath("//input[@name='vehicleMake']");
    private By vehicleModel = By.xpath("//input[@name='vehicleModel']");
    private By vehicleBodyStyle = By.xpath("//input[@name='vehicleBodystyle']");
    private By vehicleYear = By.xpath("//input[@name='vehicleYear']");
    private By vehicleColor = By.xpath("//input[@name='vehicleColor']");
    private By vehicleState = By.xpath("//select[@ng-model='wizard.report.vehicleState']");
    private By vehicleOddities = By.xpath("//input[@name='vehicleOddities']");

    //###########################################################################################################
    public AddReport_Vehicle(WebDriver driver){
        this.driver=driver;
    }
    public void  clickVehiclePage(){

        WebElement element = driver.findElement(vehiclePage);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void  setVehicleLicense(String strLicense){driver.findElement(vehicleLicense).sendKeys(strLicense);}
    public void  setVehicleMake(String strMake){driver.findElement(vehicleMake).sendKeys(strMake);}
    public void  setVehicleModel(String strModel){driver.findElement(vehicleModel).sendKeys(strModel);}
    public void  setVehicleBodyStyle(String strBodyStyle){
        driver.findElement(vehicleBodyStyle).clear();
        driver.findElement(vehicleBodyStyle).sendKeys(strBodyStyle);}
    public void  setVehicleYear(String Year){
        driver.findElement(vehicleYear).clear();
        driver.findElement(vehicleYear).sendKeys(Year);}
    public void  setVehicleColor(String strColor){driver.findElement(vehicleColor).sendKeys(strColor);}
    public void  setVehicleState(String strState){driver.findElement(vehicleState).sendKeys(strState);}
    public void  setVehicleOddities(String Oddities){driver.findElement(vehicleOddities).sendKeys(Oddities);}

   
}
