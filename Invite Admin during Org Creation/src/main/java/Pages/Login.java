package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jaishree on 3/23/17.
 */

    public class Login {

    WebDriver driver;

    public Login(WebDriver driver){
        this.driver= driver;                //set driver variable: "this" works as a reference to a current object
        // whose method or constructor is being invoked
    }

    //locate and return webelement username field
    public WebElement setUserName(){
        return driver.findElement(By.name("account_email"));
    }

    //locate and return webelement password field
    public WebElement setPassword(){
        return driver.findElement(By.name("account_password"));
    }

    //Click on login button
    public WebElement clickLogin(){
        return driver.findElement(By.xpath("//button[text()='Login']"));
    }


    public WebElement LoginNamecheck()
    {
        return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']"));
    }

    public WebElement Emailcheck() {
        return driver.findElement(By.xpath("//h5[@class='ng-binding']"));
    }
}

