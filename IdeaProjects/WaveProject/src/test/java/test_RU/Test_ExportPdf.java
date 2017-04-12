package test_RU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pages_RU.Export_As_Pdf;
import pages.pages_RU.RU_Login;
import pages.pages_RU.View_Report;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by anbus on 3/20/2017.
 */
public class Test_ExportPdf {
    WebDriver driver;
    String baseUrl ="http://testwave.qabidder.net/#/page/login";
    RU_Login objRU_Login;
    View_Report objViewReport;
    private static String downloadPath = "C:\\Users\\anbus\\Downloads";



    @BeforeTest
    public void setUp()
    {
        driver = new FirefoxDriver();
        //driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(47, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterTest
    public void teardown()
    {
        driver.close();
    }

    @Test
    public void verifyDownloadReport() throws InterruptedException {
        // Login As Regular User
        objRU_Login = new RU_Login(driver);
        objRU_Login.setLogin("anbu@mailinator.com", "testing");
        Thread.sleep(2000);

        // User views the recent report with view button click
        objViewReport = new View_Report(driver);
        objViewReport.view_Report();
        System.out.println("Newly created report is viewed");

        // Download the report as PDF file
        Export_As_Pdf  objExportReport= new  Export_As_Pdf(driver);
        objExportReport.exportPdf();
        System.out.println("Report is downloaded as PDF");

        // verify downloaded file name with the expected file name
        File file = getLatestFilefromDir(downloadPath);
        System.out.print("Download Path :" + downloadPath + " File :" + file);
        String fileName = file.getName();
        Assert.assertTrue(fileName.equals("interview_report_4553.pdf"), "Downloaded file name is not matching" +
                " with expected file name");

    }

    private File getLatestFilefromDir(String dirPath) {
        /* Get the latest file from a specific directory*/
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;

    }


}
