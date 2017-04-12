package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FacebookLogin {

    WebDriver driver;

    private By setFbEmail= By.xpath("//input[@id='email']");
    private By setFbPWD= By.xpath("//input[@id='pass']");
    private By  loginButton= By.xpath("//input[@type='submit']");


    public void FacebookLogin (WebDriver driver){
        this.driver= driver;
    }
    public void setEmailFB(String strEmail){
        driver.findElement(setFbEmail).sendKeys(strEmail);
    }
    public void setPWDFB(String strRePassword){
        driver.findElement(setFbPWD).sendKeys(strRePassword);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}
