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

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
/*
Invite regular user during the org creation
Verify that super user can invite the regular user during org creation
Precondition: super admin log in
1) Click on "Entities" link
2) Click "Add Entity" button
3) Fill out required information in the entity detail page
4) Click next button
5) Enter regular user email in to email textbox
6) Click "Next Step"
7) Click "Done"

 */

public class InviteRegularDuringORGcreationTest {



        public WebDriver driver;
        public PageResources pageResources;
        public String ORGname;


        @BeforeTest

        // Preconditions before invite regular user during ORG creation are login, fill up required entity info before invite regular user
        public void setup()throws InterruptedException{
            System.setProperty("webdriver.firefox.marionette","C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("http://testwave.qabidder.net/#/page/login");
            Thread.sleep(2000);
            pageResources = new PageResources(driver);
            Thread.sleep(8000);
            // Super admin user login
            pageResources.getLoginPage().loginToWave("t8sterfoster@gmail.com","superangry");
            Thread.sleep(8000);
            //Fill require info to entity creation page, click next or add info
            ORGname="tech"+generateRandomNameString();
            pageResources.getAddEntity().createEntity(ORGname,
                    "Thailand", "101 abc", "BKK","Texas", "30210");
            Thread.sleep(8000);
        }
    // Regualr email=Random string generrator+ domain name, use for create random entity name or email user
    public String generateRandomNameString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }


    //data provider name "NewUserEmail" stores domain name of the email
    @Test(dataProvider = "NewUserEmail", dataProviderClass = Data_Provider.class)
        public void InviteRUusertoNewEntityTest (String emailDomainName)throws InterruptedException {
        // create user email by adding random string and email domain name
        String strUseremail = generateRandomNameString() +emailDomainName;
        // input regular user email
            pageResources.getInviteUsertoNewEntity().setInviteRUemail(strUseremail);
            Thread.sleep(5000);
        // click next button
            pageResources.getInviteUsertoNewEntity().clickNextStepButtonRU();
            Thread.sleep(5000);
        //  click done button
            pageResources.getInviteUsertoNewEntity().clickdoneButtonRU();
            Thread.sleep(8000);
        // click user link on navigator panel
            pageResources.getAddUser().clickUsersLink();
            Thread.sleep(8000);
        // check if there are more

        // get the element of the pagination
        List<WebElement> nextPageButton = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']/li[@class='ng-scope']/a"));

         // check if there is more than 1 page, then click on the next index of the page button
           if(nextPageButton.size() != 0) {
                for(int i=0; i<nextPageButton.size(); i++) {
                    nextPageButton.get(i).click();
                    Thread.sleep(5000);
                }
                //get the assigned RU email
                String actualEmail = driver.findElement(By .xpath("(//tr[@ pagination-id='usersPagination']//a )[last()]")).getText();

                // click the assign permissions button to get the role of the user and the entity that user was assigned to
                driver.findElement(By.xpath("(//tr[@ pagination-id='usersPagination']/td[2]/button[1])[last()]")).click();
               Thread.sleep(5000);

              //  get the user role by going to the last row of the assign permission pop up
               String actualRole = driver.findElement(By.xpath("(//tr/td[2][@class='text-center'])[last()]")).getText();

               // get the ORG that user were assigned to ,when created the ORG
               String actualORGName= driver.findElement(By.xpath("(//div[@class='table-responsive']//tr[@class='ng-scope']/td[1])[last()]")).getText();

               ///###############################################################################################
               //Validation

               try {
                    //Compare if the entered RU email and the displayed RU email in the user list  are matching
                    Assert.assertEquals(strUseremail, actualEmail);
                    System.out.println("Entered RU email ::"+ strUseremail);
                    System.out.println("Invited user in the user list ::" + actualEmail);


                    // Validate if the new assigned RU user has the role as Regular user or not
                    Assert.assertEquals(actualRole, "Regular User");
                    System.out.println("Regular user has assigned to::"+actualRole);


                   // Validate if the new assigned RU user was assigned to the right ORG name when first created it
                   Assert.assertEquals(actualORGName, ORGname);
                   System.out.println("The created entity name ::"+ ORGname);
                   System.out.println("The entity name that RU assigned to ::"+ actualORGName);


                } catch (Throwable t) {
                    org.testng.Assert.fail("expected and actual result do not match");
                }

            }
            else{  // check there is only 1 page
               //get the assigned RU email
               String actualEmail = driver.findElement(By .xpath("(//tr[@ pagination-id='usersPagination']//a )[last()]")).getText();

               // click the assign permissions button to get the role of the user and the entity that user was assigned to
               driver.findElement(By.xpath("(//tr[@ pagination-id='usersPagination']/td[2]/button[1])[last()]")).click();
               Thread.sleep(5000);

               //  get the user role by going to the last row of the assign permission pop up
               String actualRole = driver.findElement(By.xpath("(//tr/td[2][@class='text-center'])[last()]")).getText();

               // get the ORG that user were assigned to ,when created the ORG
               String actualORGName= driver.findElement(By.xpath("(//div[@class='table-responsive']//tr[@class='ng-scope']/td[1])[last()]")).getText();

               // Close the assign permissions pop up
               pageResources.getAssignUser().setClosePopup();
               driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='panel panel-default']")));
               //driver.findElement(By.xpath("//div[@class='ngdialog-close']")).click();
               //Thread.sleep(5000);
               ///###############################################################################################
               //Validation

               try {
                   //Compare if the entered RU email and the displayed RU email in the user list  are matching
                   Assert.assertEquals(strUseremail, actualEmail);
                   System.out.println("Entered RU email ::"+ strUseremail);
                   System.out.println("Invited user in the user list ::" + actualEmail);


                   // Validate if the new assigned RU user has the role as Regular user or not
                   Assert.assertEquals(actualRole, "Regular User");
                   System.out.println("Regular user has assigned to::"+actualRole);


                   // Validate if the new assigned RU user was assigned to the right ORG name when first created it
                   Assert.assertEquals(actualORGName, ORGname);
                   System.out.println("The created entity name ::"+ ORGname);
                   System.out.println("The entity name that RU assigned to ::"+ actualORGName);


               } catch (Throwable t) {
                   org.testng.Assert.fail("expected and actual result do not match");
               }
            }

        }
   /* @AfterTest

        public void cleanUp() throws InterruptedException
        {   // click delete button
            Thread.sleep(8000);
            List<WebElement> nextPageButton = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']/li[@class='ng-scope']/a"));
            if(nextPageButton.size() != 0) {
                for (int i = 0; i < nextPageButton.size(); i++) {
                    nextPageButton.get(i).click();
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("(//tr/td[2]/button[4])[last()]")).click();
                    Thread.sleep(5000);
                    pageResources.getAddEntity().clickConfirmDelete();
                    Thread.sleep(5000);
                }
            }
            else{ driver.findElement(By.xpath("(//tr/td[2]/button[4])[last()]")).click();
                Thread.sleep(5000);

                pageResources.getAddEntity().clickConfirmDelete();
                Thread.sleep(5000);
            }

            driver.close();
        }*/



    }




