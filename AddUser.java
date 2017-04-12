package pages;

//*Created By Em
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddUser {
    WebDriver driver ;
    private By usersLink = By.xpath("//div[2]/aside[1]/div/nav/ul/li[3]/a");
    private By inviteUserbttn = By.xpath("//section/div/h3/button");
    private By email = By.cssSelector("input.form-control:nth-child(2)");
    private By sendInviteBttn= By.cssSelector("button.btn-primary:nth-child(5)");

    public void AddUser(WebDriver driver){
        this.driver=driver;
    }

    public void clickUsersLink (){
        driver.findElement(usersLink).click();
    }
    public void clickInviteUserBttn (){
        driver.findElement(inviteUserbttn).click();
    }
    public void setEmail(String stremail){
        driver.findElement(email).sendKeys(stremail);
    }
    public void clickSendInvite (){
        driver.findElement(sendInviteBttn).click();
    }


}
