package PageBase;

import org.openqa.selenium.WebDriver;
import testResources.PageResources;

/**
 * Created by kamkam on 3/19/2017.
 */
public class LogOut {

    public WebDriver driver ;
    public PageResources pageResources;


    public LogOut(WebDriver driver,PageResources pageResources) {
        this.driver = driver;
        this.pageResources=pageResources;
        }

    public void LogOut() throws Exception {
        LogIn logIn = new LogIn(driver, pageResources);
        //logIn.LoginInWaveFitAsSAU();
        Thread.sleep(3000);
        pageResources.getLogOut().UserNameProfile().click();
        Thread.sleep(3000);
        pageResources.getLogOut().LogOutButton().click();
    }
}
