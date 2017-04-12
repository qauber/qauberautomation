package pages.pages_AU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/21/2017.
 */
public class Add_Report {
    WebDriver driver;

    By AddRoprt_Link= By.xpath("//a//span[text()='Add Report']");
    By entity_click= By.xpath("//div//label[@class='ng-binding']//input");
    By next_button = By.xpath("//ul[@class='pager']//a");
    By lastname=By.xpath("//input[@name='lastName']");
    By firstname=By.xpath("//input[@name='firstName']");
    By next_button1=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(3)']");

    By next_button2=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(4)']");
    By next_button3=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(5)']");
    By locationStop=By.xpath("//input[@name='locationOfStop']");
    By next_button4=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(6)']");
    By next_button5=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(7)']");
    By next_button6=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(8)']");
    By publishReport=By.xpath("//div[@class='panel-footer clearfix']//button");

    public  Add_Report(WebDriver driver){
        this.driver=driver;
    }

    public void addReport() throws InterruptedException {
        driver.findElement(AddRoprt_Link).click();
        Thread.sleep(2000);
        driver.findElement(entity_click).click();
        driver.findElement(next_button).click();
        Thread.sleep(1000);
        driver.findElement(lastname).sendKeys("anu");
        driver.findElement(firstname).sendKeys("k");
        driver.findElement(next_button1).click();
        Thread.sleep(1000);
        driver.findElement(next_button2).click();
        driver.findElement(next_button3).click();
        driver.findElement(locationStop).sendKeys("san jose");
        driver.findElement(next_button4).click();
        driver.findElement(next_button5).click();
        driver.findElement(next_button6).click();
        Thread.sleep(1000);
        driver.findElement(publishReport).click();

    }

}
