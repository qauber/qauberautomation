package pagestest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import static javafx.scene.input.KeyCode.J;
/* *Created By Em
Verify that super admin can create an entity
Preconditions
User should be logged as super admin in on http://testwave.qabidder.net/#/page/login
Steps
1) Click on "Entities"on main navigation panel.
2) Click on "Add Entity" button.
3) Fill out all of the required fields and click "Next step" button.

Expected Result
1)the new entity will be added in the entities list page
2) Super Admin is redirected to the "Entities" page.
3) Super Admin was able to add the entity.
 */

public class CreateORGTest {

    public WebDriver driver;
    public PageResources pageResources;

    @BeforeTest
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        pageResources = new PageResources(driver);
        Thread.sleep(8000);
        //login as super user
        pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
        Thread.sleep(8000);
    }

    // random string generator
    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }


    @Test(dataProvider = "AddEntitiesInfo", dataProviderClass = Data_Provider.class, priority = 1)
    public void ORGcreationTest(String entityName, String entityCountry, String entityAddress, String entityCity, String entityState, String entityZip) throws InterruptedException {
        String expectedEntityName = entityName + generateRandomNameString();
        //Click Entities link and input all the required information
        pageResources.getAddEntity().clickEntityLink();
        Thread.sleep(30000);
        //click add entity button
        pageResources.getAddEntity().clickAddEntityButton();
        Thread.sleep(10000);
        //enter entity name
        pageResources.getAddEntity().setEntityName(expectedEntityName);
        Thread.sleep(8000);
        //enter country
        pageResources.getAddEntity().setCountryName(entityCountry);
        Thread.sleep(8000);
        //enter address
        pageResources.getAddEntity().setAddress(entityAddress);
        Thread.sleep(8000);
        //enter city
        pageResources.getAddEntity().setCity(entityCity);
        Thread.sleep(8000);
        //enter state
        pageResources.getAddEntity().setState(entityState);
        Thread.sleep(8000);
        //enter zipcode
        pageResources.getAddEntity().setZip(entityZip);
        Thread.sleep(8000);
        //click next stp button
        pageResources.getAddEntity().clickNextStepButton();
        Thread.sleep(8000);

        // Add RU user to the entity
        String RUemail="ruqauber@mailinator.com";
        pageResources.getInviteUsertoNewEntity().setInviteRUemail(RUemail);
        Thread.sleep(5000);
        pageResources.getInviteUsertoNewEntity().clickNextStepButtonRU();
        Thread.sleep(5000);
        pageResources.getInviteUsertoNewEntity().clickdoneButtonRU();
        Thread.sleep(8000);

        // Add AU user to the entity
        String AUemail="qaubertester@mailinator.com";
        pageResources.getInviteUsertoNewEntity().setinviteAUemail(AUemail);
        Thread.sleep(5000);
        pageResources.getInviteUsertoNewEntity().clickNextStepButtonAU();
        Thread.sleep(5000);
        pageResources.getInviteUsertoNewEntity().clickdoneButtonAU();
        Thread.sleep(8000);
        pageResources.getInviteUsertoNewEntity().clicksubscribeFinishButton();
        Thread.sleep(8000);


        // Complete the subscription

        String UserPaypalID="t8sterfoster-2@gmail.com";
        String UserPaypalPassword="superangry";

        pageResources.getSubscribeUsingPaypal().clickToPaypal();
        Thread.sleep(8000);
        pageResources.getSubscribeUsingPaypal().setpaypalID(UserPaypalID);
        Thread.sleep(8000);
        pageResources.getSubscribeUsingPaypal().setpaypalPassword(UserPaypalPassword);
        Thread.sleep(8000);
        pageResources.getSubscribeUsingPaypal().clickpaypalSummitButton();
        Thread.sleep(8000);
        pageResources.getSubscribeUsingPaypal().clickPaypalContinueButton();
        Thread.sleep(8000);


        //Validation
        //############################################################################################################
        // click on entity link on the navigation panel

        Thread.sleep(20000);
        // get row number of the entity list
        List<WebElement> rowOfDepartment = driver.findElements(By.xpath("//table[@class='table table-bordered']//tr"));
        Thread.sleep(3000);
        //get xpath of pagination and check size of the element to ensure if there are more than 1 page
        List<WebElement> nextPageButton = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']/li[@class='ng-scope']/a"));
        //Use .size() command to check if > button is enabled
        if (nextPageButton.size() != 0) {
            // make loop go on each row for rowOfDepartment.size()-2 times (actual row of the data)
            for (int i = 1; i <rowOfDepartment.size()-1; i++) {
                 int J=i+1;
                 //store string on each row for the assertion with the expectedEntityName which is the name that user entered when created the entity name
                String actualEntityName = driver.findElement(By.xpath("//tr[@ class='ng-scope']["+ J+"]/td[1]/div/div[1]/a[@class='ng-binding']")).getText().trim();
                Thread.sleep(3000);
                //System.out.println(actualEntityName + "  VS. "+expectedEntityName );
                //Check if the entity name in each row matching with the expectedEntityName, using row{index}
                //if the condition comes true, then go for the assertion
                if (rowOfDepartment.get(J).getText().contains(expectedEntityName)){
                    try {
                        Assert.assertEquals(expectedEntityName, actualEntityName);
                        System.out.println("Admin had entered entity name :: " + expectedEntityName + "\n Found the created entity name ::" + actualEntityName +" in row::"+J);;
                    } catch (Throwable t) {
                        org.testng.Assert.fail("expected and actual result do not match");

                    }

                } else {
                    System.out.println("Couldn't find ::" + expectedEntityName);
                }
            }

        }
        // In case that entity list has only 1 page
        else {

            for (int i = 1; i <(rowOfDepartment.size()-1) ; i++) {
                int J=i+1;
                String actualEntityName = driver.findElement(By.xpath("//tr[@ class='ng-scope']["+ i +"]/td[1]/div/div[1]/a[@class='ng-binding']")).getText().trim();
                Thread.sleep(3000);
                System.out.println("In row number."+i + " "+actualEntityName+"  VS.  "+expectedEntityName );
                if (rowOfDepartment.get(J).getText().contains(expectedEntityName)) {
                    try {
                        Assert.assertEquals(expectedEntityName, actualEntityName);
                        System.out.println("Admin had entered entity name :: " + expectedEntityName + "\n Found the created entity name ::" + actualEntityName +" in row::"+J);
                        Thread.sleep(3000);
                    } catch (Throwable t) {
                        org.testng.Assert.fail("expected and actual result do not match");

                    }

                }




            }



        }

    }
    @AfterTest
    //Clean up after created the entity
    public void cleanUp() throws InterruptedException
    {   // click delete button
        List<WebElement> nextPageButton = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']/li[@class='ng-scope']/a"));
        if(nextPageButton.size() != 0) {
            for (int i = 0; i < nextPageButton.size(); i++) {
                nextPageButton.get(i).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("(//tr//button[@ title='Delete'])[last()]")).click();
                Thread.sleep(5000);
                pageResources.getAddEntity().clickConfirmDelete();
                Thread.sleep(5000);
            }
        }
        else{ driver.findElement(By.xpath("(//tr//button[4][@ title='Delete'])[last()]")).click();
            Thread.sleep(5000);

            pageResources.getAddEntity().clickConfirmDelete();
            Thread.sleep(5000);
        }

        driver.close();
    }


    }
