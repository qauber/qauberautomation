package Test_AU;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created by anbus on 3/22/2017.
 */
public class Data_Provider {
    WebDriver driver;

    @DataProvider(name = "AU_Credentials")
    public static Object[][] getData() {
        Object[][] data = new Object[1][3];
        data[0][0] = "AU";
        data[0][1] = "random@mailinator.com";
        data[0][2] = "testing";


        return data;
    }
}
