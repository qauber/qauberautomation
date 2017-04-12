package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.*;
import pages.BaseClass;


public class Test_Login extends test.BaseClass {
    public WebDriver driver = super.driver;

    @Test(description = "This TC valid Login")
    public void verifyLogin() throws InterruptedException {
        super.loginToApp();
        System.out.println("Login Successful");
    }

    /*@Test(description = "This TC Invalid Login")
    public void verifyInvalidLogin() throws InterruptedException {
        driver.findElement(UserName).sendKeys("anbu@getnada.com");
        driver.findElement(Password).sendKeys("testing3");
        Thread.sleep(2000);
        driver.findElement(Login).click();
        System.out.println("Login is not Successful with invalid credentials");
    }*/
}





