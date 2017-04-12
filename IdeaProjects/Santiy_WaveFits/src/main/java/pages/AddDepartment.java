package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddDepartment {

     WebDriver driver;
    private By entitiesLinkforAU = By.linkText("Entities");
    private By entityLinkforSAU= By.cssSelector(".sidebar > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span:nth-child(2)");
    private By entityName = By.xpath("//tbody/tr[11]/td[1]/div/div[1]/a");
    private By addDeptButton = By.xpath("//section/div/h3/button");
    private By departmentName = By.cssSelector("input.form-control:nth-child(2)");
    private By AddButton = By.cssSelector(".clearfix > button:nth-child(1)");
    private By closePopup = By.cssSelector("body");

    public void AddDepartment(WebDriver driver){this.driver = driver; }
    public void AUclickEntitiesLink(){ driver.findElement(entitiesLinkforAU).click(); }
    public void SAUclickEntitiesLink(){ driver.findElement(entityLinkforSAU).click(); }
    public void clickEntityName(){ driver.findElement(entityName).click(); }
    public void clickAddDeptButton(){driver.findElement(addDeptButton).click(); }
    public void setDepartmentName(String strDepartmentName){ driver.findElement(departmentName).sendKeys(strDepartmentName); }
    public void clickAddDept(){driver.findElement(AddButton).click(); }

    public void clickClosePopup()throws InterruptedException{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement close = driver.findElement(closePopup);
        Thread.sleep(8000);
        executor.executeScript("arguments[0].click();", close );
        Thread.sleep(8000);
    }

    public void createDept (String deptName) throws InterruptedException
    {

       this.AUclickEntitiesLink();
        Thread.sleep(20000);
       this.clickEntityName();
        Thread.sleep(20000);
       this.clickAddDeptButton();
        Thread.sleep(3000);
       this.setDepartmentName(deptName);
        Thread.sleep(8000);
       this.clickAddDept();
        Thread.sleep(8000);
     this.clickClosePopup();
        Thread.sleep(8000);
    }



}
