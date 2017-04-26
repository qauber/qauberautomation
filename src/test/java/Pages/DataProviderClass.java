package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Jenny on 3/21/2017.
 */
public class DataProviderClass {
    WebDriver driver;


    @DataProvider(name="simpleDataProvider")
    public static Object[][] getDataUser(){
        Object[][] data = new Object[2][3];

        data[0][0]="SAU";
        data[0][1]="testerjen@mailinator.com";
        data[0][2]="qauber2016!";

        data[1][0]="AU";
        data[1][1]="testermonster@mailinator.com";
        data[1][2]="qauber2016!";

        return data;
    }

    @DataProvider(name="superAdminUserLogin")
    public static Object[][] getSuperAdminUserLogin(){
        Object[][] superAdminData = new Object[1][3];

        superAdminData[0][0]="SAU";
        superAdminData[0][1]="testerjen@mailinator.com";
        superAdminData[0][2]="qauber2016!";

        return superAdminData;
    }

    @DataProvider(name="superAdminUserLogin2")
    public static Object[][] getSuperAdminUserLogin2(){
        Object[][] superAdminData = new Object[1][3];

        superAdminData[0][0]="SAU";
        superAdminData[0][1]="testerbob@mailsac.com";
        superAdminData[0][2]="qauber2016!";

        return superAdminData;
    }

    @DataProvider(name="adminUserLogin")
    public static Object[][] getAdminUserLogin(){
        Object[][] adminData = new Object[1][3];

        adminData[0][0]="AU";
        adminData[0][1]="testermonster@mailinator.com";
        adminData[0][2]="qauber2016!";

        return adminData;
    }

    @DataProvider(name="adminUserLogin2")
    public static Object[][] getAdminUserLogin2(){
        Object[][] adminData = new Object[1][3];

        adminData[0][0]="AU";
        adminData[0][1]="testermonster@mailsac.com";
        adminData[0][2]="qauber2016!";

        return adminData;
    }


    @DataProvider(name="addReportDataProvider")
    public static Object[][] getDataAddReport(){
        Object[][] newData = new Object[1][2];

        newData[0][0] = "Invited";
        newData[0][1]= "joedirt@mailinator.com";

        return newData;
    }

    @Test(dataProviderClass=DataProviderClass.class,dataProvider="addReportDataProvider")

    public void printData(String utype, String uname){

        System.out.println(utype);
        System.out.println(uname);
        //System.out.println(password);
    }
}
