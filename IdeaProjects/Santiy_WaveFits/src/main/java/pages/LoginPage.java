package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.lang.*;

public class LoginPage extends AddReport{

    WebDriver driver;


    private By userEmail = By.xpath(".//*[@id='exampleInputEmail1']") ;
    private By userPassword = By.xpath(".//*[@id='exampleInputPassword1']");
    private  By login = By.cssSelector( "button.btn");


    public  void LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String strEmail){driver.findElement(userEmail).sendKeys(strEmail);  }
    public void setPassword(String strPassword){driver.findElement(userPassword).sendKeys(strPassword); }
    public void click(){driver.findElement(login).click(); }

    public void loginToWave(String strUsername, String strPasword) throws  InterruptedException{

        this.setEmail(strUsername);
        Thread.sleep(3000);
        this.setPassword(strPasword);
        Thread.sleep(3000);
        this.click();
        Thread.sleep(3000);
    }





}

