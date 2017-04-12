package pagestest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testresources.PageResources;
import java.math.BigInteger;
import java.security.SecureRandom;

/**Verify that user can register using Facebook account.
 *Preconditions
 Should have an existing Facebook account with valid credentials
 Steps
 http://testwave.qabidder.net/#/page/login

 1) Click on "Register Now" to register a new account.
 2) Click on the Facebook logo to create a Wave Fits account, through an existing Facebook account
 3) A pop-up window should appear, fill out the credentials for your existing Facebook account and continue.

 Expected Result
 user can register using Facebook account.

 */
public class RegisterUsingFacebookTest {
    public WebDriver driver;
    public PageResources pageResources;
    public String getEmail;
    public String userName;
    public String facebookUserName;
    public String actualEmail;


 @BeforeTest
 // Precondition has 1 facebook account and login
    public void setup() throws  InterruptedException {

     String email = "testingqauber@gmail.com";
     String userPWD = "qauber2018";

     System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64");
     driver = new FirefoxDriver();
     driver.manage().window().maximize();
     // Navigate to facebook
     driver.get("https://www.facebook.com/");
     pageResources = new PageResources(driver);
     //Enter facebook email
     pageResources.getFacebookLogin().setEmailFB(email);
     //Store the expected result of Facebook email
     getEmail = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
     Thread.sleep(3000);
     // Enter facebook password
     pageResources.getFacebookLogin().setPWDFB(userPWD);
     Thread.sleep(3000);
     pageResources.getFacebookLogin().clickLoginButton();
     Thread.sleep(3000);
     //Store the expected result of Facebook username
     facebookUserName = driver.findElement(By.cssSelector(".linkWrap.noCount")).getText();

     }
//Random string function
 public String generateRandomNameString() {
  return new BigInteger(16, new SecureRandom()).toString(64);
 }


     @Test(priority = 1)
     public void registerUser() throws  InterruptedException {

     // Email for registering
     //Extracting the expected email to get the user email and the domain part, adding random string behind the user email
     int indexOfDomain= getEmail.indexOf("@");
     int lastIndexOfEmail= getEmail.lastIndexOf('m');
     // user meail = the expected email(stored from facebook email)+ random string+ the expected domain name of the facebook email
     String userEmail= getEmail.substring(0,indexOfDomain)+ generateRandomNameString()+"@"+getEmail.substring(indexOfDomain+1,lastIndexOfEmail+1);
     //password for registering
     String userRegisterPassword= "qauber2018";

        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(3000);
        // Click on Register Now button
        pageResources.getRegisterUser().clickRegisterButton();
         Thread.sleep(3000);
        //Click on Facebook icon
        pageResources.getRegisterUser().clickFacebookButton();
         Thread.sleep(3000);

         //After click the facebook icon, facebook account will be loaded into "SIGNUP TO GET INSTANT ACCESS." fields

         //Actual result of the name, store value from Name text field for validating
         userName =  driver.findElement(By.xpath("//input[@name='account_name']")).getAttribute("value");

        //Actual result of the email address, Store value from Email address text field for validating
         actualEmail = driver.findElement(By.xpath("//input[@name='account_email']")).getAttribute("value");
         Thread.sleep(3000);

         //Due to the register email is already existing issue, juts added some random string into the original actual result email
         pageResources.getRegisterUser().setEmailRegister(userEmail);
         // Enter password
         pageResources.getRegisterUser().setPasswordRegister(userRegisterPassword);
         Thread.sleep(3000);
         //Re-type password
         pageResources.getRegisterUser().setRetypePassword(userRegisterPassword);
         Thread.sleep(3000);
         //Click button to continue
         pageResources.getRegisterUser().clickContinueRegistrationButton();
      Thread.sleep(3000);
     }
     @Test(dataProvider = "RegisterCompany", dataProviderClass = Data_Provider.class,priority = 2)
    public void registerCompany(String strCompanyName, String strContactPhone, String strEmail, String strCountry, String strAddress, String strCity,
    String strState, String strZip ) throws  InterruptedException {
   // Register the company
    // Enter company name
    pageResources.getRegisterCompany().setCompanyName(strCompanyName+generateRandomNameString());
      Thread.sleep(3000);
      //Enter phone
    pageResources.getRegisterCompany().setContactPhone(strContactPhone);
      Thread.sleep(3000);
      //Enter email
    pageResources.getRegisterCompany().setContactEmail(generateRandomNameString()+strEmail);
      Thread.sleep(3000);
      //Enter country
    pageResources.getRegisterCompany().setCountry(strCountry);
      Thread.sleep(3000);
      //Enter address
    pageResources.getRegisterCompany().setAddress(strAddress);
      Thread.sleep(3000);
      // Enter city
    pageResources.getRegisterCompany().setCity(strCity);
      Thread.sleep(3000);
      //Enter state
    pageResources.getRegisterCompany().setState(strState);
      Thread.sleep(3000);
      //Enter zip code
    pageResources.getRegisterCompany().setPostalCode(strZip);
      Thread.sleep(3000);
      //Click finish register button
    pageResources.getRegisterCompany().clickFinishButton();
      Thread.sleep(3000);
 }

 @Test(priority = 3)
 public void validateData( ) throws  InterruptedException {
//Expected Username

String registerStatus = driver.findElement(By.xpath("//div[@class='text-lg mb-lg']")).getText();
Thread.sleep(3000);
String actualRegisterStatus="Registration successful.";

  try { // assertTrue condition has to be true only to pass
  Assert.assertEquals(facebookUserName,userName);
  System.out.println("Facebook username:: "+facebookUserName + "\nUsername displayed in the Name text field ::"+ userName+"\n\n");

   Assert.assertEquals(getEmail, actualEmail);
  System.out.println("Facebook email:: "+getEmail + "\nEmail displayed in the Email address text field ::"+ actualEmail+"\n\n");

   Assert.assertEquals(registerStatus ,actualRegisterStatus);
   System.out.println("User can register using Facebook account ");
   System.out.println("Confirmed message ::"+ registerStatus );

   driver.close();

  } catch (Throwable t) {
   Assert.fail("User cannot register the account using Facebook");

  }
 }

}
