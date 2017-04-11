package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/26/2017.
 */
public class ReportSearchPages {

    WebDriver driver;
    public ReportSearchPages(WebDriver driver) {        this.driver = driver;   }

    By checkBox= By.xpath("//div[1]/div/div/div/label/span");
    By SuspectLastName= By.xpath("//div[1]/div[2]/div/input");
    By SuspectFirstName= By.xpath("//div[2]/div[2]/div/input");
    By CaseID= By.xpath("//div[3]/div[2]/div/input");
    By ContainText= By.xpath("//div[7]/div[2]/div/input");


     public WebElement checkBox(){return driver.findElement(checkBox);}
    public WebElement SuspectLastName(){return driver.findElement(SuspectLastName);}
    public WebElement SuspectFirstName(){return driver.findElement(SuspectFirstName);}
    public WebElement CaseID(){return driver.findElement(CaseID);}
    public WebElement ContainText(){return driver.findElement(ContainText);}



}
