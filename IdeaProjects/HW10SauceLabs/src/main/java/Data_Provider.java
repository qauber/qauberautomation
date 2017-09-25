/**
 * Created by sc on 5/19/2017.
 */

import org.testng.annotations.DataProvider;

public class Data_Provider {

    @DataProvider(name = "ExcelDataProvider")
    public static Object[][] getData() throws Exception {

        String FilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\UserData.xls";
        String sheetName =  "Sheet1" ;
        ReadData readData = new ReadData();
        Object[][] getData = readData.ReadExcelData(FilePath,sheetName);
        return getData;
    }
    @DataProvider(name="giveDesiredCapabilities")
    public static Object[][] giveBrowserstackPlatforms() throws Exception {
        String FilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\platforms.xls";
        //C:\Users\sc\IdeaProjects\HW10SauceLabs\src\main\Desired.xls
        String sheetName =  "Sheet1" ;
        ReadData readData = new ReadData();
        Object[][] giveBrowserstackPlatforms = readData.ReadDesiredcapabilities(FilePath,sheetName);
        return giveBrowserstackPlatforms;

    }
}
