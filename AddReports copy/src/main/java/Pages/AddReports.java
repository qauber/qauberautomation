package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by jaishree on 3/24/17.
 */
public class AddReports {

        private WebDriver driver;

        public AddReports(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement AddingReports() {
            return driver.findElement(By.xpath("//span[text()='Add Report']"));

        }

        public WebElement ViewReports() {
            return driver.findElement(By.xpath("//span[text()='Reports']"));
        }

        public WebElement Departmentname() { /*List<WebElement>*/

            return driver.findElement(By.xpath("//div[@class='radio c-radio ng-scope']//input[@type='radio']"));
        }

       // public WebElement NameofEntity(int index) {
          //  return Departmentname().get(index);
       // }

        public WebElement Nextbtn()
        {
            return driver.findElement(By.xpath("//a[text()='Next']"));
        }

        public WebElement ViewReport() {
            return driver.findElement(By.xpath("//a[text()='View']"));
        }



    }


