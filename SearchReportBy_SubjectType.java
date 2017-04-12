package sanityCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class SearchReportBy_SubjectType {
    WebDriver driver;

    By publishedOn_Checkbox = By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']//span");


    public SearchReportBy_SubjectType(WebDriver driver) {
        this.driver = driver;
    }

    /* Common method to compare the Strings(subject type in drop down & subject type in displayed reports title)
    String a= subject type in the drop down which is user selection
    List<String> b = displayed report titles with subject type
     */

    public boolean compareElements(String a, List<String> b) {
        for (String str : b) {
            if (str.contains(a)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchReportBy_Other() throws InterruptedException {

        //step 1:un check the check box for all reports otherwise reports created on that day only displays
        driver.findElement(publishedOn_Checkbox).click();


        Select dd = new Select(driver.findElement(By.xpath("//div[@class='input']//select")));
        dd.selectByIndex(5); // Refer the Index value

        // Storing the dropdown selection as Expected suspect Type to verify
        String expected = new Select(driver.findElement(By.xpath("//div[@class='input']//select"))).getOptions().get(5).getText();
        System.out.println("Expected :" + expected);
        Thread.sleep(2000);

        // Storing Actual subject Type displayed in Reports in list
        List<String> displayedTitles = new ArrayList<String>();

        // Getting all the elements titles as a list
        List<WebElement> allReport_Titles = driver.findElements(By.xpath("//div[@class='col-lg-12']"));

        //looping through the elements & finding the texts & adding tho the new list(displayedTitles)
        for (int i = 0; i < allReport_Titles.size(); i++) {
            displayedTitles.add(allReport_Titles.get(i).getText());
        }

        System.out.println("Total titles displayed:" + displayedTitles.size() + " " +"Titles: " + displayedTitles);


        // Using the common method to get the boolean result after comparing the strings
        try {
            for (String title: displayedTitles) {
                if (!compareElements(expected, displayedTitles)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught while checking  " + e.getMessage());

        }
        return true; // returning the boolean value to use in test method
    }

    public boolean searchReportBy_Victim() throws InterruptedException {

        //step 1:un check the check box for all reports otherwise reports created on that day only displays
        driver.findElement(publishedOn_Checkbox).click();

        /* select the subject type from the dropdown by index value
        Index 0= "Select by Type"
        Index 1= "R/P"
        Index 2 ="Suspect"
        Index 3 ="Victim"
        Index 4="Witness"
        Index 5= "other"
         */
        Select dd = new Select(driver.findElement(By.xpath("//div[@class='input']//select")));
        dd.selectByIndex(3); // Refer the Index value

        // Storing the dropdown selection as Expected suspect Type to verify
        String expected = new Select(driver.findElement(By.xpath("//div[@class='input']//select"))).getOptions().get(3).getText();
        System.out.println("Expected :" + expected);
        Thread.sleep(2000);

        // Storing Actual subject Type displayed in Reports in list
        List<String> displayedTitles = new ArrayList<String>();

        // Getting all the elements titles as a list
        List<WebElement> allReport_Titles = driver.findElements(By.xpath("//div[@class='col-lg-12']"));

        //looping through the elements & finding the texts & adding tho the new list(displayedTitles)
        for (int i = 0; i < allReport_Titles.size(); i++) {
            displayedTitles.add(allReport_Titles.get(i).getText());
        }

        System.out.println("Total titles displayed:" + displayedTitles.size() + " " + "Titles: " + displayedTitles);


        // Using the common method to get the boolean result after comparing the strings
        try {
            for (String title : displayedTitles) {
                if (!compareElements(expected, displayedTitles)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught while checking  " + e.getMessage());

        }
        return true;        // returning the boolean value to use in test method
    }
    public boolean searchReportBy_Suspect() throws InterruptedException {

        //step 1:un check the check box for all reports otherwise reports created on that day only displays
        driver.findElement(publishedOn_Checkbox).click();

        /* select the subject type from the dropdown by index value
        Index 0= "Select by Type"
        Index 1= "R/P"
        Index 2 ="Suspect"
        Index 3 ="Victim"
        Index 4="Witness"
        Index 5= "other"
         */
        Select dd = new Select(driver.findElement(By.xpath("//div[@class='input']//select")));
        dd.selectByIndex(2); // Refer the Index value

        // Soring the dropdown selection as Expected suspect Type to verify
        String expected = new Select(driver.findElement(By.xpath("//div[@class='input']//select"))).getOptions().get(2).getText();
        System.out.println("Expected :" + expected);
        Thread.sleep(1000);

        // Storing Actual subject Type displayed in Reports in list
        List<String> displayedTitles = new ArrayList<String>();

        // Getting all the elements titles as a list
        List<WebElement> allReport_Titles = driver.findElements(By.xpath("//div[@class='col-lg-12']"));

        //looping through the elements & finding the texts & adding tho the new list(displayedTitles)
        for (int i = 0; i < allReport_Titles.size(); i++) {
            displayedTitles.add(allReport_Titles.get(i).getText());
        }

        System.out.println("Total titles displayed:" + displayedTitles.size() + " " + "Titles: " + displayedTitles);


        // Using the common method to get the boolean result after comparing the strings
        try {
            for (String title : displayedTitles) {
                if (!compareElements(expected, displayedTitles)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught while checking  " + e.getMessage());

        }
        return true; // returning the boolean value to use in test method
    }
    public boolean searchReportBy_Witness() throws InterruptedException {

        //step 1:un check the check box for all reports otherwise reports created on that day only displays
        driver.findElement(publishedOn_Checkbox).click();


        Select dd = new Select(driver.findElement(By.xpath("//div[@class='input']//select")));
        dd.selectByIndex(4); // Refer the Index value

        // Soring the dropdown selection as Expected suspect Type to verify
        String expected = new Select(driver.findElement(By.xpath("//div[@class='input']//select"))).getOptions().get(4).getText();
        System.out.println("Expected :" + expected);
        Thread.sleep(1000);

        // Storing Actual subject Type displayed in Reports in list
        List<String> displayedTitles = new ArrayList<String>();

        // Getting all the elements titles as a list
        List<WebElement> allReport_Titles = driver.findElements(By.xpath("//div[@class='col-lg-12']"));

        //looping through the elements & finding the texts & adding tho the new list(displayedTitles)
        for (int i = 0; i < allReport_Titles.size(); i++) {
            displayedTitles.add(allReport_Titles.get(i).getText());
        }

        System.out.println("Total titles displayed:" + displayedTitles.size() + " " +"Titles: " + displayedTitles);


        // Using the common method to get the boolean result after comparing the strings
        try {
            for (String title: displayedTitles) {
                if (!compareElements(expected, displayedTitles)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught while checking  " + e.getMessage());

        }
        return true; // returning the boolean value to use in test method
    }
}




