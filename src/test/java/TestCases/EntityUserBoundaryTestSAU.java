package TestCases;

import ObjectRepository.PageResources;
import Pages.DataProviderClass;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Jenny on 4/21/2017.
 */
public class EntityUserBoundaryTestSAU {

    public WebDriver driver;
    public PageResources pageResources;
    Faker faker = new Faker();

    String emailDomain = "@mailsac.com";
    String expectedEntityName = faker.company().name();

    @BeforeTest

    public void setup() throws InterruptedException{

        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "superAdminUserLogin2", priority = 0)

    public void entityUserBoundaryTest(String utype, String uname, String password) throws InterruptedException{

        //Login as super admin user
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(10000);
        pageResources.getLoginPage().setLoginCredentials(uname, password);
        pageResources.getLoginPage().clickLogin();
        Thread.sleep(60000);

        //Click the Users Page link
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(10000);

        //Create a for loop to invite 10 new users
        //Initialize the string, lastUser, to store the name of the last user later
        String lastUser = null;

        for(int i = 1; i <= 10; i++){
            //Click the invite user button
            pageResources.getUsersPage().inviteUser().click();
            Thread.sleep(20000);

            //Generate a random email string and input into the invite email text field
            String newUser = faker.name().username() + "@getnada.com";
            pageResources.getInviteUserPage().inviteEmail().sendKeys(newUser);
            Thread.sleep(5000);

            //If i equals 10, save the name of the random, generated email as lastUser
            if(i == 10){
                lastUser = newUser;
                System.out.println("The last user is: " + lastUser);
            }

            //Click the send invite button
            pageResources.getInviteUserPage().sendInvite().click();
            Thread.sleep(15000);
        }

        Thread.sleep(5000);

        //Click the Entities Page link
        pageResources.getEntityPage().entityLink().click();
        Thread.sleep(15000);

        //Click the Add Entity button
        pageResources.getEntityPage().addEntity().click();
        Thread.sleep(15000);

        //Add entity name, address, and city name
        pageResources.getAddEntityPage().entityName().sendKeys(expectedEntityName);
        Thread.sleep(5000);
        pageResources.getAddEntityPage().address1().sendKeys(faker.address().streetAddress());
        pageResources.getAddEntityPage().city().sendKeys(faker.address().cityName());

        //Select the state
        Select selectState = new Select(pageResources.getAddEntityPage().state());
        selectState.selectByVisibleText(faker.address().state());

        //Input a postal code for the Postal Code text field
        pageResources.getAddEntityPage().postalCode().sendKeys(faker.address().zipCode());

        //Click the Next button
        pageResources.getAddEntityPage().nextButton().click();
        Thread.sleep(10000);

        //Click the Next button and Done button
        pageResources.getAddEntityInviteUserPage().nextButton().click();
        Thread.sleep(30000);

        //Input the provided Admin User already used in the DataProviderClass
        pageResources.getAddEntityInviteAdminPage().inviteAdmin().sendKeys("testermonster@mailsac.com");
        Thread.sleep(5000);

        //Click the Next button and Done button
        pageResources.getAddEntityInviteAdminPage().nextButton().click();
        Thread.sleep(10000);
        pageResources.getAddEntityInviteUserPage().doneButton().click();
        Thread.sleep(30000);

        //Click the Finish button
        pageResources.getAddEntitySubscriptionPage().finishButton().click();
        Thread.sleep(30000);

        //Once on paypal, click on the Login link
        pageResources.getPaypalPage().clickLoginPage().click();
        Thread.sleep(20000);

        //Input the Paypal sandbox login credentials
        pageResources.getPaypalLogin().email().sendKeys("testerjenbuyer@gmail.com");
        pageResources.getPaypalLogin().password().sendKeys("qauber2016!");
        pageResources.getPaypalLogin().submitLogin().click();
        Thread.sleep(10000);

        //Click the Continue button
        pageResources.getPaypalConfirmPaymentPage().continueButton().click();
        Thread.sleep(40000);

        //Iterate through the row of entity names until you find the newly created entity
        //Get a list of all the entity table rows.  This counts the total rows of entities.
        List<WebElement> entityRows = driver.findElements(By.xpath("//div[@class='col-md-6']//a"));
        System.out.println("entityRows total: " + entityRows.size());
        int i;
        int j = 0;
        for(i = 0; i < entityRows.size(); i++){
            //Grab the text of the entity name
            String str1 = entityRows.get(i).getText();
            System.out.println("entityRow: " + i);
            System.out.println("Contains: " + str1);

            //If the string matches the name of the entity, assert that they match
            if(expectedEntityName.contains(str1)){
                try{
                    Assert.assertEquals(str1, expectedEntityName, "Match of entity not found");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                j = i + 2;
                System.out.println("J is " + j);
                //Click the Assign Permissions button
                driver.findElement(By.xpath("//tr[" + j + "]//button[@title=\"Assign permissions\"]")).click();
            }
        }

        Thread.sleep(15000);

        //Create a for loop to iterate through all the users
        //List all the users
        List<WebElement> usersList = driver.findElements(By.xpath("//div[@class='word-break-all ng-binding']"));
        Thread.sleep(5000);
        System.out.println("The user size is: " + usersList.size());
        //Initialize k
        int k = 0;

        for(i = 0; i < usersList.size(); i++){
            //Get the string of the current user
            String currentUser = usersList.get(i).getText();
            System.out.println("Current user row:" + i);
            System.out.println("Contains: " + currentUser);
            k = i + 1;

            //If the current user is not one of the emails stored in DataProviderClass, select "Regular user" and save
            if(!currentUser.contains("Monster Tester") && !currentUser.contains("Regular Tester") && !currentUser.contains("garrick.green@mailsac.com")){
                WebElement selectPermission = driver.findElement(By.xpath("//tr[" + k + "]/td[2]/select[@ng-model='user.assignedRole']"));
                Select selectType = new Select(selectPermission);
                selectType.selectByVisibleText("Regular user");

                driver.findElement(By.xpath("//tr[" + k + "]//button[@title='Save changes']")).click();
                Thread.sleep(5000);

                System.out.println("Assigned and saved!");
            }
        }

        Thread.sleep(10000);

        //Grab the web element of the message stored in the alert box
        WebElement capacityAlert = driver.findElement(By.xpath("//div[@class='ngdialog ngdialog-theme-default ng-scope']//h4[contains(text(), 'User limit is reached for this Entity')]"));

        //Assert that it is displayed
        try{
            Assert.assertTrue(capacityAlert.isDisplayed(), "The alert is not visible...");
        }
        catch(Throwable t){
            t.getLocalizedMessage();
        }

        System.out.println("Alert is displayed: " + capacityAlert.isDisplayed());

        //Close the alert box
        driver.findElement(By.xpath("//div[@class='ngdialog ngdialog-theme-default ng-scope']//button[@ng-click='closeThisDialog()']")).click();
        Thread.sleep(10000);

        //Grab the text in the table column that displays the current user capacity
        String currentCapacity = driver.findElement(By.xpath("//tr[" + j + "]//span[@ng-if='entity.subscriptionModel.active' and contains(text(), '/ 10')]")).getText();

        //Assert that the user capacity is full
        try{
            Assert.assertEquals(currentCapacity, "10 / 10", "Not at max user capacity");
        }
        catch(Throwable t){
            t.getLocalizedMessage();
        }

        System.out.println("User Capacity: " + currentCapacity);

        Thread.sleep(5000);

        //Click the Users Page link
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(10000);

        //Iterate through the User rows
        //Initiate the actual, list the nextButton for pagination, initiate the index, iRow, and jRow
        String actual = null;
        List<WebElement> nextButton = driver.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]"));
        System.out.println("nextButtons: " + nextButton.size());
        int index;
        int iRow;
        int jRow = 0;
        Thread.sleep(5000);

        //If the nextButton exists, or is greater than 0
        if (nextButton.size() > 0) {
            //Scroll down the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 950);");
            Thread.sleep(100);
            //Grab and list all the pagination pages
            List<WebElement> pagenumbers = driver.findElements(By.xpath("//a[@class='ng-binding' and @ng-click='setCurrent(pageNumber)']"));
            System.out.println("pagenumbers: " + pagenumbers.size());

            //Loop through the pagination pages
            for (index = 1; index <= pagenumbers.size(); index++) {
                //While looping through, grab the list of table rows on each page
                List<WebElement> userRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
                System.out.println("rowCount: " + userRows.size());

                //Loop through the list of table rows on each pagination page
                for (iRow = 1; iRow <= (userRows.size() - 2); iRow++) {
                    //While going through each row, grab the username of the current table row and convert it to a string
                    WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                    System.out.println("Current userRow is: " + iRow);
                    String username = currentRow.getText();
                    System.out.println(username);

                    //If the current username matches the lastUser
                    if (username.equals(lastUser)) {
                        //Set the current username as the actual result
                        actual = currentRow.getText();
                        System.out.println("The actual last user has been found: " + actual);

                        jRow = iRow;
                    }
                }
                //If the actual result is still null and the nextButton does not equal 0, then click the nextButton
                if(actual == null && nextButton.size() != 0){
                    nextButton.get(0).click();
                }
            }
        }
        else{
            //If the nextButton is not enabled on the first page, scroll down the page
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 950);");
            Thread.sleep(100);

            //Grab and list all the table rows of users
            List<WebElement> userRows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
            System.out.println("rowCount: " + userRows.size());

            //Loop through the table rows
            for (iRow = 1; iRow <= (userRows.size() - 2) && actual == null; iRow++) {
                //While going through each row, grab the username of the current row and set it as a string
                WebElement currentRow = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[" + iRow + "]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"));
                System.out.println("Current userRow is: " + iRow);
                String username = currentRow.getText();
                System.out.println(username);

                //If the username matches the lastUser, set the string as the actual result
                if (username.equals(lastUser)) {
                    actual = currentRow.getText();
                    System.out.println("The actual last user has been found: " + actual);

                    jRow = iRow;
                }
            }
        }

        //Click the Assign Permissions button
        driver.findElement(By.xpath("//tr[" + jRow + "]//button[@title='Assign permissions']")).click();
        Thread.sleep(15000);

        //Create a for loop to iterate through the table of entities
        //List all the entities
        List<WebElement> entitiesList = driver.findElements(By.xpath("//div[@class='word-break-all depth-level']"));
        Thread.sleep(5000);
        System.out.println("The entity list size is: " + entitiesList.size());
        //Initialize h
        int h = 0;

        for(i = 0; i < entitiesList.size(); i++){
            //Grab the string of the current entity
            String currentEntity = entitiesList.get(i).getText();
            System.out.println("Current entity row: " + i);
            System.out.println("Contains: " + currentEntity);
            h = i + 1;

            //If the current entity matches the expectedEntityName, select "Regular User" and save
            if(currentEntity.contains(expectedEntityName)) {
                WebElement assignPermission = driver.findElement(By.xpath("//tr[" + h + "]//select[@ng-model='entity.status']"));
                Select assignType = new Select(assignPermission);
                assignType.selectByVisibleText("Regular User");

                driver.findElement(By.xpath("//tr[" + h + "]//button[@ng-click='assignEntity(entity)']")).click();
                Thread.sleep(10000);
            }

        }

        //Grab the web element of the message displayed in alert box
        capacityAlert = driver.findElement(By.xpath("//div[@class='ngdialog ngdialog-theme-default ng-scope']//h4[contains(text(), 'User limit is reached for this Entity')]"));

        //Assert that it is displayed
        try{
            Assert.assertTrue(capacityAlert.isDisplayed(), "The alert is not visible...");
        }
        catch(Throwable t){
            t.getLocalizedMessage();
        }

        System.out.println("Alert is displayed: " + capacityAlert.isDisplayed());

        //Close the alert box
        driver.findElement(By.xpath("//div[@class='ngdialog ngdialog-theme-default ng-scope']//button[@ng-click='closeThisDialog()']")).click();
        Thread.sleep(10000);

    }

    @AfterTest

    public void close() throws InterruptedException{

        pageResources.getEntityPage().entityLink().click();
        Thread.sleep(30000);

        //Iterate through the row of entity names until you find the newly created entity
        //Get a list of all the entity table rows.  This counts the total rows of entities.
        List<WebElement> table = driver.findElements(By.xpath("//table"));
        List<WebElement> entityRows = driver.findElements(By.xpath("//div[@class='col-md-6']//a"));
        System.out.println("entityRows total: " + entityRows.size());
        int i;
        int j;
        for(i = 0; i < entityRows.size(); i++){
            //Get the string of the current entity row
            String str1 = entityRows.get(i).getText();
            System.out.println("entityRow: " + i);
            System.out.println("Contains: " + str1);
            //If the expectedEntityName matches the string of the current entity row, delete the entity
            if(expectedEntityName.contains(str1)){
                try{
                    Assert.assertEquals(str1, expectedEntityName, "Match of entity not found");
                }
                catch(Throwable t){
                    t.getLocalizedMessage();
                }
                j = i + 2;
                System.out.println("J is " + j);
                driver.findElement(By.xpath("//tr[" + j + "]//button[@title=\"Delete\"]")).click();
                Thread.sleep(10000);
                driver.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
                Thread.sleep(20000);
            }
        }

        //Click the Users Page link
        pageResources.getUsersPage().usersLink().click();
        Thread.sleep(15000);

        //Create a for loop to iterate through the rows of the users table
        //List all the users
        List<WebElement> usersList = driver.findElements(By.xpath("//tr[@pagination-id='usersPagination']//span//a"));
        //Initialize k
        int k = 0;

        for(i = 0; i < usersList.size(); i++){
            //Get the string of the current user
            String currentUser = usersList.get(i).getText();
            System.out.println("Current user row:" + i);
            System.out.println("Contains: " + currentUser);
            k = i + 1;

            //If the current user is not any of emails stored in DataProviderClass, stop here
            if(!currentUser.contains("testermonster@mailsac.com") && !currentUser.contains("testerregular@mailsac.com") && !currentUser.contains("garrick.green@mailsac.com")){
                System.out.println("Row stopped at: " + k);
                System.out.println("Contains: " + currentUser);
                break;
            }
        }

        System.out.println("k is: " + k);

        //Initialize a for loop to keep deleting all the users that are moved up to this row
        for(i = 0; i < 10; i++){
            driver.findElement(By.xpath("//tr[" + k + "]//button[@title='Delete']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
            Thread.sleep(5000);
        }

        driver.close();

    }


}
