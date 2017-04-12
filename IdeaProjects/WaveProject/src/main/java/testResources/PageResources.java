package testResources;

import org.openqa.selenium.WebDriver;
import pages.AddEntity;
import pages.HomeLogin;

/**
 * Created by anbus on 3/16/2017.
 */
public class PageResources {
    private HomeLogin homeLogin;
    //private AddEntity addEntity;

    public PageResources(WebDriver driver) {
        homeLogin = new HomeLogin(driver);
    }
    public HomeLogin getHomeLogin() {
        return homeLogin;
    }



}

