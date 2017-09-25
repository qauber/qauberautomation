import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by sc on 5/17/2017.
 */
public class ReadData {


    public Object[][] ReadExcelData(String FilePath,String sheetName) throws Exception {

        String[][] tabArray = null;
        //String FilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\UserData.xls";
        //String sheetName =  "Sheet1" ;
        try {
            File f = new File(FilePath);
            Workbook workbook = Workbook.getWorkbook(f);
            Sheet sheet = workbook.getSheet(sheetName);


            // These are the total rows and total columns from Excel File
            //int totalRows = 0;
            //int totalCols = 0;

            //Getting the number of rows from Excel Sheet and printthem
            int RowCount = sheet.getRows();
          int ColCount = sheet.getColumns();

            //Initializing the Array
            tabArray = new String[RowCount - 1][ColCount];

            // Initializing Start Row and Start Column numbers where the data starts
            int startRow = 1;
            int startCol = 0;

            //Initializing RowPointer and Column pointer
            int PointerRow = 0;

            System.out.println("total cols = " + ColCount);
            System.out.println("total rows = " + RowCount);


            for (int i = startRow; i < RowCount; i++, PointerRow++) {
                int PointerColumn = 0;
                for (int j = startCol; j < ColCount; j++, PointerColumn++) {
                    tabArray[PointerRow][PointerColumn] = sheet.getCell(j, i).getContents();

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }catch(BiffException j){
            j.printStackTrace();
        }
        return (tabArray);

    }

    public Object[][] ReadDesiredcapabilities(String FilePath,String sheetName) throws Exception {

        String[][] tabArray1 = null;

        try {
            File f = new File(FilePath);
            Workbook workbook = Workbook.getWorkbook(f);
            Sheet sheet = workbook.getSheet(sheetName);


            // These are the total rows and total columns from Excel File
            //int totalRows = 0;
            //int totalCols = 0;

            //Getting the number of rows from Excel Sheet and printthem

            int RowCount = sheet.getRows();
            int ColCount = sheet.getColumns();

            //Initializing the Array
            tabArray1 = new String[RowCount - 1][ColCount];

            // Initializing Start Row and Start Column numbers where the data starts
            int startRow = 1;
            int startCol = 0;

            //Initializing RowPointer and Column pointer
            int PointerRow = 0;

            System.out.println("total cols = " + ColCount);
            System.out.println("total rows = " + RowCount);


            for (int i = startRow; i < RowCount; i++, PointerRow++) {
                int PointerColumn = 0;
                for (int j = startCol; j < ColCount; j++, PointerColumn++) {
                    tabArray1[PointerRow][PointerColumn] = sheet.getCell(j, i).getContents();

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }catch(BiffException j){
            j.printStackTrace();
        }
        return (tabArray1);

    }



}
