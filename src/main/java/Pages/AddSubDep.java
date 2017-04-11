package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;


public class AddSubDep {

    WebDriver driver;
    private By entitiesLink = By.xpath("//ul/li[2]/a/span[@class='ng-binding']");
    private By entityName = By.xpath("//table/tbody/tr[5]/td[1]//div[1]/a");
    private By departmentLink =By.xpath("//table/tbody//div[1]/a");
    private By addSubDeptButton = By.xpath("//section/div/h3/button");
    private By subDepartmentName = By.cssSelector("input.form-control:nth-child(2)");
    private By closePopup = By.xpath(".//*[@id='ngdialog1']/div[2]/div[2]");
    private By AddButton = By.cssSelector(".clearfix > button:nth-child(1)");

    public AddSubDep(WebDriver driver){
        this.driver=driver;
    }

    public void clickEntitiesLink(){

        driver.findElement(entitiesLink).click();

    }
    // Set click entity name
    public void clickEntityName(){

        driver.findElement(entityName).click();

    }
    public void clickDepartment(){

        driver.findElement(departmentLink).click();

    }

    // Set Add Dept
    public void clickAddDeptButton(){

        driver.findElement(addSubDeptButton).click();

    }
    //Set departmentname in textbox

    public void setSubDepartmentName(String strSubName){

        driver.findElement(subDepartmentName).sendKeys(strSubName);

    }
    //Set Add button

    public void clickAddSubDept(){

        driver.findElement(AddButton).click();

    }
    public void clickClosePopup()throws InterruptedException{


        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement close = driver.findElement(closePopup);
        Thread.sleep(8000);
        executor.executeScript("arguments[0].click();", close );




    }




}