package TesetCasesAU;

import Pages.DataCredential;
import PageBase.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testResources.PageResources;
import java.lang.String;
import java.io.File;


public class ExportPDF {
            public WebDriver driver;
            public PageResources pageResources;
            public LogIn logIn;



    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "USernameAndPassword")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        driver.manage().window().maximize();
        Thread.sleep(4000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(2000);
        pageResources.getLoginPage().password().sendKeys(Password);
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(3000);
    }
        @Test(priority = 2)
        public void Exporfile () throws Exception {
            pageResources = new PageResources(driver);
            Thread.sleep(4000);

            pageResources.getExportPDF().chechBox().click();
            Thread.sleep(3000);
            pageResources.getExportPDF().ExportPdf().click();
            Thread.sleep(5000);
            //WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver, "file:///D:\\Users\\kamkam\\Desktop\\search_result.pdf");

            File f = new File("D:\\Users\\kamkam\\Downloads\\search_result.pdf");
            if (f.exists())
            {
                System.out.print("File is Available");
            }
            else
            {
                System.out.print("No File Available");
            }
           

        }


}