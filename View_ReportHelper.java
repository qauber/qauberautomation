package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by anbus on 3/23/2017.
 */
public class View_ReportHelper {
    WebDriver driver;
    By View_button= By.xpath("//div[@class='col-sm-3 text-right']");
    By ahref = By.xpath("//div[@class='col-sm-3 text-right']//a");//ReportID href link

    public View_ReportHelper(WebDriver driver){
        this.driver=driver;
    }

    public void view_Report() throws InterruptedException {
        List<String> reportIDText = new ArrayList<String>(); // Extracted reportID list
        List<WebElement> viewButton = new ArrayList<WebElement>(); // View button list
        List<WebElement> alllinks = driver.findElements(ahref); //all href links including report ID

        for (int i = 0; i < alllinks.size(); i++) {
            //System.out.println("View Name:" + alllinks.get(i).getAttribute("href"));
            if (alllinks.get(i).getAttribute("href") != null) {
                String str =alllinks.get(i).getAttribute("href"); //first href link with report ID
                reportIDText.add(str.substring(str.lastIndexOf("/")+1));// extracting only Report ID
                viewButton.add(alllinks.get(i));
            }
        }
        System.out.println("ReportIDList from reports page :" + reportIDText);
        Random ran = new Random (); // generating random number to pass as a index value for viewbutton
        int num = ran.nextInt(viewButton.size()); //random number bt 0 - sizeof view button
        viewButton.get(num).click(); // clicking view button based on random index value
        Thread.sleep(1000);
        // locating the element in the view page
        List<WebElement> allText = driver.findElements(By.xpath("//div[@id='reportBody']//div[3]//div[1]"));
        // getting the reportID from view page
        String actualText = allText.get(0).getText();
        System.out.println("Expected :" + reportIDText.get(num) + ", Actual :" + actualText);
        // Comparing both reportID
        Assert.assertEquals(actualText, reportIDText.get(num));

    }
}
