package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sc on 3/22/2017.
 */
public class EntityInviteRAUPaySub {
    WebDriver dr;

    public EntityInviteRAUPaySub(WebDriver dr){
        this.dr=dr;
    }

    public WebElement regularUserEmail(){
        return dr.findElement(By.xpath("//div[@class='bootstrap-tagsinput']/input"));
    }
    public WebElement entityNextButton(){
        return dr.findElement(By.xpath("//button/span[text()='Next step']"));
    }

    public WebElement entityPrevButton(){
        return dr.findElement(By.xpath("//button/span[text()='Prev step']"));
    }

    public WebElement adminUserEmails(){
        return dr.findElement(By.xpath("//div[@class='form-group']//div[@class='bootstrap-tagsinput']/input[@type='text']"));
    }


    public WebElement entityFinishButton(){
        return dr.findElement(By.xpath("//button/span[text()='Finish']"));
    }

    public WebElement popUpButton(){
        return dr.findElement(By.xpath("//button[@ng-click='confirm()' and text()='Done']"));
    }
    // Pay for the subscription through Paypal
    public WebElement payPalpay(){
      return  dr.findElement(By.xpath("//input[@value='Pay with my PayPal account']"));
    }

    public WebElement continueButton(){
        return  dr.findElement(By.xpath("//input[@id='continue']"));
    }

}
