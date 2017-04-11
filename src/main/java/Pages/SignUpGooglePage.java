package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/30/2017.
 */
public class SignUpGooglePage {

    WebDriver driver;
    public SignUpGooglePage(WebDriver driver) {    this.driver = driver;    }




    By GoogleButton= By.xpath("//button[@class='btn btn-defalt login-form-btn-gp']");
    By EmailInGooglePage= By.xpath(".//*[@id='Email']");
    By NextBtnInGooglePage= By.xpath("//input[@id='next']");
    By PasswordInGoogle= By.xpath("//input[@id='Passwd']");
    By SignInBtnInGoogle= By.xpath("//input[@id='signIn']");
    By AllowBtnGoogle= By.xpath("//button[@id='submit_approve_access']");
    public WebElement AllowBtnGoogle(){return driver.findElement(AllowBtnGoogle);}
    public WebElement SignInBtnInGoogle(){return driver.findElement(SignInBtnInGoogle);}
    public WebElement PasswordInGoogle(){return driver.findElement(PasswordInGoogle);}
    public WebElement GoogleButton (){return driver.findElement(GoogleButton);}
    public WebElement EmailInGooglePage(){return driver.findElement(EmailInGooglePage);}
    public WebElement NextBtnInGooglePage(){return driver.findElement(NextBtnInGooglePage);}








}
