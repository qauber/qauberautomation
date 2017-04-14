package Pages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Created by jaishree on 3/23/17.
 */
public class DataProvidersClass {

    //This test method declares that its data should be supplied by the Data Provider
    // "getdata" is the function name which is passing the data
    // Number of columns should match the number of input parameters

    WebDriver driver;

    @DataProvider(name = "SuperUserCreds")
    private static Object[][] getData() {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[1][2];

        //  These are super user creds
        data[0][0] = "superuser@getnada.com";
        data[0][1] = "superuser";

        //  Regular User creds
        //data[0][0] ="dinklemcgee@mailinator.com;
        //data[0][1] = "dinklemcgee";

        // Admin creds
        //data[0][0] ="happydinkle@mailinator.com";
        //data[0][1] = "happydinkle";

        return data;
    }

}