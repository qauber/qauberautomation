package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/16/2017.
 */
public class LogOut {

    WebDriver driver;
    public LogOut(WebDriver driver) {
        this.driver = driver;
    }
    By UserNameProfile = By.xpath("//nav/div[2]/ul[2]/li/a/span");
    By LogoutButton= By.xpath("//button[@class='btn btn-labeled btn-primary btn-sm']");
    By TrialFlag= By.xpath("//div[@class='panel-body text-center ng-scope bg-danger']");

    public WebElement  TrialFlag(){return driver.findElement(TrialFlag);}
   public WebElement UserNameProfile()
   {
       return driver.findElement(UserNameProfile);
   }
   public WebElement LogOutButton()
   {
       return driver.findElement(LogoutButton);
   }
}
