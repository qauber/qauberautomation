import com.github.javafaker.Faker;
import helper.ReportHelper;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import testresources.PageResources;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 5/16/2017.
 */
public class AddReportExcelDataTest {
    WebDriver driver;
    LoginPage loginPage;
    Faker faker = new Faker();
    PageResources pageResources;
    ReportHelper reportHelper;






    @Test(dataProviderClass = Data_Provider.class, dataProvider = "ExcelDataProvider",dependsOnMethods = "setupDriver",enabled=false)
    public void ReadDataExcelReport(String lastname, String firstname, String companyname, String cityname) throws BiffException, InterruptedException {


      /*  driver.get("http://qabidder.net/testwave");
        Thread.sleep(5000);

        loginPage.userNameField().sendKeys("sinduchalasani789@gmail.com");
        loginPage.passWordField().sendKeys("sindu.789");
        Thread.sleep(5000);
        loginPage.loginButton().click();
        */
        Thread.sleep(3000);
        pageResources.getNavBar().addReportButton().click();
        Thread.sleep(5000);
        // Selecting Entity Name-- By selecting the radio button
        pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().subjectInformationPage().click();
        Thread.sleep(3000);
        // In the Subject Information, enter Last name and Firstname fields.--- Text Boxes(fields)
        pageResources.getAddReportSubjectInformation().lastNameField().click();
        //String last_name = faker.name().lastName();
        pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(lastname);
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().firstNameField().click();
        pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(firstname);

        // Click on Identifier Page: Check the check box
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().identifierPage().click();

        Thread.sleep(2000);
        pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
        pageResources.getAddReportIdentifiers().tatoos().sendKeys("tatoo on left ear");
        // ID Information Page
        pageResources.getAddReportIdentifiers().idInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().socialSecurity().click();
        pageResources.getAddReportIDInformation().socialSecurity().sendKeys("754-231-7777");
        pageResources.getAddReportIDInformation().employerName().click();
        pageResources.getAddReportIDInformation().employerName().sendKeys(companyname);
        //Selecting from Drop Down
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().employerstate().selectByVisibleText("Texas");
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().scrollToElement();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().scrollUp();
        Thread.sleep(3000);
        //pageResources.getAddReportIDInformation().nextButton().click();
        pageResources.getAddReportIDInformation().stopInformationPage().click();
        Thread.sleep(3000);

        pageResources.getAddReportStopInformation().locationOfStop().click();
        pageResources.getAddReportStopInformation().locationOfStop().sendKeys(cityname);
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().vehiclePage().click();
        Thread.sleep(3000);
        pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
        pageResources.getAddReportVehicle().photosPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportPhotos().previewPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportCommit().reportCommit().click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@ng-click='confirm()' and text()='YES']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@ng-click='confirm()' and text()='YES']")).click();
        //WebElement el =driver.findElement(By.cssSelector(".btn-success"));
        //el.click();
        //((JavascriptExecutor) driver).executeScript("window.confirm = function(msg) { return
       // true; }");
        //Handling the Alerts/Popoups
        //Alert alert = driver.switchTo().alert();
        //Switch to Alert
        //driver.switchTo().alert();
        //alert.accept();
       /* new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert message:" + alert.getText());
        alert.accept(); */
        //Thread.sleep(3000);
        //pageResources = new PageResources(driver);
         //driver.findElement(By.xpath("//div/button[text()='YES']")).click();
        //WebElement el =driver.findElement(By.cssSelector(".btn-success"));
        // driver.findElement(By.xpath("//button[@ng-click='confirm()']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        // pageResources.getReports().viewButtonByIndex(0).click();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollDown();
        WebElement v1 = driver.findElement(By.xpath("//a[@title='View'][1]"));
        v1.click();
        Thread.sleep(10000);
        pageResources.getAddReportIDInformation().scrollDown();

        String report= driver.findElement(By.tagName("body")).getText();

        Boolean checkStatus= false;

        if (report.contains(lastname))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + lastname + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + lastname + " in the View report text");


        }

        if (report.contains("Texas"))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + "Texas" + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + "Texas" + " in the View report text");


        }
        if (report.contains("tattoo on left ear"))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + "tattoo on left ear" + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + "tattoo on left ear" + " in the View report text");


        }




    }
    public String randomString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }

    public static final String USERNAME = "samhita";
    public static final String AUTOMATE_KEY = "15e867ba-e5da-4125-aa29-3b83b18b3a74";
    public static final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY +  "@ondemand.saucelabs.com:443/wd/hub";



    //@Parameters(value = {"browser", "version", "os", "osVersion"})

    @Test(dataProviderClass = Data_Provider.class, dataProvider = "giveDesiredCapabilities")
    public void setupDriverTest(String version,String platform1,String Screenresolution,String lastname,String firstname,String companyname,String companycity) throws InterruptedException, IOException {

        //driver = new ChromeDriver();
        //pageResources = new PageResources(driver);
        //loginPage = new LoginPage(driver);

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("version",version);
        caps.setCapability("platform",platform1);
        caps.setCapability("resolution"
                ,Screenresolution);

        WebDriver driver = new RemoteWebDriver(new URL(URL1), caps);
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3000,TimeUnit.SECONDS);
        driver.get("http://qabidder.net/testwave/#/page/login");

       // driver = (RemoteWebDriver) new Augmenter().augment(driver);
        //File srcFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(srcFile, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
//        takeScreenShot.takeScreenshot(driver,"ScreenShot"+generateRandomNameString());
        Thread.sleep(5000);
        pageResources = new PageResources(driver);
        pageResources.getLoginPage().userNameField().sendKeys("sinduchalasani789@gmail.com");
        pageResources.getLoginPage().passWordField().sendKeys("sindu.789");
        //loginToWave("qaubertester@mailinator.com", "qaubertester");
        driver = (RemoteWebDriver) new Augmenter().augment(driver);
        File srcFile2 = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File("C:\\HW10_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
        pageResources.getLoginPage().loginButton().click();
        Thread.sleep(5000);
        pageResources.getNavBar().addReportButton().click();
        Thread.sleep(5000);
        // Selecting Entity Name-- By selecting the radio button
        pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().subjectInformationPage().click();
        Thread.sleep(3000);
        // In the Subject Information, enter Last name and Firstname fields.--- Text Boxes(fields)
        pageResources.getAddReportSubjectInformation().lastNameField().click();
        //String lastname = faker.name().lastName();
        pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(lastname);
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().firstNameField().click();
        //String firstname = faker.name().firstName();
        pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(firstname);

        // Click on Identifier Page: Check the check box
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().identifierPage().click();

        Thread.sleep(2000);
        pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
        pageResources.getAddReportIdentifiers().tatoos().sendKeys("tatoo on left ear");
        // ID Information Page
        pageResources.getAddReportIdentifiers().idInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().socialSecurity().click();
        pageResources.getAddReportIDInformation().socialSecurity().sendKeys("754-231-7777");
        pageResources.getAddReportIDInformation().employerName().click();
       // String companyname = faker.company().name();
        pageResources.getAddReportIDInformation().employerName().sendKeys(companyname);
        //Selecting from Drop Down
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().employerstate().selectByVisibleText("Texas");
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().scrollToElement();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().scrollUp();
        Thread.sleep(3000);
        //pageResources.getAddReportIDInformation().nextButton().click();
        pageResources.getAddReportIDInformation().stopInformationPage().click();
        Thread.sleep(3000);

        pageResources.getAddReportStopInformation().locationOfStop().click();
        pageResources.getAddReportStopInformation().locationOfStop().sendKeys(companycity);
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().vehiclePage().click();
        Thread.sleep(3000);
        pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
        pageResources.getAddReportVehicle().photosPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportPhotos().previewPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportCommit().reportCommit().click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@ng-click='confirm()' and text()='YES']")).click();
        Thread.sleep(3000);
        //WebElement el =driver.findElement(By.cssSelector(".btn-success"));
        //el.click();
        //((JavascriptExecutor) driver).executeScript("window.confirm = function(msg) { return
        // true; }");
        //Handling the Alerts/Popoups
        //Alert alert = driver.switchTo().alert();
        //Switch to Alert
        //driver.switchTo().alert();
        //alert.accept();


        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        // pageResources.getReports().viewButtonByIndex(0).click();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollDown();
        WebElement v1 = driver.findElement(By.xpath("//a[@title='View'][1]"));
        v1.click();
        Thread.sleep(10000);
        pageResources.getAddReportIDInformation().scrollDown();

        String report= driver.findElement(By.tagName("body")).getText();

        Boolean checkStatus= false;

        if (report.contains(lastname))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + lastname + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + lastname + " in the View report text");


        }



    }


    public void startup(){
        System.out.println("Bringing up the Remote Driver");
    }

   @AfterClass
    public void breakDown() {
        driver.close();
        driver.quit();
    }

}