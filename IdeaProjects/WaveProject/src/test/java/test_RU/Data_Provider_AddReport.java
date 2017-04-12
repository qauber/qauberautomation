package test_RU;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created by anbus on 3/22/2017.
 */
public class Data_Provider_AddReport {
    WebDriver driver;

    @DataProvider(name = "Add_Report_Data")
    public Object[][] getData() {
        Object[][] data = new Object[1][3];
        data[0][0] = "Anbu"; // firstname
        data[0][1] = "S"; //lastname
        data[0][2] = "Cupertino"; //location to stop


        return data;
    }
}
