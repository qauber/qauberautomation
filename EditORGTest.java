package pagestest;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.Assert;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;
        import testresources.PageResources;
        import java.lang.*;
        import java.math.BigInteger;
        import java.security.SecureRandom;


/* *Created By Em
Edit Entity
Verify that super admin user can edit the entity
Preconditions
User should be logged as super admin in on http://testwave.qabidder.net/#/page/login
Steps
1) Click on "Entities"on main navigation panel.
2) Click on edit button on which entity needs to be edited
3) Fill out all of the required fields
4) Click on update button

Expected Result
1) User is able to edit the selected entity
2) new information will be updated in that entity


 */

   public class EditORGTest {
         WebDriver driver;
         public PageResources pageResources;
         @BeforeTest
         public void setup() throws InterruptedException {

            System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");

            driver = new FirefoxDriver();
             driver.manage().window().maximize();
            driver.get("http://testwave.qabidder.net/#/page/login");
            pageResources = new PageResources(driver);
            Thread.sleep(8000);
            //Precondition: Super user login
            pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com", "superangry");
            Thread.sleep(8000);
         }
        // Random string generator
         public String generateRandomNameString() {
            return new BigInteger(16, new SecureRandom()).toString(16);
         }


       @Test(dataProvider = "EditORG", dataProviderClass = Data_Provider.class, priority = 1)
        public void EditORGTest(String entityName) throws InterruptedException {
            String EntityName = entityName + generateRandomNameString();


            //Click Entities link and input all the required information
            pageResources.getAddEntity().clickEntityLink(); Thread.sleep(40000);
           //Click edit button to edit information of the entity
            pageResources.getEditORG().clickEditEntityButton();
           Thread.sleep(5000);

           //Store the old name
           String EntityOldName = driver.findElement(By.xpath("//input[@ name='name']")).getAttribute("value");
           //After stored the old name, the text field will clear up then add the new name
           pageResources.getEditORG().setEntityName(EntityName);

           // Store the new name that entered to the entity name text field
           String expectedNameResult = driver.findElement(By.xpath("//input[@ name='name']")).getAttribute("value");
           Thread.sleep(5000);
            pageResources.getEditORG().clickUpdateButton();

            //Validation

            Thread.sleep(40000);
            // Get the entity name from entity list after updated the name
            String actualNameResult = driver.findElement(By.xpath("//tr[12]/td[1]//div[@class='col-md-6']/a")).getText();
           Thread.sleep(20000);

            try {
                Assert.assertEquals(actualNameResult, expectedNameResult);
                System.out.println("Admin updated entity name from  " + EntityOldName + "  to  " + actualNameResult);
            } catch (Throwable t) {
                org.testng.Assert.fail("expected and actual result do not match");

            }

            driver.close();
        }


    }


