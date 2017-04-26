package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jennifer Grelik on 3/17/2017.
 */
public class ViewReport {
    ///// ViewReport Objects /////

    WebDriver driver;

    By exportPDF = By.xpath("*//section/div/div/div[1]/div/div/button[2]");

    public ViewReport(WebDriver driver){

        this.driver = driver;
    }

    public WebElement exportPDF(){

        return driver.findElement(exportPDF);
    }


}
