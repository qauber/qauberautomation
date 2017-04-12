package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SubscribeEntity {
    WebDriver driver;
    //HomeLogin objHomeLogin;
   // AddEntity objAddEntity;

    By Finish_button = By.xpath("//div[@class='panel-footer text-right']//span[text()='Finish']");
    By paypal_email = By.xpath("//input[@id='login_email']");
    By paypal_pwd = By.xpath("//input[@id='login_password']");
    By login = By.xpath("//input[@id='submitLogin']");
    By Agree_button = By.xpath("//input[@id='continue']");
    By NextStep_button1 = By.xpath("//button[@type='button']/span[text()='Next step']");
    By NextStep_button2=By.xpath("//button[@class='btn btn-info btn-labeled']/span[text()='Next step']");
    By PaypalLogin_link= By.xpath("//input[@id='loadLogin']");


    public SubscribeEntity(WebDriver driver) {
        this.driver = driver;
    }

    public void subscribe_entity() throws InterruptedException {

        driver.findElement(NextStep_button1).click();
        Thread.sleep(3000);
        driver.findElement(NextStep_button2).click();
        driver.findElement(Finish_button).click();
        Thread.sleep(3000);
        //click on Paypal link
        driver.findElement(PaypalLogin_link).click();
        Thread.sleep(3000);
        driver.findElement(paypal_email).clear();
        //Paypal login credentials
        driver.findElement(paypal_email).sendKeys("anbu.sundara-buyer@gmail.com");
        driver.findElement(paypal_pwd).sendKeys("tester17!");
        driver.findElement(login).click();
        Thread.sleep(3000);
        driver.findElement(Agree_button).click();
        Thread.sleep(3500);

    }
}
