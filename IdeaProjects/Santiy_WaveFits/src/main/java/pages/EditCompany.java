package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EditCompany{
    WebDriver driver;
    private By clickUserPanel= By.cssSelector("span.mr-sm.ng-binding") ;
    private By clickEditCompany = By.xpath("//button[@ng-click='$ctrl.editCompany()']");
    private By changeAddress = By.xpath("//input[@name='address1']");
    private By updateCompany=By.xpath("//button[@ng-click='$ctrl.submitAction()']");

    public void EditCompany(WebDriver driver){ this.driver= driver; }
    public void clickUserPanel(){
        driver.findElement(clickUserPanel).click();
    }
    public void ClickEditCompany(){driver.findElement(clickEditCompany).click();}
    public void setChangeAddress(String strNewAddress){
        driver.findElement(changeAddress).clear();
        driver.findElement(changeAddress).sendKeys(strNewAddress);}
    public void clickUpdateCompany(){driver.findElement(updateCompany).click();}





}
