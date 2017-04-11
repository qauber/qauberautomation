package TestCaseRU;

import Pages.DataCredential;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import testResources.PageResources;

import java.io.File;
import java.util.List;
/**
 * Created by kamkam on 3/21/2017.
 */
public class ExportPdf {


    public WebDriver driver;
    public PageResources pageResources;
    int NumberOfPage;


    @Test(priority = 1, dataProviderClass = DataCredential.class, dataProvider = "RU")
    public void Login(String Person, String UserName, String Password) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        pageResources.getLoginPage().EmailId().sendKeys(UserName);
        Thread.sleep(3000);
        pageResources.getLoginPage().password().sendKeys(Password);
        //
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void Exporfile() throws Exception {
        Thread.sleep(3000);
        pageResources.getExportPDF().chechBox().click();
        Thread.sleep(3000);
        pageResources.getExportPDF().ExportPdf().click();
        Thread.sleep(3000);

/////////////////////////Number of Page///////////////////////////////////////////
        List<WebElement> NOP = driver.findElements(By.xpath("//td//ul//li//a"));
        Thread.sleep(2000);
        NOP.get(NOP.size()-2).click();
        System.out.println("Number of page is:   " + (NOP.size() - 2));
        Thread.sleep(2000);
/////////////////////////Number of elements in the last page///////////////////////////////////////
        List<WebElement> NOPLastPage= driver.findElements(By.xpath("//tbody/tr"));
        Thread.sleep(2000);
        System.out.println("Number of Report in the last page is:   " + (NOPLastPage.size() -2 ));
//////////////////////////Read the pdf file/////////////////
        Thread.sleep(2000);
        PDDocument pdf= PDDocument.load("D:\\Users\\kamkam\\Downloads\\search_result.pdf");
        Thread.sleep(2000);
        PDFTextStripper stripper= new PDFTextStripper();
        Thread.sleep(2000);
        String pdfContent=stripper.getText(pdf);
        String Sample="City of San Jose";
        String[] parts=pdfContent.split(Sample);
        System.out.println("The Number of row in the pdf file is:  "+(parts.length-1));

        int SumOfReport=((NOP.size() - 2)-1) * 10+ (NOPLastPage.size() -2 );
 ////////////////////////////Assertion///////////////////////////////////////////
        System.out.print("Number of the reports:"+SumOfReport);

////////////////////////////////////////////////////////////////////////////////////////
        Thread.sleep(2000);
        File f = new File("D:\\Users\\kamkam\\Downloads\\search_result.pdf");
        if (f.exists()) {
            System.out.print("File Exported in the downoad file");
        } else {
            System.out.print("No File Available");
        }

    }

    @AfterTest
   public  void Finish()
    {
        driver.quit();
    }


}




