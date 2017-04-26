package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jennifer Grelik on 3/15/2017.
 */
public class LoginPage {
    ////// LoginPage Objects /////

    WebDriver driver;

    By email = By.id("exampleInputEmail1");
    By passWord = By.id("exampleInputPassword1");
    By login = By.cssSelector("button.btn");

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    // Set username in "Email" textbox

    public void setEmail(String strEmail)
    {
        driver.findElement(email).sendKeys(strEmail);
    }

    // Set password in "Password" textbox

    public void setPassword(String strPassword){
        driver.findElement(passWord).sendKeys(strPassword);
    }

    //Click on login button

    public void clickLogin(){
        driver.findElement(login).click();
    }

    //Quick email and password insertion method

    public void setLoginCredentials(String strEmail, String strPassword){

        //Set email in "Email" textbox
        this.setEmail(strEmail);

        //Set password in "Password" textbox
        this.setPassword(strPassword);
    }

}
