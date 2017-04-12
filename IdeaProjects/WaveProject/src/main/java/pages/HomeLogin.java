package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeLogin {
     WebDriver driver;

    By UserName = By.xpath("//input[@id='exampleInputEmail1']");
    By Password = By.xpath("//input[@id='exampleInputPassword1']");
    By Login = By.xpath("//form[@name='login.loginForm']//button");

    public HomeLogin(WebDriver driver){
        this.driver = driver;
    }
    // Enter Username in textbox

    public void enterUserName(String userMail){

          driver.findElement(UserName).sendKeys(userMail);
    }

    // Enter Password in password field

    public void enterPassword(String password){

         driver.findElement(Password).sendKeys(password);
    }

    // click Login button
    public void clickLoginButton(){

         driver.findElement(Login).click();
    }

    public void login(String userMail,String password) throws InterruptedException {
        driver.findElement(UserName).sendKeys(userMail);
        driver.findElement(Password).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(Login).click();
    }



    }
