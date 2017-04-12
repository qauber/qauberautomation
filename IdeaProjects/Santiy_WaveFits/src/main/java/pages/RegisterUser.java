package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterUser{
    WebDriver driver;

    private By registerButton= By.xpath("//a[@href='#/page/register-sa']");
    private By facebookButton= By.xpath("//button[@ng-click='reg.authenticateByFacebook()']");

    //SIGNUP TO GET INSTANT ACCESS PAGE
    private By nameRegister=By.xpath("//input[@name='account_name']");
    private By emailRegister=By.xpath("//input[@name='account_email']");
    private By passwordRegister=By.xpath("//input[@id='id-password']");
    private By retypePassword= By.xpath("//input[@name='account_password_confirm']");
    private By continueRegistrationButton= By.xpath("//button[@ng-click='reg.changePage(2)']");


    public void RegisterUser (WebDriver driver){
        this.driver= driver;
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public void clickFacebookButton(){
        driver.findElement(facebookButton).click();
    }
    public void setNameRegister(String strName){
        driver.findElement(nameRegister).sendKeys(strName);
    }
    public void setEmailRegister(String strEmail){

        driver.findElement(emailRegister).clear();
        driver.findElement(emailRegister).sendKeys(strEmail);
    }
    public void setPasswordRegister(String strPassword){
        driver.findElement(passwordRegister).sendKeys(strPassword);
    }
    public void setRetypePassword (String strRePassword){
        driver.findElement(retypePassword).sendKeys(strRePassword);
    }

    public void clickContinueRegistrationButton(){
        driver.findElement(continueRegistrationButton).click();
    }
}
