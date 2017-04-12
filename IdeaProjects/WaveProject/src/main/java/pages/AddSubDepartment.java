package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddSubDepartment {

    WebDriver driver;

    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By click_On_company = By.xpath("//table//tbody//tr//td[1]//div//a");// Entity
    By click_on_dept = By.xpath("//table//tbody//tr//td[1]//div//a");  // 1st dept
    By AddDeptButton = By.xpath("//div[@class='content-wrapper ng-scope ng-fadeInUp']//button [text()='Add Department']");
    By SubDeptName = By.xpath("//form//input[@name='name']");
    By Add_Button = By.xpath("//div[@class='clearfix']//button[@type='submit']");

    public AddSubDepartment(WebDriver driver) {

        this.driver = driver;
    }

    public void setAddSubDept() throws InterruptedException {
        /*driver.findElement(Entities).click(); // click on left panel
        driver.findElement(click_On_company).click(); // company
        Thread.sleep(1000);
        driver.findElement(click_on_dept).click(); // mobile dept*/

        driver.findElement(AddDeptButton).click();

        String randomSubDept = Long.toHexString(Double.doubleToLongBits(Math.random()));

        driver.findElement(SubDeptName).sendKeys(randomSubDept);
        Thread.sleep(2000);
        driver.findElement(Add_Button).click();
        Thread.sleep(2000);

        List<WebElement> allpages = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']//a"));

        //locating the pagination tab
        WebElement paginationLink = driver.findElement(By.xpath("//div[@ng-hide=\"$ctrl.pages <= 1\"]//ul"));

        // if the pagination tab displayed then check in each pages
        if(paginationLink.isDisplayed()){
            System.out.println("pagination exists check all the pages");

            for( int i=0; i<allpages.size(); i++) {
                WebElement nxtBtn = driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a"));
                if (nxtBtn.isEnabled()) {
                    List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='col-md-8']"));
                    for (int j = 0; j < allRows.size(); j++) {
                        allRows.get(j).getText();
                        System.out.println("TEXT :" + allRows.get(j).getText() + " Random Str :" + randomSubDept);
                        if (allRows.get(j).getText().contains(randomSubDept)) {
                            Assert.assertEquals(allRows.get(j).getText(), randomSubDept);
                            System.out.println("Assertion pass");
                            // k=j;
                        }
                    }

                }
                System.out.println("Clicking next page, current page:" + i);
                driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a")).click();

            }

        }
        else {
            List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='col-md-8']"));
            for (int j = 0; j < allRows.size(); j++) {
                allRows.get(j).getText();
                System.out.println("TEXT :" + allRows.get(j).getText() + " Random Str :" + randomSubDept);
                if (allRows.get(j).getText().contains(randomSubDept)) {
                    Assert.assertEquals(allRows.get(j).getText(), randomSubDept);
                    System.out.println("Assertion pass");
                    //k=j;
                }
            }

        }






    }
}
