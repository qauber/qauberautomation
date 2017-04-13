package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/** Created by Anbu
 *  Super Admin creating Entity & subscribe the entity */
public class SAU_CompanyCreation {
    WebDriver driver;
   // public int k;
    By Entities = By.xpath("//span[@class='ng-binding' and contains(text(),'Entities')]");
    By AddEntity_button = By.xpath("//h3[@class='h3-alt ng-scope']//button");
    By Entity_Name = By.name("name");
    By Address1 = By.name("address1");
    By City = By.name("city");
    //By State_dropdown = By.name("state");
    By Postalcode = By.name("zip");
    By NextStep_button = By.xpath("//div[@class='panel-footer text-right']//span[text()='Next step']");
    By Finish_button = By.xpath("//div[@class='panel-footer text-right']//span[text()='Finish']");
    By paypal_email = By.xpath("//input[@id='login_email']");
    By paypal_pwd = By.xpath("//input[@id='login_password']");
    By login = By.xpath("//input[@id='submitLogin']");
    By Agree_button = By.xpath("//input[@id='continue']");
    By NextStep_button1 = By.xpath("//button[@type='button']/span[text()='Next step']");
    By NextStep_button2 = By.xpath("//button[@class='btn btn-info btn-labeled']/span[text()='Next step']");
    By PaypalLogin_link = By.xpath("//input[@id='loadLogin']");

    public SAU_CompanyCreation(WebDriver driver) {

        this.driver = driver;
    }

    public void sau_Add_Company() throws InterruptedException {


        driver.findElement(Entities).click();
        Thread.sleep(2000);
        driver.findElement(AddEntity_button).click();
        String randomStr = Long.toHexString(Double.doubleToLongBits(Math.random()));
        driver.findElement(Entity_Name).sendKeys(randomStr);
        Thread.sleep(1000);
        driver.findElement(Address1).sendKeys("main st");
        driver.findElement(City).sendKeys("cupertino");
        Select state_dd = new Select(driver.findElement(By.name("state")));
        state_dd.selectByVisibleText("California");
        driver.findElement(Postalcode).sendKeys("1234");
        System.out.println("AddEntity - Expected:" + randomStr);

       driver.findElement(NextStep_button).click();
        Thread.sleep(1000);
       // driver.findElement(Entities).click();
       // Thread.sleep(2000);
        driver.findElement(NextStep_button1).click();
        Thread.sleep(3000);
        driver.findElement(NextStep_button2).click();
        driver.findElement(Finish_button).click();
        Thread.sleep(3000);
        //click on Paypal link
        driver.findElement(PaypalLogin_link).click();
        Thread.sleep(3000);
        driver.findElement(paypal_email).clear();
        //Paypal login credentials
        driver.findElement(paypal_email).sendKeys("anbu.sundara-buyer@gmail.com");
        driver.findElement(paypal_pwd).sendKeys("tester17!");
       // Click login
        driver.findElement(login).click();
        Thread.sleep(3000);
        // Agree the terms & click agree button
        driver.findElement(Agree_button).click();
        Thread.sleep(4500);

        /* verify the created entity is there in the list
        if it is more pages need to check each page
         */
        //All pages in pagination
        List<WebElement> allpages = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']//a"));

        //locating the pagination tab
        WebElement paginationLink = driver.findElement(By.xpath("//div[@ng-hide=\"$ctrl.pages <= 1\"]//ul"));

        // if the pagination tab displayed then check in each pages
        if(paginationLink.isDisplayed()){
            System.out.println("pagination exists check all the pages");

            for( int i=0; i<allpages.size(); i++) {
                WebElement nxtBtn = driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a"));
                if (nxtBtn.isEnabled()) {
                    List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='col-md-6']"));
                    for (int j = 0; j < allRows.size(); j++) {
                        allRows.get(j).getText();
                        System.out.println("TEXT :" + allRows.get(j).getText() + " Random Str :" + randomStr);
                        if (allRows.get(j).getText().contains(randomStr)) {
                            Assert.assertEquals(allRows.get(j).getText(), randomStr);
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
            List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='col-md-6']"));
            for (int j = 0; j < allRows.size(); j++) {
                allRows.get(j).getText();
                System.out.println("TEXT :" + allRows.get(j).getText() + " Random Str :" + randomStr);
                if (allRows.get(j).getText().contains(randomStr)) {
                    Assert.assertEquals(allRows.get(j).getText(), randomStr);
                    System.out.println("Assertion pass");
                    //k=j;
                }
            }

        }




    }




}
