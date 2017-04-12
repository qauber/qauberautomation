package pages;

//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddEntity {
    WebDriver driver;

  private By entitiesLink = By.xpath("//a[@title='Entities']");
  private By addEntityButton = By.xpath("//button[@ng-click='$ctrl.addEntity()']");
  private By entityName = By.xpath("//div/input[@name='name']");
  private By countryName= By.xpath("//div[2]/select[@name='country']");
  private By address= By.xpath("//input[@name='address1']");
  private By city = By.xpath("//input[@name='city']");
  private By state= By.cssSelector("input.form-control:nth-child(3)");
  private By zip=By.xpath("//div[7]/input[@name='zip']");
  private By nextStepButton= By.xpath("//button[2][@ng-click='$ctrl.nextStep()']");
  private By confirmDeleteORG = By.cssSelector(".btn-danger");

    public void AddEntity(WebDriver driver){
        this.driver= driver;

    }
    public void clickConfirmDelete(){driver.findElement(confirmDeleteORG).click();}
    public void clickEntityLink(){driver.findElement(entitiesLink).click();}
    public void clickAddEntityButton(){driver.findElement(addEntityButton).click();}
    public void setEntityName(String strEntityName){driver.findElement(entityName).sendKeys(strEntityName);}
    public void setCountryName(String strCountryName){driver.findElement(countryName).sendKeys(strCountryName);}
    public void setAddress(String strAddress){driver.findElement(address).sendKeys(strAddress);}
    public void setCity(String strCity){driver.findElement(city).sendKeys(strCity);}
    public void setState(String strState){driver.findElement(state).sendKeys(strState);}
    public void setZip(String strZip){driver.findElement(zip).sendKeys(strZip);}
    public void clickNextStepButton(){driver.findElement(nextStepButton).click();}


    public void createEntity (String strEntityName,String strCountryName, String strAddress, String strCity,String strState, String strZipCode) throws InterruptedException {
    this.clickEntityLink();Thread.sleep(8000);
    this.clickAddEntityButton();Thread.sleep(8000);
    this.setEntityName(strEntityName); Thread.sleep(5000);
    this.setCountryName(strCountryName);Thread.sleep(5000);
    this.setAddress(strAddress);Thread.sleep(5000);
    this.setCity(strCity);Thread.sleep(5000);
    this.setState(strState);Thread.sleep(5000);
    this.setZip(strZipCode);Thread.sleep(5000);
    this.clickNextStepButton();Thread.sleep(000);
           }


}
