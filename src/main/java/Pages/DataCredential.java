package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataCredential {
    WebDriver driver;


    @DataProvider(name = "SAU")
    public static Object[][] SAUcredentials() {
        Object[][] data = new Object[1][3];

        data[0][0] = "SAU";
        data[0][1] = "finalwave@mailinator.com";
        data[0][2] = "Kamran12345";
        return data;
    }

    @DataProvider(name = "RU")
    public static Object[][] RUcredential() {
        Object[][] data = new Object[1][3];
        data[0][0] = "RU";
        data[0][1] = "wavefittest@mailinator.com";
        data[0][2] = "Kamran12345";

        return data;
    }

    @DataProvider(name = "AU")
    public static Object[][] AUcredential() {
        Object[][] data = new Object[1][3];
        data[0][0] = "RU";
        data[0][1] = "zarzar@mailinator.com";
        data[0][2] = "Kamran12345";

        return data;
    }

    @DataProvider(name = "AddReport")
    public static Object[][] AddReport() {
        Object[][] data = new Object[1][5];
        data[0][0] = RandomStringUtils.randomAlphabetic(10);//Last Name
        data[0][1] = RandomStringUtils.randomAlphabetic(10);//First Naem
        data[0][2] = RandomStringUtils.randomNumeric(10);//Social Security
        data[0][3] = RandomStringUtils.randomAlphabetic(10);//Stop Location
        data[0][4] = RandomStringUtils.randomNumeric(6);//case ID

        return data;
    }

    //testsanity@mailinator.com
    @DataProvider(name = "Register")
    public static Object[][] Registration() {
        Object[][] data = new Object[1][4];
        data[0][0] = RandomStringUtils.random(6);
        data[0][1] = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        data[0][2] = "Kamran12345";
        data[0][3] = "Kamran12345";

        return data;
    }

        @DataProvider(name = "SignInViaGoogleAccount")
    public static Object[][]GoogleSingInPage()
    {
        Object[][]data= new Object[1][3];
        data[0][0]="kamran.zp"+"+"+ RandomStringUtils.randomNumeric(2)+"@gmail.com";
        data[0][1]= "09173203845";
        data[0][2]= RandomStringUtils.randomAlphabetic(10);
        return data;

    }

}
