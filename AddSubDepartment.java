package pages;

//*Created By Em
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;


public class AddSubDepartment {

    WebDriver driver;
    private By entitiesLink = By.linkText("Entities");
    private By entityName = By.xpath("//table/tbody/tr[7]/td[1]//div[1]/a");
    private By departmentLink =By.xpath("//table/tbody//div[1]/a");
    private By addSubDeptButton = By.xpath("//section/div/h3/button");
    private By subDepartmentName = By.cssSelector("input.form-control:nth-child(2)");
    private By closePopup = By.cssSelector("body");
    private By AddButton = By.cssSelector(".clearfix > button:nth-child(1)");

   public AddSubDepartment(WebDriver driver){
       this.driver=driver;
   }

    public void clickEntitiesLink(){ driver.findElement(entitiesLink).click(); }
    public void clickEntityName(){driver.findElement(entityName).click();}
    public void clickDepartment(){driver.findElement(departmentLink).click(); }
    public void clickAddDeptButton(){driver.findElement(addSubDeptButton).click();}
    public void setSubDepartmentName(String strSubName){driver.findElement(subDepartmentName).sendKeys(strSubName); }
    public void clickAddSubDept(){driver.findElement(AddButton).click(); }

    public void clickClosePopup()throws InterruptedException{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement close = driver.findElement(closePopup);
        Thread.sleep(8000);
        executor.executeScript("arguments[0].click();", close );
        Thread.sleep(8000);
    }




}
