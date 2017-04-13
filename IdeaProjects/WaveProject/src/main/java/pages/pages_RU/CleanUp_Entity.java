package pages.pages_RU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by anbus on 4/5/2017.
 */
public class CleanUp_Entity {
    WebDriver driver;

    public CleanUp_Entity(WebDriver driver){
        this.driver = driver;
    }

    public void cleanUp() throws InterruptedException
    {   // click delete button
        List<WebElement> nextPageButton = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']/li[@class='ng-scope']/a"));
        if(nextPageButton.size() != 0) {
            for (int i = 0; i < nextPageButton.size(); i++) {
                nextPageButton.get(i).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("(//tr//button[@ title='Delete'])[last()]")).click();
                Thread.sleep(5000);
               // pageResources.getAddEntity().clickConfirmDelete();
                Thread.sleep(5000);
            }
        }
        else{ driver.findElement(By.xpath("(//tr//button[4][@ title='Delete'])[last()]")).click();
            Thread.sleep(5000);

           // pageResources.getAddEntity().clickConfirmDelete();
            Thread.sleep(5000);
        }

       // driver.close();
    }
}
