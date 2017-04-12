package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AssignUser {
    WebDriver driver;
    private By entitiesLink = By.xpath("//div[2]/aside[1]/div/nav/ul/li[2]/a");
    private By SAUassignPermissionButton =By.xpath("//div[2]/section//table/tbody/tr[8]/td[2]/button[1]");
    private By assignPermissionButton1 = By.xpath("//div[2]/section//table/tbody/tr[7]/td[2]/button[1]");
    private By reAssignPermissionButton = By.cssSelector("tr.ng-scope:nth-child(6) > td:nth-child(2) > button:nth-child(1)");
    //Role dropdownlist no.1
    private By selectRoleDropdownList1= By.xpath("//tr[5]/td[2]/select");
    //Role dropdownlist no.2
    private By selectRoleDropdownList2= By.xpath("//tr[5]/td[2]/select");
    private By clickToSaveAction1 = By.xpath("//tr[7]/td[2]/select");
    private By clickToSaveAction2 = By.xpath("//tr[7]/td[2]/select");
    private By saveChangeUserRoleButton = By.cssSelector("button.btn-warning:nth-child(1)");

    private By closePopup = By.cssSelector(".ngdialog-close");
    private By confirmDeleteUser = By.cssSelector(".btn-danger");

    public void AssignUser (WebDriver driver){
      this.driver=driver;
    }

    public void entitiesLink(){ driver.findElement(entitiesLink).click(); }
    public void clickAssignPermission(){ driver.findElement(assignPermissionButton1).click();}
    public void SAUclickAssignPermission(){ driver.findElement(SAUassignPermissionButton).click();}
    public void clickReAssignPermission(){ driver.findElement(reAssignPermissionButton).click();}
    public void setSelectRoleDropdownList1 (String strRole){
               driver.findElement(selectRoleDropdownList1).sendKeys(strRole);}
    public void setSelectRoleDropdownList2(String strRole){
        driver.findElement(selectRoleDropdownList2).sendKeys(strRole);}
    public void clickToHoverSaveChangeButton() {driver.findElement(clickToSaveAction1).click();}
    public void clickToHoverSaveChangeButton2() {driver.findElement(clickToSaveAction2).click();}
    public void clickSaveChangeUserRoleButton() {driver.findElement(saveChangeUserRoleButton).click();}

    public void clickconfirmDeleteUser (){driver.findElement(confirmDeleteUser ).click();}

    public void setClosePopup()throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement close = driver.findElement(closePopup);
        Thread.sleep(8000);
        executor.executeScript("arguments[0].click();", close );
        Thread.sleep(5000);
    }

    }







