package helper;

import com.github.javafaker.Faker;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import testresources.PageResources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import com.sun.java.util.jar.pack.Package;


/**
 * Created by sc on 2/23/2017.
 */
public class ReportHelper {
    WebDriver dr;
    PageResources pageResources;
    Faker faker;
    public ReportHelper(WebDriver dr, PageResources pageResources) {

        this.dr = dr;
        this.pageResources=pageResources;
        faker = new Faker();
    }

    public void Login(String username,String password) throws InterruptedException {
        dr.get("http://qabidder.net/testwave");
        Thread.sleep(5000);
        pageResources.getLoginPage().userNameField().sendKeys(username);
        pageResources.getLoginPage().passWordField().sendKeys(password);
        pageResources.getLoginPage().loginButton().click();
        Thread.sleep(5000);

    }

    public Object[][] ReadData1(String excelFilePath,String filename,String sheetname) throws IOException {
        String[][] getData = null;
        try {
            getData = null;
            File f = new File(excelFilePath + "//" + filename);
            Workbook workbook = null;
            FileInputStream inputStream = new FileInputStream(f);
            String fileExtensionName = filename.substring(filename.indexOf("."));

            //Check condition if the file is xlsx file

            if (fileExtensionName.equals(".xlsx")) {

                //If it is xlsx file then create object of XSSFWorkbook class

                workbook = new XSSFWorkbook(inputStream);

            }

            //Check condition if the file is xls file

            else if (fileExtensionName.equals(".xls")) {

                //If it is xls file then create object of XSSFWorkbook class

                workbook = new HSSFWorkbook(inputStream);

            }

            Sheet sheet = workbook.getSheet(sheetname);
            int startRow = 1;
            int startcolumn = 0;
            int ci = 0;
            int cj = 0;

            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
           // int colcount = sheet.getLastRowNum()- sheet.getFirstRowNum();


            //getData = new String[rowCount-1][row.getLastCellNum()];
            for (int i = startRow; i < rowCount + 1; i++, ci++) {

                Row row = sheet.getRow(i);
                getData = new String[rowCount + 1][row.getLastCellNum()];
                for (int j = startcolumn; j < row.getLastCellNum(); j++, cj++) {
                    //System.out.print(row.getCell(j).getStringCellValue() + " ");
                    getData[i][j] = row.getCell(j).getStringCellValue();

                    System.out.println(getData[i][j]);


                }


                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();

        }
        return (getData);
    }




    public void CreateReports(int numberOfReportsToCreate, String username, String password) throws InterruptedException {

            dr.get("http://testwave.qabidder.net/#/page/login");
            Thread.sleep(5000);
            pageResources.getLoginPage().userNameField().sendKeys(username);
            pageResources.getLoginPage().passWordField().sendKeys(password);
            pageResources.getLoginPage().loginButton().click();
            Thread.sleep(5000);
            for (int i=1;i<numberOfReportsToCreate;i++) {
                pageResources.getNavBar().addReportButton().click();
                Thread.sleep(5000);
                pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
                Thread.sleep(5000);
                pageResources.getAddReportEntity().subjectInformationPage().click();
                Thread.sleep(3000);
                pageResources.getAddReportSubjectInformation().lastNameField().click();
                Thread.sleep(5000);
                pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(faker.name().lastName());
                Thread.sleep(5000);
                pageResources.getAddReportSubjectInformation().firstNameField().click();
                pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(faker.name().firstName());
                Thread.sleep(5000);
                pageResources.getAddReportSubjectInformation().identifierPage().click();

                Thread.sleep(5000);
                pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
                pageResources.getAddReportIdentifiers().tatoos().sendKeys("tattoo on left ear");
                pageResources.getAddReportIdentifiers().idInformationPage().click();
                Thread.sleep(3000);
                pageResources.getAddReportIDInformation().socialSecurity().click();
                pageResources.getAddReportIDInformation().socialSecurity().sendKeys("124-46-6789");
                pageResources.getAddReportIDInformation().employerName().click();
                pageResources.getAddReportIDInformation().employerName().sendKeys(faker.company().name());
                Thread.sleep(5000);
                pageResources.getAddReportIDInformation().scrollToElement();
                Thread.sleep(5000);
                pageResources.getAddReportIDInformation().scrollUp();
                Thread.sleep(5000);
                //pageResources.getAddReportIDInformation().nextButton().click();
                pageResources.getAddReportIDInformation().stopInformationPage().click();
                Thread.sleep(5000);

                pageResources.getAddReportStopInformation().locationOfStop().click();
                pageResources.getAddReportStopInformation().locationOfStop().sendKeys(faker.address().city());
                Thread.sleep(3000);
                pageResources.getAddReportStopInformation().vehiclePage().click();
                Thread.sleep(5000);

                pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
                pageResources.getAddReportVehicle().photosPage().click();
                Thread.sleep(5000);
                pageResources.getAddReportPhotos().previewPage().click();
                Thread.sleep(3000);
                pageResources.getAddReportCommit().reportCommit().click();
                Thread.sleep(5000);
            }




        }


    public void CreateReports(int numberOfReportsToCreate) throws InterruptedException {

        dr.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);


        for (int i=1;i<numberOfReportsToCreate;i++) {
            pageResources.getNavBar().addReportButton().click();
            Thread.sleep(5000);
            pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
            Thread.sleep(5000);
            pageResources.getAddReportEntity().subjectInformationPage().click();
            Thread.sleep(3000);
            pageResources.getAddReportSubjectInformation().lastNameField().click();
            Thread.sleep(5000);
            pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(faker.name().lastName());
            Thread.sleep(5000);
            pageResources.getAddReportSubjectInformation().firstNameField().click();
            pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(faker.name().firstName());
            Thread.sleep(5000);
            pageResources.getAddReportSubjectInformation().identifierPage().click();

            Thread.sleep(5000);
            pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
            pageResources.getAddReportIdentifiers().tatoos().sendKeys("tattoo on left ear");
            pageResources.getAddReportIdentifiers().idInformationPage().click();
            Thread.sleep(3000);
            pageResources.getAddReportIDInformation().socialSecurity().click();
            pageResources.getAddReportIDInformation().socialSecurity().sendKeys("124-46-6789");
            pageResources.getAddReportIDInformation().employerName().click();
            pageResources.getAddReportIDInformation().employerName().sendKeys(faker.company().name());
            Thread.sleep(5000);
            pageResources.getAddReportIDInformation().scrollToElement();
            Thread.sleep(5000);
            pageResources.getAddReportIDInformation().scrollUp();
            Thread.sleep(5000);
            //pageResources.getAddReportIDInformation().nextButton().click();
            pageResources.getAddReportIDInformation().stopInformationPage().click();
            Thread.sleep(5000);

            pageResources.getAddReportStopInformation().locationOfStop().click();
            pageResources.getAddReportStopInformation().locationOfStop().sendKeys(faker.address().city());
            Thread.sleep(3000);
            pageResources.getAddReportStopInformation().vehiclePage().click();
            Thread.sleep(5000);

            pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
            pageResources.getAddReportVehicle().photosPage().click();
            Thread.sleep(5000);
            pageResources.getAddReportPhotos().previewPage().click();
            Thread.sleep(3000);
            pageResources.getAddReportCommit().reportCommit().click();
            Thread.sleep(5000);
        }




    }



}

