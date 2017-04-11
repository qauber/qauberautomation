package TesetCasesRU;

import PageBase.LogIn;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testResources.PageResources;

/**
 * Created by kamkam on 3/19/2017.
 */
public class LoginRU {

    WebDriver driver;
    public PageResources pageResources;
    public LogIn logIn;
    public LoginRU() {    this.driver = driver;    }

    @Test
    public void LoginRU() throws Exception {
        logIn = new LogIn(driver,pageResources);
    }







}
