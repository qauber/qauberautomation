package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/28/2017.
 */
public class SubscriptionUsingPaypal {
    public WebDriver driver;

    public SubscriptionUsingPaypal (WebDriver driver){       this.driver=driver;    }




    By ProfileSettingBtn= By.xpath("//a[@ng-click='select($event)']//em[@class='icon-equalizer fa-lg']");
    By FirstEntityLink= By.xpath("//div[1]//a[@ng-click='$ctrl.openEditSubForm(sub)']/span[@class='ng-binding']");
    By ChangeSubscriptionBtn= By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/button[2]");
    By EntitBtn= By.xpath("//nav/ul/li[2]");

    public WebElement getProfileSettingBtn() {
        return driver.findElement(ProfileSettingBtn);
    }
    public WebElement FirstEntityLink(){return driver.findElement(FirstEntityLink);}
    public WebElement ChangeSubscriptionBtn(){return driver.findElement(ChangeSubscriptionBtn);}
    public WebElement EntityBtn(){return driver.findElement(EntitBtn);}
}
