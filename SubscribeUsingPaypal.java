package pages;


//*Created By Em


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SubscribeUsingPaypal {
    WebDriver driver;

    private By  clickPaypal= By.id("loadLogin");
    private By  paypalID= By.id("login_email");
    private By  paypalPassword= By.id("login_password");
    private By  paypalSummitButton= By.id("submitLogin");
    private By  paypalContinueButton= By.id("continue");


    public void SubscribeUsingPaypal(WebDriver driver){ this.driver= driver; }
    public void clickToPaypal(){driver.findElement(clickPaypal).click();}
    public void setpaypalID(String strPaypalID){driver.findElement(paypalID ).sendKeys(strPaypalID);}
    public void setpaypalPassword(String strPaypalPassword){driver.findElement(paypalPassword).sendKeys(strPaypalPassword);}
    public void clickpaypalSummitButton(){driver.findElement(paypalSummitButton).click();}
    public void clickPaypalContinueButton(){driver.findElement(paypalContinueButton).click();}



}
