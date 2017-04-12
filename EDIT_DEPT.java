package pages;


//*Created By Em
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EDIT_DEPT {

    WebDriver driver;
    private By entitiesLinkforAU = By.linkText("Entities");
    private By entityLinkforSAU= By.cssSelector(".sidebar > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span:nth-child(2)");
    private By entityName = By.xpath("//tbody/tr[11]/td[1]/div/div[1]/a");
    private By editDepartmentButton= By.cssSelector("tr.ng-scope:nth-child(3) > td:nth-child(2) > button:nth-child(2)");
    private By departmentNameTextField= By.cssSelector("input.form-control:nth-child(2)");
    private By SaveButton = By.cssSelector(".clearfix > button:nth-child(1)");
    private By closePopup = By.cssSelector(".ngdialog-close");
    private By deleteDeptButton = By.xpath("(//tr/td[2][@class='text-center']/button[4][@title='Delete'])[last()]");
    private By confirmDeleteDepartment = By.cssSelector(".btn-danger");

    public void EDIT_DEPT(WebDriver driver){this.driver = driver; }
    public void AUclickEntitiesLink(){ driver.findElement(entitiesLinkforAU).click(); }
    public void SAUclickEntitiesLink(){ driver.findElement(entityLinkforSAU).click(); }
    public void clickSelectEntityName(){ driver.findElement(entityName ).click(); }
    public void clickEditDeptButton(){driver.findElement(editDepartmentButton).click(); }
    public void setDepartmentName(String strDepartmentName){
        driver.findElement(departmentNameTextField).clear();
        driver.findElement(departmentNameTextField).sendKeys(strDepartmentName); }
    public void clickSaveDeptName(){driver.findElement(SaveButton).click(); }

    public void clickClosePopup()throws InterruptedException{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement close = driver.findElement(closePopup);
        Thread.sleep(8000);
        executor.executeScript("arguments[0].click();", close );
        Thread.sleep(8000);
    }
    public void clickDeleteDEPT() {driver.findElement(deleteDeptButton).click();}
    public String clickConfirmDeleteDEPT(){
        String status;
        driver.findElement(confirmDeleteDepartment).click();
    return status="true";
    }


}
