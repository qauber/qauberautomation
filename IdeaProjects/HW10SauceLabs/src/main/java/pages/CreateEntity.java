package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sc on 3/22/2017.
 */
public class CreateEntity {
    WebDriver dr;

    public CreateEntity(WebDriver dr){
        this.dr=dr;
    }

    public WebElement entityName(){
        return dr.findElement(By.xpath("//input[@name='name']"));
    }
    public Select entityCountry(){
        return new Select(dr.findElement(By.xpath("//select[@name='country']")));
    }
    public WebElement entityAddress(){
        return dr.findElement(By.xpath("//input[@name='address1']"));
    }
    public WebElement entityCity(){
        return dr.findElement(By.xpath("//input[@name='city']"));

    }
    public WebElement entityPrevButton(){
        return dr.findElement(By.xpath("//button/span[text()='Prev step']"));
    }
    public void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor)dr;
        jse.executeScript("scroll(0, 450);");

    }
    public WebElement entityState(){
        return dr.findElement(By.xpath("//input[@name='state']"));
    }
    public WebElement entityZip(){
        return dr.findElement(By.xpath("//input[@name='zip']"));
    }
    public WebElement entityNextButton(){
        return dr.findElement(By.xpath("//button/span[text()='Next step']"));
    }

}
