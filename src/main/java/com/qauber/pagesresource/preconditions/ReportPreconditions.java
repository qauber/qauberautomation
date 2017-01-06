package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

/**
 * Created by MadMax on 1/4/2017.
 */
public class ReportPreconditions {
    private int sleepTime;

    private WebDriver driver;
    private Faker faker;
    private NavBar navBar;
    private Reports reports;
    private AddReportsOrganization addReportsOrganization;
    private AddReportNavigation addReportNavigation;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportEnvironment addReportEnvironment;
    private AddReportPreview addReportPreview;

    public ReportPreconditions(WebDriver driver)
    {
        sleepTime = 1000;
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        reports = new Reports(driver);
        addReportsOrganization = new AddReportsOrganization(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportSubjectInformationPage = new AddReportSubjectInformationPage(driver);
        addReportEnvironment = new AddReportEnvironment(driver);
        addReportPreview = new AddReportPreview(driver);
    }

    /**
     * ensureReportsAtLeast(int num)
     * Get 'number of pages we need to create'
     * If numberOfReportsNeeded > 0, create those users
     */
    public void ensureReportsAtLeast(int num) throws InterruptedException
    {
        int numberOfReportsNeeded = verifyReportsAtLeast(num);
        System.out.println("Number of reports we need to create: " + numberOfReportsNeeded);
        if (numberOfReportsNeeded > 0) {
            createReport(numberOfReportsNeeded);
        }
    }

    public int verifyReportsAtLeast(int num) throws InterruptedException
    {
        try
        {
            reports.pagination("1").isDisplayed();
            Thread.sleep(sleepTime);
            int sum = 0;
            int i = 1;
            while(true)
            {
                Thread.sleep(sleepTime);
                ArrayList<WebElement> list1 = new ArrayList<WebElement>(reports.reportsRows());
                sum = sum + list1.size();
                ArrayList<WebElement> list2 = new ArrayList<WebElement>(reports.paginationSum());

                if(i<Integer.parseInt(list2.get(list2.size()-1).getText()))
                {
                    reports.pagination(i+1+"").click();
                    i++;
                }
                else
                {
                    break;
                }
            }
            sum = num - sum;
            return sum<=0 ? 0 : sum;
        }
        catch (NoSuchElementException e){
            ArrayList<WebElement> list = new ArrayList<WebElement>(reports.reportsRows());

            int sum = num - list.size();
            return sum<=0 ? 0 : sum;
        }

    }
    public void createReport(int reportsNeeded) throws InterruptedException {

        for (int i = 0; i<reportsNeeded; i++) {
            navBar.addReportButton().click();
            Thread.sleep(sleepTime);

            addReportsOrganization.clickOrganization1();
            Thread.sleep(sleepTime);

            addReportNavigation.subjectInformationTab().click();
            Thread.sleep(sleepTime);
            addReportSubjectInformationPage.firstName().sendKeys(faker.name().firstName());
            addReportSubjectInformationPage.lastName().sendKeys(faker.name().lastName());
            Thread.sleep(sleepTime);

            addReportNavigation.environmentTab().click();
            Thread.sleep(sleepTime);
            addReportEnvironment.stopLocationField().sendKeys(faker.address().cityName());
            Thread.sleep(sleepTime);

            addReportNavigation.previewTab().click();
            Thread.sleep(sleepTime);

            addReportPreview.publishReportButton().click();
            Thread.sleep(sleepTime);
        }
    }
}
