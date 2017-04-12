package pages.pages_RU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anbus on 3/20/2017.
 */
public class Export_As_Pdf {
    WebDriver driver;

    By Download_Pdf = By.xpath("//div[@class='col-md-12']//button[text()='Download as PDF']");

    public Export_As_Pdf(WebDriver driver){
        this.driver=driver;
    }

    public void exportPdf() throws InterruptedException {
        driver.findElement(Download_Pdf).click();
        Thread.sleep(1000);
    }


}
