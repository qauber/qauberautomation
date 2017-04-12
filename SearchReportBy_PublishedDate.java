package sanityCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SearchReportBy_PublishedDate {

    WebDriver driver;
    By publisedOn_DatePicker1 = By.xpath("//input[@ng-model='searchFrom']");
    By publisedOn_DatePicker2 = By.xpath("//input[@ng-click='openedSearchTo=true']");
    By selectDate1 = By.xpath("//div//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']//button[text()='Today']");
    By selectDate2 =By.xpath("//div//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']//button[text()='Today']");

    public SearchReportBy_PublishedDate(WebDriver driver){
        this.driver = driver;
    }

    /** This method format the String date to date format::return boolean value */

    public boolean checkDateRange(String checkDate, String strStartDate, String strEndDate ) throws ParseException {
        Date displayedDate = new SimpleDateFormat("MMMM dd, yyyy").parse(checkDate);//checkdate in the ArrayList
        Date startDate = new SimpleDateFormat("MMMM dd, yyyy").parse(strStartDate);// selected date from calender 1
        Date endDate = new SimpleDateFormat("MMMM dd, yyyy").parse(strEndDate);//selected date from calender2

        // compare the dates with the displayed list of dates
        return displayedDate.compareTo(startDate) >= 0 && displayedDate.compareTo(endDate) <=0;
    }

    public boolean searchReportBy_PublishedOn_Date() throws InterruptedException {

        /**click on first calender   */
        driver.findElement(publisedOn_DatePicker1).click();

        /**select specific date( Start date) */
        String startDate = driver.findElement(selectDate1).getText();
        System.out.println("Fromdate:" +startDate);
        driver.findElement(selectDate1).click();
        Thread.sleep(300);

        /**click on second calender */
        driver.findElement(publisedOn_DatePicker2).click();
        /**select specific date ( End date) */
        String endDate = driver.findElement(selectDate2).getText();
        System.out.println("Todate :"+ endDate);
        driver.findElement(selectDate2).click();
        Thread.sleep(1000);

        /** storing all dates in the list  */
        List<WebElement> allDates = driver.findElements(By.xpath("//div//span[@ng-show='report.status']"));
        List <String> dates = new ArrayList<String>();

        for (int j = 0; j < allDates.size(); j++) {
            System.out.println("Index: " +j + "::Date Found :" + allDates.get(j).getText());
            if (allDates.get(j).getText() != "") {
                dates.add(allDates.get(j).getText());
            }
        }

        /** use the method checkDateRange   to verify the dates are in range selection
         * e:the date in array list which is displayed in reports
         * startDate,endDate is the user selection dates from the calender*/
        try {
            for (String e : dates) {
                if (!checkDateRange(e, startDate, endDate)) {
                    return false;
                }
            }
        } catch (ParseException e) {
            System.out.println("Exception caught while checking date " + e.getMessage());
        }
        return true;
    }

}




/* // check for pagination
        WebElement pagination_Link= driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//a"));


        List<WebElement> allpages = driver.findElements(By.xpath("//ul[@class='pagination ng-scope']//a"));
        System.out.println(allpages.size());
        List <String> dates = new ArrayList<String>();

        if(pagination_Link.isDisplayed() ) {
            for (int i = 0; i < allpages.size(); i++) {
                List<WebElement> allDates = driver.findElements(By.xpath("//div//span[@ng-show='report.status']"));
                //dates.add(allDates.get(i).getText());


                WebElement nxtBtn = driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a"));
                if (nxtBtn.isEnabled()) {
                    Thread.sleep(2000);

                    // List<WebElement> allDates = driver.findElements(By.xpath("//div//span[@ng-show='report.status']"));
                    for (int j = 0; j < allDates.size(); j++) {
                        System.out.println(j + "::allDates.get(i).getText() :" + allDates.get(j).getText());
                        if (allDates.get(j).getText() != "") {
                            dates.add(allDates.get(j).getText());
                        }
                    }
                }

                System.out.println("Clicking next page, current page:" + i);
                driver.findElement(By.xpath("//ul[@class='pagination ng-scope']//li[last()]//a")).click();

            }
        }
        else{
            List<WebElement> allDates = driver.findElements(By.xpath("//div//span[@ng-show='report.status']"));

            for (int j = 0; j < allDates.size(); j++) {
                System.out.println(j + "::allDates.get(i).getText() :" + allDates.get(j).getText());
                if (allDates.get(j).getText() != "") {
                    dates.add(allDates.get(j).getText());
                }
            }

        }*/