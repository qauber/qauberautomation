package pages;

//*Created By Em
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CleanUpAssignedUserData {
    WebDriver driver ;
    // Click at User link
    private By gotoUserPageLink = By.xpath("//div[2]/aside[1]/div/nav/ul/li[3]/a");
    //Click at delete button on the target user
    private By clickDeleteAssignedUser = By.xpath("//table/tbody/tr[6]/td[2]/button[4]");
    // Click confirm to delete
    private By clickConfirmDelete = By.cssSelector(".btn-danger");


    public void CleanUpAssignedUserData(WebDriver driver){ this.driver= driver; }
    public void clickAtUserlink(){driver.findElement(gotoUserPageLink).click();}
    public void clickDeleteButton(){driver.findElement(clickDeleteAssignedUser).click();}
    public void clickConfirmDelete() {driver.findElement(clickConfirmDelete).click();}
}
