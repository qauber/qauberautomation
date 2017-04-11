package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/30/2017.
 */
public class ForgetPassPage {

    WebDriver driver;

    public ForgetPassPage(WebDriver driver) {        this.driver = driver;    }

    //////for forgrt link=//a[@class='text-muted']
    By ForgetLink= By.xpath("//a[@class='text-muted']");
    ////// email address: //input[@name='email']
    By EmailAddress= By.xpath("//input[@name='email']");
    ////Reset click = //button[@class='btn btn-primary btn-block mb-lg']
    By ResetBtn= By.xpath("//button[@class='btn btn-primary btn-block mb-lg']");
    By FirstEmail= By.xpath(".//*[@id='body']//div/a[1]/div");
    By LinkofFirsEmail=By.xpath("//p//a");
    By PasswordtextBoxInChangingPass= By.xpath(".//*[@id='id-password']");
    By ConfirmPassTextBoxInChangePass= By.xpath("//button[@class='btn btn-block btn-primary mt-lg']");
    By ChangePswBtn= By.xpath("//button[@class='btn btn-block btn-primary mt-lg']");

    public WebElement ChangePswBtn(){return driver.findElement(ChangePswBtn);}
    public WebElement ForgetLink(){return driver.findElement(ForgetLink);}
    public WebElement EmailAddress(){return driver.findElement(EmailAddress);}
    public WebElement ResetBtn(){return driver.findElement(ResetBtn);}
    public WebElement FirstEmail(){return driver.findElement(FirstEmail);}
    public WebElement LinkofFirsEmail(){return driver.findElement(LinkofFirsEmail);}
    public WebElement PasswordtextBoxInChangingPass(){return driver.findElement(PasswordtextBoxInChangingPass);}
    public WebElement ConfirmPassTextBoxInChangePass(){return driver.findElement(ConfirmPassTextBoxInChangePass);}

//////////////////////////////////
   ////working on the Getnada

    By EnterEmailOnGetnada= By.xpath("//input[@id='emailaddress']");
    By LetsGoBtnInGetNada= By.xpath("//button[@type='submit']");

public WebElement EnterEmailOnGetnada(){return  driver.findElement(EnterEmailOnGetnada);}
    public WebElement LetsGoBtnInGetNada(){return  driver.findElement(LetsGoBtnInGetNada);}
  ////////////////////////////////////



    ///zarzar@getnada.com
    ////////////https://app.getnada.com/inbox/zarzar@getnada.com
    //////login





}
