package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created by jaishree on 4/6/17.
 */
public class DataProviderClass {

    //This test method declares that its data should be supplied by the Data Provider
    // "getdata" is the function name which is passing the data
    // Number of columns should match the number of input parameters

    WebDriver driver;

    @DataProvider(name = "SuperUserCreds")
    private static Object[][] getData() {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[1][2];

        // 1st row
        data[0][0] = "superuser@getnada.com";
        data[0][1] = "superuser";

        // 2nd row
        //data[1][0] ="dinklemcgee@mailinator.com";
        //data[1][1] = "dinklemcgee";

        // 3rd row
        //data[2][0] ="happydinkle@mailinator.com";
        //data[2][1] = "happydinkle";

        return data;


    }

}