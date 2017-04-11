package TestCaseSAU;

import PageBase.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;

/**
 * Created by kamkam on 3/16/2017.
 */
public class AddSubDep {

    public WebDriver driver;
    public PageResources pageResources;
    public LogIn logIn;

    @BeforeTest
    public void Login() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        //driver.manage().window().maximize();
        Thread.sleep(8000);
        pageResources.getLoginPage().EmailId().sendKeys("wavefittest@mailinator.com ");
        Thread.sleep(4000);
        pageResources.getLoginPage().password().sendKeys("Kamran12345");
        Thread.sleep(4000);
        pageResources.getLoginPage().SignIn().click();
    }

    @Test
    public void AddSubDep1() throws Exception {
//        logIn= new LogIn(driver,pageResources);
//        logIn.launchBrowser();

        Thread.sleep(3000);
        pageResources.getAddSubDep().clickEntitiesLink();
        Thread.sleep(3000);
        pageResources.getAddSubDep().clickEntityName();
        Thread.sleep(3000);
        pageResources.getAddSubDep().clickDepartment();
        Thread.sleep(3000);
        pageResources.getAddSubDep().clickAddDeptButton();
        Thread.sleep(3000);
        pageResources.getAddSubDep().setSubDepartmentName("IT");
        Thread.sleep(3000);
        pageResources.getAddSubDep().clickAddSubDept();
        Thread.sleep(3000);
        pageResources.getAddSubDep().clickClosePopup();




    }





}
