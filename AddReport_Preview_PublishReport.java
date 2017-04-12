package pages;

//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReport_Preview_PublishReport {
    WebDriver driver;
    //Photo page

    private By previewReport = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[8]");
    private By publishReport= By.xpath("//button[@ng-click='wizard.commitReport()']");


    //###########################################################################################################
    public AddReport_Preview_PublishReport(WebDriver driver){
        this.driver=driver;
    }
    public void clickReportPreview()
    {

        WebElement element = driver.findElement(previewReport);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void clickPublishReport(){
        driver.findElement(publishReport).click();
    }

}
