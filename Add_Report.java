package sanityCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/** Created by Anbu
 * This is helper class for adding report with subject type */

public class Add_Report {
    WebDriver driver;

    By AddRoprt_Link= By.xpath("//a//span[text()='Add Report']");
    By entity_click= By.xpath("//div//label[@class='ng-binding']//input");
    By next_button = By.xpath("//ul[@class='pager']//a");
    By lastname=By.xpath("//input[@name='lastName']");
    By firstname=By.xpath("//input[@name='firstName']");
    By next_button1=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(3)']");
    By subject_Type = By.xpath("//div[@class='controls']//select[@ng-model='wizard.report.suspectType']");
    By next_button2=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(4)']");
    By next_button3=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(5)']");
    By locationStop=By.xpath("//input[@name='locationOfStop']");
    By next_button4=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(6)']");
    By next_button5=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(7)']");
    By next_button6=By.xpath("//ul[@class='pager']//a[@ng-click='wizard.go(8)']");
    By publishReport=By.xpath("//div[@class='panel-footer clearfix']//button");
    By confirm_button = By.xpath("//div[@class='ngdialog-message']//button[text()='YES']");

    public  Add_Report(WebDriver driver){
        this.driver=driver;
    }




    public void addReport_Victim(String lastName,String firstName,String LocationtoStop) throws InterruptedException {
        /** Click addreport link in left menu*/
        driver.findElement(AddRoprt_Link).click();
        Thread.sleep(2000);
        driver.findElement(entity_click).click();
        driver.findElement(next_button).click();
        Thread.sleep(1000);

        /** select subject type "Victim" */
        Select subjectType_dd = new Select(driver.findElement(subject_Type));
        subjectType_dd.selectByVisibleText("Victim");

        /** enter mandatory fields lastname, first name,Location to stop */
        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(firstname).sendKeys(firstName);
        driver.findElement(next_button1).click();
        Thread.sleep(1000);
        driver.findElement(next_button2).click();
        driver.findElement(next_button3).click();
        driver.findElement(locationStop).sendKeys(LocationtoStop);
        driver.findElement(next_button4).click();
        driver.findElement(next_button5).click();
        driver.findElement(next_button6).click();
        Thread.sleep(1000);
        driver.findElement(publishReport).click();
        Thread.sleep(1000);
        driver.findElement(confirm_button).click();
        Thread.sleep(2000);

    }

    /** Adding report with suspect type "Suspect" */
    public void addReport_Suspect(String lastName,String firstName,String LocationtoStop) throws InterruptedException {
        driver.findElement(AddRoprt_Link).click();
        Thread.sleep(2000);
        driver.findElement(entity_click).click();
        driver.findElement(next_button).click();
        Thread.sleep(1000);
        Select subjectType_dd = new Select(driver.findElement(subject_Type));
        subjectType_dd.selectByVisibleText("Suspect");

        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(firstname).sendKeys(firstName);
        driver.findElement(next_button1).click();
        Thread.sleep(1000);
        driver.findElement(next_button2).click();
        driver.findElement(next_button3).click();
        driver.findElement(locationStop).sendKeys(LocationtoStop);
        driver.findElement(next_button4).click();
        driver.findElement(next_button5).click();
        driver.findElement(next_button6).click();
        Thread.sleep(1000);
        driver.findElement(publishReport).click();
        Thread.sleep(1000);
        driver.findElement(confirm_button).click();
        Thread.sleep(2000);

    }
    /** Adding report with suspect type "Witness" */
    public void addReport_Witness(String lastName,String firstName,String LocationtoStop) throws InterruptedException {
        driver.findElement(AddRoprt_Link).click();
        Thread.sleep(2000);
        driver.findElement(entity_click).click();
        driver.findElement(next_button).click();
        Thread.sleep(1000);
        Select subjectType_dd = new Select(driver.findElement(subject_Type));
        subjectType_dd.selectByVisibleText("Witness");

        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(firstname).sendKeys(firstName);
        driver.findElement(next_button1).click();
        Thread.sleep(1000);
        driver.findElement(next_button2).click();
        driver.findElement(next_button3).click();
        driver.findElement(locationStop).sendKeys(LocationtoStop);
        driver.findElement(next_button4).click();
        driver.findElement(next_button5).click();
        driver.findElement(next_button6).click();
        Thread.sleep(1000);
        driver.findElement(publishReport).click();
        Thread.sleep(1000);
        driver.findElement(confirm_button).click();
        Thread.sleep(2000);

    }
    public void addReport_R(String lastName,String firstName,String LocationtoStop) throws InterruptedException {
        driver.findElement(AddRoprt_Link).click();
        Thread.sleep(2000);
        driver.findElement(entity_click).click();
        driver.findElement(next_button).click();
        Thread.sleep(1000);
        Select subjectType_dd = new Select(driver.findElement(subject_Type));
        subjectType_dd.selectByVisibleText("R/P");

        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(firstname).sendKeys(firstName);
        driver.findElement(next_button1).click();
        Thread.sleep(1000);
        driver.findElement(next_button2).click();
        driver.findElement(next_button3).click();
        driver.findElement(locationStop).sendKeys(LocationtoStop);
        driver.findElement(next_button4).click();
        driver.findElement(next_button5).click();
        driver.findElement(next_button6).click();
        Thread.sleep(1000);
        driver.findElement(publishReport).click();
        Thread.sleep(1000);
        driver.findElement(confirm_button).click();
        Thread.sleep(2000);

    }
    /** Adding report with suspect type "Other" */
    public void addReport_Other(String lastName,String firstName,String LocationtoStop) throws InterruptedException {
        driver.findElement(AddRoprt_Link).click();
        Thread.sleep(2000);
        driver.findElement(entity_click).click();
        driver.findElement(next_button).click();
        Thread.sleep(1000);
        Select subjectType_dd = new Select(driver.findElement(subject_Type));
        subjectType_dd.selectByVisibleText("Other");

        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(firstname).sendKeys(firstName);
        driver.findElement(next_button1).click();
        Thread.sleep(1000);
        driver.findElement(next_button2).click();
        driver.findElement(next_button3).click();
        driver.findElement(locationStop).sendKeys(LocationtoStop);
        driver.findElement(next_button4).click();
        driver.findElement(next_button5).click();
        driver.findElement(next_button6).click();
        Thread.sleep(1000);
        driver.findElement(publishReport).click();
        Thread.sleep(1000);
        driver.findElement(confirm_button).click();
        Thread.sleep(2000);
    }
}
