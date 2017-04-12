package pages;
//*Created By Em
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EditORG {
    WebDriver driver;

    private By entitiesLink = By.xpath("//a[@title='Entities']");
    private By editEntityButton = By.xpath("//tr[12]/td[4]/button[2]");
    private By entityName = By.xpath("//div/input[@name='name']");
    private By countryName= By.xpath("//div[2]/select[@name='country']");
    private By address= By.xpath("//input[@name='address1']");
    private By city = By.xpath("//input[@name='city']");
    private By state= By.cssSelector("input.form-control:nth-child(3)");
    private By zip=By.xpath("//div[7]/input[@name='zip']");
    private By updateButton= By.xpath("//div[2]/button[@ng-click='$ctrl.updateAction()']");

    public void EditORG(WebDriver driver){
        this.driver= driver;

    }
    public void clickEntityLink(){driver.findElement(entitiesLink).click();}
    public void clickEditEntityButton(){driver.findElement(editEntityButton ).click();
           }
    public void setEntityName(String strEntityName)
    {
        driver.findElement(entityName).clear();
        driver.findElement(entityName).sendKeys(strEntityName);}

    public void clickUpdateButton(){driver.findElement(updateButton).click();}




}
