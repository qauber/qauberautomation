package helper;
/*
*Created By Em
*/

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import testresources.PageResources;

import java.lang.*;

public class ReportHelper {
    PageResources pageResources;
    WebDriver driver;
    public static LoginPage loginPage;

    public  void login(String strUsername, String strPasword) throws InterruptedException{
        loginPage = new LoginPage();
        loginPage.LoginPage(driver);

        loginPage.loginToWave(strUsername,strPasword);
    }
    public void completeReport() {
        System.out.print("Login Successful");
    }

}

