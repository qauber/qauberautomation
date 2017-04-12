package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class AddEntity {

    WebDriver driver;


    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By AddEntity_button = By.xpath("//h3[@class='h3-alt ng-scope']//button");
    By Entity_Name = By.name("name");
    By Address1 = By.name("address1");
    By City = By.name("city");
    //By State_dropdown = By.name("state");
    By Postalcode = By.name("zip");
    By NextStep_button = By.xpath("//div[@class='panel-footer text-right']//span[text()='Next step']");

    public AddEntity(WebDriver driver) {

        this.driver = driver;
    }

    public void add_entity() throws InterruptedException {


        driver.findElement(Entities).click();
        Thread.sleep(2000);
        driver.findElement(AddEntity_button).click();
        String randomStr = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(Entity_Name).sendKeys(randomStr);
        Thread.sleep(1000);
        driver.findElement(Address1).sendKeys("main st");
        driver.findElement(City).sendKeys("cupertino");
        //state_dropdown=driver.findElement(By.name("state"));
        Select state_dd = new Select(driver.findElement(By.name("state")));
        state_dd.selectByVisibleText("California");
        driver.findElement(Postalcode).sendKeys("1234");
        System.out.println("AddEntity - Expected:" + randomStr);

        driver.findElement(NextStep_button).click();
        Thread.sleep(1000);
        driver.findElement(Entities).click();
        Thread.sleep(2000);

       /* By secondPageLink = By.xpath("//pages-manager//div//li//a[text()='2']");
        //2nd page is displayed or not
        if (driver.findElement(secondPageLink).isDisplayed()) {
            //get all pagination links
            List<WebElement> allPagination_links = driver.findElements(By.xpath("//pages-manager//div//li//a"));
            //get the last page link
            allPagination_links.get(allPagination_links.size() - 1).click();
            Thread.sleep(2000);
        }*/

        //get the allrows of the last page
       /* List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='col-md-8']"));

        System.out.println("Allrows(lastText) :" + allRows.get(allRows.size() - 1).getText() + ", Size:" + allRows.size());
        String actualStr = allRows.get(allRows.size() - 1).getText();
        System.out.println("The last entity name in  row:" + actualStr);
        Assert.assertEquals(actualStr,randomStr,"String don't match"); */

        List<WebElement> allRows = driver.findElements(By.xpath("//table//tr//div[@class='col-md-8']"));
        for (int j = 0; j < allRows.size(); j++) {
            allRows.get(j).getText();
            System.out.println("TEXT :" + allRows.get(j).getText() + " Random Str :" + randomStr);
            if (allRows.get(j).getText().contains(randomStr)) {
                // Assert.assertEquals(allRows.get(j).getText(), randomStr);
                System.out.println("Found newly added Entity at" + allRows.get(j).getSize());
                //k=j;
                driver.findElement(By.xpath("//table//tr[" + j + "]//div[@class='col-md-8']//a")).click();

            }
        }
    }



}











