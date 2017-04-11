package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/23/2017.
 */
public class SAUSignUp {
    WebDriver driver;



    By Register= By.xpath("//a[@ui-sref='page.register-sa']");
    By SAname= By.xpath("//input[@name='account_name']");
    By AccountEmail= By.xpath("//input[@name='account_email']");
    By AccountPSW= By.xpath("//input[@id='id-password']");
    By PassConfirm= By.xpath("//input[@name='account_password_confirm']");
    By Continue= By.xpath("//button[@ng-click='reg.changePage(2)']");
    By FinishConfirmation= By.xpath("//div[@class='text-lg mb-lg']");
////////////////////////////////////////////////
    By AcoountNameReg= By.xpath("//input[@name='name']");
    By PhoneReg= By.xpath("//input[@name='phone']");
    By EmailReg= By.xpath("//input[@name='email']");
    By AddressReg= By.xpath("//input[@name='address1']");
    By CityReg= By.xpath("//input[@name='city']");
    By StateReg= By.xpath("//select[@name='state']");
    By PostalReg= By.xpath("//input[@name='zip']");
    By ConfirmationReg= By.xpath("//button[@id='registerConfirm']");
//////////////////////////
public WebElement FinishConfirmation (){return driver.findElement(FinishConfirmation);}
    public WebElement Continue (){return driver.findElement(Continue);}
    public WebElement Register(){return driver.findElement(Register);}
    public WebElement SAname(){return driver.findElement(SAname);}
    public WebElement AccountEmail(){return driver.findElement(AccountEmail);}
    public WebElement AccountPSW(){return driver.findElement(AccountPSW);}
    public WebElement PassConfirm(){return driver.findElement(PassConfirm);}

    ///////////////////////////////
    public SAUSignUp (WebDriver driver){       this.driver=driver;    }

    //////////////////////////REGISTRATION
    public WebElement ConfirmationReg (){return driver.findElement(ConfirmationReg);}
    public WebElement AcoountNameReg (){return driver.findElement(AcoountNameReg);}
    public WebElement PhoneReg (){return driver.findElement(PhoneReg);}
    public WebElement EmailReg (){return driver.findElement(EmailReg);}
    public WebElement CityReg (){return driver.findElement(CityReg);}
    public WebElement StateReg (){return driver.findElement(StateReg);}
    public WebElement PostalReg (){return driver.findElement(PostalReg);}
    public WebElement AddressReg(){return driver.findElement(AddressReg);}
}
