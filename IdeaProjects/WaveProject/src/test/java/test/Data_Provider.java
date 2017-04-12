package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by anbus on 3/21/2017.
 */
public class Data_Provider {
    WebDriver driver;

    @DataProvider(name="SimpleDataProvider")
    public static Object[][] getData(){
        Object[][] data = new Object[1][3];
        data[0][0]="SAU";
        data[0][1]="new@mailinator.com";
        data[0][2]="testing";


        return data;
    }
    @Test(dataProvider = "SimpleDataProvider")
    public void printUserType(String UserType,String UserName,String Password){
        System.out.println(UserType);
        System.out.println(UserName);
        System.out.println(Password);
    }


}
