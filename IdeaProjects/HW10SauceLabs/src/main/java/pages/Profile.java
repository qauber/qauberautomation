package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sc on 5/7/2017.
 */
public class Profile {


    WebDriver dr;
    public Profile(WebDriver dr){
        System.out.println("Created  Page");
        this.dr = dr;
    }

    public WebElement CaretDownLink(){
        return dr.findElement(By.xpath("//a/em[@class='fa fa-caret-down']"));
    }

    public WebElement LogoutButton(){
        return dr.findElement(By.xpath("//button[@ng-click='app.logout()']"));
    }

    public WebElement GetEmail(){
        return dr.findElement(By.xpath("//a[contains(@ng-href,'mailto')]"));
    }


    public WebElement EditProfileButton(){
        return dr.findElement(By.xpath("//button[text()='Edit Profile']"));
    }

    public WebElement ProfileName(){
        return dr.findElement(By.xpath("//input[@placeholder='John Doe']"));
    }

    public WebElement UpdateButton(){
        return dr.findElement(By.xpath("//button[@ng-click='$ctrl.submitGeneralForm()']"));
    }

    public WebElement GetProfileName(){
        return dr.findElement(By.xpath("//a/span[@class='mr-sm ng-binding']"));
    }
}
