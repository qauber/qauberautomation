package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kamkam on 3/20/2017.
 */
public class ExportPDF {
    WebDriver driver;


    By ExportPdf = By.xpath("//section/div/div[3]/button");
    By CheckBox= By.xpath("html/body/div[2]/section/div/div[1]/div[5]/div[1]/div/div/div/label/span");




    public ExportPDF(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement chechBox(){return driver.findElement(CheckBox);}

    public WebElement ExportPdf() {
        return driver.findElement(ExportPdf);
    }


}
